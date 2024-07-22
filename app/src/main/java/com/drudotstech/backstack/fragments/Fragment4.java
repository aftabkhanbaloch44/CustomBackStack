package com.drudotstech.backstack.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.drudotstech.backstack.databinding.Fragment4Binding;
import com.drudotstech.backstack.fragments.base.BackStackBaseFragment;
import com.drudotstech.backstack.home.HomeActivity;
import com.drudotstech.backstack.home.base.NavStackEntry;

public class Fragment4 extends BackStackBaseFragment {

    Fragment4Binding binding;

    public Fragment4(HomeActivity homeActivity, NavStackEntry stackEntry) {
        super(homeActivity, stackEntry);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        bindUi();
        setOnClickListeners();
        return root;
    }

    private void bindUi() {
        binding = Fragment4Binding.inflate(LayoutInflater.from(context));
        root = binding.getRoot();
        root.setFocusableInTouchMode(true);
        root.requestFocus();
    }
}