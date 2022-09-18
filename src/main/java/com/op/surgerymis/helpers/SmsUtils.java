package com.op.surgerymis.helpers;

import okhttp3.*;
import org.apache.tomcat.util.http.parser.MediaType;
import org.springframework.http.client.OkHttp3ClientHttpRequestFactory;

import java.io.IOException;

public class SmsUtils {
    public void send(String recipient,String message) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder()
                .build();

        RequestBody body = new MultipartBody.Builder().setType(MultipartBody.FORM)
                .addFormDataPart("recipients", recipient)
                .addFormDataPart("message", message)
                .addFormDataPart("sender", "+250788671144")
                .build();
        Request request = new Request.Builder()
                .url("https://www.intouchsms.co.rw/api/sendsms/.json")
                .method("POST", body)
                .addHeader("auth", "Channy:Channy@Inema!")
                .addHeader("Authorization", "Basic Q2hhbm55OkNoYW5ueUBJbmVtYSE=")
                .build();

        Response response = client.newCall(request).execute();
        System.out.println(response.message());
    }
}
