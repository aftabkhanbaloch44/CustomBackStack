package com.drudotstech.backstack.home;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.drudotstech.backstack.R;
import com.drudotstech.backstack.databinding.ActivityHomeBinding;
import com.drudotstech.backstack.fragments.host.FragmentTab1Host;
import com.drudotstech.backstack.fragments.host.FragmentTab2Host;
import com.drudotstech.backstack.fragments.host.FragmentTab3Host;
import com.drudotstech.backstack.fragments.host.FragmentTab4Host;
import com.drudotstech.backstack.home.adapter.ViewPagerAdapter;
import com.drudotstech.backstack.home.base.BackStackBaseActivity;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends BackStackBaseActivity {

    ActivityHomeBinding binding;
    ViewPager2 viewPager;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        bindUi();
        setViewPager();
        setNavigationBarTabsListener();
    }


    private void setNavigationBarTabsListener() {
        binding.navBar.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.tab1) {
                setCurrentPage(0);
                return true;
            } else if (itemId == R.id.tab2) {
                setCurrentPage(1);
                return true;
            } else if (itemId == R.id.tab3) {
                setCurrentPage(2);
                return true;
            } else if (itemId == R.id.tab4) {
                setCurrentPage(3);
                return true;
            }
            return false;
        });
    }

    private void setCurrentPage(int item) {
        viewPager.setCurrentItem(item, false);
        pushStackIntoList(item);
    }

    private void setViewPager() {
        viewPager = binding.viewPager;

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new FragmentTab1Host(this));
        fragments.add(new FragmentTab2Host(this));
        fragments.add(new FragmentTab3Host(this));
        fragments.add(new FragmentTab4Host(this));

        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(this, fragments);
        viewPager.setAdapter(pagerAdapter);
        viewPager.setUserInputEnabled(false);
        viewPager.setOffscreenPageLimit(4);
    }

    private void bindUi() {
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        root = binding.getRoot();
        setContentView(root);
    }

    @Override
    public void onBackPressed() {
        if (stacks.size() > 1) {
            if (!popEntryFromStack(viewPager.getCurrentItem())) {
                int tab = getNextPopulatedStack();
                {
                    viewPager.setCurrentItem(tab, false);
                    binding.navBar.getMenu().getItem(tab).setChecked(true);
                }
            }
        } else if (viewPager.getCurrentItem() != 0) {
            viewPager.setCurrentItem(0, false);
            binding.navBar.getMenu().getItem(0).setChecked(true);
        } else if (!popEntryFromStack(0)) {
            super.onBackPressed();
        }

    }
}
