package com.luo.zp.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.luo.zp.R;
import com.luo.zp.activities.SelectActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class IntroduceFragment extends Fragment {


    @Bind(R.id.loginButton)
    Button loginButton;
    @Bind(R.id.registerButton)
    Button registerButton;
    @Bind(R.id.enterButton)
    Button enterButton;
    @Bind(R.id.bottom)
    LinearLayout bottom;

    public IntroduceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_introduce, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.enterButton)
    public void enterButtonClick() {
        startActivity(new Intent(getActivity(), SelectActivity.class));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
