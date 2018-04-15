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

package com.mindorks.framework.mvvm.data.model.api;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by amitshekhar on 07/07/17.
 */

public class MarketResponse {

    @Expose
    @SerializedName("markets")
    private List<Market> markets;

    @Expose
    @SerializedName("chartFormat")
    private String chartFormat;

    @Expose
    @SerializedName("lightstreamerEndpoint")
    private String lightstreamerEndpoint;


    @Expose
    @SerializedName("configuration")
    private String configuration;


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MarketResponse)) {
            return false;
        }

        MarketResponse that = (MarketResponse) o;

        if (!lightstreamerEndpoint.equals(that.lightstreamerEndpoint)) {
            return false;
        }
        if (!chartFormat.equals(that.chartFormat)) {
            return false;
        }
        return markets.equals(that.markets);

    }

    @Override
    public int hashCode() {
        int result = lightstreamerEndpoint.hashCode();
        result = 31 * result + chartFormat.hashCode();
        result = 31 * result + markets.hashCode();
        return result;
    }

    public List<Market> getMarkets() {
        return markets;
    }

    public String getChartFormat() {
        return chartFormat;
    }

    public String getConfiguration() { return configuration; }

    public String getLightstreamerEndpoint() {
        return lightstreamerEndpoint;
    }

    public static class Market {

        @Expose
        @SerializedName("instrumentName")
        private String instrumentName;

        @Expose
        @SerializedName("instrumentVersion")
        private int instrumentVersion;

        @Expose
        @SerializedName("displayPeriod")
        private String displayPeriod;

        @Expose
        @SerializedName("epic")
        private String epic;

        @Expose
        @SerializedName("exchangeId")
        private String exchangeId;

        @Expose
        @SerializedName("displayBid")
        private String displayBid;

        @Expose
        @SerializedName("displayOffer")
        private String displayOffer;

        @Expose
        @SerializedName("updateTime")
        private String updateTime;

        @Expose
        @SerializedName("netChange")
        private double netChange;

        @Expose
        @SerializedName("scaled")
        private boolean scaled;

        @Expose
        @SerializedName("timezoneOffset")
        private int timezoneOffset;


        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Market)) {
                return false;
            }

            Market market = (Market) o;

            if (!displayPeriod.equals(market.displayPeriod)) {
                return false;
            }
            if (!epic.equals(market.epic)) {
                return false;
            }
            if (!displayOffer.equals(market.displayOffer)) {
                return false;
            }
            if (!displayBid.equals(market.displayBid)) {
                return false;
            }
            if (!instrumentName.equals(market.instrumentName)) {
                return false;
            }
            if (instrumentVersion != market.instrumentVersion) {
                return false;
            }
            if (!updateTime.equals(market.updateTime)) {
                return false;
            }
            if (netChange != market.netChange) {
                return false;
            }
            if (scaled != market.scaled) {
                return false;
            }
            if (timezoneOffset != market.timezoneOffset) {
                return false;
            }
            return exchangeId.equals(market.exchangeId);

        }

        @Override
        public int hashCode() {
            int result = displayPeriod.hashCode();
            result = 31 * result + epic.hashCode();
            result = 31 * result + displayOffer.hashCode();
            result = 31 * result + displayBid.hashCode();
            result = 31 * result + instrumentName.hashCode();
            result = 31 * result + exchangeId.hashCode();
            return result;
        }

        public String getInstrumentName() {
            return instrumentName;
        }

        public String getDisplayPeriod() {
            return displayPeriod;
        }

        public String getEpic() {
            return epic;
        }

        public String getExchangeId() {
            return exchangeId;
        }

        public String getDisplayBid() {
            return displayBid;
        }

        public String getDisplayOffer() {
            return displayOffer;
        }

        public int getInstrumentVersion() { return instrumentVersion; }

        public String getUpdateTime() {
            return updateTime;
        }

        public double getNetChange() {
            return netChange;
        }

        public boolean getScaled() {
            return scaled;
        }

        public int getTimezoneOffset() {
            return timezoneOffset;
        }

    }
}