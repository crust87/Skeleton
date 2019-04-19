package com.ethanhua.skeleton.viewholder;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ethanhua.skeleton.R;

import io.supercharge.shimmerlayout.ShimmerLayout;

/**
 * Created by crust87 on 2019/4/19.
 */
public class BaseViewHolder extends RecyclerView.ViewHolder {

    ShimmerLayout shimmerLayout;

    public ShimmerLayout getShimmerLayout() {
        return shimmerLayout;
    }

    public BaseViewHolder(View itemView) {
        super(itemView);
    }
}
