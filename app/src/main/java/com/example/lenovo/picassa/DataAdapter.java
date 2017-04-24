package com.example.lenovo.picassa;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Fazle Rabbi on 4/18/2017.
 */
public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<Image> image_versions;
    private Context context;

    public DataAdapter(Context context, ArrayList<Image> android_versions) {
        this.context = context;
        this.image_versions = android_versions;

    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {

        viewHolder.tv_android.setText(image_versions.get(i).getAndroid_version_name());
        Picasso.with(context).load(image_versions.get(i).getAndroid_image_url()).into(viewHolder.img_android);
    }

    @Override
    public int getItemCount() {
        return image_versions.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_android;
        ImageView img_android;
        LinearLayout itemId;

        public ViewHolder(View view) {
            super(view);

            tv_android = (TextView) view.findViewById(R.id.tv_android);
            img_android = (ImageView) view.findViewById(R.id.img_android);
            itemId = (LinearLayout) view.findViewById(R.id.itemId);
        }
    }
}
