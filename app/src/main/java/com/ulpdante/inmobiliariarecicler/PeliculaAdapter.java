package com.ulpdante.inmobiliariarecicler;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PeliculaAdapter extends RecyclerView.Adapter<PeliculaAdapter.ViewHolderPepe> {
    private List<Pelicula> listaDePeliculas;
    private Context context;
    private LayoutInflater li;

    public PeliculaAdapter(List<Pelicula> listaDePeliculas, Context context, LayoutInflater li) {
        this.listaDePeliculas = listaDePeliculas;
        this.context = context;
        this.li = li;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        listaDePeliculas.clear();
        listaDePeliculas.addAll(peliculas);
        notifyDataSetChanged();
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public void setLi(LayoutInflater li) {
        this.li = li;
    }

    @NonNull
    @Override
    public ViewHolderPepe onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=li.inflate(R.layout.item,parent,false);
        return new ViewHolderPepe(view);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPepe holder, int position) {

        Pelicula pelicula = listaDePeliculas.get(position);
        holder.titulo.setText(pelicula.getTitulo());
        holder.resenia.setText(pelicula.getResenia());
        holder.foto.setImageResource(pelicula.getFoto());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetalleActivity.class);
                intent.putExtra("pelicula", pelicula);
                intent.setFlags(intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listaDePeliculas.size();
    }

    public class ViewHolderPepe extends RecyclerView.ViewHolder{

        TextView titulo, resenia;
        ImageView foto;

        Button button;

        public ViewHolderPepe(@NonNull View itemView) {
            super(itemView);
            titulo=itemView.findViewById(R.id.titulo);
            resenia=itemView.findViewById(R.id.resenia);
            foto=itemView.findViewById(R.id.foto);
            button=itemView.findViewById(R.id.button);
        }
    }
}
