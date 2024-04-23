package com.moviles.explorador_de_farmacias.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.moviles.explorador_de_farmacias.Modelo.Farmacia;
import com.moviles.explorador_de_farmacias.databinding.FragmentGalleryBinding;

import java.util.ArrayList;

public class GalleryFragment extends Fragment {

    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        GalleryViewModel vm =
                new ViewModelProvider(this).get(GalleryViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


         vm.getmListaFarmacias().observe(getActivity(), new Observer<ArrayList<Farmacia>>() {
             @Override
             public void onChanged(ArrayList<Farmacia> farmacias) {

                 AdapterListaFarmacias adapter = new AdapterListaFarmacias(farmacias, getActivity(), getLayoutInflater());
                 GridLayoutManager gl = new GridLayoutManager(getActivity(), 1, GridLayoutManager.VERTICAL, false);
                 RecyclerView rv = binding.rvListaFarmacias;
                 rv.setLayoutManager(gl);
                 rv.setAdapter(adapter);
             }
         });

         vm.crearListaFarmacia();

        return root;
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}