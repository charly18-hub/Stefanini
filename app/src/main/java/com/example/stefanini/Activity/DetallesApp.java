package com.example.stefanini.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.example.stefanini.Adapter.AppsDetailsAdapter;
import com.example.stefanini.Model.AppsModel;
import com.example.stefanini.R;
import com.example.stefanini.VM.AppsDetailsViewModel;

import java.util.List;

public class DetallesApp extends AppCompatActivity {


    RecyclerView recviewDetails;
    List<AppsModel> appslist;
    AppsDetailsViewModel listDetailsViewModel;
    AppsDetailsAdapter adapterdetails;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_app);

        recviewDetails=findViewById(R.id.recyclerDApps);

        String AppBuscada = getIntent().getStringExtra("app");

        listDetailsViewModel= ViewModelProviders.of(this).get(AppsDetailsViewModel.class);
        listDetailsViewModel.getAppslistObserver().observe(this, new Observer<List<AppsModel>>() {
            @Override
            public void onChanged(List<AppsModel> appsModels) {
                if(appsModels!=null) {
                    appslist= appsModels;
                    adapterdetails.updatemovielist(appsModels);
                    //noresfound.setVisibility(View.GONE);
                }
                if(appsModels==null)
                {
                    recviewDetails.setVisibility(View.GONE);
                    //noresfound.setVisibility(View.VISIBLE);
                }
            }
        });


        LinearLayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        layoutManager.setOrientation(RecyclerView.HORIZONTAL);


        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),1);
        StaggeredGridLayoutManager staggerd = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recviewDetails.setLayoutManager(gridLayoutManager);

        //recview.setLayoutManager(new LinearLayoutManager(this));
        recviewDetails.addItemDecoration(new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.VERTICAL));

        adapterdetails=new AppsDetailsAdapter(appslist);
        recviewDetails.setAdapter(adapterdetails);
        listDetailsViewModel.makeApiCallDetalles(AppBuscada);



    }
}