package hoanle.mvvm_instagram.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import hoanle.mvvm_instagram.PhotoAdapter;
import hoanle.mvvm_instagram.R;
import hoanle.mvvm_instagram.object.InstagramPhoto;
import hoanle.mvvm_instagram.databinding.ActivityMainBinding;
import hoanle.mvvm_instagram.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity implements MainViewModel.CallBack.MainView{

    private ActivityMainBinding activityMainBinding;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDataBinding();

        setSupportActionBar(activityMainBinding.toolbar);
        setUpRecyclerView();
        mainViewModel.loadData();
    }

    private void initDataBinding(){
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainViewModel = new MainViewModel(this, this);
        activityMainBinding.setMainViewModel(mainViewModel);
    }

    private void setUpRecyclerView(){
        RecyclerView recyclerView = activityMainBinding.rvList;
        recyclerView.setAdapter(new PhotoAdapter());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    @Override
    public void postLoadData(List<InstagramPhoto> list) {
        ((PhotoAdapter)activityMainBinding.rvList.getAdapter()).setList(list);
    }

    @Override
    public void makeToast(String message) {
        Snackbar.make(activityMainBinding.coordinatorLayout, message, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        mainViewModel.reset();
        super.onDestroy();
    }
}
