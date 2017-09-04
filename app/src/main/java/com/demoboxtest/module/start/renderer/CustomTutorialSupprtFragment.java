package com.demoboxtest.module.start.renderer;

import android.app.Fragment;
import android.content.Intent;
import android.print.PageRange;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.View;

import com.cleveroad.slidingtutorial.OnTutorialPageChangeListener;
import com.cleveroad.slidingtutorial.PageOptions;
import com.cleveroad.slidingtutorial.TutorialOptions;
import com.cleveroad.slidingtutorial.TutorialPageOptionsProvider;
import com.cleveroad.slidingtutorial.TutorialSupportFragment;
import com.demoboxtest.SplashActivity;
import com.demoboxtest.config.Const;
import com.demoboxtest.utils.SPUtils;

/**
 * Created by Administrator on 2017/9/3.
 */

public class CustomTutorialSupprtFragment extends TutorialSupportFragment implements OnTutorialPageChangeListener{

    private static final int TOTAL_PAGES = 3;
    private static final int ACTUAL_PAGES_COUNT = 3;

    private final View.OnClickListener mOnSkipClickListener=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(getActivity(), SplashActivity.class));
            SPUtils.put(getActivity(), Const.FIRST_OPEN, true);
            getActivity().finish();
        }
    };

    private final TutorialPageOptionsProvider mTutorialPageOptionsProvider=new TutorialPageOptionsProvider() {
        @NonNull
        @Override
        public PageOptions provide(int position) {
//            @LayoutRes int
            return null;
        }
    };



    @Override
    protected TutorialOptions provideTutorialOptions() {
        return null;
    }









    @Override
    public void onPageChanged(int position) {

    }


}
