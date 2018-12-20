package com.badderxkaido.customlistview;

/*
Created By  Badre Eddine MOUHOUB
            Ingénieur d'Etat, JAVA Software Engineer, ENSAH
            badre.mouhoub@gmail.com
            https://www.linkedin.com/in/bmouhoub/

 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class CustomListAdapter extends ArrayAdapter<Item> {

    ArrayList<Item> items;
    Context context;
    int resource;

    public CustomListAdapter(Context context, int resource, ArrayList<Item> items) {
        super(context, resource, items);
        this.items = items;
        this.context = context;
        this.resource = resource;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){

            LayoutInflater layoutInflater = (LayoutInflater) getContext()
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

            convertView = layoutInflater.inflate(R.layout.custom_list_layout, null);
        }

        Item item = getItem(position);

        ImageView imageView = convertView.findViewById(R.id.imageAvatar);
        // Using the Glide library
        Glide.with(context).load(item.getOwnerAvatar()).into(imageView);

        ImageView iv = convertView.findViewById(R.id.starImg);
        Glide.with(context).load(item.getStarsImage()).into(iv);

        TextView tx1 = convertView.findViewById(R.id.repoName);
        tx1.setText(item.getRepoName());

        TextView tx2 = convertView.findViewById(R.id.repoDesc);
        tx2.setText(item.getRepoDescription());

        TextView tx3 = convertView.findViewById(R.id.ownerName);
        tx3.setText(item.getOwnerName());

        TextView tx4 = convertView.findViewById(R.id.numberOfStars);
        tx4.setText(item.getNumberOfStars());

        return convertView;

    }
}
