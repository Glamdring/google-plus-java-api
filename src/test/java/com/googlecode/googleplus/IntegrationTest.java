package com.googlecode.googleplus;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;
import static com.github.tomakehurst.wiremock.client.WireMock.urlMatching;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import com.googlecode.googleplus.impl.PeopleOperationsImpl;
import com.googlecode.googleplus.model.person.Person;
import com.googlecode.googleplus.model.person.PersonName;

public class IntegrationTest {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(8089);

    private ObjectMapper mapper = new ObjectMapper();

    @Test
    public void simpleIntegrationTest() throws Exception {
        pointToLocalhost();

        Person person = new Person();
        person.setId("1");
        person.setName(new PersonName());
        person.getName().setGivenName("Foo");
        person.getName().setFamilyName("Bar");
        stubFor(get(urlMatching(".+"))
                .willReturn(aResponse()
                        .withHeader("Content-Type", "application/json")
                        .withBody(mapper.writeValueAsString(person)))
                );

        GooglePlusFactory factory = new GooglePlusFactory("clientId", "secret");
        Plus plus = factory.getApi("access", "refresh", null);
        Person result = plus.getPeopleOperations().get("1");

        assertEquals("IDs must match", person.getId(), result.getId());
        assertEquals("Names must match", person.getName().getGivenName(), result.getName().getGivenName());
    }

    private void pointToLocalhost() throws NoSuchFieldException, IllegalAccessException {
        //reset constant to point to localhost
        Field fld = PeopleOperationsImpl.class.getDeclaredField("GET_URL");
        setValue(fld, "http://localhost:8089/people/{id}");
    }

    private void setValue(Field fld, Object value) throws NoSuchFieldException, IllegalAccessException {
        fld.setAccessible(true);

        Field modifiersField = Field.class.getDeclaredField("modifiers");
        modifiersField.setAccessible(true);
        modifiersField.setInt(fld, fld.getModifiers() & ~Modifier.FINAL);

        fld.set(null, value);
    }
}
