package org.university.development.service.controller.user;
import ma.glasnost.orika.MapperFacade;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.university.development.api.user.models.request.ClientRequestDTO;
import org.university.development.api.user.models.request.model.PagingRequestDTO;
import org.university.development.api.user.models.response.ClientResponseDTO;
import org.university.development.domain.exception.ValidationException;
import org.university.development.domain.feature.client.model.ClientDomain;
import org.university.development.domain.feature.client.service.ClientService;
import org.university.development.domain.feature.commons.model.PaginatedResponse;
import org.university.development.domain.feature.commons.model.PagingRequest;

@RestController
@RequestMapping("/v3/clients")
public class ClientController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

    private ClientService clientService;
    private MapperFacade mapper;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @Autowired
    @Qualifier("serviceMapper")
    public void setMapper(MapperFacade mapper) {
        this.mapper = mapper;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<PaginatedResponse<ClientResponseDTO>> getClients(PagingRequestDTO params)
        throws ValidationException {
        LOGGER.info("[CONTROLLER] Starting getClients request");
        LOGGER.debug(">>> Recieved params: " + params.toString());
        PagingRequest pagingRequest = this.mapper.map(params, PagingRequest.class);
        PaginatedResponse<ClientDomain> clientsDomain = this.clientService.getClients(pagingRequest);

        PaginatedResponse.Builder<ClientResponseDTO> paginatedResponseBuilder = new PaginatedResponse.Builder<ClientResponseDTO>();
        paginatedResponseBuilder.setPaging(clientsDomain.getPaging());
        paginatedResponseBuilder.setOrderBy(clientsDomain.getOrderBy());
        paginatedResponseBuilder.setItems(this.mapper.mapAsList(clientsDomain.getItems(), ClientResponseDTO.class));

        return new ResponseEntity<PaginatedResponse<ClientResponseDTO>>(paginatedResponseBuilder.build(), HttpStatus.OK);
    }

    @RequestMapping(value = "/{clientId}", method = RequestMethod.GET)
    public ResponseEntity<ClientResponseDTO> getClient(@PathVariable("clientId") String clientId) throws ValidationException {
        LOGGER.info("[CONTROLLER] Starting getClient request");
        LOGGER.debug(">>> Recieved param: " + clientId);
        ClientDomain clientDomain = this.clientService.getClient(clientId);
        ClientResponseDTO result = this.mapper.map(clientDomain, ClientResponseDTO.class);
        return new ResponseEntity<ClientResponseDTO>(result, HttpStatus.OK);
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<ClientResponseDTO> postClient(@RequestBody ClientRequestDTO clientRequestDTO)
        throws ValidationException {
        LOGGER.info("[CONTROLLER] Starting postClient request");
        LOGGER.debug(">>> Recieved params: " + clientRequestDTO.toString());
        ClientDomain clientDomain = this.mapper.map(clientRequestDTO, ClientDomain.class);
        ClientDomain clientDomainResponse = this.clientService.addClient(clientDomain);
        ClientResponseDTO clientResponseDTO = this.mapper.map(clientDomainResponse, ClientResponseDTO.class);
        return new ResponseEntity<ClientResponseDTO>(clientResponseDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/{clientId}", method = RequestMethod.PUT)
    public ResponseEntity<ClientResponseDTO> putClient(@RequestBody ClientRequestDTO clientRequestDTO,
        @PathVariable("clientId") String clientId) throws ValidationException {
        LOGGER.info("[CONTROLLER] Starting putClient request");
        clientRequestDTO.setId(clientId);
        LOGGER.debug(">>> Recieved params: " + clientRequestDTO.toString());
        ClientDomain clientDomain = this.mapper.map(clientRequestDTO, ClientDomain.class);
        ClientDomain clientDomainResponse = this.clientService.updateClient(clientDomain);
        ClientResponseDTO clientResponseDTO = this.mapper.map(clientDomainResponse, ClientResponseDTO.class);
        return new ResponseEntity<ClientResponseDTO>(clientResponseDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/{clientId}", method = RequestMethod.DELETE)
    public void deleteClient(@PathVariable("clientId") String clientId) throws ValidationException {
        LOGGER.info("[CONTROLLER] Starting deleteClient request");
        LOGGER.debug(">>> Recieved param: " + clientId);
        this.clientService.deleteClient(clientId);
    }

}


