package com.simple.common.utils;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by simple on 2017/10/20.
 */

public class EventBusUtils {

    public synchronized static void register(Object subscriber) {
        if (!EventBus.getDefault().isRegistered(subscriber)) {
            EventBus.getDefault().register(subscriber);
        }
    }

    public synchronized static void unregister(Object subscriber) {
        if (EventBus.getDefault().isRegistered(subscriber)) {
            EventBus.getDefault().unregister(subscriber);
        }
    }

    public static void post(Object event) {
        if (event == null) {
            return;
        }
        EventBus.getDefault().post(event);
    }
}
