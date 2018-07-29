package me.gungunpriatna.androidmvp.deps;


import javax.inject.Singleton;

import dagger.Component;
import me.gungunpriatna.androidmvp.home.HomeActivity;
import me.gungunpriatna.androidmvp.networking.NetworkModule;

@Singleton
@Component(modules = {NetworkModule.class,})
public interface Deps {
    void inject(HomeActivity homeActivity);
}