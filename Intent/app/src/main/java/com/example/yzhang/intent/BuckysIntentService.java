package com.example.yzhang.intent;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by yzhang on 8/29/2016.
 */
public class BuckysIntentService extends IntentService{

    private static final String Tag = "com.example.yzhang.intent";

    public BuckysIntentService()
    {
        super("BuckysIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        Log.i(Tag,"The service has now started.");
    }
}
