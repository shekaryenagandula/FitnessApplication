package com.example.gymapplication.ui.main;

import android.content.Context;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.gymapplication.Fragment1;
import com.example.gymapplication.Fragment2;
import com.example.gymapplication.Fragment3;
import com.example.gymapplication.R;


/**
 * A [FragmentPagerAdapter] that returns a fragment corresponding to
 * one of the sections/tabs/pages.
 */
public class SectionsPagerAdapter extends FragmentPagerAdapter {

    @StringRes
    private static final int[] TAB_TITLES = new int[]{R.string.tab_text_1, R.string.tab_text_2,R.string.tab_text_3};
    private final Context mContext;

    public SectionsPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        switch (position){
            case 0:
                fragment=new Fragment1();
                break;
            case 1:
                fragment=new Fragment2();
                break;
            case 2:
                fragment=new Fragment3();
                break;
        }
        return fragment;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mContext.getResources().getString(TAB_TITLES[position]);
    }

    @Override
    public int getCount() {
        // Show 2 total pages.
        return 3;
    }

/*    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.about:
                Toast.makeText(this,"About is Clicked",Toast.LENGTH_LONG).show();
                //            startActivity(new Intent(this,About.class));
                break;
            case R.id.feedback:
                Toast.makeText(this,"Enter Valuable Feedback",Toast.LENGTH_SHORT).show();
                //              startActivity(new Intent(this,Feedback.class));
                break;
            case R.id.logout:
                Toast.makeText(this,"Logged Out",Toast.LENGTH_LONG).show();
//                startActivity(new Intent(this,SignIn.class));
                break;
            case R.id.exit:
                finish();
                System.exit(0);
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

*/
}
