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
     * @Operation: CREAR CLIENTE
     * @Param: CLIENT REQUEST DTO OBJECT
     * @Return: CLIENT DTO OBJECT
     * */
    @Override
    public ResponseEntity<ClientDTO> createClient(ClientRequestDTO clientRequestDTO) {
        ClientDTO response = this.clientService.save(clientRequestDTO);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    /**
     * GET
     * @Operation: LISTAR CLIENTES POR PROVINCIA
     * @Param: INTEGER ID
     * @Return: CLIENT LIST DTO
     * */
    @Override
    public ResponseEntity<ClientListDTO> getAllClientsByProvince(Integer idProvince) {
        return ClientsApiDelegate.super.getAllClientsByProvince(idProvince);
    }

    /**
     * GET
     * @Operation: LISTAR TODOS LOS CLIENTES
     * @Param: -
     * @Return: CLIENT LIST DTO
     * * */
    @Override
    public ResponseEntity<ClientListDTO> retrieveAll() {
        ClientListDTO response = new ClientListDTO().items(this.clientService.findAll());
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    /**
     * GET
     * @Operation: BUSCAR CLIENTE POR ID
     * @Param: INTEGER ID
     * @Return: CLIENTE DTO OBJECT
     * * */
    @Override
    public ResponseEntity<ClientDTO> retrieveClientById(Integer id) {
        ClientDTO response = this.clientService.findById(id);
        System.out.println("id resibido "+id);
        System.out.println("responde por api microservice");
        System.out.println(response);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    /**
     * POST
     * @Operation: ACTUALIZAR CLIENTE
     * @Param: CLIENT DTO OBJECT
     * @Return: CLIENT DTO OBJECT (MODIFIED)
     * * */
    @Override
    public ResponseEntity<ClientDTO> updateClient(ClientDTO clientDTO) {
        ClientDTO response = this.clientService.update(clientDTO);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    /**
     * POST
     * @Operation: RETORNA CLIENTE POR SU NOMBRE
     * @Param: STRING
     * @Return: CLIENT LIST
     * * */
    @Override
    public ResponseEntity<ClientListDTO> retrieveClientByName(String name) {

        if (name.isEmpty() || name == null)
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .build();

        ClientListDTO response = new ClientListDTO().items(this.clientService.findByName(name));


        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @Override
    public ResponseEntity<ClientDTO> retrieveClientByDni(Integer dni) {

        if(dni == null)
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

        if((dni instanceof Integer) == false) {
            throw new NumberFormatException();
        }

        return ResponseEntity.status(HttpStatus.OK).body(this.clientService.findByDni(dni));
    }
}
