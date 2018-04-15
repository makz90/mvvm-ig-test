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

import android.databinding.ObservableField;

import com.mindorks.framework.mvvm.data.model.api.MarketResponse;

/**
 * Created by amitshekhar on 10/07/17.
 */

public class MarketItemViewModel {

    public final ObservableField<String> author;

    public final ObservableField<String> content;

    public final ObservableField<String> date;

    public final MarketItemViewModelListener mListener;

    public final ObservableField<String> title;

    private final MarketResponse.Market mMarket;

    public MarketItemViewModel(MarketResponse.Market market, MarketItemViewModelListener listener) {
        this.mMarket = market;
        this.mListener = listener;
        title = new ObservableField<>(mMarket.getDisplayOffer());
        author = new ObservableField<>(mMarket.getInstrumentName());
        date = new ObservableField<>(mMarket.getExchangeId());
        content = new ObservableField<>(mMarket.getDisplayBid());
    }

    public void onItemClick() {
        mListener.onItemClick(mMarket.getDisplayPeriod());
    }

    public interface MarketItemViewModelListener {

        void onItemClick(String marketUrl);
    }
}
