package com.example.user.portalberitaretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Adapter;

import com.example.user.portalberitaretrofit.Respon.BeritaItem;
import com.example.user.portalberitaretrofit.Respon.ResponseBerita;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        ambilData();
    }

    private void ambilData() {
        onfigRetrofit.service.getDetailBerita().enqueue(new Callback<ResponseBerita>() {
            @Override
            public void onResponse(Call<ResponseBerita> call, Response<ResponseBerita> response) {
                if (response.isSuccessful()){
                    //ambil item semuanya
                    List<BeritaItem> data = response.body().getBerita();

                    //masukin datanya keadapteran
                    AdapterRV adapterRV = new AdapterRV(data);

                    //set adapter ke recycler view
                    recyclerView.setAdapter(adapterRV);

                    //set layout adapter
                    recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                }
            }

            @Override
            public void onFailure(Call<ResponseBerita> call, Throwable t) {
                Log.d("error",t.getMessage());
            }
        });
    }
}
