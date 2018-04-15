/*
 *  Copyright (C) 2017 MINDORKS NEXTGEN PRIVATE LIMITED
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      https://mindorks.com/license/apache-v2
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License
 */

package com.mindorks.framework.mvvm.ui.main.markets;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.mindorks.framework.mvvm.data.model.api.MarketResponse;
import com.mindorks.framework.mvvm.databinding.ItemMarketEmptyViewBinding;
import com.mindorks.framework.mvvm.databinding.ItemMarketViewBinding;
import com.mindorks.framework.mvvm.ui.base.BaseViewHolder;
import com.mindorks.framework.mvvm.utils.AppLogger;

import java.util.List;

public class MarketAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    public static final int VIEW_TYPE_EMPTY = 0;

    public static final int VIEW_TYPE_NORMAL = 1;

    private List<MarketResponse.Market> mMarketResponseList;

    private MarketAdapterListener mListener;

    public MarketAdapter(List<MarketResponse.Market> marketResponseList) {
        this.mMarketResponseList = marketResponseList;
    }

    @Override
    public int getItemCount() {
        if (mMarketResponseList != null && mMarketResponseList.size() > 0) {
            return mMarketResponseList.size();
        } else {
            return 1;
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (mMarketResponseList != null && !mMarketResponseList.isEmpty()) {
            return VIEW_TYPE_NORMAL;
        } else {
            return VIEW_TYPE_EMPTY;
        }
    }

    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_NORMAL:
                ItemMarketViewBinding blogViewBinding = ItemMarketViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new MarketViewHolder(blogViewBinding);
            case VIEW_TYPE_EMPTY:
            default:
                ItemMarketEmptyViewBinding emptyViewBinding = ItemMarketEmptyViewBinding.inflate(LayoutInflater.from(parent.getContext()),
                        parent, false);
                return new EmptyViewHolder(emptyViewBinding);
        }
    }

    public void addItems(List<MarketResponse.Market> marketList) {
        mMarketResponseList.addAll(marketList);
        notifyDataSetChanged();
    }

    public void clearItems() {
        mMarketResponseList.clear();
    }

    public void setListener(MarketAdapterListener listener) {
        this.mListener = listener;
    }

    public interface MarketAdapterListener {
        void onRetryClick();
    }

    public class MarketViewHolder extends BaseViewHolder implements MarketItemViewModel.MarketItemViewModelListener {

        private ItemMarketViewBinding mBinding;

        private MarketItemViewModel mMarketItemViewModel;

        public MarketViewHolder(ItemMarketViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            final MarketResponse.Market market = mMarketResponseList.get(position);
            mMarketItemViewModel = new MarketItemViewModel(market, this);
            mBinding.setViewModel(mMarketItemViewModel);

            // Immediate Binding
            // When a variable or observable changes, the binding will be scheduled to change before
            // the next frame. There are times, however, when binding must be executed immediately.
            // To force execution, use the executePendingBindings() method.
            mBinding.executePendingBindings();
        }

        @Override
        public void onItemClick(String marketUrl) {
            if (marketUrl != null) {
                try {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_VIEW);
                    intent.addCategory(Intent.CATEGORY_BROWSABLE);
                    intent.setData(Uri.parse(marketUrl));
                    itemView.getContext().startActivity(intent);
                } catch (Exception e) {
                    AppLogger.d("url error");
                }
            }
        }
    }

    public class EmptyViewHolder extends BaseViewHolder implements MarketEmptyItemViewModel.BlogEmptyItemViewModelListener {

        private ItemMarketEmptyViewBinding mBinding;

        public EmptyViewHolder(ItemMarketEmptyViewBinding binding) {
            super(binding.getRoot());
            this.mBinding = binding;
        }

        @Override
        public void onBind(int position) {
            MarketEmptyItemViewModel emptyItemViewModel = new MarketEmptyItemViewModel(this);
            mBinding.setViewModel(emptyItemViewModel);
        }

        @Override
        public void onRetryClick() {
            mListener.onRetryClick();
        }
    }
}