package dev.gladkowski.wetaherapp.presentation.common.customview;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Base View used for custom views
 */
public abstract class BaseView<T> extends FrameLayout {

    private T callbackListener;

    public BaseView(Context context) {
        super(context);
        init(context, null);
    }

    public BaseView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public BaseView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public BaseView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        initUI(context);
        initData(context, attrs);
    }

    public T getCallbackListener() {
        return callbackListener;
    }

    public void setCallbackListener(T callbackListener) {
        this.callbackListener = callbackListener;
        initListeners();
    }

    public abstract void initUI(Context context);

    public abstract void initListeners();

    public abstract void initData(Context context, AttributeSet attrs);
}