package module.start.api;

/**
 * Created by Administrator on 2017/9/1.
 */

public interface SplashPresenter {

    //判断是否是第一次启动
    void isFirstOpen(boolean isFirstOpen);

    void onDestroy();


}
