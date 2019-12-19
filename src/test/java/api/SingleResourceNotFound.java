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

public class SingleResourceNotFound {

    @Test
    public void SingleResourceNotFound () throws URISyntaxException, IOException {

        // Creating a client
        HttpClient httpClient = HttpClientBuilder.create().build();

        // Constructing URL
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("reqres.in")
                .setPath("api/unknown/23");

        // Defining a GET method
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("Accept", "application.json");

        // Executing the API call
        HttpResponse httpResponse = httpClient.execute(httpGet);

        // Validate
        Assert.assertEquals(HttpStatus.SC_OK, httpResponse.getStatusLine().getStatusCode());
    }
}
