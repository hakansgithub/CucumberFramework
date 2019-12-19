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

public class GetUserList {

    @Test
    public void GetUserList() throws URISyntaxException, IOException {

        HttpClient httpClient = HttpClientBuilder.create().build();

        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https")
                .setHost("reqres.in")
                .setPath("api/users?page=2");

        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("Accept", "application.json");

        HttpResponse httpResponse = httpClient.execute(httpGet);

        Assert.assertEquals(HttpStatus.SC_OK, httpResponse.getStatusLine().getStatusCode());
    }
}
