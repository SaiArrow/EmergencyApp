package thedorkknightrises.emergencyapp.ui.feed;

/**
 * Created by ysr on 1/28/2017.
 */

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import thedorkknightrises.emergencyapp.R;



public class RecyclerAdapterNews extends RecyclerView.Adapter<RecyclerAdapterNews.NewsRecyclerViewHolder> {

    private Context context;

    private ArrayList<FeedItem> arrayList = new ArrayList<>();


    public RecyclerAdapterNews(Context context, ArrayList<FeedItem> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @Override
    public NewsRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.recycler_news_item, parent, false);

        return new NewsRecyclerViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(final NewsRecyclerViewHolder holder, final int position) {
        //set layout resources here from arraylist
        holder.tvTitle.setText(arrayList.get(position).getTitle());
        holder.imgNews.setImageResource(arrayList.get(position).getImageId());
        holder.tvExcerpt.setText(arrayList.get(position).getExcerpt());
        holder.imgNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String clicked_tv=holder.tvTitle.getText().toString();
                Intent intent = new Intent(context, FeedEvent.class);
                intent.putExtra("title", clicked_tv);
                intent.putExtra("desc", holder.tvExcerpt.getText().toString());
                intent.putExtra("image", arrayList.get(position).getImageId());
                System.out.println(clicked_tv);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
        holder.event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String clicked_tv=holder.tvTitle.getText().toString();
                Intent intent = new Intent(context, FeedEvent.class);
                intent.putExtra("title", clicked_tv);
                intent.putExtra("desc", holder.tvExcerpt.getText().toString());
                intent.putExtra("image", arrayList.get(position).getImageId());
                System.out.println(clicked_tv);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

    }


    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class NewsRecyclerViewHolder extends RecyclerView.ViewHolder {
        ImageView imgNews;
        TextView tvTitle;
        TextView tvExcerpt;
        LinearLayout event;


        NewsRecyclerViewHolder(View itemView) {
            super(itemView);

            imgNews = (ImageView) itemView.findViewById(R.id.img_news) ;
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvExcerpt = (TextView) itemView.findViewById(R.id.tv_excerpt);
            event = (LinearLayout) itemView.findViewById(R.id.event);

        }
    }

}
