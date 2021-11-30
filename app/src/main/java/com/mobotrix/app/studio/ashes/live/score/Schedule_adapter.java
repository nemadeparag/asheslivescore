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

public class Schedule_adapter extends RecyclerView.Adapter<Schedule_adapter.ViewHolder> {

    private List<String> mMatch_Number;
    private List<String> mMatch_Date_Time;
    private List<String> mMatch_Location;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;

    Schedule_adapter(Context context, List<String> match_number, List<String> match_date_time, List<String> match_location) {
        this.mInflater = LayoutInflater.from(context);
        this.mMatch_Number = match_number;
        this.mMatch_Date_Time = match_date_time;
        this.mMatch_Location = match_location;
    }

    // inflates the row layout from xml when needed
    @Override
    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.schedule_recyclerview_layout, parent, false);
        return new Schedule_adapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String MATCH_Number = mMatch_Number.get(position);
        String MATCH_Date_Time = mMatch_Date_Time.get(position);
        String MATCH_Location = mMatch_Location.get(position);
        holder.match_number.setText(MATCH_Number);
        holder.match_date_time.setText(MATCH_Date_Time);
        holder.match_location.setText(MATCH_Location);
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mMatch_Number.size();
    }
    
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView match_number;
        TextView match_date_time;
        TextView match_location;

        ViewHolder(View itemView) {
            super(itemView);
            match_number = itemView.findViewById(R.id.match_number);
            match_date_time = itemView.findViewById(R.id.match_date_time);
            match_location = itemView.findViewById(R.id.match_location);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    public String getItem(int id) {
        return mMatch_Number.get(id);
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
