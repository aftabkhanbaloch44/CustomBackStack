package com.drudotstech.backstack.fragments.host;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.drudotstech.backstack.databinding.FragmentTab1HostBinding;
import com.drudotstech.backstack.fragments.Fragment1;
import com.drudotstech.backstack.fragments.base.BackStackBaseFragment;
import com.drudotstech.backstack.home.HomeActivity;
import com.drudotstech.backstack.home.base.NavStackEntry;

public class FragmentTab1Host extends BackStackBaseFragment {

    FragmentTab1HostBinding binding;

    public FragmentTab1Host(HomeActivity homeActivity) {
        super(homeActivity);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        bindUi(inflater);
        Fragment1 fragment = new Fragment1(homeActivity);
        stackEntry = new NavStackEntry(tab1Container, getChildFragmentManager(), fragment);
        fragment.setStackEntry(stackEntry);
        pushFragment(fragment);


        return root;
    }

    private void bindUi(@NonNull LayoutInflater inflater) {
        binding = FragmentTab1HostBinding.inflate(inflater);
        root = binding.getRoot();
    }

}
