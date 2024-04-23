package com.moviles.explorador_de_farmacias;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.moviles.explorador_de_farmacias.Modelo.Farmacia;
import com.moviles.explorador_de_farmacias.R;
import com.moviles.explorador_de_farmacias.databinding.ActivityDetalleBinding;

public class DetalleActivity extends AppCompatActivity {

    private ActivityDetalleBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetalleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Log.d("entro","entro al activity detalle");
        Intent intent = getIntent();
        Farmacia farmacia = (Farmacia) intent.getSerializableExtra("farmacia");

       /* binding.tvNombreDet.setText(farmacia.getNombre());
        binding.ivFotoDet.setImageResource(farmacia.getFoto());
        binding.tvDireccionDet.setText(farmacia.getDireccion());
        //binding.tvLocacionDet.setText(farmacia.getLocation().latitude+", "+farmacia.getLocation().longitude);
        binding.tvHoras.setText("Abre a las "+farmacia.getHoraApertura()+" y cierra a las "+farmacia.getHoraCierre());*/

    }
}