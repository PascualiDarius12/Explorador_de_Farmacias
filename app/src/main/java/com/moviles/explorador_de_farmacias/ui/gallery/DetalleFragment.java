package com.moviles.explorador_de_farmacias.ui.gallery;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.moviles.explorador_de_farmacias.Modelo.Farmacia;
import com.moviles.explorador_de_farmacias.R;
import com.moviles.explorador_de_farmacias.databinding.FragmentDetalleBinding;
import com.moviles.explorador_de_farmacias.databinding.FragmentGalleryBinding;

public class DetalleFragment extends Fragment {

    private DetalleViewModel vm;
    private FragmentDetalleBinding binding;

    public static DetalleFragment newInstance() {
        return new DetalleFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        binding = FragmentDetalleBinding.inflate(inflater, container, false);
        vm = new ViewModelProvider(this).get(DetalleViewModel.class);
        View root = binding.getRoot();
        vm.getmFarmacia().observe(getActivity(), new Observer<Farmacia>() {
            @Override
            public void onChanged(Farmacia farmacia) {
                Log.d("entro","entro al observer");
                binding.tvNombreDet.setText(farmacia.getNombre());
                binding.ivFotoDet.setImageResource(farmacia.getFoto());
                binding.tvDireccionDet.setText(farmacia.getDireccion());
                binding.tvLocacionDet.setText(farmacia.getLocation().latitude+", "+farmacia.getLocation().longitude);
                binding.tvHoras.setText("Abre a las "+farmacia.getHoraApertura()+" y cierra a las "+farmacia.getHoraCierre());
            }
        });


        vm.recibirPalabra(getArguments());
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding=null;
    }
}