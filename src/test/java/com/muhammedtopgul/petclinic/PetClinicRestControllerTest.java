package com.muhammedtopgul.petclinic;

/*
 * created by Muhammed Topgul
 * on 08/04/2021
 * at 21:19
 */

import com.muhammedtopgul.petclinic.entity.OwnerEntity;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;

public class PetClinicRestControllerTest {

    private RestTemplate restTemplate;
    private final String URL = "http://localhost:8080/api/owners";

    @Before
    public void setUp() {
        restTemplate = new RestTemplate();
        BasicAuthorizationInterceptor interceptor = new BasicAuthorizationInterceptor("admin", "admin");
        restTemplate.setInterceptors(Collections.singletonList(interceptor));
    }

    @Test
    public void testGetOwnerById() {
        ResponseEntity<OwnerEntity> response = restTemplate.getForEntity(URL + "/1", OwnerEntity.class);

        MatcherAssert.assertThat(response.getStatusCodeValue(), Matchers.equalTo(200));
        // MatcherAssert.assertThat(Objects.requireNonNull(response.getBody()).getFirstName(), Matchers.equalTo("Muhammed"));
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

    @Test
    public void testCreateOwner() {
        OwnerEntity postEntity = new OwnerEntity();
        postEntity.setFirstName("Mefa");
        postEntity.setLastName("Topgül");

        URI uri = restTemplate.postForLocation(URL, postEntity);

        assert uri != null;
        OwnerEntity getEntity = restTemplate.getForObject(uri, OwnerEntity.class);
        assert getEntity != null;
        MatcherAssert.assertThat(postEntity.getFirstName(), Matchers.equalTo(getEntity.getFirstName()));
    }

    @Test
    public void testOwnerUpdate() {
        OwnerEntity entityFromDb = restTemplate.getForObject(URL + "/1", OwnerEntity.class);

        MatcherAssert.assertThat(Objects.requireNonNull(entityFromDb).getFirstName(), Matchers.equalTo("Muhammed"));
        entityFromDb.setFirstName("Mamito");
        restTemplate.put(URL + "/1", entityFromDb);

        entityFromDb = restTemplate.getForObject(URL + "/1", OwnerEntity.class);
        MatcherAssert.assertThat(Objects.requireNonNull(entityFromDb).getFirstName(), Matchers.equalTo("Mamito"));
    }

    @Test
    public void testDeleteOwner() {
        restTemplate.delete(URL + "/1");
        try {
            restTemplate.getForEntity(URL + "/1", OwnerEntity.class);
            Assert.fail("Should have not returned...");
        } catch (RestClientException exception) {
            System.out.println("Exception: " + exception.getMessage());
        }
    }
}
