package com.ethanhua.skeleton.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ethanhua.skeleton.R;

import io.supercharge.shimmerlayout.ShimmerLayout;

/**
 * Created by ethanhua on 2017/7/29.
 */

public class ShimmerViewHolder extends BaseViewHolder {

    public ShimmerViewHolder(LayoutInflater inflater, ViewGroup parent, int innerViewResId) {
        super(inflater.inflate(R.layout.layout_shimmer, parent, false));
        shimmerLayout = (ShimmerLayout) itemView;
        View view = inflater.inflate(innerViewResId, shimmerLayout, false);
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        if (lp != null) {
            shimmerLayout.setLayoutParams(lp);
        }
        shimmerLayout.addView(view);
    }
}
