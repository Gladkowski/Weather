package dev.gladkowski.wetaherapp.presentation.weather.adapter;

import com.hannesdorfmann.adapterdelegates3.ListDelegationAdapter;

import java.util.ArrayList;
import java.util.List;

import dev.gladkowski.wetaherapp.entity.app.presentation.BaseItem;
import dev.gladkowski.wetaherapp.entity.weather.presentation.BaseForecastItem;
import dev.gladkowski.wetaherapp.presentation.weather.converter.WeatherImageConverter;

/**
 * Adapter for weather forecast
 */
public class ForecastAdapter extends ListDelegationAdapter<List<BaseForecastItem>> {

    public ForecastAdapter(WeatherImageConverter imageConverter) {
        delegatesManager.addDelegate(new ForecastAdapterDelegate(imageConverter));

        setItems(new ArrayList<>());
    }

    /**
     * Put items to the list
     */
    public void addItems(List<BaseForecastItem> forecastItems) {
        items.clear();
        items.addAll(forecastItems);
        this.notifyDataSetChanged();
    }

    /**
     * Clear list
     */
    public void clearList() {
        items.clear();
        notifyDataSetChanged();
    }

    /**
     * Get item object by it's position in list
     */
    public BaseItem getItemByPosition(int position) {
        return items.get(position);
    }
}
