package com.example.machinetask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AssignmentAdapter extends RecyclerView.Adapter<AssignmentAdapter.ViewHolder> {

    List<AssinmentObject> mlist = new ArrayList<AssinmentObject>();
    Context context;

    public AssignmentAdapter(List<AssinmentObject> mlist, Context context) {
        this.mlist = mlist;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.listlayout, parent, false);
        return new ViewHolder(v);    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final AssinmentObject object = mlist.get(position);
        holder.listname.setText(object.getName());
        holder.listAge.setText(object.getAge());
        holder.listRollNo.setText(object.getRollNo());
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView listname,listAge,listRollNo;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            listname = itemView.findViewById(R.id.listName);
            listAge = itemView.findViewById(R.id.listAge);
            listRollNo = itemView.findViewById(R.id.listRollNo);
        }
    }
}
