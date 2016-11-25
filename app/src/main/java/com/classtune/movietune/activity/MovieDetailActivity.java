package com.classtune.movietune.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;
import android.view.TextureView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.classtune.movietune.R;
import com.classtune.movietune.adapter.RecyclerAdapter;
import com.classtune.movietune.model.MovieDetail;
import com.classtune.movietune.model.MoviePage;
import com.classtune.movietune.model.SimilarMovie;
import com.classtune.movietune.service.ResourceProvider;
import com.google.gson.Gson;

import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by user- on 25-Nov-16.
 */

public class MovieDetailActivity extends AppCompatActivity {


    private String keyUrl = "?api_key=c37d3b40004717511adb2c1fbb15eda4";
    private static final String SIMILAR_MOVIE_FIRST_PART_URL = "https://api.themoviedb.org/3/movie/";
    private static final String SIMILAR_MOVIE_SECOND_PART_URL = "similar?api_key=c37d3b40004717511adb2c1fbb15eda4&page=1";

    private String movieId;
    private String postarPath;
    private String similarMovieUrl;

    private ImageView postarImageView;


    private TextView moviewandYearTextView;
    private TextView moviewType;
    private TextView rating;
    private TextView popularityPercentage;
    private TextView movieOverViewTextView;
    private TextView productionCompanyNameTextview;
    private TextView budgetTextView;
    private TextView productionCountrieNameTextview;
    private TextView languageTextView;

    private RecyclerView recyclerView;


    private String data = "";
    private View actionBarView;
    private TextView actionBarMovieNameTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);


        movieId = String.valueOf(getIntent().getIntExtra("movieid", 0));
        keyUrl = ResourceProvider.MOVIE_DETAIL_URL + movieId + keyUrl;
        postarPath = getIntent().getStringExtra("postarpath");
        similarMovieUrl = SIMILAR_MOVIE_FIRST_PART_URL + movieId + "/" + SIMILAR_MOVIE_SECOND_PART_URL;

        actionBarView = getLayoutInflater().inflate(R.layout.activity_movie_detail_actionbar, null);
        actionBarMovieNameTextView = (TextView) actionBarView.findViewById(R.id.actionBarMovieNameTextView);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(actionBarView);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        postarImageView = (ImageView) findViewById(R.id.postarImage);
        moviewandYearTextView = (TextView) findViewById(R.id.movieName);
        moviewType = (TextView) findViewById(R.id.movieType);
        rating = (TextView) findViewById(R.id.rating);
        popularityPercentage = (TextView) findViewById(R.id.popularityPercentage);
        movieOverViewTextView = (TextView) findViewById(R.id.movieOverViewTextView);
        productionCompanyNameTextview = (TextView) findViewById(R.id.productionCompanyTextview);
        budgetTextView = (TextView) findViewById(R.id.budgetTextView);
        productionCountrieNameTextview = (TextView) findViewById(R.id.productionCountriesNameTextview);
        languageTextView = (TextView) findViewById(R.id.languageTextView);


        Glide.with(this).load("http://image.tmdb.org/t/p/w500/" + postarPath).crossFade().into(postarImageView);


        fetchMovies(keyUrl);
        fetchSimilarrMovies(similarMovieUrl);


    }

    private void fetchSimilarrMovies(final String similarMovieUrl) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response = new ResourceProvider(MovieDetailActivity.this).fetchGetResponse(similarMovieUrl);
                    ResponseBody responseBody = response.body();
                    final String responseValue = responseBody.string();
                    responseBody.close();
                    final SimilarMovie similarMovie = new Gson().fromJson(responseValue, SimilarMovie.class);
                    MovieDetailActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            setupRecyclerView(similarMovie);
                        }
                    });

                    //Log.d("response", moviePage.toString());

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

    private void setupRecyclerView(SimilarMovie similarMovie) {
        recyclerView = (RecyclerView) findViewById(R.id.similarMovieRecyclerView);
        recyclerView.setAdapter(new RecyclerAdapter(MovieDetailActivity.this, similarMovie.getResults().subList(0, 15), "similarclass"));
        recyclerView.setLayoutManager(new LinearLayoutManager(MovieDetailActivity.this, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setVisibility(View.VISIBLE);

    }

    /*@Override
    public void onBackPressed() {
       *//*Thread t= new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                   Thread.sleep(2500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t.start();*//*


    }
*/
    private void fetchMovies(final String url) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response = new ResourceProvider(MovieDetailActivity.this).fetchGetResponse(url);
                    ResponseBody responseBody = response.body();

                    final String responseValue = responseBody.string();
                    responseBody.close();
                    final MovieDetail movieDetail = new Gson().fromJson(responseValue, MovieDetail.class);
                    Log.d("response", movieDetail.toString());

                    MovieDetailActivity.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            setUpUi(movieDetail);
                        }
                    });

                    Log.d("response", movieDetail.toString());

                } catch (IOException e) {
                    Log.d("jason", e.toString());

                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void setUpUi(MovieDetail movieDetail) {

        actionBarMovieNameTextView.setText(movieDetail.getTitle());

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = format.parse(movieDetail.getRelease_date());
            SimpleDateFormat df = new SimpleDateFormat("yyyy");
            //  moviewandYearTextView.setText(movieDetail.getTitle() + "  (" + movieDetail.getRelease_date() + ")");
            moviewandYearTextView.setText(movieDetail.getTitle() + "  (" + df.format(date) + ")");

        } catch (ParseException e) {
            e.printStackTrace();
        }


        if (movieDetail.getGenres() != null) {

            for (int i = 0; i < movieDetail.getGenres().size(); i++) {
                data = "";
                data = data + movieDetail.getGenres().get(i).getName();
            }
            moviewType.setText(data);
        }


        rating.setText(movieDetail.getVote_average() + "");


        popularityPercentage.setText((int) (movieDetail.getPopularity() + 0.5d) + "%");

        movieOverViewTextView.setText(movieDetail.getOverview());

        if (movieDetail.getProduction_companies() != null) {

            for (int i = 0; i < movieDetail.getProduction_companies().size(); i++) {
                data = data + movieDetail.getProduction_companies().get(i).getName();
            }

            productionCompanyNameTextview.setText(data);
        }

        budgetTextView.setText("$  "+movieDetail.getBudget() + "");

        if (movieDetail.getProduction_countries() != null) {

            data = "";
            for (int i = 0; i < movieDetail.getProduction_countries().size(); i++) {
                data = data + movieDetail.getProduction_countries().get(i).getName();
            }
            productionCountrieNameTextview.setText(data);
        }


        if (movieDetail.getSpoken_languages() != null) {
            data = "";
            for (int i = 0; i < movieDetail.getSpoken_languages().size(); i++) {
                data = data + movieDetail.getSpoken_languages().get(i).getName();
            }
            languageTextView.setText(data);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                Intent homeIntent = new Intent(this, MainActivity.class);
                homeIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(homeIntent);
        }
        return (super.onOptionsItemSelected(menuItem));
    }

}
