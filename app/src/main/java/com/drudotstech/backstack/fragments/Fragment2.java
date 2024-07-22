package com.drudotstech.backstack.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.drudotstech.backstack.databinding.Fragment2Binding;
import com.drudotstech.backstack.fragments.base.BackStackBaseFragment;
import com.drudotstech.backstack.fragments.base.BaseFragment;
import com.drudotstech.backstack.home.HomeActivity;
import com.drudotstech.backstack.home.base.NavStackEntry;

public class Fragment2 extends BackStackBaseFragment {

    Fragment2Binding binding;

    public Fragment2(HomeActivity homeActivity, NavStackEntry stackEntry) {
        super(homeActivity,stackEntry);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        bindUi();
        setOnClickListeners();
        return root;
    }

    @Override
    public void setOnClickListeners() {
        super.setOnClickListeners();
        
        binding.btnNext.setOnClickListener(view -> pushFragment(new Fragment3(homeActivity, stackEntry)));
    }

    private void bindUi() {
        binding = Fragment2Binding.inflate(LayoutInflater.from(context));
        root = binding.getRoot();
        root.setFocusableInTouchMode(true);
        root.requestFocus();
    }
}