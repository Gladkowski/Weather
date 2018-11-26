package dev.gladkowski.wetaherapp.presentation.weather.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import dev.gladkowski.wetaherapp.R;
import dev.gladkowski.wetaherapp.presentation.common.customview.BaseView;

public class ForecastView extends BaseView<ForecastView.OnRequestPermissionListener> {

    private ForecastView.OnRequestPermissionListener onRequestPermissionListener;

    public ForecastView(Context context) {
        super(context);
    }

    public ForecastView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ForecastView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ForecastView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void initUI(Context context) {
        ButterKnife.bind(inflate(context, R.layout.view_forecast, this));
    }

    @Override
    public void initListeners() {

    }

    @Override
    public void initData(Context context, AttributeSet attrs) {

    }

    @OnClick(R.id.button_request)
    public void submit(View view) {
        getCallbackListener().onRequestPermission();
    }

    public interface OnRequestPermissionListener {
        void onRequestPermission();
    }
}
