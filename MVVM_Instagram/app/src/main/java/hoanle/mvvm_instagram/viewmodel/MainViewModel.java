package hoanle.mvvm_instagram.viewmodel;

import android.databinding.ObservableInt;
import android.os.Handler;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import hoanle.mvvm_instagram.InstagramPhoto;

/**
 * Created by hoanle on 4/1/16.
 */
public class MainViewModel {

    public ObservableInt progressObservableInt;

    private List<InstagramPhoto> listInstagramPhoto = new ArrayList<>();
    private CallBack.MainView mainView;

    public MainViewModel(CallBack.MainView mainView ){
        this.mainView = mainView;
        progressObservableInt = new ObservableInt(View.GONE);
    }

    public void loadData(){
        progressObservableInt.set(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mainView.postLoadData(getListInstagramPhoto());
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

    private List<InstagramPhoto> getListInstagramPhoto(){
        for (int i = 0; i < 10; i++){
            InstagramPhoto photo = new InstagramPhoto();
            photo.setProfileUrl("https://igcdn-photos-b-a.akamaihd.net/hphotos-ak-xta1/t51.2885-19/11261270_1593671427561833_1532969775_a.jpg");
            photo.setUsername("yarihoan");
            listInstagramPhoto.add(photo);
        }
        return listInstagramPhoto;
    }

    public interface CallBack{
        interface MainView{
            void postLoadData(List<InstagramPhoto> list);
            void makeToast(String message);
        }
    }
}
