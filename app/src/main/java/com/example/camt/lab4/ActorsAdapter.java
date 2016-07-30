package com.example.camt.lab4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by SKY on 7/11/2016.
 */

public class ActorsAdapter extends ArrayAdapter<Actors> {
    Context mContext;
    int mResource;
    ArrayList<Actors> mObjects;

    public ActorsAdapter(Context context, int resource, ArrayList<Actors> objects){
        super(context,resource,objects);
        mContext = context;
        mResource = resource;
        mObjects= objects;

    }

    public View getView(int position, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(mResource, parent, false);

        ImageView actorImage = (ImageView) convertView.findViewById(R.id.img_actor);
        TextView actorName = (TextView) convertView.findViewById(R.id.name_actor);
        TextView actorDesc = (TextView) convertView.findViewById(R.id.desc_actor);


        actorName.setText(mObjects.get(position).getName());
        actorDesc.setText(mObjects.get(position).getDescription());

        Picasso.with(mContext)
                .load(mObjects.get(position).getImage())
                .into(actorImage);

        return convertView;

    }
}
