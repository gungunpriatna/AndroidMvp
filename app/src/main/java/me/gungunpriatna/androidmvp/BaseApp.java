package me.gungunpriatna.androidmvp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


import java.io.File;

import me.gungunpriatna.androidmvp.deps.DaggerDeps;
import me.gungunpriatna.androidmvp.deps.Deps;
import me.gungunpriatna.androidmvp.networking.NetworkModule;

public class BaseApp  extends AppCompatActivity {
    Deps deps;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        File cacheFile = new File(getCacheDir(), "responses");
        deps = DaggerDeps.builder().networkModule(new NetworkModule(cacheFile)).build();

    }

    public Deps getDeps() {
        return deps;
    }
}
