package com.example.stefanini.Adapter;

import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.stefanini.Model.AppsModel;
import com.example.stefanini.R;

import java.util.List;

public class AppsListAdapter extends RecyclerView.Adapter<AppsListAdapter.AppsViewHolder> implements  View.OnClickListener {


    List<AppsModel> appslist;

    Context context;
    View.OnClickListener listener;

    public AppsListAdapter(Context context) {
        this.context = context;
    }

    public AppsListAdapter(List<AppsModel> list) {
        this.appslist = list;
    }

    public void updatemovielist(List<AppsModel> list) {
        this.appslist = list;
        notifyDataSetChanged();
    }




    @NonNull
    @Override
    public AppsListAdapter.AppsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.row_apps,parent,false);
        return new AppsListAdapter.AppsViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull AppsListAdapter.AppsViewHolder holder, int position) {



        holder.nombreApp.setText(appslist.get(position).getAppNombre());



        if(appslist.get(position).getCalificacion() == 5 ){

            holder.st1.setVisibility(View.VISIBLE);
            holder.st2.setVisibility(View.VISIBLE);
            holder.st3.setVisibility(View.VISIBLE);
            holder.st4.setVisibility(View.VISIBLE);
            holder.st5.setVisibility(View.VISIBLE);

        }else if(appslist.get(position).getCalificacion() == 4 ){


            holder.st1.setVisibility(View.VISIBLE);
            holder.st2.setVisibility(View.VISIBLE);
            holder.st3.setVisibility(View.VISIBLE);
            holder.st4.setVisibility(View.VISIBLE);
            holder.st5.setVisibility(View.INVISIBLE);

        }else if(appslist.get(position).getCalificacion() == 3 ){


            holder.st1.setVisibility(View.VISIBLE);
            holder.st2.setVisibility(View.VISIBLE);
            holder.st3.setVisibility(View.VISIBLE);
            holder.st4.setVisibility(View.INVISIBLE);
            holder.st5.setVisibility(View.INVISIBLE);

        }else if(appslist.get(position).getCalificacion() == 2 ){


            holder.st1.setVisibility(View.VISIBLE);
            holder.st1.setImageResource(R.drawable.baseline_star_242);
            holder.st2.setVisibility(View.VISIBLE);
            holder.st2.setImageResource(R.drawable.baseline_star_242);
            holder.st3.setVisibility(View.INVISIBLE);
            holder.st3.setImageResource(R.drawable.baseline_star_242);
            holder.st4.setVisibility(View.INVISIBLE);
            holder.st4.setImageResource(R.drawable.baseline_star_242);
            holder.st5.setVisibility(View.INVISIBLE);
            holder.st5.setImageResource(R.drawable.baseline_star_242);

        }else if(appslist.get(position).getCalificacion() == 1 ){


            holder.st1.setVisibility(View.VISIBLE);
            holder.st1.setImageResource(R.drawable.baseline_star_242);
            holder.st2.setVisibility(View.INVISIBLE);
            holder.st2.setImageResource(R.drawable.baseline_star_242);

            holder.st3.setVisibility(View.INVISIBLE);
            holder.st3.setImageResource(R.drawable.baseline_star_242);
            holder.st4.setVisibility(View.INVISIBLE);
            holder.st4.setImageResource(R.drawable.baseline_star_242);
            holder.st5.setVisibility(View.INVISIBLE);
            holder.st5.setImageResource(R.drawable.baseline_star_242);

        }else if(appslist.get(position).getCalificacion() < 1 ){


            holder.st1.setVisibility(View.VISIBLE);
            holder.st1.setImageResource(R.drawable.baseline_star_242);
            holder.st2.setVisibility(View.INVISIBLE);
            holder.st2.setImageResource(R.drawable.baseline_star_242);

            holder.st3.setVisibility(View.INVISIBLE);
            holder.st3.setImageResource(R.drawable.baseline_star_242);
            holder.st4.setVisibility(View.INVISIBLE);
            holder.st4.setImageResource(R.drawable.baseline_star_242);
            holder.st5.setVisibility(View.INVISIBLE);
            holder.st5.setImageResource(R.drawable.baseline_star_242);

        }




        if(appslist.get(position).getPrecio() < 1 ){

            holder.precio.setText("Free");

        }else {

            holder.precio.setText("$"+String.valueOf(appslist.get(position).getPrecio())+".00");

        }


        Glide.with(holder.imgApp.getContext()).load(appslist.get(position).getUrl_image()).into(holder.imgApp);









        holder.nombreApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





                View pupop = LayoutInflater.from(holder.nombreApp.getContext()).inflate(R.layout.app_pop,null,false);
                final PopupWindow popupWindow = new PopupWindow(pupop,500,800,false);
                popupWindow.showAtLocation(holder.nombreApp, Gravity.CENTER_HORIZONTAL,30,0);



                TextView nombre = pupop.findViewById(R.id.titleViewApp);
                TextView precio = pupop.findViewById(R.id.precioViewApp);
                ImageView img = pupop.findViewById(R.id.cardimg);
                ImageView imgE = pupop.findViewById(R.id.cardimgHeader);
                ImageView st1= pupop.findViewById(R.id.s1);
                ImageView st2= pupop.findViewById(R.id.s2);
                ImageView st3= pupop.findViewById(R.id.s3);
                ImageView st4= pupop.findViewById(R.id.s4);
                ImageView st5= pupop.findViewById(R.id.s5);


                if(appslist.get(position).getPrecio() < 1 ){

                    precio.setText("free");

                }else {

                    precio.setText("$"+String.valueOf(appslist.get(position).getPrecio())+".00");

                }



                if(appslist.get(position).getCalificacion() == 5 ){

                    st1.setVisibility(View.VISIBLE);
                    st2.setVisibility(View.VISIBLE);
                    st3.setVisibility(View.VISIBLE);
                    st4.setVisibility(View.VISIBLE);
                    st5.setVisibility(View.VISIBLE);

                }else if(appslist.get(position).getCalificacion() == 4 ){


                    st1.setVisibility(View.VISIBLE);
                    st2.setVisibility(View.VISIBLE);
                    st3.setVisibility(View.VISIBLE);
                    st4.setVisibility(View.VISIBLE);
                    st5.setVisibility(View.INVISIBLE);

                }else if(appslist.get(position).getCalificacion() == 3 ){


                    st1.setVisibility(View.VISIBLE);
                    st2.setVisibility(View.VISIBLE);
                    st3.setVisibility(View.VISIBLE);
                    st4.setVisibility(View.INVISIBLE);
                    st5.setVisibility(View.INVISIBLE);

                }else if(appslist.get(position).getCalificacion() == 2 ){


                    st1.setVisibility(View.VISIBLE);
                    st1.setImageResource(R.drawable.baseline_star_242);
                    st2.setVisibility(View.VISIBLE);
                    st2.setImageResource(R.drawable.baseline_star_242);
                    st3.setVisibility(View.INVISIBLE);
                    st3.setImageResource(R.drawable.baseline_star_242);
                    st4.setVisibility(View.INVISIBLE);
                    st4.setImageResource(R.drawable.baseline_star_242);
                    st5.setVisibility(View.INVISIBLE);
                    st5.setImageResource(R.drawable.baseline_star_242);

                }else if(appslist.get(position).getCalificacion() == 1 ){


                    st1.setVisibility(View.VISIBLE);
                    st1.setImageResource(R.drawable.baseline_star_242);
                    st2.setVisibility(View.INVISIBLE);
                    st2.setImageResource(R.drawable.baseline_star_242);

                    st3.setVisibility(View.INVISIBLE);
                    st3.setImageResource(R.drawable.baseline_star_242);
                    st4.setVisibility(View.INVISIBLE);
                    st4.setImageResource(R.drawable.baseline_star_242);
                    st5.setVisibility(View.INVISIBLE);
                    st5.setImageResource(R.drawable.baseline_star_242);

                }else if(appslist.get(position).getCalificacion() < 1 ){


                    st1.setVisibility(View.INVISIBLE);
                    st1.setImageResource(R.drawable.baseline_star_242);
                    st2.setVisibility(View.INVISIBLE);
                    st2.setImageResource(R.drawable.baseline_star_242);

                    st3.setVisibility(View.INVISIBLE);
                    st3.setImageResource(R.drawable.baseline_star_242);
                    st4.setVisibility(View.INVISIBLE);
                    st4.setImageResource(R.drawable.baseline_star_242);
                    st5.setVisibility(View.INVISIBLE);
                    st5.setImageResource(R.drawable.baseline_star_242);

                }


                nombre.setText(appslist.get(position).getDesarrollador());


                CardView cardView= pupop.findViewById(R.id.card);


                Glide.with(holder.nombreApp.getContext()).load(appslist.get(position).getUrl_image()).into(img);
                Glide.with(holder.nombreApp.getContext()).load(appslist.get(position).getUrl_encabezado()).into(imgE);


                cardView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        popupWindow.dismiss();
                    }
                });

            }
        });
    }

    @Override
    public int getItemCount() {

        if(this.appslist!=null)
            return this.appslist.size();
        else
            return 0;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {

        this.listener = onClickListener;

    }
    @Override
    public  void onClick(View v){
        if(listener!= null){
            listener.onClick(v);
        }
    }



    public class AppsViewHolder extends RecyclerView.ViewHolder
    {
        TextView nombreApp,desarrollador,precio,calificacion;
        ImageView imgApp,st1,st2,st3,st4,st5;
        public AppsViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreApp=itemView.findViewById(R.id.titleViewApp);
            precio=itemView.findViewById(R.id.precioViewApp);
            //calificacion=itemView.findViewById(R.id.calificacionViewApp);
            imgApp=itemView.findViewById(R.id.imgV);
            st1= itemView.findViewById(R.id.s1);
            st2= itemView.findViewById(R.id.s2);
            st3= itemView.findViewById(R.id.s3);
            st4= itemView.findViewById(R.id.s4);
            st5= itemView.findViewById(R.id.s5);
        }
    }


}
