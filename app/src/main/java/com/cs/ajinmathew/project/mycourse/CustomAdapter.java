package com.cs.ajinmathew.project.mycourse;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    List<Course> my_list;
    Context context;

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from( parent.getContext() ).inflate( R.layout.my_view,parent,false );


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        final Course course=my_list.get( position );

        holder.tv1.setText( course.getCourse_Title() );
        holder.tv2.setText( course.getCourse_date() );
        holder.tv3.setText( course.getCourse_description() );
        holder.tv4.setText( course.getCourse_duration() );
        holder.tv5.setText( course.getCourse_venue() );
    }

    @Override
    public int getItemCount() {
        return my_list.size();
    }

    public CustomAdapter(List<Course> my_list, Context context) {
        this.my_list = my_list;
        this.context = context;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv1,tv2,tv3,tv4,tv5;

        public MyViewHolder(@NonNull View itemView) {
            super( itemView );

            tv1=itemView.findViewById( R.id.titlecourse );
            tv2=itemView.findViewById( R.id.datecourse );
            tv3=itemView.findViewById( R.id.descriptioncourse );
            tv4=itemView.findViewById( R.id.durationcourse );
            tv5=itemView.findViewById( R.id.venuecourse );

        }
    }
}
