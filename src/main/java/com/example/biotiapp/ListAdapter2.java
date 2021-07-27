package com.example.biotiapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ListAdapter2 extends RecyclerView.Adapter<ListAdapter2.ViewHolder>{
    private List<ListElement2> mData;
    private LayoutInflater mInflater;
    private Context context;
    final ListAdapter2.OnItemClickListener listener;

    public interface OnItemClickListener{
        void onItemClick(ListElement2 item);
    }

    public ListAdapter2(List<ListElement2> itemList, Context context, ListAdapter2.OnItemClickListener listener){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
        this.listener = listener;
    }

    @Override
    public int getItemCount(){ return mData.size(); }

    @Override
    public ListAdapter2.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.list_element2, parent, false);
        return new ListAdapter2.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapter2.ViewHolder holder, final int position){
        holder.bindData(mData.get(position));
    }

    public void setItems(List<ListElement2> items){ mData = items; }

    public  class ViewHolder extends RecyclerView.ViewHolder{
        TextView nameM, timeM, dateM, result, resultado;

        ViewHolder(View itemView){
            super(itemView);
            nameM = itemView.findViewById(R.id.TextViewNameM);
            dateM = itemView.findViewById(R.id.textViewDateM);
            timeM = itemView.findViewById(R.id.textViewTimeM);
            result = itemView.findViewById(R.id.textViewInd);
            resultado = itemView.findViewById(R.id.textViewResult1);
        }

        void bindData(final ListElement2 item){
            nameM.setText(item.getNameM());
            dateM.setText(item.getDateM());
            timeM.setText(item.getTimeM());
            result.setText(item.getResult());
            resultado.setText(item.getResultado());
            
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(item);
                }
            });
        }



    }

}