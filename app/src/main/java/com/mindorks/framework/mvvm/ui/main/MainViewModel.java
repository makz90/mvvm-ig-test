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

package com.mindorks.framework.mvvm.ui.main;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableField;
import android.databinding.ObservableList;

import com.mindorks.framework.mvvm.data.DataManager;
import com.mindorks.framework.mvvm.data.model.api.MarketResponse;
import com.mindorks.framework.mvvm.ui.base.BaseViewModel;
import com.mindorks.framework.mvvm.ui.main.markets.CountryCode;
import com.mindorks.framework.mvvm.utils.rx.SchedulerProvider;

import java.util.List;

public class MainViewModel extends BaseViewModel<MainNavigator> {

    public static final int NO_ACTION = -1, ACTION_ADD_ALL = 0, ACTION_DELETE_SINGLE = 1;

    private final ObservableField<String> appVersion = new ObservableField<>();

    private final ObservableField<String> userEmail = new ObservableField<>("maksym.krawczyk@gmail.com");

    private final ObservableField<String> userName = new ObservableField<>("Maksym Krawczyk");

    private final ObservableField<String> userProfilePicUrl = new ObservableField<>("https://media.licdn.com/dms/image/C4E03AQHENonjQAHzPg/profile-displayphoto-shrink_100_100/0?e=1528930800&v=beta&t=nt1FjWvG3AMkrAiC6evAKCOkRAxnaZtBzHJR0-orouY");

    public final ObservableList<MarketResponse.Market> marketObservableArrayList = new ObservableArrayList<>();

    public final ObservableList<CountryCode> countryCodeObservableArrayList = new ObservableArrayList<>();

    private final MutableLiveData<List<MarketResponse.Market>> marketListLiveData;

    private String selectedApiEndpoint;

    private int action = NO_ACTION;

    public MainViewModel(DataManager dataManager, SchedulerProvider schedulerProvider) {
        super(dataManager, schedulerProvider);
        marketListLiveData = new MutableLiveData<>();
        initCountryCodes();
        fetchMarkets();
    }

    private void initCountryCodes() {
        countryCodeObservableArrayList.clear();
        countryCodeObservableArrayList.add(new CountryCode("UK", "/en_GB/igi"));
        countryCodeObservableArrayList.add(new CountryCode("France", "/fr_FR/frm"));
        countryCodeObservableArrayList.add(new CountryCode("Germany", "/de_DE/dem"));
        selectedApiEndpoint = countryCodeObservableArrayList.get(0).getApiEndpoint();
    }

    public String getSelectedApiEndpoint() {
        return selectedApiEndpoint;
    }

    public void setSelectedApiEndpoint(String selectedApiEndpoint) {
        this.selectedApiEndpoint = selectedApiEndpoint;
    }

    public ObservableField<String> getAppVersion() {
        return appVersion;
    }

    public ObservableField<String> getUserEmail() {
        return userEmail;
    }

    public ObservableField<String> getUserName() {
        return userName;
    }

    public void updateAppVersion(String version) {
        appVersion.set(version);
    }

    public void addMarketItemsToList(List<MarketResponse.Market> markets) {
        marketObservableArrayList.clear();
        marketObservableArrayList.addAll(markets);
    }

    public void fetchMarkets() {
        setIsLoading(true);
        getCompositeDisposable().add(getDataManager()
                .getMarketApiCall(selectedApiEndpoint)
                .subscribeOn(getSchedulerProvider().io())
                .observeOn(getSchedulerProvider().ui())
                .subscribe(marketResponse -> {
                    if (marketResponse != null && marketResponse.getMarkets() != null) {
                        marketListLiveData.setValue(marketResponse.getMarkets());
                    }
                    setIsLoading(false);
                }, throwable -> {
                    setIsLoading(false);
                    getNavigator().handleError(throwable);
                }));
    }

    public MutableLiveData<List<MarketResponse.Market>> getMarketListLiveData() {
        return marketListLiveData;
    }

    public ObservableList<MarketResponse.Market> getMarketObservableList() {
        return marketObservableArrayList;
    }
}
