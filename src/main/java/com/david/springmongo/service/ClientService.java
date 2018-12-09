package com.david.springmongo.service;

import org.springframework.data.repository.NoRepositoryBean;

import com.david.springmongo.model.Client;

@NoRepositoryBean
public interface ClientService extends BaseService<Client> {

}
