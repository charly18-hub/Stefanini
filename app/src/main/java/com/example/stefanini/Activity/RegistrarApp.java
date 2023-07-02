package com.example.stefanini.Activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.stefanini.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RegistrarApp extends AppCompatActivity {

    ImageView imageView;
    private Uri output;
    private File file;
    String url = "https://americangoldpharma.com.mx/AmericanPharma/resources/views/web/registrarApp.php";
    String KEY_IMAGE="foto";
    String KEY_NOMBRE="nombre";
    String KEY_CATEGORIA="categoria";

    String KEY_PRICE="precio";
    String KEY_DEVELOPER="desarrollador";
    Bitmap bitmap;
    private static final int REQUEST_TAKE_PHOTO=1;


    TextView res;
    EditText nombre;
    EditText desarrollador;
    EditText precio;
    EditText categoriaA;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);



        switch (requestCode){

            case REQUEST_TAKE_PHOTO:

                Uri miPath = data.getData();

                Toast.makeText(this, miPath.toString(), Toast.LENGTH_SHORT).show();

                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),miPath);

                    imageView.setImageURI(miPath);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }


                break;

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_app);


        imageView = (ImageView) findViewById(R.id.registroImage);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent,REQUEST_TAKE_PHOTO);
            }


        });



         nombre = findViewById(R.id.titleViewApp);
         desarrollador = findViewById(R.id.desarrolladorViewApp);
         precio = findViewById(R.id.precioViewApp);
        categoriaA = findViewById(R.id.categoriaED);
        res = findViewById(R.id.respuesta);

        Button cancelar= findViewById(R.id.cancelar);

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), PrincipalActivity.class);
                startActivity(intent);

                finish();

            }
        });

        Button guardar = findViewById(R.id.guardar);
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                subir();
                Toast.makeText(getApplicationContext(), "valor "+ nombre.getText().toString() ,Toast.LENGTH_LONG).show();

            }
        });

    }

    public String getStringImage(Bitmap btm){
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        btm.compress(Bitmap.CompressFormat.JPEG,50,baos);
        byte[] imageBytes = baos.toByteArray();
        String encodeImage = Base64.encodeToString(imageBytes,Base64.DEFAULT);
        return encodeImage;

    }

    public void subir(){

       // final ProgressDialog loading = ProgressDialog.show(getApplicationContext(),"bien","bien");

        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        res.setText("Se Cargo Bien La Aplicacion Al Servidor");
                        Handler handler = new Handler();

                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {

                                Intent intent = new Intent(getApplicationContext(),PrincipalActivity.class);
                                startActivity(intent);
                                finish();

                            }
                        },5000);


                        // loading.dismiss();

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


                res.setText("Se Perdio La Comunicacion Intente Mas Tarde");
                Handler handler = new Handler();

                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        Intent intent = new Intent(getApplicationContext(),PrincipalActivity.class);
                        startActivity(intent);
                        finish();

                    }
                },5000);

            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() {
                String image = getStringImage(bitmap);
                String nombrew = nombre.getText().toString();
                String developer = desarrollador.getText().toString();
                String price = precio.getText().toString();
                String categoria = categoriaA.getText().toString();

                Map<String, String> params = new HashMap<String,String>();
                params.put(KEY_IMAGE,image);
                params.put(KEY_NOMBRE, nombrew);
                params.put(KEY_PRICE, price);
                params.put(KEY_DEVELOPER, developer);
                params.put(KEY_CATEGORIA, categoria);

                return params;

            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);

    }



}