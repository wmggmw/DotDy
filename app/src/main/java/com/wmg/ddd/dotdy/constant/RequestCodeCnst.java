package com.wmg.ddd.dotdy.constant;

/**
 * Created by 明光 on 2017/12/5.
 */

public class RequestCodeCnst {

    public static int ACTIVITY(Class cls){
        if( cls == null)
            return 0;
        int hashCode = cls.hashCode();
        while ( hashCode > Math.pow(2, 16)){
            hashCode = hashCode >> 1;
        }
        return hashCode;
    }
}
