package com.drudotstech.backstack.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.drudotstech.backstack.databinding.Fragment1Binding;
import com.drudotstech.backstack.fragments.base.BackStackBaseFragment;
import com.drudotstech.backstack.home.HomeActivity;
import com.drudotstech.backstack.home.base.NavStackEntry;

public class Fragment1 extends BackStackBaseFragment {

    Fragment1Binding binding;

    public Fragment1(HomeActivity homeActivity, NavStackEntry stackEntry) {
       super(homeActivity,stackEntry);
    }

    public Fragment1(HomeActivity homeActivity) {
        super(homeActivity);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        bindUi();
        setOnClickListeners();
        return root;
    }

    @Override
    protected void setOnClickListeners() {
        super.setOnClickListeners();
        binding.btnNext.setOnClickListener(view -> pushFragment(new Fragment2(homeActivity, stackEntry)));

    }

    private void bindUi() {
        binding = Fragment1Binding.inflate(LayoutInflater.from(context));
        root = binding.getRoot();
        root.setFocusableInTouchMode(true);
        root.requestFocus();
    }

    @Override
    public void onResumed() {
        Toast.makeText(context, "OnResume Fragment1", Toast.LENGTH_SHORT).show();
    }
}