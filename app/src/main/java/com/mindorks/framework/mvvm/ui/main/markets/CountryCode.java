package com.mindorks.framework.mvvm.ui.main.markets;

public class CountryCode {
    private String name;
    private String apiEndpoint;

    public CountryCode(String name, String apiEndpoint) {
        this.name = name;
        this.apiEndpoint = apiEndpoint;
    }

    public void setApiEndpoint(String apiEndpoint) {
        this.apiEndpoint = apiEndpoint;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApiEndpoint() {
        return apiEndpoint;
    }

    public String getName() {
        return name;
    }
}
