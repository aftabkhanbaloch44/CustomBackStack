package com.drudotstech.backstack.fragments.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.drudotstech.backstack.R;
import com.drudotstech.backstack.home.HomeActivity;

public class BaseFragment extends Fragment {

    protected Context context;
    protected Activity activity;

    protected HomeActivity homeActivity;

    protected View root;

    public BaseFragment(HomeActivity homeActivity) {
        this.homeActivity = homeActivity;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
        this.activity = getActivity();
    }

    protected void setOnClickListeners() {
        View btnBack = root.findViewById(R.id.btnBack);
        if (btnBack != null && homeActivity != null)
            btnBack.setOnClickListener(v -> homeActivity.onBackPressed());
    }

}
