package com.example.chapter3.homework;


import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.List;

public class PlaceholderFragment extends Fragment {

    LottieAnimationView animationView;
    ViewPager pager;

    private String[] data = {"Sunny","Cloudy","Few Clouds","Partly Cloudy","Overcast","Windy","Calm","Light Breeze",
            "Moderate","Fresh Breeze","Strong Breeze","High Wind","Gale","Strong Gale","Storm","Violent Storm","Hurricane",
            "Tornado","Tropical Storm","Shower Rain","Heavy Shower Rain","Thundershower","Heavy Thunderstorm","Thundershower with hail",
            "Light Rain","Moderate Rain","Heavy Rain","Extreme Rain","Drizzle Rain","Storm","Heavy Storm","Severe Storm","Freezing Rain",
            "Light to moderate rain","Moderate to heavy rain","Heavy rain to storm","Storm to heavy storm","Heavy to severe storm",
            "Rain","Light Snow","Moderate Snow","Heavy Snow","Snowstorm","Sleet","Rain And Snow","Shower Snow","Snow Flurry",
            "Light to moderate snow","Moderate to heavy snow","Heavy snow to snowstorm","Snow","Mist","Foggy","Haze","Sand","Dust",
            "Duststorm","Sandstorm","Dense fog","Strong fog","Moderate haze","Heavy haze","Severe haze","Heavy fog","Extra heavy fog",
            "Hot","Cold","Unknown"};
    ListView listView;



    private List<String> getData(){
        List<String> data = new ArrayList<String>();
        for(int i = 0; i < 20; i++) {
            data.add("item" + i+ "");
        }
        return data;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        View view =  inflater.inflate(R.layout.fragment_placeholder, container, false);
        listView = (ListView)view.findViewById(R.id.list_item);
        animationView = (LottieAnimationView)view.findViewById(R.id.animation_view);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1,getData());
        listView.setAdapter(arrayAdapter);
        listView.setAlpha(0.0f);
        return view;
    }

    public  void onAttach(Context context) {
        super.onAttach(context);
     //   animationView = Ch3Ex3Activity.getAnimationView();
        pager = Ch3Ex3Activity.getPager();
        listView = Ch3Ex3Activity.getListView();
    }

    private void resetTargetAnimation() {
 //       pager.setAlpha(0.0f);
        //animationView = new LottieAnimationView(0.0f, 1.0f);
        animationView.animate().
                alpha(0f)
                .setDuration(500)
                .setListener(null);
        listView.animate().alpha(1f)
                        .setDuration(500)
                        .setListener(null);
//        listView.setAlpha(1.0f);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                resetTargetAnimation();
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
            }
        }, 5000);
    }
}
