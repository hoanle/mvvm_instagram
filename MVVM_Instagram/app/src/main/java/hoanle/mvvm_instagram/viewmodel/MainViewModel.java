package hoanle.mvvm_instagram.viewmodel;

import android.content.Context;
import android.databinding.ObservableInt;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import hoanle.mvvm_instagram.PhotoApplication;
import hoanle.mvvm_instagram.data.PhotoResponse;
import hoanle.mvvm_instagram.data.PhotoService;
import hoanle.mvvm_instagram.extra.Constant;
import hoanle.mvvm_instagram.object.InstagramPhoto;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * Created by hoanle on 4/1/16.
 */
public class MainViewModel {

    public ObservableInt progressObservableInt;

    private List<InstagramPhoto> listInstagramPhoto = new ArrayList<>();
    private CallBack.MainView mainView;
    private Context context;
    private Subscription subscription;

    public MainViewModel(CallBack.MainView mainView, @NonNull Context context){
        this.mainView = mainView;
        this.context = context;
        progressObservableInt = new ObservableInt(View.GONE);
    }

    public void loadData(){
        progressObservableInt.set(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                getListInstagramPhoto();
                progressObservableInt.set(View.GONE);
            }
        }, 2000);
    }

    public String getToolbarTitle(){
        return "Main Activity";
    }

    public void onFab(View v){
        mainView.makeToast("Coming soon");
    }

    private void getListInstagramPhoto(){
        unSubscribeFromObservable();

        PhotoApplication photoApplication = PhotoApplication.create(context);
        PhotoService photoService = photoApplication.getPhotoService();
        subscription = photoService.getPhotos()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(photoApplication.subscribeScheduler())
                .subscribe(new Action1<PhotoResponse>() {
                    @Override
                    public void call(PhotoResponse photoResponse) {
                        if (photoResponse != null && photoResponse.getList() != null) {
                            Log.d("2359", "res " + photoResponse.toString());
                            mainView.postLoadData(photoResponse.getList());
                        }
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throwable.printStackTrace();
                    }
                });
    }

    public interface CallBack{
        interface MainView{
            void postLoadData(List<InstagramPhoto> list);
            void makeToast(String message);
        }
    }

    public void reset(){
        unSubscribeFromObservable();
        subscription = null;
        context = null;
        mainView = null;
    }

    private void unSubscribeFromObservable(){
        if (subscription != null && !subscription.isUnsubscribed())
            subscription.unsubscribe();
    }
}
