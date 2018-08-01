package com.soon.karat.animations;

import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class AnimateValueAnimatorFragment extends Fragment {

    private static final String TAG = "AnimateValueAnimatorFra";

    private Button button1;
    private Button button2;

    private TextView debugTranslation;
    private TextView debugRotation;

    private MainActivity myContext;

    @Override
    public void onAttach(Context context) {
        myContext = (MainActivity) context;
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_animate_value_animator, container, false);

        debugTranslation = view.findViewById(R.id.text_debug_translation);
        debugRotation = view.findViewById(R.id.text_debug_rotation);

        button1 = view.findViewById(R.id.button1);
        createAnimationToTranslateByX();

        button2 = view.findViewById(R.id.button2);
        createAnimationToTranslateByXAndRotate();


        return view;
    }

    /**
     * This method animates the {@link #button1} so when you click in the button
     * it will move from left to right horizontally.
     *
     * </p>
     * In order to do that you need to create a {@link ValueAnimator} that will
     * have the duration of the animation and a value.
     * In our case the {@link ValueAnimator} has 1000ms of duration and it will
     * go from 0f to 500f.
     * I used float, but it can be also other values, just check the options:
     * {@link ValueAnimator#ofFloat(float...)}.
     * {@link ValueAnimator#ofInt(int...)}
     * {@link ValueAnimator#ofObject(TypeEvaluator, Object...)}
     * {@link ValueAnimator#ofArgb(int...)}
     * {@link ValueAnimator#ofPropertyValuesHolder(PropertyValuesHolder...)}
     *
     * </p>
     * Now I can take these value (0f to 500f) and use whatever I want: I can
     *
     * <ol>
     *     <li>Move it horizontally by using {@link View#setTranslationX(float)}</li>
     *     <li>Move it vertically by using {@link View#setTranslationY(float)}</li>
     *     <li>Rotate it by using {@link View#setRotation(float)}}</li>
     *     <li>And several other options, as you need to.</li>
     * </ol>
     * </p>
     * <strong>NOTE:</strong> {@link #debugTranslation} prints the animated values
     * on the screen so you can check what is happening.
     */
    private void createAnimationToTranslateByX() {
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValueAnimator animator = ValueAnimator.ofFloat(0f, 500f);
                animator.setDuration(1000);
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float animatedValue = (float) animation.getAnimatedValue();
                        button1.setTranslationX(animatedValue);

                        //___________ Print the values on the screen ___________
                        String translationValues = "Translating by X: " + animatedValue;
                        debugTranslation.setText(translationValues);

                    }
                });
                animator.start();
            }
        });
    }

    /**
     * This method animates the {@link #button2} so when you click in the button
     * it will move from left to right horizontally and rotate by its axis
     * 360 degrees.
     *
     * </p>
     * In order to do that you need to create a {@link ValueAnimator} that will
     * have the duration of the animation and a value.
     * In our case our first {@link ValueAnimator} has 1000ms of duration and it will
     * go from 0f to 500f for the translation in X.
     * Our second {@link ValueAnimator} has 1000ms of duration and it will go from
     * 0f to 360f (rotating the button by 360 degree) for the rotation.
     *
     * </p>
     * <strong>NOTE:</strong> {@link #debugTranslation} and {@link #debugRotation}
     * print the animated values on the screen so you can check what is happening.
     */

    private void createAnimationToTranslateByXAndRotate() {
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //-----------------------------------------------------------------------
                //                           Translate in X
                //-----------------------------------------------------------------------
                ValueAnimator animatorTranslateX = ValueAnimator.ofFloat(0f, 500f);
                animatorTranslateX.setDuration(1000);
                animatorTranslateX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        float animatedValue = (float) animation.getAnimatedValue();
                        button2.setTranslationX(animatedValue);


                        //___________ Print the values on the screen ___________
                        String translationValues = "Translating by X: " + animatedValue;
                        debugTranslation.setText(translationValues);

                    }
                });
                animatorTranslateX.start();


                //-----------------------------------------------------------------------
                //                               Rotate
                //-----------------------------------------------------------------------
                ValueAnimator animatorRotate = ValueAnimator.ofFloat(0f, 360f);
                animatorRotate.setDuration(1000);
                animatorRotate.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        button2.setRotation((float) animation.getAnimatedValue());


                        //___________ Print the values on the screen ___________
                        String rotationValues = "Rotation: " + ((float) animation.getAnimatedValue());
                        debugRotation.setText(rotationValues);

                    }
                });
                animatorRotate.start();

            }
        });
    }

}
