package br.com.concrete.androidanimationspart1.fragment.drawable;


import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import br.com.concrete.androidanimationspart1.R;
import br.com.concrete.androidanimationspart1.fragment.AnimationFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class DrawableLoadingFragment extends Fragment implements AnimationFragment {

    View view;
    AnimationDrawable animation;

    public static DrawableLoadingFragment newInstance() {
        return new DrawableLoadingFragment();
    }

    public DrawableLoadingFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_base, container, false);
        view = layout.findViewById(R.id.view);
        return layout;
    }

    @Override
    public void runAnimation() {
        Toast.makeText(getContext(), "run", Toast.LENGTH_SHORT).show();
    }
}
