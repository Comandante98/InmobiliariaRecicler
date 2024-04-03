package com.ulpdante.inmobiliariarecicler;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ulpdante.inmobiliariarecicler.databinding.ActivityMainBinding;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    private MainActivityViewModel vm;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(MainActivityViewModel.class);
        vm.getPeliculaMutable().observe(this, new Observer<List<Pelicula>>() {
            @Override
            public void onChanged(List<Pelicula> peliculas) {
                PeliculaAdapter pa = new PeliculaAdapter(peliculas ,MainActivity.this,getLayoutInflater());
                GridLayoutManager glm = new GridLayoutManager(MainActivity.this,2,GridLayoutManager.VERTICAL,false);
                RecyclerView rc=binding.lista;
                rc.setLayoutManager(glm);
                rc.setAdapter(pa);

            }

        });
        vm.crearLista();
    }
}