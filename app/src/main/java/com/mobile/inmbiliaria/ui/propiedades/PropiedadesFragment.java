package com.mobile.inmbiliaria.ui.propiedades;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
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
import com.mobile.inmbiliaria.ui.model.Propiedad;

import java.util.ArrayList;
import java.util.List;

public class PropiedadesFragment extends Fragment {

    private PropiedadesViewModel propiedadesViewModel;

    private AppBarLayout appBarLayout;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ArrayList<Propiedad> lista = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        propiedadesViewModel =
                ViewModelProviders.of(this).get(PropiedadesViewModel.class);
        View root = inflater.inflate(R.layout.fragment_propiedades, container, false);

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
                lista.add(new Propiedad(1,R.drawable.casa1, "Justo Daract 300", 2, "casa", "residencial", 6500, true));
                lista.add(new Propiedad(2,R.drawable.casa2, "Serranias Puntanas 4010", 3, "casa","residencial", 3000, false));
                lista.add(new Propiedad(3, R.drawable.casa3, "Bolivar 930", 1, "casa", "comercial",4000, false));


                for (int i = 0; i <lista.size() ; i++) {
                 vpa.addFragment(PropiedadFragment.newInstance(lista.get(i)), "Propiedad: "+ i);

                }

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