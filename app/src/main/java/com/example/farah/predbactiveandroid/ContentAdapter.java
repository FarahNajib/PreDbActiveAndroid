package com.example.farah.predbactiveandroid;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.activeandroid.query.Select;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by farah on 5/1/2017.
 */

public class ContentAdapter  extends RecyclerView.Adapter<ViewHolder> {

    public Context mContext;
    public   ArrayList<Itemd> dataitraw ;



    public ContentAdapter(Context mContext, ArrayList<Itemd> dataitraw)
    {
        this.mContext = mContext;
        this.dataitraw = dataitraw;


    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemrecview, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Itemd vocdata = dataitraw.get(position);
        byte[] outImage=dataitraw.get(position).imgvoc;
       // Resources resources = context.getResources();
        if (outImage !=null) {
            ByteArrayInputStream imageStream = new ByteArrayInputStream(outImage);
            Bitmap theImage = BitmapFactory.decodeStream(imageStream);

           holder.picture.setImageBitmap(theImage);
        }
        else
            {
            //   holder.picture.setImageBitmap();

        }
        holder.name.setText(dataitraw.get(position).namef);

    }

    @Override
    public int getItemCount() {
        return dataitraw.size();
    }

    public void setFilter(List<Itemd> countryModels) {
        dataitraw = new ArrayList<>();
        dataitraw.addAll(countryModels);
        notifyDataSetChanged();
    }
    }


