package com.example.stefanini.API;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroInstance
{

    public static String baseurl="https://americangoldpharma.com.mx/AmericanPharma/resources/views/web/"; // volley_array.json
    private static Retrofit retrofit;

    public static Retrofit getRetroClient()
    {
        if(retrofit==null)
        {
            retrofit= new Retrofit.Builder()
                    .baseUrl(baseurl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
