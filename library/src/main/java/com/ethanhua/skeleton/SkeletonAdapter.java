package com.ethanhua.skeleton;

import android.support.annotation.IntRange;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.ethanhua.skeleton.viewholder.BackgroundedShimmerViewHolder;
import com.ethanhua.skeleton.viewholder.DefaultViewHolder;
import com.ethanhua.skeleton.viewholder.BaseViewHolder;
import com.ethanhua.skeleton.viewholder.ShimmerViewHolder;

import io.supercharge.shimmerlayout.ShimmerLayout;

/**
 * Created by ethanhua on 2017/7/29.
 */

public class SkeletonAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private int mItemCount;
    private int mLayoutReference;
    private int mBackgroundReference;
    private int[] mLayoutArrayReferences;
    private int mColor;
    private boolean mShimmer;
    private int mShimmerDuration;
    private int mShimmerAngle;

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (doesArrayOfLayoutsExist()) {
            mLayoutReference = viewType;
        }
        if (mShimmer) {
            if (mBackgroundReference != 0) {
                return new BackgroundedShimmerViewHolder(inflater, parent, mLayoutReference, mBackgroundReference);
            } else {
                return new ShimmerViewHolder(inflater, parent, mLayoutReference);
            }
        }

        return new DefaultViewHolder(inflater.inflate(mLayoutReference, parent, false));
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        if (mShimmer && holder.getShimmerLayout() != null) {
            ShimmerLayout layout = holder.getShimmerLayout();
            layout.setShimmerAnimationDuration(mShimmerDuration);
            layout.setShimmerAngle(mShimmerAngle);
            layout.setShimmerColor(mColor);
            layout.startShimmerAnimation();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if(doesArrayOfLayoutsExist()) {
            return getCorrectLayoutItem(position);
        }
        return super.getItemViewType(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return mItemCount;
    }

    public void setLayoutReference(int layoutReference) {
        this.mLayoutReference = layoutReference;
    }

    public void setBackgroundReference(int backgroundReference) {
        this.mBackgroundReference = backgroundReference;
    }

    public void setArrayOfLayoutReferences(int[] layoutReferences) {
        this.mLayoutArrayReferences = layoutReferences;
    }

    public void setItemCount(int itemCount) {
        this.mItemCount = itemCount;
    }

    public void setShimmerColor(int color) {
        this.mColor = color;
    }

    public void shimmer(boolean shimmer) {
        this.mShimmer = shimmer;
    }

    public void setShimmerDuration(int shimmerDuration) {
        this.mShimmerDuration = shimmerDuration;
    }

    public void setShimmerAngle(@IntRange(from = 0, to = 30) int shimmerAngle) {
        this.mShimmerAngle = shimmerAngle;
    }

    public int getCorrectLayoutItem(int position) {
        if(doesArrayOfLayoutsExist()) {
            return mLayoutArrayReferences[position % mLayoutArrayReferences.length];
        }
        return mLayoutReference;
    }

    private boolean doesArrayOfLayoutsExist() {
        return mLayoutArrayReferences != null && mLayoutArrayReferences.length != 0;
    }
}
