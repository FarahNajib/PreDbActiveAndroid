package com.example.farah.predbactiveandroid;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by farah on 5/1/2017.
 */

public class ViewHolder extends RecyclerView.ViewHolder {

  public ImageView picture;
    public TextView name;

    public ViewHolder(View itemView) {

        super(itemView);

      picture=(ImageView)itemView.findViewById(R.id.tile_picture);

        name=(TextView)itemView.findViewById(R.id.tile_title);
    }
}
