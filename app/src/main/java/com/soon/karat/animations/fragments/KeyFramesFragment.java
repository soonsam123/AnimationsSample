package com.soon.karat.animations.fragments;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.soon.karat.animations.R;

/**
 * This Fragment uses {@link Keyframe} to help building the animations.
 */
public class KeyFramesFragment extends Fragment {

    private Button button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_key_frames, container, false);

        button = view.findViewById(R.id.button);

        createAnimationWithKeyFrames();

        return view;
    }

    /**
     * {@link Keyframe} holds a time/value pair of an animation. The
     * {@link Keyframe} class is used to define the values that the animation
     * target will have over the course of the animation.
     * </p>
     * For example, in my case the {@link #button} will start at a 0f rotation.
     * When it passed half of the time (fraction .5f) it will rotate all the way
     * to 360f. Then, when the time is finished it will rotate back to 0f.
     * </p>
     * begin of the time --> fraction of the time: 0f  --> value of rotation: 0f   [stopped]
     * half of the time  --> fraction of the time: .5f --> value of rotation: 360f [one complete rotation forward]
     * end of the time   --> fraction of the time: 1f  --> value of rotation: 0f   [one complete rotation backward]
     */
    private void createAnimationWithKeyFrames() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Keyframe kf0 = Keyframe.ofFloat(0f, 0f);
                Keyframe kf1 = Keyframe.ofFloat(.5f, 360f);
                Keyframe kf2 = Keyframe.ofFloat(1f, 0f);
                PropertyValuesHolder pvhRotation = PropertyValuesHolder.ofKeyframe("rotation", kf0, kf1, kf2);
                ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(button, pvhRotation);
                animator.setDuration(1000);
                animator.start();
            }
        });
    }

}
