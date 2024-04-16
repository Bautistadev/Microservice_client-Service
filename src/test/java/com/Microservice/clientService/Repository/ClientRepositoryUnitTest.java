package com.Microservice.clientService.Repository;

import com.Microservice.clientService.Entity.AddressEntity;
import com.Microservice.clientService.Entity.ClientEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;


import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
public class ClientRepositoryUnitTest {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private AddressRepository addressRepository;



    @BeforeEach
    public void setUp(){

        Random random = new Random();

        /**
         * crea 10 objetos aleatorios
         * */
        IntStream.range(0,20).forEach(i->{
            ClientEntity clientEntity = ClientEntity.builder()
                    .id(i)
                    .name(RandomChar())
                    .lastname(RandomChar())
                    .dni(random.nextInt(1000000))
                    .email(RandomChar())
                    .cuil(random.nextInt(1000000))
                    .telephone(String.valueOf(random.nextInt(10000)))
                    .address(null)
                    .build();
            this.clientRepository.save(clientEntity);
        });

        AddressEntity addressEntity = AddressEntity.builder()
                .id(1)
                .number(1400)
                .name("RAUCH")
                .location(null).build();

        this.addressRepository.save(addressEntity);
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
    public void InjectedTest(){
        assertNotNull(clientRepository);
    }
    @Test
    public void save1(){

        ClientEntity clientEntity = ClientEntity.builder()
                .name("test")
                .lastname("test")
                .dni(10000000)
                .email("admin@gmail")
                .birth(LocalDate.now())
                .telephone("2132132")
                .cuil(10000002)
                .address(null).build();

        ClientEntity response = clientRepository.save(clientEntity);

        assertNotNull(response);
        assertEquals(response,clientEntity);
        assertNull(response.getAddress());

    }

    @Test
    public void save2(){
        ClientEntity clientEntity = ClientEntity.builder()
                .name("test")
                .lastname("test")
                .dni(10000000)
                .email("admin@gmail")
                .birth(LocalDate.now())
                .telephone("2132132")
                .cuil(10000002)
                .address(
                        AddressEntity.builder()
                                .id(1)
                                .name("RAUCH")
                                .number(1400)
                                .location(null).build()
                ).build();

        ClientEntity response = clientRepository.save(clientEntity);

        assertNotNull(response);
        assertEquals(response,clientEntity);
        assertNotNull(response.getAddress());

    }

    @Test
    public void find(){
        List<ClientEntity> clientEntityList = this.clientRepository.findAll();

        assertNotNull(clientEntityList);
        assertTrue(clientEntityList.isEmpty() == false);
        assertNotNull(clientEntityList.get(2));
    }

    @Test
    public void FindById(){
        List<ClientEntity> clientEntityList = this.clientRepository.findAll();
        ClientEntity entityDB = this.clientRepository.findById(clientEntityList.get(2).getId()).get();
        ClientEntity entityList = clientEntityList.get(2);

        assertNotNull(entityDB);
        assertEquals(entityList.getDni(), entityDB.getDni());
        assertEquals(entityList.getCuil(),entityDB.getCuil());
        assertEquals(entityDB,entityList);
    }

    @Test
    public void removeById(){
        ClientEntity entityDB = this.clientRepository.findById(2).get();
        /**
         * verificamos existencia
         * */
        assertNotNull(entityDB);

        /**
         * borramos
         * */
        this.clientRepository.deleteById(entityDB.getId());
        /**
         * aseguramos su borrado
         * */
        assertFalse(this.clientRepository.findById(2).isPresent());

    }
    @AfterEach
    public void end(){
        System.out.println("END");
    }
}
