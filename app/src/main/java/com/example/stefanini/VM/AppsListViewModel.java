package com.example.stefanini.VM;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.stefanini.API.APISerices;
import com.example.stefanini.API.APISericesEducacion;
import com.example.stefanini.API.APISericesEntretenimiento;
import com.example.stefanini.API.APISericesJuegos;
import com.example.stefanini.Model.AppsModel;
import com.example.stefanini.API.RetroInstance;

import java.util.List;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppsListViewModel extends ViewModel {

    private MutableLiveData<List<AppsModel>> appslist;

    public AppsListViewModel(){
        appslist=new MutableLiveData<>();
    }

    public MutableLiveData<List<AppsModel>> getAppslistObserver()
    {
        return appslist;
    }

    public void makeApiCallJuegos() {


        APISericesJuegos apiServicesJuegos= RetroInstance.getRetroClient().create(APISericesJuegos.class);
        Call<List<AppsModel>> call=apiServicesJuegos.getAppsListJuegos("1");
        call.enqueue(new Callback<List<AppsModel>>() {
            @Override
            public void onResponse(Call<List<AppsModel>> call, Response<List<AppsModel>> response) {
                appslist.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<AppsModel>> call, Throwable t) {
                appslist.postValue(null);
                Log.e("Error :",t.getMessage().toString());
            }
        });

    }
        public void makeApiCall()
    {

        APISerices apiServices= RetroInstance.getRetroClient().create(APISerices.class);
        Call<List<AppsModel>> call=apiServices.getAppsList("0");
        call.enqueue(new Callback<List<AppsModel>>() {
            @Override
            public void onResponse(Call<List<AppsModel>> call, Response<List<AppsModel>> response) {
                appslist.postValue(response.body());


            }

            @Override
            public void onFailure(Call<List<AppsModel>> call, Throwable t) {
                appslist.postValue(null);
                Log.e("Error :",t.getMessage().toString());
            }
        });


    }



    public void makeApiCallEducacion() {


        APISericesEducacion apiSericesEducacion= RetroInstance.getRetroClient().create(APISericesEducacion.class);
        Call<List<AppsModel>> call=apiSericesEducacion.getAppsListEducacion("3");
        call.enqueue(new Callback<List<AppsModel>>() {
            @Override
            public void onResponse(Call<List<AppsModel>> call, Response<List<AppsModel>> response) {
                appslist.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<AppsModel>> call, Throwable t) {
                appslist.postValue(null);
                Log.e("Error :",t.getMessage().toString());
            }
        });

    }

    public void makeApiCallEntretenimiento() {


        APISericesEntretenimiento apiSericesEntretenimiento= RetroInstance.getRetroClient().create(APISericesEntretenimiento.class);
        Call<List<AppsModel>> call=apiSericesEntretenimiento.getAppsListEntretenimiento("2");
        call.enqueue(new Callback<List<AppsModel>>() {
            @Override
            public void onResponse(Call<List<AppsModel>> call, Response<List<AppsModel>> response) {
                appslist.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<AppsModel>> call, Throwable t) {
                appslist.postValue(null);
                Log.e("Error :",t.getMessage().toString());
            }
        });

    }

}
