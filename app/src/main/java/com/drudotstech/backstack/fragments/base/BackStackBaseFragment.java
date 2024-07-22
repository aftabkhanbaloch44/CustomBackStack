package com.drudotstech.backstack.fragments.base;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.drudotstech.backstack.R;
import com.drudotstech.backstack.fragments.callbacks.OnResumeListener;
import com.drudotstech.backstack.home.HomeActivity;
import com.drudotstech.backstack.home.base.NavStackEntry;

public class BackStackBaseFragment extends BaseFragment implements OnResumeListener {

    public NavStackEntry stackEntry;
    protected int tab1Container, tab2Container, tab3Container, tab4Container, tab5Container;
    protected String tab1ContainerTag, tab2ContainerTag, tab3ContainerTag, tab4ContainerTag, tab5ContainerTag;


    public BackStackBaseFragment(HomeActivity homeActivity) {
        super(homeActivity);
    }

    public BackStackBaseFragment(HomeActivity homeActivity, NavStackEntry stackEntry) {
        super(homeActivity);
        this.stackEntry = new NavStackEntry(stackEntry);
    }


    public void setStackEntry(NavStackEntry stackEntry) {
        this.stackEntry = stackEntry;
    }


    public void pushFragment(Fragment fragment, NavStackEntry entry) {
        entry.fragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .setCustomAnimations(R.anim.right_to_left, R.anim.left_to_right, R.anim.activity_enter, R.anim.activity_exit)
                .add(entry.containerId, fragment, getContainerTag(entry.containerId))
                .addToBackStack(entry.fragmentName)
                .commit();
        if (homeActivity != null)
            homeActivity.pushEntryIntoStack(entry);
    }

    public void pushFragment(BackStackBaseFragment fragment) {
        fragment.stackEntry.fragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .setCustomAnimations(R.anim.right_to_left, R.anim.left_to_right, R.anim.activity_enter, R.anim.activity_exit)
                .add(fragment.stackEntry.containerId, fragment, getContainerTag(fragment.stackEntry.containerId))
                .addToBackStack(fragment.stackEntry.fragmentName)
                .commit();
        fragment.stackEntry.onResumeListener = fragment;
        if (homeActivity != null)
            homeActivity.pushEntryIntoStack(fragment.stackEntry);
    }

    private String getContainerTag(int containerId) {
        return containerId == tab1Container ? tab1ContainerTag :
                containerId == tab2Container ? tab2ContainerTag :
                        containerId == tab3Container ? tab3ContainerTag :
                                tab4ContainerTag;
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
        initializeStrings();
    }

    @Override
    public void onResume() {
        super.onResume();
        root.setFocusableInTouchMode(true);
        root.requestFocus();
    }

    private void initializeStrings() {
        if (context != null) {
            tab1Container = R.id.containerViewTab1;
            tab2Container = R.id.containerViewTab2;
            tab3Container = R.id.containerViewTab3;
            tab4Container = R.id.containerViewTab4;

            tab1ContainerTag = context.getString(R.string.tab1_container_tag);
            tab2ContainerTag = context.getString(R.string.tab2_container_tag);
            tab3ContainerTag = context.getString(R.string.tab3_container_tag);
            tab4ContainerTag = context.getString(R.string.tab4_container_tag);

        }
    }

    @Override
    public void onResumed() {

    }
}
