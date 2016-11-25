package com.classtune.movietune.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.classtune.movietune.R;
import com.classtune.movietune.adapter.RecyclerAdapter;
import com.classtune.movietune.model.MoviePage;
import com.classtune.movietune.service.ResourceProvider;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by user- on 25-Nov-16.
 */

public class TopRatedFragment extends Fragment {



    private View fragmentBaseView;
    int counter = 1;

    private RecyclerView recyclerView;
    private Button pagiNationButton;
    private ProgressBar progressBar;

    public TopRatedFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        fragmentBaseView = inflater.inflate(R.layout.fragment_new_release, container, false);

        pagiNationButton = (Button) fragmentBaseView.findViewById(R.id.pagingButton);
        progressBar = (ProgressBar) fragmentBaseView.findViewById(R.id.progressbar);

        pagiNationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recyclerView.setVisibility(View.GONE);
                progressBar.setVisibility(View.VISIBLE);
                counter++;
                fetchMovies(ResourceProvider.TOP_RATED_URL + counter);
            }
        });


        this.fetchMovies(ResourceProvider.TOP_RATED_URL + counter);
        return fragmentBaseView;
    }
    private void fetchMovies(final String url) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Response response = new ResourceProvider(getActivity()).fetchGetResponse(url);
                    ResponseBody responseBody = response.body();
                    final String responseValue = responseBody.string();
                    responseBody.close();
                    final MoviePage moviePage = new Gson().fromJson(responseValue, MoviePage.class);
                    getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            setupRecyclerView(moviePage);
                        }
                    });

                    Log.d("response", moviePage.toString());

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void setupRecyclerView(MoviePage moviePage) {
        recyclerView = (RecyclerView) fragmentBaseView.findViewById(R.id.newReleaseRecycler);
        recyclerView.setAdapter(new RecyclerAdapter(getActivity(), moviePage.getresults().subList(0, 10),"toprated"));
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setVisibility(View.VISIBLE);
        pagiNationButton.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.GONE);

    }
}
