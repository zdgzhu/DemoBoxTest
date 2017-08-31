package module.start.splash;

import module.start.api.SplashPresenter;
import module.start.api.SplashView;

/**
 * Created by Administrator on 2017/9/1.
 */

public class SplashPresenterImpl implements SplashPresenter {
    private SplashView mSplashView;

    public SplashPresenterImpl(SplashView mSplashView) {
        this.mSplashView = mSplashView;
    }
    @Override
    public void isFirstOpen(boolean isFirstOpen) {

    }

    @Override
    public void onDestroy() {

    }
}
