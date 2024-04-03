package com.ulpdante.inmobiliariarecicler;

import android.app.Application;
import android.content.Context;
import android.content.Intent;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.List;

public class DetalleActivityViewModel extends AndroidViewModel {

    private MutableLiveData<Pelicula> detallePeliculaMutable;

    public DetalleActivityViewModel(@NonNull Application application){
        super(application);
    }

    public LiveData<Pelicula> getDetallePeliculaMutable() {

        if(detallePeliculaMutable == null){
            detallePeliculaMutable = new MutableLiveData<>();
        }
        return detallePeliculaMutable;
    }

    public void detalle(Intent intent){
        Pelicula pelicula = (Pelicula)intent.getSerializableExtra("pelicula");

        if (pelicula != null){

            detallePeliculaMutable.setValue(pelicula);

        }
    }
}
