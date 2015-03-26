package com.example.samaracatalina.mongo.net;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

/**
 * Created by Mobile 14 on 26/03/2015.
 */
public class HttpConection {

    HttpURLConnection con;
    String baseUrl;

    public HttpConection(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    //data etiqueta=valor&etiqueta2=valor2
    public String getString(String data) throws IOException {

        String urlC=baseUrl;
        if(data!=null)
            urlC= baseUrl+"?"+data;

        URL url = new URL(urlC);

        con = (HttpURLConnection) url.openConnection();
        InputStream iS = con.getInputStream();
        return processStream(iS);
    }

    public InputStream getStream(String data) throws IOException {
        String urlC=baseUrl;
        if(data!=null)
            urlC= baseUrl+"?"+data;

        URL url = new URL(urlC);

        con = (HttpURLConnection) url.openConnection();
        InputStream iS = con.getInputStream();
        return  iS;
    }

    //form etiqueta=valor&etiqueta2=valor2
    public void postForm(String form) throws IOException {

        URL url = new URL(baseUrl);
        con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("POST");
        con.setDoOutput(true);
        OutputStream out = con.getOutputStream();

        OutputStreamWriter writer = new OutputStreamWriter(out);

        writer.write(form);
        writer.flush();
        disconnectHttpCon();
    }

    public void postJson(String json) throws IOException {
        URL url = new URL(baseUrl);
        con = (HttpURLConnection) url.openConnection();

        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type","application/json");
        con.setDoOutput(true);
        OutputStream out = con.getOutputStream();

        OutputStreamWriter writer = new OutputStreamWriter(out);

        writer.write(json);
        writer.flush();
        disconnectHttpCon();
    }

    public String processStream(InputStream iS) throws IOException {
        InputStreamReader reader = new InputStreamReader(iS);
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        int ch;

        String rta =  null;

        while((ch = reader.read())!=-1)
            stream.write(ch);

        rta = new String(stream.toByteArray());
        disconnectHttpCon();
        return rta;
    }

    public void disconnectHttpCon(){
        if(con!=null)
            con.disconnect();
    }
}
