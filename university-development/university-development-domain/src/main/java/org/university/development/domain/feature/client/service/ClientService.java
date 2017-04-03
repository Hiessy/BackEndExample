package org.university.development.domain.feature.client.service;

import org.university.development.domain.feature.client.model.ClientDomain;
import org.university.development.domain.feature.commons.model.BusinessService;
import org.university.development.domain.feature.commons.model.PaginatedResponse;
import org.university.development.domain.feature.commons.model.PagingRequest;

public interface ClientService
    extends BusinessService {

    public PaginatedResponse<ClientDomain> getClients(PagingRequest params);

    public ClientDomain getClient(String id);

    public ClientDomain addClient(ClientDomain client);

    public void deleteClient(String id);

    public ClientDomain updateClient(ClientDomain client);

}
