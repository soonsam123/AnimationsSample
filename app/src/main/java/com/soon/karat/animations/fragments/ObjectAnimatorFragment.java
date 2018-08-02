package com.soon.karat.animations.fragments;

import android.animation.ObjectAnimator;
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
 * This {@link Fragment} doest that same thing as the {@link ValueAnimatorFragment}
 * but using {@link ObjectAnimator} instead of {@link android.animation.ValueAnimator}.
 * This first one is more recommended by Android because you do not need to the add the
 * listener and you set the {@link View} directly in the {@link ObjectAnimator}.
 */
public class ObjectAnimatorFragment extends Fragment {

    private Button button1;
    private Button button2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_object_animator, container, false);

        button1 = view.findViewById(R.id.button1);
        createAnimationToTranslateByX();

        button2 = view.findViewById(R.id.button2);
        createAnimationToTranslateByXAndRotate();

        return view;
    }

    /**
     * When you click in the {@link #button1} it moves from left to right
     * horizontally by 500 pixels.
     * </p>
     * In order to do that you just need to create an {@link ObjectAnimator#ofFloat(float...)}.
     * (float value in my specific case).
     * And you set directly to the animator the {@link View}, the type of translation and the value.
     * Therefore, you do not need to add listeners as you did in the {@link android.animation.ValueAnimator}.
     * </p>
     * At last, start the animation using {@link ObjectAnimator#start()}.
     */
    private void createAnimationToTranslateByX() {
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animator = ObjectAnimator.ofFloat(button1, "translationX", 0f, 500f);
                animator.setDuration(1000);
                animator.start();
            }
        });
    }

    /**
     * When you click in the {@link #button2} it moves from left to right
     * horizontally by 500 pixels and rotate by 360 degrees in its axis.
     * </p>
     * In order to do that you just need to create an {@link ObjectAnimator#ofFloat(float...)}.
     * (float value in my specific case).
     * And you set directly to the animator the {@link View}, the type of translation and the value.
     * Therefore, you do not need to add listeners as you did in the {@link android.animation.ValueAnimator}.
     * </p>
     * I needed to create two {@link ObjectAnimator}:
     * <ol>
     *     <li>One for the Translation in X</li>
     *     <li>One for the Rotation</li>
     * </ol>
     * At last, start the animation using {@link ObjectAnimator#start()}.
     */
    private void createAnimationToTranslateByXAndRotate() {
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //-----------------------------------------------------------------------
                //                           Translate in X
                //-----------------------------------------------------------------------
                ObjectAnimator animatorTranslate = ObjectAnimator.ofFloat(button2, "translationX", 0f, 500f);
                animatorTranslate.setDuration(1000);
                animatorTranslate.start();

                //-----------------------------------------------------------------------
                //                               Rotate
                //-----------------------------------------------------------------------
                ObjectAnimator animatorRotation = ObjectAnimator.ofFloat(button2, "rotation", 0f, 360f);
                animatorRotation.setDuration(1000);
                animatorRotation.start();
            }
        });
    }
}
