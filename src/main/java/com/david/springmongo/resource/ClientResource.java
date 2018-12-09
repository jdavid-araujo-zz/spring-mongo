package com.david.springmongo.resource;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.david.springmongo.model.Client;
import com.david.springmongo.service.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientResource implements Serializable {

	private static final long serialVersionUID = 2749447544178288537L;
	
	private ClientService clientService;

	@Autowired
	public ClientResource(ClientService clientService) {
		this.clientService = clientService;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	private ResponseEntity<Client> save(@RequestBody Client entity) {

		Client client = this.clientService.save(entity);

		return ResponseEntity.status(HttpStatus.CREATED).body(client);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	private ResponseEntity<Client> update(@PathVariable String id, @RequestBody Client entity) {

		Client client = this.clientService.update(id, entity);

		return ResponseEntity.ok(client);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	private ResponseEntity<Client> findById(@PathVariable String id) {

		Client client = this.clientService.findById(id);

		return ResponseEntity.ok(client);
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	private ResponseEntity<Iterable<Client>> findAll() {

		Iterable<Client> client = this.clientService.findAll();

		return ResponseEntity.ok(client);
	}

	@ResponseStatus(HttpStatus.NO_CONTENT)
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	private void delete(@PathVariable String id) {
		this.clientService.deleteById(id);
	}
}
