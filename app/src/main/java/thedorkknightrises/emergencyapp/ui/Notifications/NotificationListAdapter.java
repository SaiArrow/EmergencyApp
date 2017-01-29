package thedorkknightrises.emergencyapp.ui.Notifications;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import thedorkknightrises.emergencyapp.R;
import thedorkknightrises.emergencyapp.model.SosData;

/**
 * Created by Tejas on 29/01/2017.
 */

public class NotificationListAdapter extends RecyclerView.Adapter<NotificationListAdapter.NoteViewHolder>{

    Context context;
    ArrayList<SosData> list;

    class NoteViewHolder extends RecyclerView.ViewHolder{
        TextView type,name;
        NoteViewHolder(View view){
            super(view);
            type= (TextView)view.findViewById(R.id.list_item_type);
            name= (TextView)view.findViewById(R.id.list_item_name);
        }
    }

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.noti_list_item,parent,false);
        return new NoteViewHolder(view);
    }

    public NotificationListAdapter(Context context , ArrayList<SosData> list){
        this.list =list;
        this.context= context;
    }

    @Override
    public void onBindViewHolder(NoteViewHolder holder, int position) {
        SosData data = list.get(position);
        holder.type.setText(data.getUser_type());
        holder.name.setText(data.getUser_name());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}






















