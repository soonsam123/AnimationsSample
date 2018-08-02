package com.soon.karat.animations.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.soon.karat.animations.MainActivity;
import com.soon.karat.animations.R;

public class ChooserFragment extends Fragment {

    private ListView listView;
    private MainActivity myContext;

    @Override
    public void onAttach(Context context) {
        myContext = (MainActivity) context;
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_chooser, container, false);

        listView = view.findViewById(R.id.list_view);

        String[] options = new String[]{"Animate with a drawable"
                , "Animate with a Vector", "Animate using ValueAnimator"
                , "Animate with ObjectAnimator", "Animate a group with AnimatorSet"
                , "Animate with StateList", "Animate using KeyFrames"
                , "Animating a Heart (like button)", "Crossfade animation"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(myContext, android.R.layout.simple_list_item_1, android.R.id.text1, options);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        makeTransactionToAnotherFragment(new AnimateDrawableFragment());
                        break;
                    case 1:
                        makeTransactionToAnotherFragment(new AnimateVectorFragment());
                        break;
                    case 2:
                        makeTransactionToAnotherFragment(new ValueAnimatorFragment());
                        break;
                    case 3:
                        makeTransactionToAnotherFragment(new ObjectAnimatorFragment());
                        break;
                    case 4:
                        makeTransactionToAnotherFragment(new AnimatorSetFragment());
                        break;
                    case 5:
                        makeTransactionToAnotherFragment(new StateListFragment());
                        break;
                    case 6:
                        makeTransactionToAnotherFragment(new KeyFramesFragment());
                        break;
                    case 7:
                        makeTransactionToAnotherFragment(new LikeAnimationFragment());
                        break;
                    case 8:
                        makeTransactionToAnotherFragment(new CrossfadeFragment());
                        break;
                }
            }
        });
        return view;
    }

    private void makeTransactionToAnotherFragment(Fragment fragment) {
        FragmentTransaction transaction = myContext.getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.fragment_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
