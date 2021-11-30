package com.mobotrix.app.studio.ashes.live.score;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Main_adapter extends RecyclerView.Adapter<Main_adapter.ViewHolder>{

    private List<Integer> mImagesMain;
    private List<String> mNamesMain;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    Main_adapter(Context context, List<Integer> images_main, List<String> names_main) {
        this.mInflater = LayoutInflater.from(context);
        this.mImagesMain = images_main;
        this.mNamesMain = names_main;

    }

    // inflates the row layout from xml when needed
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.main_recyclerview_layout, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the view and textview in each row
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int MAin_Image = mImagesMain.get(position);
        String tXt_Name = mNamesMain.get(position);
        holder.main_imageview.setBackgroundResource(MAin_Image);
        holder.name_txt.setText(tXt_Name);
    }
    // total number of rows
    @Override
    public int getItemCount() {
        return mNamesMain.size();
    }




    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView main_imageview;
        TextView name_txt;

        ViewHolder(View itemView) {
            super(itemView);
            main_imageview = itemView.findViewById(R.id.MAIN_Imageview);
            name_txt = itemView.findViewById(R.id.TXT_MAIN_Names);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    public String getItem(int id) {
        return mNamesMain.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

}
