package com.moviles.explorador_de_farmacias.ui.slideshow;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.gms.maps.GoogleMap;
import com.moviles.explorador_de_farmacias.MainActivity;
import com.moviles.explorador_de_farmacias.databinding.FragmentSlideshowBinding;

public class SlideshowFragment extends Fragment {

    private FragmentSlideshowBinding binding;
    public static int tipoMapa = GoogleMap.MAP_TYPE_NORMAL;
    public static String navMapa = "Mapa";
    public static String navListaFarmacias = "Lista de Farmacias";
    public static String navConfiguracion = "Configuracion";
    public static String navSalir = "Salir";


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        SlideshowViewModel slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);

        binding = FragmentSlideshowBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        binding.rbSatelital.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tipoMapa = GoogleMap.MAP_TYPE_SATELLITE;
                binding.rbNormal.setChecked(false);
                Toast.makeText(requireContext(), "Se cambio tipo de mapa a satelital", Toast.LENGTH_SHORT).show();
            }
        });
        binding.rbNormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               tipoMapa = GoogleMap.MAP_TYPE_NORMAL;
               binding.rbSatelital.setChecked(false);
                Toast.makeText(requireContext(), "Se cambio tipo de mapa a normal", Toast.LENGTH_SHORT).show();
            }
        });

        binding.rbIngles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 navMapa = "Map";
                 navListaFarmacias = "List of Farmacy";
                navConfiguracion = "Configuration";
                 navSalir = "Exit";
                binding.rbEspanol.setChecked(false);
                Toast.makeText(requireContext(), "Se cambio idioma a ingles", Toast.LENGTH_SHORT).show();
            }
        });

        binding.rbEspanol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navMapa = "Mapa";
                navListaFarmacias = "Lista de Farmacias";
                navConfiguracion = "Configuracion";
                navSalir = "Salir";
                binding.rbIngles.setChecked(false);
                Toast.makeText(requireContext(), "Se cambio idioma a Español", Toast.LENGTH_SHORT).show();
            }
        });




        return root;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}