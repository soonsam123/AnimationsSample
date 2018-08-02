package com.soon.karat.animations.fragments;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.soon.karat.animations.MainActivity;
import com.soon.karat.animations.R;

import java.util.ArrayList;

public class AnimatorSetFragment extends Fragment {

    private RelativeLayout mContainer;
    private FloatingActionButton button;
    private MainActivity myContext;

    @Override
    public void onAttach(Context context) {
        myContext = (MainActivity) context;
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_animator_set, container, false);

        mContainer = view.findViewById(R.id.relative_layout_container);

        button = view.findViewById(R.id.floating_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ArrayList<ImageView> imagesList = new ArrayList<>();

                // Creates 5 ImageViews
                for (int i = 0; i < 5; i++) {
                    ImageView imageView = createImageView();
                    mContainer.addView(imageView);
                    imagesList.add(imageView);
                }


                ObjectAnimator animator1X = ObjectAnimator.ofFloat(imagesList.get(0), "translationX", 0f, -500f);
                animator1X.setDuration(200);
                ObjectAnimator animator1Y = ObjectAnimator.ofFloat(imagesList.get(0), "translationY", 0f, -500f);
                animator1Y.setDuration(200);

                ObjectAnimator animator2 = ObjectAnimator.ofFloat(imagesList.get(1), "translationX", 0f, -500f);
                animator1X.setDuration(200);

                ObjectAnimator animator3 = ObjectAnimator.ofFloat(imagesList.get(2), "translationY", 0f, -500f);
                animator3.setDuration(200);

                ObjectAnimator animator4X = ObjectAnimator.ofFloat(imagesList.get(3), "translationX", 0f, -500f);
                animator4X.setDuration(200);
                ObjectAnimator animator4Y = ObjectAnimator.ofFloat(imagesList.get(3), "translationY", 0f, -500f);
                animator4Y.setDuration(200);

                ObjectAnimator animator5X = ObjectAnimator.ofFloat(imagesList.get(4), "translationX", 0f, -500f);
                animator5X.setDuration(100);
                ObjectAnimator animator5Y = ObjectAnimator.ofFloat(imagesList.get(4), "translationY", 0f, -500f);
                animator5Y.setDuration(100);


                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(animator1X).with(animator1Y);
                animatorSet.play(animator2).after(animator1Y);
                animatorSet.play(animator3).after(animator2);
                animatorSet.play(animator4X).after(animator3);
                animatorSet.play(animator4X).with(animator4Y);
                animatorSet.play(animator5X).after(animator4Y);
                animatorSet.play(animator5X).with(animator5Y);
                animatorSet.start();
            }
        });

        return view;
    }

    @NonNull
    private ImageView createImageView() {
        ImageView imageView = new ImageView(myContext);
        RelativeLayout.LayoutParams layoutParams =
                new RelativeLayout.LayoutParams(
                        RelativeLayout.LayoutParams.WRAP_CONTENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(60, 60, 60, 60);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
        layoutParams.addRule(RelativeLayout.ALIGN_PARENT_END);
        imageView.setLayoutParams(layoutParams);
        imageView.setBackground(getResources().getDrawable(R.drawable.bg_circle));
        return imageView;
    }
}
