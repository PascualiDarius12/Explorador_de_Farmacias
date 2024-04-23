package com.moviles.explorador_de_farmacias.ui.mapa;

import android.Manifest;
import android.app.Application;
import android.content.pm.PackageManager;
import android.location.Location;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.Priority;
import com.google.android.gms.maps.model.LatLng;
import com.moviles.explorador_de_farmacias.Modelo.Farmacia;

import java.util.ArrayList;

public class MapsViewModel extends AndroidViewModel {

    private MutableLiveData<Location> mLocation;
    private MutableLiveData<ArrayList<Farmacia>> mListaFarmacias;
    private FusedLocationProviderClient fused;

    private LocationCallback callback;

    public MapsViewModel(@NonNull Application application) {
        super(application);
        fused = LocationServices.getFusedLocationProviderClient(getApplication());
    }


    public MutableLiveData<Location> getmLocation() {
        if (mLocation == null) {
            this.mLocation = new MutableLiveData<>();
        }
        return mLocation;
    }

    public MutableLiveData<ArrayList<Farmacia>> getmListaFarmacias() {
        if (mListaFarmacias == null) {
            this.mListaFarmacias = new MutableLiveData<>();
        }
        return mListaFarmacias;
    }

    public void ubicacionActualizable() {
     /* LocationRequest r = LocationRequest.create();
      r.setInterval(5000);
      r.setFastestInterval(5000);
      r.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);*/

        LocationRequest r = new LocationRequest.Builder(Priority.PRIORITY_HIGH_ACCURACY, 5000).build();
        callback = new LocationCallback() {
            @Override
            public void onLocationResult(@NonNull LocationResult locationResult) {
                if (locationResult == null) {
                    return;
                }
                Location location = locationResult.getLastLocation();
                mLocation.postValue(location);
            }
        };

        if (ActivityCompat.checkSelfPermission(getApplication(), Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(getApplication(), Manifest.permission.ACCESS_COARSE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fused.requestLocationUpdates(r, callback, null);

    }

    public void pararUbicacionActualizable(){
        fused.removeLocationUpdates(callback);
    }

    public void ubicacionFarmacias(){
        ArrayList<Farmacia> farmacias = new Farmacia().getFarmacias();

        mListaFarmacias.setValue(farmacias);
    }



}