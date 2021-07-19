package com.example.user.portalberitaretrofit;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.user.portalberitaretrofit.Respon.BeritaItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterRV extends RecyclerView.Adapter<AdapterRV.ViewHolder> {
    List<BeritaItem> dataSet;

    public AdapterRV(List<BeritaItem> data) {
        dataSet = data;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //view baru
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.listitem,viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.bind(dataSet.get(i));
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        //inisialisasi and deklarasi item yang ada di list item
        TextView txt;
        ImageView img;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txt = itemView.findViewById(R.id.txtItem);
            img = itemView.findViewById(R.id.ImgItem);

        }

        public void bind(final BeritaItem beritaItem) {
            txt.setText(beritaItem.getJudul());

            String url_foto = "http://192.168.100.4/portal_berita/foto_berita/";
            Picasso.with(itemView.getContext()).load(url_foto + beritaItem.getGambar()).into(img);

            //aksi ketika listviewnya dipencet
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(itemView.getContext().getApplicationContext(),DetailActivity.class);
                    i.putExtra("id", beritaItem.getId());
                    i.putExtra("judul", beritaItem.getJudul());
                    i.putExtra("isi", beritaItem.getIsi());
                    i.putExtra("gambar", beritaItem.getGambar());
                    itemView.getContext().startActivity(i);
                }
            });
        }
    }
}
