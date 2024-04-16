package com.Microservice.clientService.Repository;

import com.Microservice.clientService.Entity.AddressEntity;
import com.Microservice.clientService.Entity.LocationEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
public class AddressRepositoryUnitTest {

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private LocationRepository locationRepository;


    @BeforeEach
    public void setUp() {
        Random random = new Random();

        LocationEntity locationPre =this.locationRepository.save(LocationEntity.builder()
                .id(1)
                .name("Junin")
                .postalCode(1400)
                .provinceEntity(null)
                .build());

        IntStream.range(0, 20).forEach((i) -> {
            AddressEntity address = AddressEntity.builder()
                    .id(i)
                    .number(random.nextInt(1000))
                    .location(null)
                    .name(RandomChar())
                    .build();

            if(i == 17)
                address.setLocation(locationPre);

            this.addressRepository.save(address);
        });



    }

    private String RandomChar() {
        Random random = new Random();

        String word = "";
        String[] letters = {"A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N",
                "Ñ", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Z", "a", "b", "c", "d", "e", "f", "g",
                "h", "i", "j", "k", "l", "m", "n", "ñ", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "z"};


        word = IntStream.range(0, random.nextInt(15))
                .mapToObj(i -> letters[random.nextInt(letters.length)])
                .collect(Collectors.joining());

        return word;
    }

    @Test
    public void InjectedTest() {
        assertNotNull(addressRepository);
    }

    @Test
    public void save1() {

        AddressEntity address = AddressEntity.builder()
                .name(RandomChar())
                .number(new Random().nextInt(1000))
                .location(null)
                .build();

        AddressEntity response = this.addressRepository.save(address);

        assertNotNull(response);
        assertNull(response.getLocation());
        assertEquals(address, response);

    }

    @Test
    public void save2() {
        AddressEntity address = AddressEntity.builder()
                .name(RandomChar())
                .number(new Random().nextInt(1000))
                .location(LocationEntity.builder()
                        .id(1)
                        .postalCode(1400)
                        .name("Junin")
                        .provinceEntity(null)
                        .build())
                .build();

        AddressEntity response = this.addressRepository.save(address);

        assertNotNull(response);
        assertNotNull(response.getLocation());
        assertEquals(address, response);

    }

    @Test
    public void find() {
        List<AddressEntity> clienList = this.addressRepository.findAll();
        assertNotNull(clienList);
        assertTrue(clienList.isEmpty() == false);
        assertNotNull(clienList.get(2));
        assertNotNull(clienList.size() == 20);
    }

    @Test
    public void findById() {
        List<AddressEntity> AddressEntityList = this.addressRepository.findAll();
        AddressEntity addressDB = this.addressRepository.findById(AddressEntityList.get(2).getId()).get();
        AddressEntity addressEntity = AddressEntityList.get(2);

        assertNotNull(addressDB);
        assertEquals(addressEntity.getName(), addressDB.getName());
        assertEquals(addressEntity.getNumber(), addressDB.getNumber());
        assertEquals(addressEntity, addressDB);
    }

    @Test
    public void findByAttribute(){
        List<AddressEntity> AddressEntityList = this.addressRepository.findAll();
        AddressEntity addressEntity = AddressEntityList.stream().filter(e -> e.getId() == 17).collect(Collectors.toList()).get(0);
        AddressEntity addressDB = this.addressRepository.findByAttribute(addressEntity.getName(),addressEntity.getNumber(),addressEntity.getLocation().getId());

        assertNotNull(addressDB);
        assertEquals(addressEntity.getName(), addressDB.getName());
        assertEquals(addressEntity.getNumber(), addressDB.getNumber());
        assertEquals(addressEntity.getLocation(),addressDB.getLocation());
        assertEquals(addressEntity, addressDB);
    }

    @Test
    public void removeById(){

        AddressEntity address = this.addressRepository.findById(2).get();

        assertNotNull(address);

        this.addressRepository.deleteById(address.getId());

        assertFalse(this.addressRepository.findById(2).isPresent());

    }
}


