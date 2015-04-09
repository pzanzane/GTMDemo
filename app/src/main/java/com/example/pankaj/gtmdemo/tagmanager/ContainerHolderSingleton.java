package com.example.pankaj.gtmdemo.tagmanager;

import com.google.android.gms.tagmanager.ContainerHolder;

/**
 * Created by pankaj on 25/2/15.
 */
public class ContainerHolderSingleton {

    private static ContainerHolder containerHolder;

    /**
     * Utility class; don't instantiate.
     */
    private ContainerHolderSingleton() {
    }

    public static ContainerHolder getContainerHolder() {
        return containerHolder;
    }

    public static void setContainerHolder(ContainerHolder c) {
        containerHolder = c;
    }


}
