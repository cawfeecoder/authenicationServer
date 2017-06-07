package com.nfrush.Client;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.methods.GetMethod;

import javax.xml.ws.http.HTTPException;
import java.io.IOException;


/**
 * Created by nfrush on 6/6/17.
 */

public class SSLClient {

    final static String KEYSTORE_PASSWORD = "changeit";

    static
    {
        System.setProperty("javax.net.ssl.trustStore", "/home/nfrush/workspace/x509-client/src/main/resources/client.jks");
        System.setProperty("javax.net.ssl.trustStorePassword", KEYSTORE_PASSWORD);
        System.setProperty("javax.net.ssl.keyStore", "/home/nfrush/workspace/x509-client/src/main/resources/client.jks");
        System.setProperty("javax.net.ssl.keyStorePassword", KEYSTORE_PASSWORD);

    }

    public String getURL(URI url) throws HTTPException, IOException {
        HttpClient client = new HttpClient();
        GetMethod method = new GetMethod();
        method.setURI(url);
        client.executeMethod(method);

        return method.getResponseBodyAsString();
    }
}

