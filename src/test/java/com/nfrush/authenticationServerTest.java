package com.nfrush;

import com.google.gson.Gson;
import com.nfrush.Client.SSLClient;
import com.nfrush.Domains.JSON.Greeting;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.apache.commons.httpclient.URI;

import java.io.IOException;

/**
 * Created by nfrush on 6/7/17.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class authenticationServerTest {

    static
    {
        System.setProperty("http.nonProxyHosts", "*localhost");
    }

    @Test
    public void HelloControllerNoParamsTest() throws IOException{
        SSLClient sslClient = new SSLClient();
        Gson g = new Gson();
        Greeting response = g.fromJson(sslClient.getURL(new URI("https://localhost:8443/hello", false)), Greeting.class);
        assert(response.getContent()).equals("Hello, Stranger!");
    }

    @Test
    public void HelloControllerParamsTest() throws IOException{
        String requestParam = "test";
        SSLClient sslClient = new SSLClient();
        Gson g = new Gson();
        Greeting response = g.fromJson(sslClient.getURL(new URI("https://localhost:8443/hello?name=" + requestParam, false)), Greeting.class);
        assert(response.getContent()).equals("Hello, " + requestParam + "!");
    }

    @Test
    public void UserControllerTest() throws IOException{
        SSLClient sslClient = new SSLClient();
        Gson g = new Gson();
        Greeting response = g.fromJson(sslClient.getURL(new URI("https://localhost:8443/user", false)), Greeting.class);
        assert(response.getContent()).equals("Identified User: cid!");
    }
}
