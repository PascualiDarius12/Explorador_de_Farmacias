package com.moviles.explorador_de_farmacias.ui.gallery;

import android.app.Application;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.moviles.explorador_de_farmacias.Modelo.Farmacia;

public class DetalleViewModel extends AndroidViewModel {

     private MutableLiveData<Farmacia> mFarmacia;
    public DetalleViewModel(@NonNull Application application) {
        super(application);
    }

    public MutableLiveData<Farmacia> getmFarmacia() {
        if(mFarmacia == null){
            mFarmacia = new MutableLiveData<>();
        }
        return mFarmacia;
    }

    public void recibirPalabra(Bundle bundle){
        Farmacia farmacia = (Farmacia) bundle.get("farmacia");
        mFarmacia.setValue(farmacia);
    }
}