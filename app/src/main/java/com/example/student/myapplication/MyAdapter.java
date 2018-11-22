package com.example.student.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    List<String> dataList;
    public MyAdapter(List<String> myDataset)
    {
        dataList = myDataset;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType)
    {
        if(viewType==0) {
            TextView view = (TextView)LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.header_layout, viewGroup, false);
            return new HeaderViewHolder(view);
        }
        else {
            TextView view = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.student_layout, viewGroup, false);
            return new StudentViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int position)
    {
                    HeaderViewHolder myViewHolder = (HeaderViewHolder) viewHolder;
                    myViewHolder.headerTextView.setText(dataList.get(position));
    }

    @Override
    public int getItemCount()
    {
        return dataList.size();
    }

    @Override
    public int getItemViewType(int position)
    {
        if(position==0){
            return 0;
        }
        else{
            return 1;
        }
    }

    class HeaderViewHolder extends RecyclerView.ViewHolder{
        TextView headerTextView;
        public HeaderViewHolder(@NonNull View itemView){
            super(itemView);
             headerTextView = itemView.findViewById(R.id.textViewHeader);
        }
    }
    class StudentViewHolder extends RecyclerView.ViewHolder{
        TextView imeTextView;
        TextView prezimeTextView;
        public StudentViewHolder(@NonNull View itemView){
            super(itemView);
           imeTextView = itemView.findViewById(R.id.textViewIme);
           prezimeTextView = itemView.findViewById(R.id.textViewPrezime);
        }
    }
}