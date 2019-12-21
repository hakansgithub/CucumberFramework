package api;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Map;

public class ApiIntro {

    @Test
    public void firstGetCall () throws URISyntaxException, IOException {

        ///for deserialization we use ->Jackson library
        ObjectMapper objectMapper = new ObjectMapper();

        //Creating client( like postman)
        HttpClient httpClient = HttpClientBuilder.create().build();

        // Constructing URL
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("petstore.swagger.io")
                .setPath("v2/pet/1");

        // Defining a Get method
        HttpGet httpGet = new HttpGet(uriBuilder.build());// it is class   also get  DEserilization
        httpGet.addHeader("Accept", "application/json");

        // Executing the api call
        HttpResponse response = httpClient.execute(httpGet);
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());

        // Jackson libraries
        Map<String, Object> firstDeserialization = objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {
                });
        System.out.println(firstDeserialization.get("id"));
        System.out.println(firstDeserialization.get("status"));

        Map<String, Object> categoryMap = (Map<String, Object>) firstDeserialization.get("category");
        String name = categoryMap.get("name").toString();
        Integer id = (Integer) categoryMap.get("id");
        System.out.println(categoryMap);
    }

    @Test
    public void getDogAndCatName () throws URISyntaxException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("petstore.swagger.io")
                .setPath("v2/pet/200");

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("Accept", "application/json");

        HttpResponse response = httpClient.execute(httpGet);

        Map<String, Object> firstDeserialization1 = objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {
                });

        System.out.println(firstDeserialization1.get("id"));
        System.out.println(firstDeserialization1.get("status"));

        Map<String, Object> categoryMap1 = (Map<String, Object>) firstDeserialization1.get("category");
        String name1 = categoryMap1.get("name").toString();
        int id1 = (int) categoryMap1.get("id");
        System.out.println(categoryMap1);

        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
    }

    @Test
    public void FirstNames () throws URISyntaxException, IOException {

        ObjectMapper objectMapper = new ObjectMapper();

        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("reqres.in")
                .setPath("api/users?page=2");

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("Accept", "application/json");

        HttpResponse response = httpClient.execute(httpGet);

        Map<String, Object> firstDeserialization2 = objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {
                });

        System.out.println(firstDeserialization2.get("first_name"));
        System.out.println(firstDeserialization2.get("status"));

        Map<String, Object> categoryMap1 = (Map<String, Object>) firstDeserialization2.get("category");
        String name1 = categoryMap1.get("first_name").toString();
        int id1 = (int) categoryMap1.get("id");
        System.out.println(categoryMap1);

        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
    }
}