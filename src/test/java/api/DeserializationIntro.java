package api;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

public class DeserializationIntro {
    @Test
    public void getAllUsersName () throws URISyntaxException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https")  //  schema or protocol
                .setHost("reqres.in")  //  host or domain
                .setPath("api/users")  //  path parameter
                .setCustomQuery("page=2");   // query parameter on APache
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("Accept", "application/json");
        HttpResponse response = httpClient.execute(httpGet);
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> allUsers = objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {
                });
        List<Map<String, Object>> usersDataList = (List<Map<String, Object>>) allUsers.get("data");
        for (int i = 0; i < usersDataList.size(); i++) {
            String firstName = (String) usersDataList.get(i).get("first_name");
            System.out.println(firstName);
        }
    }

    @Test
    public void requestUser5 () throws URISyntaxException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https")  //  schema or protocol
                .setHost("reqres.in")  //  host or domain
                .setPath("api/users/5"); //  path parameter
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("Accept", "application/json");
        HttpResponse response = httpClient.execute(httpGet);
        ObjectMapper objectMapper = new ObjectMapper(); // to convert java type
        Map<String, Object> UserData = objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {
                });
        Map<String, Object> singleUSer = (Map<String, Object>) UserData.get("data");
        String name = (String) singleUSer.get("first_name");
        String lastName = (String) singleUSer.get("last_name");
        String email = (String) singleUSer.get("email");
        String id = (String) singleUSer.get("id");
        System.out.println(name + " " + lastName + " " + email);
    }

    @Test
    public void petStatus () throws URISyntaxException, IOException {
        HttpClient httpClient = HttpClientBuilder.create().build();
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https")  //  schema or protocol
                .setHost("petstore.swagger.io")  //  host or domain
                .setPath("v2/findByStatus") //  path parameter
                .setCustomQuery("status=jan");
        HttpGet httpGet = new HttpGet(uriBuilder.build());
        httpGet.addHeader("Accept", "application/json");
        HttpResponse response = httpClient.execute(httpGet);
        ObjectMapper objectMapper = new ObjectMapper(); // to convert java type
        Map<String, Object> petStatus = objectMapper.readValue(response.getEntity().getContent(),
                new TypeReference<Map<String, Object>>() {
                });
        Map<String, Object> categoryData = (Map<String, Object>) petStatus.get("category");
        String categoryName = (String) categoryData.get("name");
        System.out.println("Category name:" + categoryName);
        String name = (String) categoryData.get("name");
        System.out.println("Regular name" + name);
        Map<String, Object> categoryTags = (Map<String, Object>) petStatus.get("tags");
        String tagName = (String) categoryData.get("name");
        System.out.println("Category name:" + tagName);
        System.out.println(categoryData.get("status"));
    }
}

