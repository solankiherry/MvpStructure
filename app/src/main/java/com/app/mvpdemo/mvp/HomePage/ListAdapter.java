package com.app.mvpdemo.mvp.HomePage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.mvpdemo.R;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.MainViewHolder> {

    public ListAdapter(List<String> items, Listener listener) {
        this.items = items;
        this.listener = listener;
    }

    public interface Listener {
        void onItemClicked(String item);
    }

    private List<String> items;
    private Listener listener;

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);
        return new MainViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder holder, int position) {
        final String item = items.get(position);
        holder.textView.setText(item);
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClicked(item);
            }
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class MainViewHolder extends RecyclerView.ViewHolder {

        TextView textView;

        MainViewHolder(View item) {
            super(item);
            this.textView = item.findViewById(R.id.txt);
        }
    }
}