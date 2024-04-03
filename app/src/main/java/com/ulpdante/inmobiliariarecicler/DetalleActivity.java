package com.ulpdante.inmobiliariarecicler;

import android.content.Intent;
import android.os.Bundle;
import android.telecom.TelecomManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.ulpdante.inmobiliariarecicler.databinding.ActivityDetalleBinding;

public class DetalleActivity extends AppCompatActivity {

    private DetalleActivityViewModel vm;

    private ActivityDetalleBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        ActivityDetalleBinding binding = ActivityDetalleBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        vm = ViewModelProvider.AndroidViewModelFactory.getInstance(getApplication()).create(DetalleActivityViewModel.class);
        vm.getDetallePeliculaMutable().observe(this, new Observer<Pelicula>() {
            @Override
            public void onChanged(Pelicula pelicula) {
                TextView titulo = findViewById(R.id.tituloDetalle);
                ImageView foto = findViewById(R.id.fotoDetalle);
                TextView resenia = findViewById(R.id.reseniaDetalle);
                TextView actores = findViewById(R.id.actores);
                TextView director = findViewById(R.id.director);

                titulo.setText(pelicula.getTitulo());
                foto.setImageResource(pelicula.getFoto());
                resenia.setText(pelicula.getResenia());
                actores.setText("Actores: " + pelicula.getActores());
                director.setText("Director/es: " + pelicula.getDirector());
            }
        });

        vm.detalle(getIntent());

        Button boton = findViewById(R.id.volver);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetalleActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

}