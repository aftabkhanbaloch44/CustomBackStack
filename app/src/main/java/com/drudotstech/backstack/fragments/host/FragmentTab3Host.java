package com.drudotstech.backstack.fragments.host;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.drudotstech.backstack.databinding.FragmentTab3HostBinding;
import com.drudotstech.backstack.fragments.Fragment1;
import com.drudotstech.backstack.fragments.base.BackStackBaseFragment;
import com.drudotstech.backstack.fragments.base.BaseFragment;
import com.drudotstech.backstack.home.HomeActivity;
import com.drudotstech.backstack.home.base.NavStackEntry;

public class FragmentTab3Host extends BackStackBaseFragment {

    FragmentTab3HostBinding binding;

    public FragmentTab3Host(HomeActivity homeActivity) {
        super(homeActivity);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bindUi(inflater);
        stackEntry = new NavStackEntry(tab3Container,getChildFragmentManager(),true);
        pushFragment(new Fragment1(homeActivity, stackEntry));
        return root;
    }

    private void bindUi(@NonNull LayoutInflater inflater) {
        binding = FragmentTab3HostBinding.inflate(inflater);
        root = binding.getRoot();
    }
}
