package com.example.stefanini.VM;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.stefanini.API.APIDetalles;
import com.example.stefanini.Model.AppsModel;
import com.example.stefanini.API.RetroInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppsDetailsViewModel extends ViewModel {

    private MutableLiveData<List<AppsModel>> appslist;

    public AppsDetailsViewModel(){
        appslist=new MutableLiveData<>();
    }

    public MutableLiveData<List<AppsModel>> getAppslistObserver()
    {
        return appslist;
    }

    public void makeApiCallDetalles(String AppBuscada) {



        APIDetalles apiDetalles= RetroInstance.getRetroClient().create(APIDetalles.class);
        Call<List<AppsModel>> call=apiDetalles.getDAppsList(AppBuscada);
        call.enqueue(new Callback<List<AppsModel>>() {
            @Override
            public void onResponse(Call<List<AppsModel>> call, Response<List<AppsModel>> response) {
                appslist.postValue(response.body());

                Log.i("respuestaDetalles", response.body().toString());



            }

            @Override
            public void onFailure(Call<List<AppsModel>> call, Throwable t) {
                appslist.postValue(null);
                Log.e("Error :",t.getMessage().toString());
            }
        });

    }

}
