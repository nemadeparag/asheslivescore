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

public class Australia_Players_adapter extends RecyclerView.Adapter<Australia_Players_adapter.ViewHolder>{
    private List<Integer> mImages2;
    private List<String> mNames2;
    private List<String> mRoles2;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;


    Australia_Players_adapter(Context context, List<Integer> images2, List<String> names2, List<String> roles2) {
        this.mInflater = LayoutInflater.from(context);
        this.mImages2 = images2;
        this.mNames2 = names2;
        this.mRoles2 = roles2;
    }

    // inflates the row layout from xml when needed
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.australia_player_recyclerview_layout, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the view and textview in each row
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        int Player_Image = mImages2.get(position);
        String Player_Name = mNames2.get(position);
        String Player_Role = mRoles2.get(position);
        holder.Aus_player_imageview.setBackgroundResource(Player_Image);
        holder.Aus_player_name_txt.setText(Player_Name);
        holder.Aus_TXT_Player_Role.setText(Player_Role);
    }
    // total number of rows
    @Override
    public int getItemCount() {
        return mNames2.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView Aus_player_imageview;
        TextView Aus_player_name_txt;
        TextView Aus_TXT_Player_Role;

        ViewHolder(View itemView) {
            super(itemView);
            Aus_player_imageview = itemView.findViewById(R.id.Aus_Player_Imageview);
            Aus_player_name_txt = itemView.findViewById(R.id.Aus_Player_Name_txtView);
            Aus_TXT_Player_Role = itemView.findViewById(R.id.txt_Aus_player_role);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    public String getItem(int id) {
        return mNames2.get(id);
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
