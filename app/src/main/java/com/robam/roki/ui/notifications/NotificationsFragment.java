package com.robam.roki.ui.notifications;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.AppBarLayout;
import com.jaeger.library.StatusBarUtil;
import com.robam.roki.R;
import com.robam.roki.ui.adapter.InventoryAdapter;

import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends Fragment {
    private ImageView imageView;
    private NotificationsViewModel notificationsViewModel;
    private static final int UI_ANIMATION_DELAY = 300;
    private int distance = 0;
    private final Handler mHideHandler = new Handler();
    private final Runnable mHidePart2Runnable = new Runnable() {
        @SuppressLint("InlinedApi")
        @Override
        public void run() {
            // Delayed removal of status and navigation bar

            // Note that some of these constants are new as of API 16 (Jelly Bean)
            // and API 19 (KitKat). It is safe to use them, as they are inlined
            // at compile-time and do nothing on earlier devices.
            int flags = View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;

            Activity activity = getActivity();
            if (activity != null
                    && activity.getWindow() != null) {
                activity.getWindow().getDecorView().setSystemUiVisibility(flags);
            }

        }
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                ViewModelProviders.of(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);
        imageView = root.findViewById(R.id.imageView);
        AppBarLayout appBarLayout = root.findViewById(R.id.appbar);
        final Toolbar toolbar = root.findViewById(R.id.toolbar);
        final List data = new ArrayList();
        for (int i = 'A'; i < 'Z'; i++) {
            data.add(i+"KKKKK");
        }
        final InventoryAdapter adapter = new InventoryAdapter(getContext(), data);
        RecyclerView recyclerView = root.findViewById(R.id.recyclerview);
        recyclerView.setAdapter(adapter);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                distance += dy;
                Log.e("onScrolled", "distance="+distance);
            }
        });

        appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int i) {
                Log.e("onOffsetChanged", "i=" + i);
                if (i == 0)
                    return;
                Log.e("getTotalScrollRange", "range=" + appBarLayout.getTotalScrollRange());
                float percent = (float) Math.abs(i) / appBarLayout.getTotalScrollRange();
                Log.e("onOffsetChanged", "percent=" + percent);

//                StatusBarUtil.setColor(getActivity(), Color.WHITE, (int) (255*(1-percent)));
                toolbar.setBackgroundColor(Color.argb((int) (255*percent), 0xFF, 0xFF, 0xFF));
            }
        });
        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        StatusBarUtil.setTranslucentForImageView(getActivity(), 0, imageView);
//        StatusBarUtil.setColorNoTranslucent(getActivity(), Color.BLACK);
    }

    @Override
    public void onPause() {
        super.onPause();
        if (getActivity() != null && getActivity().getWindow() != null) {
            getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

            // Clear the systemUiVisibility flag
            getActivity().getWindow().getDecorView().setSystemUiVisibility(0);
        }

    }
}