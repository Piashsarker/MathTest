package com.ptlearnpoint.mathtest.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ptlearnpoint.mathtest.MainMenu;
import com.ptlearnpoint.mathtest.R;

import java.util.ArrayList;

/**
 * Created by pt on 11/17/16.
 */

public class MainMenuAdapter extends RecyclerView.Adapter<MainMenuAdapter.ViewHolder> {
    Context mContext;
    OnItemClickListener mItemClickListener;
    private ArrayList<MainMenu> mainMenuArrayList;
    // 2
    public MainMenuAdapter(Context context , ArrayList<MainMenu> mainMenuList) {

        this.mContext = context;
        this.mainMenuArrayList = mainMenuList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_main_menu, parent, false);
        return new ViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        holder.placeName.setText(mainMenuArrayList.get(position).getName());
        holder.placeImage.setImageResource(mainMenuArrayList.get(position).getPhoto());

        Bitmap photo = BitmapFactory.decodeResource(mContext.getResources(), mainMenuArrayList.get(position).getPhoto());

        Palette.generateAsync(photo, new Palette.PaletteAsyncListener() {
            public void onGenerated(Palette palette) {
                int bgColor = palette.getMutedColor(mContext.getResources().getColor(android.R.color.black));
                holder.placeNameHolder.setBackgroundColor(bgColor);
            }
        });


    }

    @Override
    public int getItemCount() {
        return  mainMenuArrayList.size();
    }


    // 3
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public LinearLayout placeHolder;
        public LinearLayout placeNameHolder;
        public TextView placeName;
        public ImageView placeImage;



        public ViewHolder(View itemView) {
            super(itemView);
            placeHolder = (LinearLayout) itemView.findViewById(R.id.mainHolder);
            placeName = (TextView) itemView.findViewById(R.id.category_name);
            placeNameHolder = (LinearLayout) itemView.findViewById(R.id.category_name_holder);
            placeImage = (ImageView) itemView.findViewById(R.id.category_image);
            placeHolder.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {
            if (mItemClickListener != null) {
                mItemClickListener.onItemClick(itemView, getPosition());
            }
        }
    }
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mItemClickListener = mItemClickListener;
    }
}
