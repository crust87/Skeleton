package com.ethanhua.skeleton.viewholder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ethanhua.skeleton.R;

import io.supercharge.shimmerlayout.ShimmerLayout;

/**
 * Created by ethanhua on 2017/7/29.
 */

public class BackgroundedShimmerViewHolder extends BaseViewHolder {

    public BackgroundedShimmerViewHolder(LayoutInflater inflater, ViewGroup parent, int innerViewResId, int outerViewResId) {
        super(inflater.inflate(outerViewResId, parent, false));
        ViewGroup layout = (ViewGroup) itemView;
        shimmerLayout = (ShimmerLayout) inflater.inflate(R.layout.layout_shimmer, layout, false);
        View view = inflater.inflate(innerViewResId, shimmerLayout, false);
        ViewGroup.LayoutParams lp = view.getLayoutParams();
        if (lp != null) {
            shimmerLayout.setLayoutParams(lp);
        }
        shimmerLayout.addView(view);
        layout.addView(shimmerLayout);
    }
}
