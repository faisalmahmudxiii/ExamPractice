package preparation.mobapp207.com.exam.Other;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import preparation.mobapp207.com.exam.R;

public class FragmentManeger {

    private static FragmentManeger INSTANCE = null;

    // other instance variables can be here

    private FragmentManeger() {};

    public static FragmentManeger getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FragmentManeger();
        }
        return(INSTANCE);
    }

    public void loadFragment(Fragment fragment,boolean isAddStack,String tag, FragmentActivity activity) {

        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        if (isAddStack) {
            fragmentTransaction.addToBackStack(tag);
        }
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit(); // save the changes
    }



}
