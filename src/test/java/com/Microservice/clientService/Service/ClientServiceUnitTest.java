package com.Microservice.clientService.Service;

import com.Microservice.clientService.Entity.AddressEntity;
import com.Microservice.clientService.Entity.ClientEntity;
import com.Microservice.clientService.Repository.AddressRepository;
import com.Microservice.clientService.Repository.ClientRepository;
import com.Microservice.clientService.Service.Mapper.ClientMapper;
import com.Microservice.clientService.Service.Mapper.ClientMapperImplements;
import com.Microservice.clientService.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@AutoConfigureTestDatabase
public class ClientServiceUnitTest {

    @Autowired
    private ClientMapper mapper;

    @Mock
    private ClientMapper clientMapper;

    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientService clientService;

    @BeforeEach
    public void BeforeTest(){
        MockitoAnnotations.openMocks(this);
    }

    private String RandomChar(){
        Random random = new Random();

        String word="";
        String[] letters = {"A","B","C","D","E","F","G","H","I","J","K","L","M","N",
                "Ñ","O","P","Q","R","S","T","U","V","W","X","Z","a","b","c","d","e","f","g",
                "h","i","j","k","l","m","n","ñ","o","p","q","r","s","t","u","v","w","x","z"};


        word = IntStream.range(0,random.nextInt(15))
                .mapToObj(i->letters[random.nextInt(letters.length)])
                .collect(Collectors.joining());

        return word;
    }

    @Test
    public void setUp(){
        assertNotNull(clientMapper);
        assertNotNull(clientRepository);
        assertNotNull(clientService);
    };
    @Test
    public void save1(){
        //Objeto observado
        ClientRequestDTO clientRequestDTO = new ClientRequestDTO()
                .name("test")
                .lastname("test")
                .dni(10000000)
                .email("test@gmail")
                .birth(LocalDate.now())
                .telephone("2132132")
                .cuil(10000002)
                .address(new AddressDTO().id(1)
                        .number(1400)
                        .name("Maestro argentino")
                        .location(new LocationDTO().id(1)
                                .name("Junin")
                                .postalCode(6666)
                                .province(new ProvinceDTO().id(1).name("Buenos Aires"))));

        //objecto esperado
        ClientDTO clientDTO = new ClientDTO()
                .id(1)
                .name("test")
                .lastname("test")
                .dni(10000000)
                .email("test@gmail")
                .birth(LocalDate.now())
                .telephone("2132132")
                .cuil(10000002)
                .address(new AddressDTO().id(1)
                        .number(1400)
                        .name("Maestro argentino")
                        .location(new LocationDTO().id(1)
                                .name("Junin")
                                .postalCode(6666)
                                .province(new ProvinceDTO().id(1).name("Buenos Aires"))));

        //Configuramos comportamiento de los metodos en observacion del mock ClientRepository
        when(this.clientRepository.save(any(ClientEntity.class))).thenReturn(new ClientEntity());
        when(this.clientMapper.map(any(ClientRequestDTO.class))).thenReturn(new ClientEntity());
        when(this.clientMapper.map(any(ClientEntity.class))).thenReturn(clientDTO);


        //llamamos al metodo en observacion
        ClientDTO clientCreated = this.clientService.save(clientRequestDTO);

        //verificamos la llamada del al metodo observado
        verify(clientRepository,times(1)).save(any(ClientEntity.class));
        verify(clientMapper,times(1)).map(any(ClientEntity.class));


        //verificamos valores resultantes con los esperados
        assertEquals(clientRequestDTO.getCuil(),clientCreated.getCuil());
        assertEquals(clientRequestDTO.getBirth(),clientCreated.getBirth());
        assertEquals(clientRequestDTO.getEmail(),clientCreated.getEmail());

    };
    @Test
    public void save2(){};
    @Test
    public void find(){

        //objeto esperado
        List<ClientDTO> clientDTOList = new ArrayList<>();
        clientDTOList.add(new ClientDTO()
                .id(1)
                .name(RandomChar())
                .lastname(RandomChar())
                .dni(10000000)
                .email(RandomChar())
                .birth(LocalDate.now())
                .telephone("2132132")
                .cuil(10000002)
                .address(new AddressDTO().id(1)
                        .number(1400)
                        .name(RandomChar())
                        .location(new LocationDTO().id(1)
                                .name(RandomChar())
                                .postalCode(6666)
                                .province(new ProvinceDTO().id(1).name(RandomChar())))));
        clientDTOList.add(new ClientDTO()
                .id(2)
                .name(RandomChar())
                .lastname(RandomChar())
                .dni(10000001)
                .email(RandomChar())
                .birth(LocalDate.now())
                .telephone("2132132")
                .cuil(10000003)
                .address(new AddressDTO().id(1)
                        .number(1400)
                        .name(RandomChar())
                        .location(new LocationDTO().id(1)
                                .name(RandomChar())
                                .postalCode(6666)
                                .province(new ProvinceDTO().id(1).name(RandomChar())))));



        when(clientRepository.findAll()).thenReturn(clientDTOList.stream().map(e ->{
            return mapper.map(e);
        }).collect(Collectors.toList()));
        when(clientMapper.map(any(ClientEntity.class))).thenReturn(new ClientDTO());

        List<ClientDTO> resultClientList = this.clientService.findAll();

        verify(clientRepository,times(1)).findAll();
        verify(clientMapper,times(2)).map(any(ClientEntity.class));

    };
    @Test
    public void findById(){};
    @Test
    public void removeById(){};


}
