package com.example.pankaj.gtmdemo;

/**
 * Created by pankaj on 8/4/15.
 */
public class Constants {

    private static Constants constants =null;

    public static Constants getSingleton(){
        if(constants==null){
            constants = new Constants();
        }
        return  constants;
    }

    public final String GTM_CONTAINER_ID="GTM-W6SNLB";
}
