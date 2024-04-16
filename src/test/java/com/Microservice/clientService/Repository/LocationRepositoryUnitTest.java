package com.Microservice.clientService.Repository;

import com.Microservice.clientService.Entity.LocationEntity;
import com.Microservice.clientService.Entity.ProvinceEntity;
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
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@AutoConfigureTestDatabase
public class LocationRepositoryUnitTest {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private ProvinceRepository provinceRepository;


    @BeforeEach
    public void setUp() {
        Random random = new Random();

        ProvinceEntity provinceEntity = ProvinceEntity.builder()
                .id(1)
                .name("Buenos Aires")
                .build();

        this.provinceRepository.save(provinceEntity);

        IntStream.range(0, 20).forEach((i) -> {

            LocationEntity location = LocationEntity.builder()
                    .id(i)
                    .name(RandomChar())
                    .postalCode(new Random().nextInt(1000))
                    .provinceEntity(null)
                    .build();

            if( i == 17)
                location.setProvinceEntity(provinceEntity);

            this.locationRepository.save(location);
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
        assertNotNull(locationRepository);
    }

    @Test
    public void save1() {

        LocationEntity location = LocationEntity.builder()
                .name(RandomChar())
                .postalCode(new Random().nextInt(1000))
                .provinceEntity(null)
                .build();


        LocationEntity response = this.locationRepository.save(location);

        assertNotNull(response);
        assertNull(response.getProvinceEntity());
        assertEquals(location, response);

    }

    @Test
    public void save2() {
        LocationEntity location = LocationEntity.builder()
                .name(RandomChar())
                .postalCode(new Random().nextInt(1000))
                .provinceEntity(ProvinceEntity.builder()
                        .id(1)
                        .name("Buenos Aires")
                        .build())
                .build();


        LocationEntity response = this.locationRepository.save(location);

        assertNotNull(response);
        assertNotNull(response.getProvinceEntity());
        assertEquals(location, response);

    }

    @Test
    public void find() {
        List<LocationEntity> locationList = this.locationRepository.findAll();
        assertNotNull(locationList);
        assertTrue(locationList.isEmpty() == false);
        assertNotNull(locationList.get(2));
        assertNotNull(locationList.size() == 20);
    }

    @Test
    public void findById() {
        List<LocationEntity> locationEntityList = this.locationRepository.findAll();
        LocationEntity locationDB = this.locationRepository.findById(locationEntityList.get(2).getId()).get();
        LocationEntity locationEntity = locationEntityList.get(2);

        assertNotNull(locationDB);
        assertEquals(locationEntity.getName(), locationDB.getName());
        assertEquals(locationEntity.getPostalCode(), locationDB.getPostalCode());
        assertEquals(locationEntity, locationDB);
    }

    @Test
    public void findByIdName(){
        List<LocationEntity> locationEntityList = this.locationRepository.findAll();
        LocationEntity locationEntity = locationEntityList.stream().filter(e -> e.getId() == 17).collect(Collectors.toList()).get(0);
        LocationEntity locationDB = this.locationRepository.findByidProvince(locationEntity.getProvinceEntity().getId(),locationEntity.getName());

        assertNotNull(locationDB);
        assertEquals(locationEntity.getName(), locationDB.getName());
        assertEquals(locationEntity.getPostalCode(), locationDB.getPostalCode());
        assertEquals(locationEntity.getProvinceEntity(),locationDB.getProvinceEntity());
        assertEquals(locationEntity, locationDB);
    }

    @Test
    public void removeById(){

        LocationEntity location = this.locationRepository.findById(2).get();

        assertNotNull(location);

        this.locationRepository.deleteById(location.getId());

        assertFalse(this.locationRepository.findById(2).isPresent());

    }
}
