package com.soon.karat.animations.fragments;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.soon.karat.animations.R;

/**
 * This Fragments uses a Crossfade animation to hide the progress bar
 * {@link #mLoadingView} and show the text content {@link #mContentView}.
 */
public class CrossfadeFragment extends Fragment {

    private View mContentView;
    private View mLoadingView;
    private int mShortAnimationDuration;

    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_crossfade, container, false);

        mContentView = view.findViewById(R.id.content);
        mLoadingView = view.findViewById(R.id.progress_bar);

        mShortAnimationDuration = getResources().getInteger(android.R.integer.config_shortAnimTime);

        // Initially hide the content view, set it to GONE so it does not take space on the screen.
        mContentView.setVisibility(View.GONE);

        // Start the crossfade animation after 1.5 seconds
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                crossFade();
            }
        }, 1500);

        return view;
    }

    /**
     * This method shows the text content {@link #mContentView} by animating
     * its alpha from 0f to 1f, and the hide the progress bar {@link #mLoadingView}
     * by animating its alpha from 1f to 0f.
     */
    private void crossFade() {

        // Set the content view to VISIBLE but with 0% opacity.
        // So when the animator starts the content is already in the screen (but fully transparent).
        mContentView.setAlpha(0f);
        mContentView.setVisibility(View.VISIBLE);

        // Animate the content view to 100% opacity using the short animation duration.
        // and clear any animation listeners set before.
        mContentView.animate()
                .alpha(1f)
                .setDuration(mShortAnimationDuration)
                .setListener(null);

        // Animate the loading view to 0% opacity using the short animation duration and
        // set the listeners to set the view to GONE when the animation is ended.
        mLoadingView.animate()
                .alpha(0f)
                .setDuration(mShortAnimationDuration)
                .setListener(new AnimatorListenerAdapter() { // Adapter gives the possible to import
                    @Override                                // only the methods you want.
                    public void onAnimationEnd(Animator animation) {
                        mLoadingView.setVisibility(View.GONE);
                    }
                });
    }
}
