package com.ngiersz.scraper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

// TODO: think about better name
public class Connection {

    private URL url;
    private HttpURLConnection con;

    public Connection(String path)
            throws IOException {
        this.url = new URL(path);
        this.con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
    }

    public String getResponse() throws IOException {
        con = (HttpURLConnection) this.url.openConnection();
        int status = con.getResponseCode();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();
        return content.toString();
    }
}
