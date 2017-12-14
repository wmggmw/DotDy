package com.wmg.ddd.dotdy.exception;

import android.util.Log;

/**
 * Created by wu-mingguang on 2017/9/18.
 */

public class ArrayNullExeception extends Exception {
    public ArrayNullExeception() {
    }

    public ArrayNullExeception(String message) {
        super(message);
        Log.e("wmg", message);
    }
}
