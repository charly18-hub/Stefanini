package com.example.stefanini.API;

import com.example.stefanini.Model.AppsModel;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APISericesEducacion {


    @GET("aplicaciones.php")
    retrofit2.Call<List<AppsModel>> getAppsListEducacion(@Query("categoria") String categoria);

}
