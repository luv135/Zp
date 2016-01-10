/*
 * Copyright (C) 2015 Drakeet <drakeet.me@gmail.com>
 *
 * This file is part of Meizhi
 *
 * Meizhi is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Meizhi is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with Meizhi.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.luo.zp.views.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.luo.zp.R;
import com.luo.zp.models.Meizhi;
import com.luo.zp.views.RatioImageView;
import com.orhanobut.logger.Logger;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by drakeet on 6/20/15.
 */
public class MeizhiListAdapter
        extends RecyclerView.Adapter<MeizhiListAdapter.ViewHolder> {

    public static final String TAG = "MeizhiListAdapter";

    private List<Meizhi> mList;
    private Context mContext;
    private OnMeizhiTouchListener mOnMeizhiTouchListener;



    public MeizhiListAdapter(Context context) {
        mList = new ArrayList<>();
        mContext = context;
    }

//    public void set(List<Meizhi> mList){
//        int size = this.mList.size();
//        int size1 = mList.size();
//        if(size>size1){
//            notifyItemRangeChanged(0,size1);
//
//        } else {    //size<size1
//            notifyItemRangeChanged(0,size);
//            notifyItemRangeInserted(size,size1-size);
//        }
//    }

    public void update(String faceid, List<Meizhi> mList) {
        int oldSize = this.mList.size();
        int newSize = mList.size();
        int oldPosition=-1;
        if(!TextUtils.isEmpty(faceid)) {
            oldPosition = findFaceidPosition(faceid, this.mList);
            int newPosition = findFaceidPosition(faceid, mList);
            if(oldPosition!=-1&&newPosition!=-1) {
                Meizhi meizhi = mList.get(newPosition);
                mList.remove(newPosition);
                mList.add(oldPosition, meizhi);
            }
            Logger.d("old: %d, new: %d",oldPosition,newPosition);
        }


        this.mList.clear();
        this.mList.addAll(mList);

        if (oldSize <= newSize) {
            if (oldPosition>-1){
                notifyItemRangeChanged(0, oldPosition);
                notifyItemRangeChanged(oldPosition+1, oldSize-oldPosition);
                notifyItemRangeInserted(oldSize, newSize - oldSize);
            }else {
                notifyItemRangeChanged(0, oldSize);
                notifyItemRangeInserted(oldSize, newSize - oldSize);
            }

        } else {
            if(oldPosition>-1) {
                notifyItemRangeChanged(0, oldPosition);
                notifyItemRangeChanged(oldPosition + 1, newSize-oldPosition);
                notifyItemRangeRemoved(newSize, oldSize - newSize);
            } else {
                notifyItemRangeChanged(0, newSize);
                notifyItemRangeRemoved(newSize, oldSize - newSize);
            }
        }
    }

    public int findFaceidPosition(String faceid, List<Meizhi> mList) {
        int position = -1;
        for (int i = 0; i < mList.size(); i++) {
            if (faceid.equals(mList.get(i).getFaceid())) {
                Logger.d("find position is "+i);
                position = i;
//                break;
            }
        }
        return position;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_meizhi, parent, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
        Meizhi meizhi = mList.get(position);
        viewHolder.meizhi = meizhi;
        viewHolder.titleView.setText(String.format("%d岁  %scm  %s %d", meizhi.getAge(), meizhi.getState(), meizhi.getUserinfos().getSchool(),position));
        Glide.with(mContext)
                .load(meizhi.getHeadimage())
                .centerCrop()
                .into(viewHolder.meizhiView);
//             .getSize((width, height) -> {
//                 if (!viewHolder.card.isShown()) {
//                     viewHolder.card.setVisibility(View.VISIBLE);
//                 }
//             });
    }


    @Override
    public void onViewRecycled(ViewHolder holder) {
        super.onViewRecycled(holder);
    }


    @Override
    public int getItemCount() {
        return mList.size();
    }


    public void setOnMeizhiTouchListener(OnMeizhiTouchListener onMeizhiTouchListener) {
        this.mOnMeizhiTouchListener = onMeizhiTouchListener;
    }

    public Meizhi getItem(int position) {
        return mList.get(position);
    }

    public List<Meizhi> getList() {
        return mList;
    }


    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @Bind(R.id.iv_meizhi)
        RatioImageView meizhiView;
        @Bind(R.id.tv_title)
        TextView titleView;
        View card;
        Meizhi meizhi;


        public ViewHolder(View itemView) {
            super(itemView);
            card = itemView;
            ButterKnife.bind(this, itemView);
            meizhiView.setOnClickListener(this);
            card.setOnClickListener(this);
            meizhiView.setOriginalSize(50, 50);
        }


        @Override
        public void onClick(View v) {
            mOnMeizhiTouchListener.onTouch(v, meizhiView, card, meizhi);
        }
    }

}
