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

public class Stadium_adapter extends RecyclerView.Adapter<Stadium_adapter.ViewHolder>{


    private List<Integer> mImagesStadium;
    private List<String> mNamesStadium;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    Stadium_adapter(Context context, List<Integer> images_stadium, List<String> names_stadium) {
        this.mInflater = LayoutInflater.from(context);
        this.mImagesStadium = images_stadium;
        this.mNamesStadium = names_stadium;

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
        int Player_Image = mImagesStadium.get(position);
        String Player_Name = mNamesStadium.get(position);
        holder.Aus_player_imageview.setBackgroundResource(Player_Image);
        holder.Aus_player_name_txt.setText(Player_Name);
    }
    // total number of rows
    @Override
    public int getItemCount() {
        return mNamesStadium.size();
    }



    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView Aus_player_imageview;
        TextView Aus_player_name_txt;

        ViewHolder(View itemView) {
            super(itemView);
            Aus_player_imageview = itemView.findViewById(R.id.Aus_Player_Imageview);
            Aus_player_name_txt = itemView.findViewById(R.id.Aus_Player_Name_txtView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    public String getItem(int id) {
        return mNamesStadium.get(id);
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
