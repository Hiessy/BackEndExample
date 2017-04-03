package org.university.development.domain.feature.client.service;

import java.util.List;

import ma.glasnost.orika.MapperFacade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Service;

import org.university.development.commons.annotation.Valid;
import org.university.development.commons.annotation.ValidateGroups;
import org.university.development.commons.model.Cause;
import org.university.development.domain.exception.InvalidIDException;
import org.university.development.domain.feature.client.dao.ClientDAO;
import org.university.development.domain.feature.client.model.Client;
import org.university.development.domain.feature.client.model.ClientDomain;
import org.university.development.domain.feature.client.model.ClientDomain.AddValidations;
import org.university.development.domain.feature.client.model.ClientDomain.UpdateValidations;
import org.university.development.domain.feature.client.service.support.ClientCriteriaSupport;
import org.university.development.domain.feature.client.service.support.ClientDefaultValuesLoader;
import org.university.development.domain.feature.commons.annotation.ValidId;
import org.university.development.domain.feature.commons.model.PaginatedResponse;
import org.university.development.domain.feature.commons.model.PagingRequest;
import org.university.development.domain.feature.commons.model.PagingResponse;
import org.university.development.domain.feature.commons.model.SelectableOrder;

@Service("clientService")
public class ClientServiceImpl implements ClientService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ClientServiceImpl.class);

	private ClientDAO dao;
	private MapperFacade mapper;

	@Autowired
	private ClientCriteriaSupport criteriaSupport;

	@Autowired
	private ClientDefaultValuesLoader defaultValuesLoader;

	@Autowired
	public ClientServiceImpl(ClientDAO dao) {
		this.dao = dao;
	}

	@Autowired
	@Qualifier("domainMapper")
	public void setMapper(MapperFacade mapper) {
		this.mapper = mapper;
	}

	public PaginatedResponse<ClientDomain> getClients(PagingRequest params) {
		LOGGER.info("[DOMAIN] Executing getClients request");
		LOGGER.debug(">>> Request params: " + params.toString());
		PagingRequest alteredParams = this.defaultValuesLoader.loadDefaultPagingValues(params);

		List<Order> orders = this.criteriaSupport.getOrders(alteredParams.getOrders());

		LOGGER.debug(">>> Find all with params: " + alteredParams.toString());
		Page<Client> clientsEntity = this.dao.findAll(new PageRequest(alteredParams.getOffset(), alteredParams.getLimit(), new Sort(orders)));

		LOGGER.debug(">>> Obtained " + clientsEntity.getNumberOfElements() + " elements of  " + clientsEntity.getTotalElements() + " total results");
		List<ClientDomain> clientsDomain = this.mapper.mapAsList(clientsEntity.getContent(), ClientDomain.class);

		// Build paginated response
		PagingResponse.Builder paging = new PagingResponse.Builder();
		paging.setLimit(alteredParams.getLimit());
		paging.setOffset(alteredParams.getOffset());
		paging.setTotal(clientsEntity.getTotalElements());
		List<SelectableOrder> sortings = this.criteriaSupport.selectOrders(orders);

		return new PaginatedResponse<ClientDomain>(clientsDomain, sortings, paging.build());
	}

	public ClientDomain getClient(@ValidId String id) {
		LOGGER.info("[DOMAIN] Executing getClient request");
		LOGGER.debug(">>> Request param: " + id);
		Client clientEntity = this.dao.findOne(id);
		if (clientEntity == null) {
			throw new InvalidIDException(new Cause(id, "Nonexistent ID"));
		}
		return this.mapper.map(clientEntity, ClientDomain.class);
	}

	@ValidateGroups(AddValidations.class)
	public ClientDomain addClient(@Valid ClientDomain client) {
		LOGGER.info("[DOMAIN] Executing addClient request");
		LOGGER.debug(">>> Request params: " + client.toString());
		Client clientEntity = this.mapper.map(client, Client.class);
		Client clientEntityResponse = this.dao.save(clientEntity);
		return this.mapper.map(clientEntityResponse, ClientDomain.class);
	}

	public void deleteClient(@ValidId String id) {
		LOGGER.info("[DOMAIN] Executing deleteClient request");
		LOGGER.debug(">>> Request param: " + id);
		try {
			this.dao.delete(id);
		} catch (EmptyResultDataAccessException emptyResultDataAccessException) {
			throw new InvalidIDException(new Cause(id, "Nonexistent ID"));
		}
	}

	@ValidateGroups(UpdateValidations.class)
	public ClientDomain updateClient(@Valid ClientDomain client) {
		LOGGER.info("[DOMAIN] Executing updateClient request");
		LOGGER.debug(">>> Request params: " + client.toString());
		Client clientEntity = this.mapper.map(client, Client.class);

		Client dbClient = this.dao.findOne(client.getId());
		if (dbClient == null) {
			throw new InvalidIDException(new Cause(client.getId(), "Nonexistent ID"));
		}

		LOGGER.debug(">>> Merging with original data: " + dbClient.toString());
		if (clientEntity.getName() == null) {
			clientEntity.setName(dbClient.getName());
		}
		if (clientEntity.getGender() == null) {
			clientEntity.setGender(dbClient.getGender());
		}
		if (clientEntity.getType() == null) {
			clientEntity.setType(dbClient.getType());
		}

		LOGGER.debug(">>> Saving client: " + clientEntity.toString());
		Client clientEntityResponse = this.dao.save(clientEntity);
		return this.mapper.map(clientEntityResponse, ClientDomain.class);
	}

}
