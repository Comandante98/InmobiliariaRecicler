package com.ulpdante.inmobiliariarecicler;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

    private MutableLiveData<List<Pelicula>> peliculaMutable;

    public MainActivityViewModel(@NonNull Application application) {super(application);}

    public LiveData<List<Pelicula>> getPeliculaMutable(){
        if (peliculaMutable == null){
            this.peliculaMutable = new MutableLiveData<>();
        }
        return peliculaMutable;
    }

    public void crearLista(){
        ArrayList<Pelicula> lista = new ArrayList<>();
        lista.add(new Pelicula("Mad Max: Fury Road", R.drawable.peli1, "Perseguido por su turbulento pasado, Max Rockatansky cree que la mejor forma de sobrevivir es ir solo por el mundo. Sin embargo, se ve arrastrado a formar parte de un grupo que huye a través del desierto en un War Rig conducido por una Emperatriz de élite: Furiosa.", "Tom Hardy, Charlize Theron", "George Miller"));
        lista.add(new Pelicula("Avengers: Endgame", R.drawable.peli2, "Los Vengadores restantes deben encontrar una manera de recuperar a sus aliados para un enfrentamiento épico con Thanos, el malvado que diezmó el planeta y el universo.", "Robert Downey Jr. , Crhis Evans, Scarlett Johansson, Chris Hemsworth", "Anthony Russo, Joe Russo"));
        lista.add(new Pelicula("El viaje de Chihiro", R.drawable.peli3, "Chihiro es una niña caprichosa que debe adentrarse en un mundo de fantasía para poder salvar a sus padres, convertidos en cerdos.", "Rumi Hiiragi", "Hayao Miyazaki"));
        peliculaMutable.setValue(lista);
    }

}
