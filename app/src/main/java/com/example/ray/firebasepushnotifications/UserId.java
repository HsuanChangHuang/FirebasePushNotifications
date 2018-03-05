package com.example.ray.firebasepushnotifications;

import android.support.annotation.NonNull;

/**
 * Created by Ray on 2018/2/28.
 */

public class UserId {

    public String user_Id;

    public <T extends UserId> T withId(@NonNull final String id){
        this.user_Id = id;
        return (T) this;
    }
}
