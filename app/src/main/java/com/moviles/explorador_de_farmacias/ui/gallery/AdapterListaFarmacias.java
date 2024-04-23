package com.moviles.explorador_de_farmacias.ui.gallery;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.moviles.explorador_de_farmacias.DetalleActivity;
import com.moviles.explorador_de_farmacias.Modelo.Farmacia;
import com.moviles.explorador_de_farmacias.R;

import java.util.ArrayList;

public class AdapterListaFarmacias extends RecyclerView.Adapter<AdapterListaFarmacias.ViewHolderInterno> {

    private ArrayList<Farmacia> listaFarmacias;
    private Context contexto;
    private LayoutInflater li;

    public AdapterListaFarmacias(ArrayList<Farmacia> listaFarmacias, Context contexto, LayoutInflater li) {
        this.listaFarmacias = listaFarmacias;
        this.contexto = contexto;
        this.li = li;
    }

    @NonNull
    @Override
    public ViewHolderInterno onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = li.inflate(R.layout.item_farmacias, parent, false);
        return new ViewHolderInterno(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderInterno holder, int position) {
      Farmacia farmacia = listaFarmacias.get(position);

      holder.direccion.setText(farmacia.getDireccion());
      holder.nombre.setText(farmacia.getNombre());
      holder.foto.setImageResource(farmacia.getFoto());

      holder.itemView.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View view) {

              Log.d("entro","entro al click");
              Bundle bundle = new Bundle();
              bundle.putSerializable("farmacia", farmacia);
              Navigation.findNavController((Activity) contexto, R.id.nav_host_fragment_content_main).navigate(R.id.detalleFragment, bundle);
          }
      });



    }

    @Override
    public int getItemCount() {
        return listaFarmacias.size();
    }

    public class ViewHolderInterno extends RecyclerView.ViewHolder{
        private TextView nombre, direccion;
        private ImageView foto;


        public ViewHolderInterno(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.tvNombre);
            direccion = itemView.findViewById(R.id.tvDireccion);
            foto = itemView.findViewById(R.id.ivFoto);

        }
    }
}
