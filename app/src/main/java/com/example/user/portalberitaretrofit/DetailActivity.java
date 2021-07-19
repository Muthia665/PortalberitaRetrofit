package com.example.user.portalberitaretrofit;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.portalberitaretrofit.Respon.BeritaItem;
import com.example.user.portalberitaretrofit.Respon.ResponseBerita;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {

    TextView txtjudul, txtisi;
    ImageView imgdetail;
    String id, judul, isi, gambar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        txtjudul = findViewById(R.id.detailJudul);
        txtisi = findViewById(R.id.detailIsi);
        imgdetail = findViewById(R.id.imgDetail);

        Intent a = getIntent();
        id = a.getStringExtra("id");
        judul = a.getStringExtra("judul");
        isi = a.getStringExtra("isi");
        gambar = a.getStringExtra("gambar");


        detailberita();
    }

    private void detailberita() {
        txtjudul.setText(judul);
        txtisi.setText(isi);
        String url_foto = "http://192.168.100.4/portal_berita/foto_berita/";
        Picasso.with(this).load(url_foto + gambar).into(imgdetail);
    }
}
