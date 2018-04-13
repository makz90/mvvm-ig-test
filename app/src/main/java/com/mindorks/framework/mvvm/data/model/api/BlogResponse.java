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

public class BlogResponse {

    @Expose
    @SerializedName("markets")
    private List<Blog> markets;

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
        if (!(o instanceof BlogResponse)) {
            return false;
        }

        BlogResponse that = (BlogResponse) o;

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

    public List<Blog> getMarkets() {
        return markets;
    }

    public String getChartFormat() {
        return chartFormat;
    }

    public String getConfiguration() { return configuration; }

    public String getLightstreamerEndpoint() {
        return lightstreamerEndpoint;
    }

    public static class Blog {

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
            if (!(o instanceof Blog)) {
                return false;
            }

            Blog blog = (Blog) o;

            if (!displayPeriod.equals(blog.displayPeriod)) {
                return false;
            }
            if (!epic.equals(blog.epic)) {
                return false;
            }
            if (!displayOffer.equals(blog.displayOffer)) {
                return false;
            }
            if (!displayBid.equals(blog.displayBid)) {
                return false;
            }
            if (!instrumentName.equals(blog.instrumentName)) {
                return false;
            }
            if (instrumentVersion != blog.instrumentVersion) {
                return false;
            }
            if (!updateTime.equals(blog.updateTime)) {
                return false;
            }
            if (netChange != blog.netChange) {
                return false;
            }
            if (scaled != blog.scaled) {
                return false;
            }
            if (timezoneOffset != blog.timezoneOffset) {
                return false;
            }
            return exchangeId.equals(blog.exchangeId);

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

        public int getInstrumentVersion() {
            return instrumentVersion;
        }

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