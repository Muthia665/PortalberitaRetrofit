package com.example.user.portalberitaretrofit;

import com.example.user.portalberitaretrofit.Respon.BeritaItem;
import com.example.user.portalberitaretrofit.Respon.ResponseBerita;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {

    @GET("berita.php")
    Call<ResponseBerita> getDetailBerita();

    @POST("detail_berita.php")
    Call<BeritaItem> getIsiBerita();


}
