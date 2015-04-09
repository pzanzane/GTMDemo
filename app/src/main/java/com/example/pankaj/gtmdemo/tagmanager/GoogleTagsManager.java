package com.example.pankaj.gtmdemo.tagmanager;

import android.content.Context;
import android.util.Log;

import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.tagmanager.Container;
import com.google.android.gms.tagmanager.ContainerHolder;
import com.google.android.gms.tagmanager.DataLayer;
import com.google.android.gms.tagmanager.TagManager;

import java.util.Map;

/**
 * Created by pankaj on 26/2/15.
 */
public class GoogleTagsManager {

    private static GoogleTagsManager googleTagsManager = null;

    public static final GoogleTagsManager getSingleton(){
        if(googleTagsManager == null){
            googleTagsManager = new GoogleTagsManager();
        }
        return googleTagsManager;
    }

    private GoogleTagsManager(){}

    public void initGoogleTagManager(Context context, String containerIdConstant, int rawReourceContainerId){
        TagManager tagManager = TagManager.getInstance(context);
        tagManager.setVerboseLoggingEnabled(true);

        PendingResult<ContainerHolder> pending = tagManager.loadContainerPreferNonDefault(
                containerIdConstant,
                rawReourceContainerId
        );
        pending.setResultCallback(new GTMResultCallback());

    }

    private static class GTMResultCallback implements ResultCallback<ContainerHolder>{

        @Override
        public void onResult(ContainerHolder containerHolder) {

            ContainerHolderSingleton.setContainerHolder(containerHolder);
            Container container = containerHolder.getContainer();

            if (!containerHolder.getStatus().isSuccess()) {
                Log.e("WASTE", "failure loading container");
                return;
            }
            ContainerHolderSingleton.setContainerHolder(containerHolder);
            ContainerLoadedCallback.registerCallbacksForContainer(container);
            containerHolder.setContainerAvailableListener(new ContainerLoadedCallback());
            Log.d("TAGMANAGER", "onResult:" + ContainerHolderSingleton.getContainerHolder().getContainer().getContainerId());

        }
    }
    private static class ContainerLoadedCallback implements ContainerHolder.ContainerAvailableListener {
        public static void registerCallbacksForContainer(Container container) {

            // Register two custom function call macros to the container.
            container.registerFunctionCallMacroCallback("screen resolution", new CustomMacroCallback());
            container.registerFunctionCallMacroCallback("event", new CustomMacroCallback());

            // Register a custom function call tag to the container.
            container.registerFunctionCallTagCallback("Google Analytics", new CustomTagCallback());
        }

        @Override
        public void onContainerAvailable(ContainerHolder containerHolder, String containerVersion) {
            // We load each container when it becomes available.
            Container container = containerHolder.getContainer();
            registerCallbacksForContainer(container);
        }
    }

    private static class CustomMacroCallback implements Container.FunctionCallMacroCallback {
        private int numCalls;

        @Override
        public Object getValue(String name, Map<String, Object> parameters) {

            Log.d("TAGMANAGER", "CustomMacroCallback:" + name);
            return name;
        }
    }


    private static class CustomTagCallback implements Container.FunctionCallTagCallback {
        @Override
        public void execute(String tagName, Map<String, Object> parameters) {
            // The code for firing this custom tag.
            Log.i("WASTE", "CustomTagCallback :" + tagName + " is fired.");
        }
    }


    public static void push(Context context,String key, String value) {
        DataLayer dataLayer = TagManager.getInstance(context).getDataLayer();
        dataLayer.push(key,value);
        Log.d("TAGMANAGER", "push=>" + key + " : " + value);
    }

    public String get(Context context,String key){
        DataLayer dataLayer = TagManager.getInstance(context).getDataLayer();
        return String.valueOf(dataLayer.get(key));
    }
    public void pushEvent(Context context, String eventValue,String key,String value) {
        DataLayer dataLayer = TagManager.getInstance(context).getDataLayer();
        dataLayer.push(DataLayer.mapOf("event",eventValue,key,value));

        Log.d("TAGMANAGER", "pushOpenScreenEvent=>" + key + ":" + value);
    }


}
