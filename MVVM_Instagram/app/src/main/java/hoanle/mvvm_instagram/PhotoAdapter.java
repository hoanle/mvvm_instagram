package hoanle.mvvm_instagram;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import hoanle.mvvm_instagram.object.InstagramPhoto;
import hoanle.mvvm_instagram.databinding.ItemPhotoBinding;
import hoanle.mvvm_instagram.viewmodel.InstagramPhotoViewModel;

/**
 * Created by hoanle on 4/1/16.
 */
public class PhotoAdapter extends RecyclerView.Adapter<PhotoAdapter.PhotoViewHolder>{

    private List<InstagramPhoto> list;

    public PhotoAdapter(){
        this.list = new ArrayList<>();
    }

    public void setList(List<InstagramPhoto> list){
        this.list = list;
        notifyDataSetChanged();
    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemPhotoBinding itemPhotoBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_photo, parent, false);
        return new PhotoViewHolder(itemPhotoBinding);
    }

    @Override
    public void onBindViewHolder(PhotoViewHolder holder, int position) {
        holder.bindPhoto(list.get(position));
    }

    @Override
    public int getItemCount() {
        return (this.list != null ? this.list.size() : 0);
    }

    public static class PhotoViewHolder extends RecyclerView.ViewHolder{
        private ItemPhotoBinding itemPhotoBinding;

        public PhotoViewHolder(ItemPhotoBinding itemPhotoBinding){
            super(itemPhotoBinding.itemPhoto);
            this.itemPhotoBinding = itemPhotoBinding;
        }

        public void bindPhoto(InstagramPhoto photo){
            if (this.itemPhotoBinding.getInstagramPhotoModel() == null)
                itemPhotoBinding.setInstagramPhotoModel(new InstagramPhotoViewModel(photo));
            else
                itemPhotoBinding.getInstagramPhotoModel().setPhoto(photo);

        }
    }
}
