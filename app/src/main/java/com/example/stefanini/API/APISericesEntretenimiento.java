package com.example.stefanini.API;

import com.example.stefanini.Model.AppsModel;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APISericesEntretenimiento {


    @GET("aplicaciones.php")
    retrofit2.Call<List<AppsModel>> getAppsListEntretenimiento(@Query("categoria") String categoria);

}
