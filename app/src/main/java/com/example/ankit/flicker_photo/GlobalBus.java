package com.example.ankit.flicker_photo;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by ankit on 8/22/17.
 */

public class GlobalBus {
    private static EventBus sBus;
    public static EventBus getBus() {
        if (sBus == null)
            sBus = EventBus.getDefault();
        return sBus;
    }

}
