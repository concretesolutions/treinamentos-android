package br.com.concrete.androidanimationspart1.fragment.property;


import android.animation.ValueAnimator;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.graphics.drawable.ArgbEvaluator;
import android.support.v4.app.Fragment;
import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

import br.com.concrete.androidanimationspart1.R;
import br.com.concrete.androidanimationspart1.fragment.AnimationFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ValueTextFragment extends Fragment implements AnimationFragment {

    View view;
    private TextView text;

    public static ValueTextFragment newInstance() {
        return new ValueTextFragment();
    }

    public ValueTextFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_base_text, container, false);
        view = layout.findViewById(R.id.view);
        text = (TextView) layout.findViewById(R.id.text);
        return layout;
    }

    @Override
    public void runAnimation() {
        Toast.makeText(getContext(), "run", Toast.LENGTH_SHORT).show();
    }

    private int getRandomNumber(){
        return new Random().nextInt(1000);
    }
}
