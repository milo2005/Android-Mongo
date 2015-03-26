package com.example.samaracatalina.mongo.net;

import android.os.AsyncTask;

import java.io.IOException;

/**
 * Created by Mobile 14 on 26/03/2015.
 */
//Entrada: DAtos, Progreso: respuesta, resultado:respuesta
public class HttpAsyncTask extends AsyncTask<String, String, String> {

    public static final int POST =0;
    public static final int GET =1;

    public static final int POST_JSON=0;
    public static final int POST_FORM=1;

    public interface HttpInterface{
        public void setResponse(String rta);
    }


    int method, posType;
    String url;
    HttpConection con;

    HttpInterface httpI;

    public HttpAsyncTask(HttpInterface httpI,String url){
        this.httpI = httpI;
        method = GET;
        this.url = url;
        con = new HttpConection(url);
    }

    public HttpAsyncTask(HttpInterface httpI,String url, int postType){
        this.httpI = httpI;
        this.url = url;
        this.posType = postType;
        method = POST;
        con = new HttpConection(url);
    }


    @Override
    protected String doInBackground(String... params) {
        String rta = null;

        for(int i=0; i<params.length;i++){
                try {
                    rta = excuteRequest(params[i]);
                    publishProgress(rta);
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return null;
    }

    @Override
    protected void onProgressUpdate(String... values) {
        httpI.setResponse(values[0]);
    }

    public String excuteRequest(String data) throws IOException {

        if(method == POST){
            if(posType == POST_FORM)
                con.postForm(data);
            else
                con.postJson(data);
            return "OK";
        }else{
            String rta = con.getString(data);
            return rta;
        }

    }
}
