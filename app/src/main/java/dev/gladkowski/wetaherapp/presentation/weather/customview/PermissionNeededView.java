package dev.gladkowski.wetaherapp.presentation.weather.customview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import dev.gladkowski.wetaherapp.R;
import dev.gladkowski.wetaherapp.presentation.common.customview.BaseView;

public class PermissionNeededView extends BaseView<PermissionNeededView.OnRequestPermissionListener> {

    private OnRequestPermissionListener onRequestPermissionListener;

    public PermissionNeededView(Context context) {
        super(context);
    }

    public PermissionNeededView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public PermissionNeededView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PermissionNeededView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void initUI(Context context) {
        ButterKnife.bind(inflate(context, R.layout.view_permission_needed, this));
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
