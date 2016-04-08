package hoanle.mvvm_instagram;

import android.app.Application;
import android.content.Context;

import hoanle.mvvm_instagram.data.PhotoFactory;
import hoanle.mvvm_instagram.data.PhotoService;
import rx.Scheduler;
import rx.schedulers.Schedulers;

/**
 * Created by hoanle on 4/8/16.
 */
public class PhotoApplication extends Application{

    private PhotoService photoService;
    private Scheduler scheduler;

    private static PhotoApplication get(Context context){
        return (PhotoApplication) context.getApplicationContext();
    }
    public static PhotoApplication create(Context context){
        return PhotoApplication.get(context);
    }

    public PhotoService getPhotoService(){
        if (photoService == null)
            photoService = PhotoFactory.create();
        return photoService;
    }

    public Scheduler subscribeScheduler(){
        if (scheduler == null)
            scheduler = Schedulers.io();
        return scheduler;
    }
}
