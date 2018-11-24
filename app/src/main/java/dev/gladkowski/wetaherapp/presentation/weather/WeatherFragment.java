package dev.gladkowski.wetaherapp.presentation.weather;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import dev.gladkowski.wetaherapp.R;
import dev.gladkowski.wetaherapp.presentation.common.fragment.BaseFragment;


/**
 * Fragment that shows weather
 */
public class WeatherFragment extends BaseFragment<WeatherPresenter, WeatherView> implements WeatherView {

    @InjectPresenter
    WeatherPresenter weatherPresenter;

    public WeatherFragment() {
    }

    public static WeatherFragment newInstance() {
        WeatherFragment fragment = new WeatherFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @ProvidePresenter
    WeatherPresenter provideMoviesPresenter() {
        return presenterProvider.get();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_weather, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        }

    ///////////////////////////////////////////////////////////////////////////
    // GETTERS
    ///////////////////////////////////////////////////////////////////////////

    @Override
    protected WeatherPresenter getPresenter() {
        return weatherPresenter;
    }

    ///////////////////////////////////////////////////////////////////////////
    // MVP
    ///////////////////////////////////////////////////////////////////////////

    @Override
    public void onSetTitle(String title) {
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

}
