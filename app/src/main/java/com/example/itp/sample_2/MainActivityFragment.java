package com.example.itp.sample_2;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    View view;
    LinearLayout first_ll, second_ll;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, container, false);

        first_ll = (LinearLayout) view.findViewById(R.id.first_ll);
        second_ll = (LinearLayout) view.findViewById(R.id.second_ll);
        Button btn1 = (Button) view.findViewById(R.id.button1);
        Button btn2 = (Button) view.findViewById(R.id.button2);
        TextView cancel_tv = (TextView) view.findViewById(R.id.cancel_tv);

        //Load animation
        final Animation slide_down = AnimationUtils.loadAnimation(getActivity().getApplicationContext(),
                R.anim.slide_down);

        final Animation slide_up = AnimationUtils.loadAnimation(getActivity().getApplicationContext(),
                R.anim.slide_up);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Start animation
                first_ll.startAnimation(slide_down);
                first_ll.setVisibility(View.GONE);
                second_ll.startAnimation(slide_up);
                second_ll.setVisibility(View.VISIBLE);
            }
        });
        cancel_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                second_ll.startAnimation(slide_down);
                second_ll.setVisibility(View.GONE);

                first_ll.startAnimation(slide_up);
                first_ll.setVisibility(View.VISIBLE);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Activity activity = getActivity();
                MainActivity mainActivity = (MainActivity) activity;

                Fragment2 fragment2 = new Fragment2();
                mainActivity.changeFragment(fragment2, true);


            }
        });


        return view;
    }
}
