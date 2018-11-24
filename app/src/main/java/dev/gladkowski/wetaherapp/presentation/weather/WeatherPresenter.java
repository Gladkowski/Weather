package dev.gladkowski.wetaherapp.presentation.weather;

import android.support.annotation.NonNull;

import com.arellomobile.mvp.InjectViewState;

import dev.gladkowski.wetaherapp.presentation.common.activity.BaseNetworkPresenter;
import dev.gladkowski.wetaherapp.utils.rx.ErrorResourceProvider;
import ru.terrakok.cicerone.Router;

/**
 * Presenter for WeatherFragment
 */
@InjectViewState
public class WeatherPresenter extends BaseNetworkPresenter<WeatherView> {

    @NonNull
    private Router router;
    @NonNull
    private ErrorResourceProvider errorResourceProvider;

    public WeatherPresenter(@NonNull Router router,
                            @NonNull ErrorResourceProvider errorResourceProvider) {
        this.router = router;
        this.errorResourceProvider = errorResourceProvider;
    }

    @NonNull
    @Override
    public Router getRouter() {
        return router;
    }

    @NonNull
    @Override
    public ErrorResourceProvider getErrorResourceProvider() {
        return errorResourceProvider;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

    @Override
    public void initData() {

    }
}
