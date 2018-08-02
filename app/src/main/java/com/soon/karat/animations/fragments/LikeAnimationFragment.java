package com.soon.karat.animations.fragments;

import android.animation.AnimatorSet;
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
import android.widget.ImageView;

import com.soon.karat.animations.R;

public class LikeAnimationFragment extends Fragment {

    private ImageView mLike;

    private boolean liked = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_like_animation, container, false);

        mLike = view.findViewById(R.id.image_like);
        mLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (liked) {
                    mLike.setImageResource(R.drawable.heart_outline);
                } else {
                    mLike.setImageResource(R.drawable.heart);
                }
                liked = !liked;

                //----------------------------------------------------------------------------
                //                             Using Keyframes
                //----------------------------------------------------------------------------
                Keyframe kf0 = Keyframe.ofFloat(0f, 1f);
                Keyframe kf1 = Keyframe.ofFloat(.33f, .5f);
                Keyframe kf2 = Keyframe.ofFloat(.66f, 1.2f);
                Keyframe kf3 = Keyframe.ofFloat(1f, 1f);

                PropertyValuesHolder pvhX = PropertyValuesHolder.ofKeyframe("scaleX", kf0, kf1, kf2, kf3);
                PropertyValuesHolder pvhY = PropertyValuesHolder.ofKeyframe("scaleY", kf0, kf1, kf2, kf3);
                ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(mLike, pvhX, pvhY);
                animator.setDuration(300);
                animator.start();

                //----------------------------------------------------------------------------
                //                           With Object Animators
                //----------------------------------------------------------------------------

                /*// Animate from half the size (.5f) to 1.2 of the size (1.2f).
                ObjectAnimator animator0X = ObjectAnimator.ofFloat(mLike, "scaleX", .5f, 1.2f);
                ObjectAnimator animator0Y = ObjectAnimator.ofFloat(mLike, "scaleY", .5f, 1.2f);

                // Animate from 1.2 size (1.2f) to normal (1f).
                ObjectAnimator animator1X = ObjectAnimator.ofFloat(mLike, "scaleX", 1.2f, 1f);
                ObjectAnimator animator1Y = ObjectAnimator.ofFloat(mLike, "scaleY", 1.2f, 1f);

                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(animator0X).with(animator0Y);
                animatorSet.play(animator1X).after(animator0Y);
                animatorSet.play(animator1X).with(animator1Y);
                animatorSet.setDuration(100);
                animatorSet.start();*/

                //----------------------------------------------------------------------------
                //                              ViewPropertyAnimator
                //----------------------------------------------------------------------------
                // Not working yet
                /*mLike.animate().scaleX(0.5f).scaleY(0.5f).setDuration(100).start();
                mLike.animate().scaleX(1.2f).scaleY(1.2f).setDuration(100).setStartDelay(100).start();
                mLike.animate().scaleX(1f).scaleY(1f).setDuration(100).setStartDelay(200).start();*/

            }
        });

        return view;
    }
}
