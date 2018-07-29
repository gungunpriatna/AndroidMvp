package me.gungunpriatna.androidmvp.networking;


import me.gungunpriatna.androidmvp.models.CityListResponse;
import retrofit2.http.GET;
import rx.Observable;


public interface NetworkService {

    @GET("v1/city")
    Observable<CityListResponse> getCityList();

}