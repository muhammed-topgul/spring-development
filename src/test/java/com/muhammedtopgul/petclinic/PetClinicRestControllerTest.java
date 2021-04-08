package com.muhammedtopgul.petclinic;

/*
 * created by Muhammed Topgul
 * on 08/04/2021
 * at 21:19
 */

import com.muhammedtopgul.petclinic.entity.OwnerEntity;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class PetClinicRestControllerTest {

    private RestTemplate restTemplate;
    private final String URL = "http://localhost:8080/api/owners";

    @Before
    public void setUp() {
        restTemplate = new RestTemplate();
    }

    @Test
    public void testGetOwnerById() {
        ResponseEntity<OwnerEntity> response = restTemplate.getForEntity(URL + "/1", OwnerEntity.class);

        MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
        MatcherAssert.assertThat(Objects.requireNonNull(response.getBody()).getFirstName(), Matchers.equalTo("Muhammed"));
    }

    @Test
    public void testGetOwnersByLastName() {
        ResponseEntity<List> response = restTemplate.getForEntity(URL + "/filter?lastName=Topgül", List.class);

        MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
        List<Map<String, String>> body = response.getBody();
        List<String> firstNames = body.stream().map(e -> e.get("firstName")).collect(Collectors.toList());
        MatcherAssert.assertThat(firstNames, Matchers.containsInAnyOrder("Muhammed", "Orhan", "Hüseyin"));
    }

    @Test
    public void testGetOwners() {
        ResponseEntity<List> response = restTemplate.getForEntity(URL, List.class);

        MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
    }
}
