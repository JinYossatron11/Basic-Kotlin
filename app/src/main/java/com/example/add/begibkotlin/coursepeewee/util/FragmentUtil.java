package com.example.add.begibkotlin.coursepeewee.util;

import android.support.v4.app.FragmentManager;
import com.example.add.begibkotlin.R;

public class FragmentUtil {
    public static void clearFragment(FragmentManager manager) {
        if (manager != null && !isEmptyStack(manager)) {
            manager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        }
    }

    public static void removeAllFragment(FragmentManager manager) {
        manager.beginTransaction().remove(manager.findFragmentById(R.id.container)).commit();
    }

    public static boolean isEmptyStack(FragmentManager manager) {
        return manager == null || manager.getBackStackEntryCount() == 0;
    }

    public static int stackCount(FragmentManager manager) {
        return manager.getBackStackEntryCount();
    }
}
