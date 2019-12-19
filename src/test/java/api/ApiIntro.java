package api;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;

public class ApiIntro {

    @Test
    public void firstGetCall() throws URISyntaxException, IOException {

        // Creating a client (like postman)
        HttpClient httpClient = HttpClientBuilder.create().build();

        // Constracting URL
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("petstore.swagger.io")
                .setPath("v2/pet/1");

        //Defining a GET method
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("Accept", "application/json");

        // Executing the API call
        HttpResponse response = httpClient.execute(httpGet);
        Assert.assertEquals(HttpStatus.SC_OK, response.getStatusLine().getStatusCode());
    }


}
