package com.drudotstech.backstack.home.base;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentManager;

import com.drudotstech.backstack.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class BackStackBaseActivity extends BaseActivity {

    protected Stack<NavStackEntry> tab1Stack, tab2Stack, tab3Stack, tab4Stack;
    protected int tab1Container, tab2Container, tab3Container, tab4Container;
    protected List<Stack<NavStackEntry>> stacks;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initStacks();
        initializeContainersIds();
    }

    private void initStacks() {
        tab1Stack = new Stack<>();
        tab2Stack = new Stack<>();
        tab3Stack = new Stack<>();
        tab4Stack = new Stack<>();
        stacks = new ArrayList<>();
    }

    protected void pushStackIntoList(int tab) {
        Stack<NavStackEntry> stack = getStack(tab);
        if (stacks.contains(stack)) {
            return;
        }
        stacks.add(stack);
    }


    private Stack<NavStackEntry> getStack(int tab) {
        return tab == 0 ? tab1Stack : tab == 1 ? tab2Stack : tab == 2 ? tab3Stack : tab4Stack;
    }

    private Stack<NavStackEntry> getStack(NavStackEntry entry) {
        if (entry.containerId == tab1Container)
            return tab1Stack;
        if (entry.containerId == tab2Container)
            return tab2Stack;
        if (entry.containerId == tab3Container)
            return tab3Stack;
        return tab4Stack;
    }

    private Stack<NavStackEntry> getStackUsingContainerId(int containerId) {
        if (containerId == tab1Container)
            return tab1Stack;
        if (containerId == tab2Container)
            return tab2Stack;
        if (containerId == tab3Container)
            return tab3Stack;
        return tab4Stack;
    }

    protected int getNextPopulatedStack() {
        if (stacks.size() > 0) {
            Stack<NavStackEntry> stack = stacks.get(stacks.size() - 1);
            if (stack == tab1Stack)
                return 0;
            if (stack == tab2Stack)
                return 1;
            if (stack == tab3Stack)
                return 2;
            if (stack == tab4Stack)
                return 3;
        }
        return 0;
    }

    private void initializeContainersIds() {
        if (context != null) {
            tab1Container = R.id.containerViewTab1;
            tab2Container = R.id.containerViewTab2;
            tab3Container = R.id.containerViewTab3;
            tab4Container = R.id.containerViewTab4;
        }
    }

    public void pushEntryIntoStack(NavStackEntry entry) {

        if (entry.containerId == tab1Container) {
            tab1Stack.push(entry);
            Log.d("---->", entry.fragmentName + " pushed into stack 1");
        } else if (entry.containerId == tab2Container) {
            tab2Stack.push(entry);
            Log.d("---->", entry.fragmentName + " pushed into stack 2");
        } else if (entry.containerId == tab3Container) {
            tab3Stack.push(entry);
            Log.d("---->", entry.fragmentName + " pushed into stack 3");
        } else if (entry.containerId == tab4Container) {
            tab4Stack.push(entry);
            Log.d("---->", entry.fragmentName + " pushed into stack 4");
        }

    }


    public void popEntriesFromStackUntil(int containerId, String fragmentName) {
        Stack<NavStackEntry> stack = getStackUsingContainerId(containerId);
        if (stack.size() > 1) {
            for (int i = stack.size() - 1; i > 0; i--) {
                NavStackEntry peek = stack.peek();
                if (!peek.startFragment && !TextUtils.equals(peek.fragmentName, fragmentName)) {
                    peek.fragmentManager.popBackStack(peek.fragmentName, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                    stack.pop();
                }
                if (stack.peek().onResumeListener != null)
                    stack.peek().onResumeListener.onResumed();

            }
        }
    }


    protected boolean popEntryFromStack(int tab) {
        Stack<NavStackEntry> stack = getStack(tab);

        if (stack.size() > 1) {
            NavStackEntry entry = stack.peek();
            if (!entry.startFragment) {
                entry.fragmentManager.popBackStack(entry.fragmentName, FragmentManager.POP_BACK_STACK_INCLUSIVE);
                stack.pop();
                if (stack.peek().onResumeListener != null)
                    stack.peek().onResumeListener.onResumed();
                return true;
            } else {
                stacks.remove(stack);
                return false;
            }
        } else {
            stacks.remove(stack);
            return false;
        }
    }
}

