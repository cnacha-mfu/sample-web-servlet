package com.example;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Response;

import org.hamcrest.CoreMatchers;
import org.junit.AfterClass;
import org.junit.BeforeClass;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CalculatorIT {
    private static Client client;
    private static Logger _logger = LoggerFactory.getLogger(CalculatorIT.class);
    private static String WEB_URI = "http://localhost:8080/calculate";

    @BeforeClass
    public static void createClient() {
        // Use ClientBuilder to create a new client that can be used to create
        // connections to the Web service.
        client = ClientBuilder.newClient();
    }

    @AfterClass
    public static void closeConnection() {
        client.close();
    }

    @Test
    public void testCalculate() {
        Response response = client.target(WEB_URI).queryParam("num1", 5).queryParam("num2", 7).request().get();
        assertEquals(200, response.getStatus());
        String result = response.readEntity(String.class);
        assertThat(result, CoreMatchers.containsString("12"));

    }

    @Test
    public void testCalculate2() {
        Response response = client.target(WEB_URI).queryParam("num1", 5).queryParam("num2", 7).request().get();
        assertEquals(200, response.getStatus());
        String result = response.readEntity(String.class);
        assertThat(result, CoreMatchers.containsString("12"));

    }

}
