package com.Microservice.clientService.Controller;

import com.Microservice.clientService.ClientsApiDelegate;
import com.Microservice.clientService.Service.ClientService;
import com.Microservice.clientService.model.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/clients")
public class ClientController implements ClientsApiDelegate {

    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public Optional<NativeWebRequest> getRequest() {
        return ClientsApiDelegate.super.getRequest();
    }

    /**
     * POST
     * */
    @Override
    public ResponseEntity<ClientDTO> createClient(ClientRequestDTO clientRequestDTO) {
        ClientDTO response = this.clientService.save(clientRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    /**
     * GET
     * */
    @Override
    public ResponseEntity<ClientListDTO> getAllClientsByProvince(Integer idProvince) {
        return ClientsApiDelegate.super.getAllClientsByProvince(idProvince);
    }

    /**
     * GET
     * */
    @Override
    public ResponseEntity<ClientListDTO> retrieveAll() {
        ClientListDTO response = new ClientListDTO().items(this.clientService.findAll());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    /**
     * GET
     * */
    @Override
    public ResponseEntity<ClientDTO> retrieveClientById(Integer id) {
        ClientDTO response = this.clientService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    /**
     * POST
     * */
    @Override
    public ResponseEntity<ClientDTO> updateClient(ClientDTO clientDTO) {
        return ClientsApiDelegate.super.updateClient(clientDTO);
    }
}
