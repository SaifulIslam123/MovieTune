package com.classtune.movietune.service;

import android.app.Activity;
import android.util.Log;

import java.io.IOException;

import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;


/**
 * Created by sayemkcn on 8/10/16.
 */
public class ResourceProvider {
    public static final String NEW_RELEASE_URL = "https://api.themoviedb.org/3/movie/now_playing?api_key=c37d3b40004717511adb2c1fbb15eda4&page=";
    public static final String TOP_RATED_URL = "https://api.themoviedb.org/3/movie/top_rated?api_key=c37d3b40004717511adb2c1fbb15eda4&page=";
    public static final String UPCOMING_URL = "https://api.themoviedb.org/3/movie/upcoming?api_key=c37d3b40004717511adb2c1fbb15eda4&page=";
    public static final String MOVIE_DETAIL_URL = "https://api.themoviedb.org/3/movie/";
    public static final String SIMILAR_MOVIE = "";

    private Activity context;
    private String response = null;

    public static final int RESPONSE_CODE_CREATED = 201;
    public static final int RESPONSE_CODE_FOUND = 302;
    public static final int RESPONSE_CODE_NOT_FOUND = 404;
    public static final int RESPONSE_CODE_NO_CONTENT = 204;
    public static final int RESPONSE_CODE_LOCKED = 423;
    public static final int RESPONSE_NOT_ACCEPTABLE = 406;
    public static final int RESPONSE_ACCEPTED = 202;
    public static final int RESPONSE_CODE_BAD_REQUEST = 400;
    public static final int RESPONSE_CODE_INTERNAL_SERVER_ERROR = 500;
    public static final int RESPONSE_CODE_OK = 200;
    public static final int RESPONSE_CODE_CONFLICT = 409;
    public static final int RESPONSE_CODE_FORBIDDEN = 403;


    public ResourceProvider(Activity context) {
        this.context = context;
    }

    public String fetchData(String url) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = okHttpClient.newCall(request).execute();
        ResponseBody responseBody = response.body();
        String responseBodyString = responseBody.string();
        responseBody.close();
        return responseBodyString;

    }

    public Response fetchGetResponse(String url) throws IOException {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();
        Response response = okHttpClient.newCall(request).execute();
        Log.d("URL", request.url().toString());
        return response;
    }

    public Response fetchPostResponse(String url) throws IOException {
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.setType(MultipartBody.FORM);
        builder.addFormDataPart("test", "test");
        RequestBody requestBody = builder.build();

        Request request = new Request.Builder()
                .url(url)
                .method("POST", RequestBody.create(null, new byte[0]))
                .post(requestBody)
                .build();
        Log.d("URL", request.url().toString());
        return new OkHttpClient().newCall(request).execute();
    }

}
