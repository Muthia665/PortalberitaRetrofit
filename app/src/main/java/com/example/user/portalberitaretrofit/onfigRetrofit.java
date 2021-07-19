package com.example.user.portalberitaretrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class onfigRetrofit {
    public static Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.100.4/portal_berita/")

            .addConverterFactory(GsonConverterFactory.create()).build();

    public static ApiService service = retrofit.create(ApiService.class);
}
