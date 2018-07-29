package me.gungunpriatna.androidmvp.home;

import me.gungunpriatna.androidmvp.models.CityListResponse;

public interface HomeView {
    void showWait();

    void removeWait();

    void onFailure(String appErrorMessage);

    void getCityListSuccess(CityListResponse cityListResponse);

}