package com.example.inviter.invtandroid.core;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Ravikant on 06/12/16.
 */

public class InviterCore {

    public static void longToastBuilder(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show();
    }

    public static void shortToastBuilder(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
