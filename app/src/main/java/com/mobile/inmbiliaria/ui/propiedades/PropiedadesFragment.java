package com.mobile.inmbiliaria.ui.propiedades;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.mobile.inmbiliaria.PropiedadFragment;
import com.mobile.inmbiliaria.R;

import java.util.ArrayList;
import java.util.List;

public class PropiedadesFragment extends Fragment {

    private PropiedadesViewModel propiedadesViewModel;

    private AppBarLayout appBarLayout;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        propiedadesViewModel =
                ViewModelProviders.of(this).get(PropiedadesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_propiedades, container, false);
        //final TextView textView = root.findViewById(R.id.text_gallery);

        propiedadesViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                viewPager= root.findViewById(R.id.viewPage);
                appBarLayout= root.findViewById(R.id.appBar);
                tabLayout= new TabLayout(root.getContext());

                appBarLayout.addView(tabLayout);
                ViewPageAdapter vpa= new ViewPageAdapter(getChildFragmentManager());


                // setear dinamicamente llenar los fragments
                //crear lista de propiedades

                vpa.addFragment(new PropiedadFragment(), "Propiedad 1");
                vpa.addFragment(new PropiedadFragment(), "Propiedad 2");

                viewPager.setAdapter(vpa);
                tabLayout.setupWithViewPager(viewPager);
            }
        });
        return root;
    }



    public class ViewPageAdapter extends FragmentPagerAdapter {

        private List<Fragment> fragmentList= new ArrayList<>();
        private List<String> nombresPropiedades= new ArrayList<>();


        public ViewPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return  nombresPropiedades.get(position);
        }

        public void addFragment(Fragment fragment, String titulo){
            fragmentList.add(fragment);
            nombresPropiedades.add(titulo);
        }
    }
}