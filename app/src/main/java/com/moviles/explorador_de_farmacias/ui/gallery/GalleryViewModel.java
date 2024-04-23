package com.moviles.explorador_de_farmacias.ui.gallery;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.moviles.explorador_de_farmacias.Modelo.Farmacia;

import java.util.ArrayList;

public class GalleryViewModel extends AndroidViewModel {

    private MutableLiveData<ArrayList<Farmacia>> mListaFarmacias;

    public GalleryViewModel(@NonNull Application application) {
        super(application);
    }


    public MutableLiveData<ArrayList<Farmacia>> getmListaFarmacias() {
        if(mListaFarmacias == null){
            mListaFarmacias = new MutableLiveData<>();
        }
        return mListaFarmacias;
    }

    public void crearListaFarmacia(){
        ArrayList<Farmacia> lista = new Farmacia().getFarmacias();
        mListaFarmacias.setValue(lista);
    }



}