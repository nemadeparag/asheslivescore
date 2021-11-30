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

public class England_Players_adapter extends RecyclerView.Adapter<England_Players_adapter.ViewHolder>{

    private List<Integer> mImages;
    private List<String> mNames;
    private List<String> mRoles;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    England_Players_adapter(Context context, List<Integer> images, List<String> names, List<String> roles) {
        this.mInflater = LayoutInflater.from(context);
        this.mImages = images;
        this.mNames = names;
        this.mRoles = roles;
    }

    // inflates the row layout from xml when needed
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.england_player_recyclerview_layout, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the view and textview in each row
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int Player_Image = mImages.get(position);
        String Player_Name = mNames.get(position);
        String Player_Role = mRoles.get(position);
        holder.Eng_player_imageview.setBackgroundResource(Player_Image);
        holder.Eng_player_name_txt.setText(Player_Name);
        holder.TXT_Player_Role.setText(Player_Role);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mNames.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView Eng_player_imageview;
        TextView Eng_player_name_txt;
        TextView TXT_Player_Role;

        ViewHolder(View itemView) {
            super(itemView);
            Eng_player_imageview = itemView.findViewById(R.id.Aus_Player_Imageview);
            Eng_player_name_txt = itemView.findViewById(R.id.Aus_Player_Name_txtView);
            TXT_Player_Role = itemView.findViewById(R.id.txt_Aus_player_role);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    public String getItem(int id) {
        return mNames.get(id);
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
