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

public class MarketItemViewModel {

    public final ObservableField<String> instrumentName;

    public final ObservableField<String> displayBid;

    public final ObservableField<String> displayOffer;

    public final ObservableField<String> displayPeriod;

    public final ObservableField<String> epic;

    public final ObservableField<String> updateTime;

    public final ObservableField<String> versionString;

    public final ObservableField<String> exchangeIdString;

    public final ObservableField<String> netChangeString;

    private final MarketResponse.Market mMarket;

    public final MarketItemViewModelListener mListener;

    public MarketItemViewModel(MarketResponse.Market market, MarketItemViewModelListener listener) {
        this.mMarket = market;
        this.mListener = listener;

        instrumentName = new ObservableField<>(mMarket.getInstrumentName());
        displayOffer = new ObservableField<>(mMarket.getDisplayOffer());
        displayPeriod = new ObservableField<>(mMarket.getDisplayPeriod());
        epic = new ObservableField<>(mMarket.getEpic());
        updateTime = new ObservableField<>(mMarket.getUpdateTime());
        displayBid = new ObservableField<>(mMarket.getDisplayBid());
        versionString = new ObservableField<>("(version " + mMarket.getInstrumentVersion() + ")");
        exchangeIdString = new ObservableField<>("(ID: " + mMarket.getExchangeId() + ")");
        netChangeString = new ObservableField<>(String.valueOf(mMarket.getNetChange()));
    }

    public void onItemClick() {
        mListener.onItemClick(mMarket.getDisplayPeriod());
    }

    public interface MarketItemViewModelListener {

        void onItemClick(String marketUrl);
    }
}
