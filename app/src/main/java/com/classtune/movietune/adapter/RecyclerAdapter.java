package com.classtune.movietune.adapter;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.classtune.movietune.R;
import com.classtune.movietune.activity.MovieDetailActivity;
import com.classtune.movietune.model.Movie;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private LayoutInflater inflater;
    private List<Movie> movieList;
    private Activity context;
    private String prefKey = null;
    private String adapterCallerClass;

    public RecyclerAdapter(Activity context, List<Movie> movieList, String adapterCallerClass) {
        this.inflater = LayoutInflater.from(context);
        this.movieList = movieList;
        this.context = context;
        this.adapterCallerClass = adapterCallerClass;
    }


    public void setPrefKey(String prefKey) {
        this.prefKey = prefKey;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View view = inflater.inflate(R.layout.new_release_movie_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder myViewHolder, int position) {

        if (adapterCallerClass.equals("similarclass")) {
            Movie movie = this.movieList.get(position);
           /* myViewHolder.imageView.getLayoutParams().height = 250;
            myViewHolder.imageView.getLayoutParams().width = 250;
           */ Glide.with(context).load("http://image.tmdb.org/t/p/w500" + movie.getPoster_path()).crossFade().into(myViewHolder.imageView);

        } else {
            Movie movie = this.movieList.get(position);
            Glide.with(context).load("http://image.tmdb.org/t/p/w500" + movie.getPoster_path()).crossFade().into(myViewHolder.imageView);
        }


    }

    @Override
    public int getItemCount() {
        return this.movieList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;


        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.newReleaseMoviePoster);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Movie movie = movieList.get(getAdapterPosition());

                    Log.d("moviedata", movie.getId() + "");
                    Log.d("moviedata", movie.getPoster_path());

                    context.startActivity(new Intent(context, MovieDetailActivity.class).putExtra("movieid", movie.getId()).
                            putExtra("postarpath", movie.getPoster_path()).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                }
            });

        }
    }

}
