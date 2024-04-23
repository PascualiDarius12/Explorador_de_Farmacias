package com.moviles.explorador_de_farmacias.ui.mapa;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.moviles.explorador_de_farmacias.MainActivity;
import com.moviles.explorador_de_farmacias.Modelo.Farmacia;
import com.moviles.explorador_de_farmacias.R;
import com.moviles.explorador_de_farmacias.ui.slideshow.SlideshowFragment;

import java.util.ArrayList;

public class MapsFragment extends Fragment {
  private MapsViewModel vm;
  private Location l;
  private ArrayList<Farmacia> lFarmacias;
    private OnMapReadyCallback callback = new OnMapReadyCallback() {

        /**
         * Manipulates the map once available.
         * This callback is triggered when the map is ready to be used.
         * This is where we can add markers or lines, add listeners or move the camera.
         * In this case, we just add a marker near Sydney, Australia.
         * If Google Play services is not installed on the device, the user will be prompted to
         * install it inside the SupportMapFragment. This method will only be triggered once the
         * user has installed Google Play services and returned to the app.
         */
        @Override
        public void onMapReady(GoogleMap googleMap) {
            googleMap.clear(); // Elimina todos los marcadores existentes en el mapa
            if (l != null) {
                LatLng miUbicacion = new LatLng(l.getLatitude(), l.getLongitude());
                googleMap.addMarker(new MarkerOptions().position(miUbicacion).title("Mi Ubicacion"));
                googleMap.setMapType(SlideshowFragment.tipoMapa);
                Log.d("mapa", String.valueOf(SlideshowFragment.tipoMapa));


                for (Farmacia farmacia : lFarmacias) {
                    MarkerOptions opciones = new MarkerOptions()
                            .position(farmacia.getLocation())
                            .title(farmacia.getNombre())
                            .icon(BitmapDescriptorFactory.fromResource(R.drawable.icono_farmacia));
                    googleMap.addMarker(opciones);
                }
                googleMap.moveCamera(CameraUpdateFactory.newLatLng(miUbicacion));
            }
        }
    };

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        vm = new ViewModelProvider(this).get(MapsViewModel.class);
        vm.getmLocation().observe(getViewLifecycleOwner(), new Observer<Location>() {
            @Override
            public void onChanged(Location location) {
                l = location;
                actualizarMapa();
            }
        });

        vm.getmListaFarmacias().observe(getViewLifecycleOwner(), new Observer<ArrayList<Farmacia>>() {
                    @Override
                    public void onChanged(ArrayList<Farmacia> farmacias) {
                        lFarmacias=farmacias;
                    }
                });
        vm.ubicacionFarmacias();
        vm.ubicacionActualizable();


        return inflater.inflate(R.layout.fragment_maps, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
        if (mapFragment != null) {
            mapFragment.getMapAsync(callback);
        }
    }

    private void actualizarMapa() {
        if (getView() != null) {
            SupportMapFragment mapFragment =
                    (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
            if (mapFragment != null && mapFragment.isAdded()) {
                mapFragment.getMapAsync(callback);
            }
        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Limpiar el mapa y cualquier otro recurso asociado a la vista
        if (getActivity() != null && !getActivity().isFinishing()) {
            SupportMapFragment mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.map);
            if (mapFragment != null) {
                getChildFragmentManager().beginTransaction().remove(mapFragment).commitAllowingStateLoss();
            }
        }
    }
}

