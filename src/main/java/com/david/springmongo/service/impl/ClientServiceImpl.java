package com.david.springmongo.service.impl;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.david.springmongo.model.Client;
import com.david.springmongo.repository.ClientRepository;
import com.david.springmongo.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService {

	private ClientRepository clientRepository;
	
	
	@Autowired
	public ClientServiceImpl(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	@Override
	public Client findById(String id) {
		Optional<Client> client = this.clientRepository.findById(id);
		
		return client.orElseThrow(() -> new EmptyResultDataAccessException(1));
	}

	@Override
	public Client save(Client entity) {
		Client client = this.clientRepository.save(entity);

		return client;
	}

	@Override
	public Client update(String id, Client entity) {
		Client client = this.findById(id);

		BeanUtils.copyProperties(entity, client, "id", "customer");

		return this.clientRepository.save(client);
	}

	@Override
	public void deleteById(String id) {
		this.clientRepository.deleteById(id);		
	}

	@Override
	public Iterable<Client> findAll() {
		return this.clientRepository.findAll();
	}

}
