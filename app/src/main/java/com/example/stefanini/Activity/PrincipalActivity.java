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
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.stefanini.Adapter.AppsListAdapter;
import com.example.stefanini.Model.AppsModel;
import com.example.stefanini.R;
import com.example.stefanini.VM.AppsListViewModel;

import java.util.List;

public class PrincipalActivity extends AppCompatActivity {

    EditText find;
    RecyclerView recview;
    ImageView pluss,search;
    Spinner spinner;
    List<AppsModel> appslist;
    AppsListViewModel listViewModel;
    AppsListAdapter adapter;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        recview=findViewById(R.id.recyclerApps);

        find = findViewById(R.id.editText);

        search = findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), DetallesApp.class);
                intent.putExtra("app", find.getText().toString());
                startActivity(intent);

            }
        });


        pluss = findViewById(R.id.pluss);

        pluss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(getApplicationContext(), RegistrarApp.class);
                startActivity(intent);
                finish();
            }
        });



        listViewModel= ViewModelProviders.of(this).get(AppsListViewModel.class);
        listViewModel.getAppslistObserver().observe(this, new Observer<List<AppsModel>>() {
            @Override
            public void onChanged(List<AppsModel> appsModels) {
                if(appsModels!=null) {
                    appslist= appsModels;
                    adapter.updatemovielist(appsModels);
                    //noresfound.setVisibility(View.GONE);
                }
                if(appsModels==null)
                {
                    recview.setVisibility(View.GONE);
                    //noresfound.setVisibility(View.VISIBLE);
                }
            }
        });


        spinner = findViewById(R.id.spinner_categoria);


        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(getApplicationContext(),R.array.categorias, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item);

        spinner.setAdapter(adapter1);



        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


                String categoria = String.valueOf(position);

                if(categoria.equals("0")){


                    LinearLayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
                    layoutManager.setOrientation(RecyclerView.HORIZONTAL);


                    GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
                    StaggeredGridLayoutManager staggerd = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
                    recview.setLayoutManager(gridLayoutManager);

                    //recview.setLayoutManager(new LinearLayoutManager(this));
                    recview.addItemDecoration(new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.VERTICAL));

                    adapter=new AppsListAdapter(appslist);
                    recview.setAdapter(adapter);


                    adapter.setOnClickListener(new View.OnClickListener(){

                        @Override
                        public void onClick(View v) {

                            recview.setAlpha(0.5F);

                            //Toast.makeText(getApplicationContext(), appslist.get(recview.getChildAdapterPosition(v)), Toast.LENGTH_SHORT).show();
                        }
                    });



                    listViewModel.makeApiCall();



                }
                if(categoria.equals("1")){



                    LinearLayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
                    layoutManager.setOrientation(RecyclerView.HORIZONTAL);


                    GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
                    StaggeredGridLayoutManager staggerd = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
                    recview.setLayoutManager(gridLayoutManager);

                    //recview.setLayoutManager(new LinearLayoutManager(this));
                    recview.addItemDecoration(new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.VERTICAL));

                    adapter=new AppsListAdapter(appslist);
                    recview.setAdapter(adapter);




                    listViewModel.makeApiCallJuegos();

                }

                if(categoria.equals("2")){



                    LinearLayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
                    layoutManager.setOrientation(RecyclerView.HORIZONTAL);


                    GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
                    StaggeredGridLayoutManager staggerd = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
                    recview.setLayoutManager(gridLayoutManager);

                    //recview.setLayoutManager(new LinearLayoutManager(this));
                    recview.addItemDecoration(new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.VERTICAL));

                    adapter=new AppsListAdapter(appslist);
                    recview.setAdapter(adapter);




                    listViewModel.makeApiCallEntretenimiento();


                }
                if(categoria.equals("3")){


                    LinearLayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
                    layoutManager.setOrientation(RecyclerView.HORIZONTAL);


                    GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);
                    StaggeredGridLayoutManager staggerd = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
                    recview.setLayoutManager(gridLayoutManager);

                    //recview.setLayoutManager(new LinearLayoutManager(this));
                    recview.addItemDecoration(new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.VERTICAL));

                    adapter=new AppsListAdapter(appslist);
                    recview.setAdapter(adapter);

                    listViewModel.makeApiCallEducacion();


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        //return null;
    }
}