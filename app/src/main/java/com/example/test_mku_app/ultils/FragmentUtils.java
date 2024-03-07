package com.example.test_mku_app.ultils;


import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.test_mku_app.R;


public class FragmentUtils {
    public static void replaceFragment(FragmentManager manager,
                                       Fragment fragment,
                                       boolean addToBackStack) {
        FragmentTransaction transaction = manager.beginTransaction();
        if (addToBackStack) {
            transaction.addToBackStack(null);
        }
        transaction.replace(R.id.fragmentContainerView, fragment);
        transaction.commit();
    }
}
