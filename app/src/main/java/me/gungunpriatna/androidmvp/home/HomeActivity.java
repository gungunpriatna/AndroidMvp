package me.gungunpriatna.androidmvp.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import javax.inject.Inject;

import me.gungunpriatna.androidmvp.R;
import me.gungunpriatna.androidmvp.BaseApp;
import me.gungunpriatna.androidmvp.models.CityListData;
import me.gungunpriatna.androidmvp.models.CityListResponse;
import me.gungunpriatna.androidmvp.networking.Service;

public class HomeActivity extends BaseApp implements HomeView {

    private RecyclerView list;
    @Inject
    public Service service;
    ProgressBar progressBar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getDeps().inject(this);

        renderView();
        init();

        HomePresenter presenter = new HomePresenter(service, this);
        presenter.getCityList();
    }

    public  void renderView(){
        setContentView(R.layout.activity_home);
        list = findViewById(R.id.list);
        progressBar = findViewById(R.id.progress);
    }

    public void init(){
        list.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void showWait() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void removeWait() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onFailure(String appErrorMessage) {

    }

    @Override
    public void getCityListSuccess(CityListResponse cityListResponse) {

        HomeAdapter adapter = new HomeAdapter(getApplicationContext(), cityListResponse.getData(),
                new HomeAdapter.OnItemClickListener() {
                    @Override
                    public void onClick(CityListData Item) {
                        Toast.makeText(getApplicationContext(), Item.getName(),
                                Toast.LENGTH_LONG).show();
                    }
                });

        list.setAdapter(adapter);

    }
}