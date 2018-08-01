package com.soon.karat.animations;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class AnimateDrawableFragment extends Fragment {

    ImageView imageView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_animate_drawable, container, false);

        imageView = view.findViewById(R.id.image_drawable);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createAnimationDrawable();
            }
        });

        return view;
    }

    /**
     * It's important to note that the start() method called on the {@link AnimationDrawable}
     * cannot be called during the {@link #onCreate(Bundle)} method of your Activity, because
     * the {@link AnimationDrawable} is not yet fully attached to the window. If you want to
     * play the animation immediately, without requiring interaction, then you might want to
     * call it from the {@link #onStart()} method in your Activity, which will get called
     * when Android makes the view visible on the screen.
     * </p>
     * This animation will run for just three frames by following the sequence on the
     * the {@link R.drawable#animation_play_pause} xml file. See the file for additional
     * information.
     */
    private void createAnimationDrawable() {
        imageView.setBackgroundResource(R.drawable.animation_play_pause);
        AnimationDrawable playPauseAnimation = (AnimationDrawable) imageView.getBackground();
        playPauseAnimation.start();
    }

}


