package com.pelme.ejemplotabs.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.pelme.ejemplotabs.fragments.IngresoFragment;
import com.pelme.ejemplotabs.fragments.ListaFragment;

public class PageAdapter extends FragmentStatePagerAdapter {

    private int nroTabs;

    public PageAdapter(FragmentManager fm, int nroTabs) {
        super(fm);
        this.nroTabs = nroTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position){
            case 0:
                return new IngresoFragment();
            case 1:
                return new ListaFragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return nroTabs;
    }

}
