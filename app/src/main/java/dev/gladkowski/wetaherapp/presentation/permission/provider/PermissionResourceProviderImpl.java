package dev.gladkowski.wetaherapp.presentation.permission.provider;

import android.content.Context;

import dev.gladkowski.wetaherapp.R;

/**
 * Implementation of PermissionResourceProvider
 */
public class PermissionResourceProviderImpl implements PermissionResourceProvider {

    private Context context;

    public PermissionResourceProviderImpl(Context context) {
        this.context = context;
    }

    @Override
    public String getTitle() {
        return context.getString(R.string.app_name);
    }
}
