package polytechnice.tobeortohave.parrainage;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import polytechnice.tobeortohave.R;

/**
 * Created by Pierre on 09/05/2017.
 */

public class MainParrainageFragment extends Fragment {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    public static MainParrainageFragment newInstance(){
        MainParrainageFragment fragment = new MainParrainageFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.parrainage, container, false);
        rootView.setBackgroundColor(Color.parseColor("#F5F5DC"));
        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle bundle){
        super.onActivityCreated(bundle);
        mSectionsPagerAdapter = new SectionsPagerAdapter(getChildFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) getView().findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(final int i, final float v, final int i2) {
            }
            @Override
            public void onPageSelected(final int i) {
                FragmentInterface fragment = (FragmentInterface) mSectionsPagerAdapter.instantiateItem(mViewPager, i);
                if (fragment != null) {
                    if(fragment instanceof ParrainageHomeFragment){
                        fragment.fragmentBecameVisible();
                    }
                }
            }
            @Override
            public void onPageScrollStateChanged(final int i) {
            }
        });
        TabLayout tabLayout = (TabLayout)getView().findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
    }
}
