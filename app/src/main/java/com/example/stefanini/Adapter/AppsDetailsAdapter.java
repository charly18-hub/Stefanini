package com.example.stefanini.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.stefanini.Model.AppsModel;
import com.example.stefanini.R;

import java.util.List;


public class AppsDetailsAdapter extends RecyclerView.Adapter<AppsDetailsAdapter.AppsViewHolder> {


    List<AppsModel> appslist;

    Context context;
    View.OnClickListener listener;

    public AppsDetailsAdapter(Context context) {
        this.context = context;
    }

    public AppsDetailsAdapter(List<AppsModel> list) {
        this.appslist = list;
    }

    public void updatemovielist(List<AppsModel> list) {
        this.appslist = list;
        notifyDataSetChanged();
    }





    @NonNull
    @Override
    public AppsDetailsAdapter.AppsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.app_pop,parent,false);
        return new AppsDetailsAdapter.AppsViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull AppsDetailsAdapter.AppsViewHolder holder, int position) {

        holder.nombreApp.setText(appslist.get(position).getAppNombre());
        holder.desarrollador.setText(appslist.get(position).getDesarrollador());

        if(appslist.get(position).getPrecio() < 1 ){

            holder.precio.setText("Free");

        }else {

            holder.precio.setText("$"+String.valueOf(appslist.get(position).getPrecio())+".00");

        }



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


        Glide.with(holder.imgApp.getContext()).load(appslist.get(position).getUrl_image()).into(holder.imgApp);

        Glide.with(holder.imgAppE.getContext()).load(appslist.get(position).getUrl_encabezado()).into(holder.imgAppE);

    }

    @Override
    public int getItemCount() {

        if(this.appslist!=null)
            return this.appslist.size();
        else
            return 0;
    }



    public class AppsViewHolder extends RecyclerView.ViewHolder
    {
        TextView nombreApp,desarrollador,precio,calificacion;
        ImageView imgApp,imgAppE,st1,st2,st3,st4,st5;
        public AppsViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreApp=itemView.findViewById(R.id.titleViewApp);
            desarrollador=itemView.findViewById(R.id.desarrolladorViewApp);
            precio=itemView.findViewById(R.id.precioViewApp);
            //calificacion=itemView.findViewById(R.id.calificacionViewApp);
            imgApp=itemView.findViewById(R.id.cardimg);
            imgAppE=itemView.findViewById(R.id.cardimgHeader);
            st1= itemView.findViewById(R.id.s1);
            st2= itemView.findViewById(R.id.s2);
            st3= itemView.findViewById(R.id.s3);
            st4= itemView.findViewById(R.id.s4);
            st5= itemView.findViewById(R.id.s5);


        }
    }

}
