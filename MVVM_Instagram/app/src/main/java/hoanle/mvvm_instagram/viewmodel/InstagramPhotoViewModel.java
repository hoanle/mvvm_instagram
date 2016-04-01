package hoanle.mvvm_instagram.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import hoanle.mvvm_instagram.InstagramPhoto;

/**
 * Created by hoanle on 4/1/16.
 */
public class InstagramPhotoViewModel extends BaseObservable{
    private InstagramPhoto photo;

    public InstagramPhotoViewModel(InstagramPhoto photo){
        this.photo = photo;
    }

    public void setPhoto(InstagramPhoto  photo){
        this.photo = photo;
        notifyChange();
    }

    public InstagramPhoto getPhoto() {
        return photo;
    }

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl){
        Glide.with(view.getContext()).load(imageUrl).into(view);
    }
}
