package com.drudotstech.backstack.home.base;

import androidx.fragment.app.FragmentManager;

import com.drudotstech.backstack.fragments.callbacks.OnResumeListener;

public class NavStackEntry {
    public int containerId;
    public String fragmentName;
    public FragmentManager fragmentManager;
    public boolean startFragment;
    public OnResumeListener onResumeListener;

    public NavStackEntry(int containerId, FragmentManager fragmentManager, boolean startFragment) {
        this.containerId = containerId;
        this.fragmentName = String.valueOf(System.nanoTime());
        this.fragmentManager = fragmentManager;
        this.startFragment = startFragment;
    }
    public NavStackEntry(int containerId, FragmentManager fragmentManager, boolean startFragment,String fragmentName) {
        this.containerId = containerId;
        this.fragmentName = fragmentName;
        this.fragmentManager = fragmentManager;
        this.startFragment = startFragment;
    }

    public NavStackEntry(int containerId, FragmentManager fragmentManager, boolean startFragment, OnResumeListener onResumeListener) {
        this.containerId = containerId;
        this.fragmentName = String.valueOf(System.nanoTime());
        this.fragmentManager = fragmentManager;
        this.startFragment = startFragment;
        this.onResumeListener = onResumeListener;
    }



    public NavStackEntry(int containerId, FragmentManager fragmentManager, String fragmentName, OnResumeListener onResumeListener) {
        this.containerId = containerId;
        this.fragmentName = fragmentName;
        this.fragmentManager = fragmentManager;
        this.onResumeListener = onResumeListener;
    }

    public NavStackEntry(int containerId, FragmentManager fragmentManager) {
        this.containerId = containerId;
        this.fragmentName = String.valueOf(System.nanoTime());
        this.fragmentManager = fragmentManager;
    }

    public NavStackEntry(int containerId, FragmentManager fragmentManager,String fragmentName) {
        this.containerId = containerId;
        this.fragmentName = fragmentName;
        this.fragmentManager = fragmentManager;
    }

    public NavStackEntry(int containerId, FragmentManager fragmentManager, OnResumeListener onResumeListener) {
        this.containerId = containerId;
        this.fragmentName = String.valueOf(System.nanoTime());
        this.fragmentManager = fragmentManager;
        this.onResumeListener = onResumeListener;
    }

    public NavStackEntry(NavStackEntry otherEntry) {
        this.containerId = otherEntry.containerId;
        this.fragmentName = String.valueOf(System.nanoTime());
        this.fragmentManager = otherEntry.fragmentManager;
    }

}
