package com.soon.karat.animations;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.soon.karat.animations.fragments.ChooserFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_container) != null) {
            if (savedInstanceState != null) {
                return;
            }
            ChooserFragment chooserFragment = new ChooserFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, chooserFragment).commit();
        }

    }

}
