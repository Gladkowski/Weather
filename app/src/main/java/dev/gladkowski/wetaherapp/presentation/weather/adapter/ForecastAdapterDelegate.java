package dev.gladkowski.wetaherapp.presentation.weather.adapter;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.hannesdorfmann.adapterdelegates3.AdapterDelegate;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import dev.gladkowski.wetaherapp.R;
import dev.gladkowski.wetaherapp.entity.weather.presentation.BaseForecastItem;
import dev.gladkowski.wetaherapp.entity.weather.presentation.ForecastItem;
import dev.gladkowski.wetaherapp.presentation.weather.converter.WeatherImageConverter;

public class ForecastAdapterDelegate extends AdapterDelegate<List<BaseForecastItem>> {

    @NonNull
    private WeatherImageConverter imageConverter;

    ForecastAdapterDelegate(@NonNull WeatherImageConverter imageConverter) {
        this.imageConverter = imageConverter;
    }

    @Override
    public boolean isForViewType(@NonNull List items, int position) {
        return items.get(position) instanceof ForecastItem;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent) {
        View item = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_forecast, parent, false);
        return new ViewHolder(item);
    }

    @Override
    public void onBindViewHolder(@NonNull List<BaseForecastItem> items,
                                 int position,
                                 @NonNull RecyclerView.ViewHolder holder,
                                 @Nullable List<Object> payloads) {

        ForecastAdapterDelegate.ViewHolder viewHolder = (ForecastAdapterDelegate.ViewHolder) holder;
        ForecastItem viewModel = (ForecastItem) items.get(position);

        viewHolder.setItem(viewModel);
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_date)
        TextView textDate;
        @BindView(R.id.image_weather_condition)
        ImageView image;
        @BindView(R.id.text_temperature_day_night)
        TextView textTemperature;

        ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        private void setItem(ForecastItem item) {
            textDate.setText(item.getDate());
            image.setImageResource(imageConverter.getImageResource(item.getWeatherCondition()));
            textTemperature.setText(item.getTemperatureDayNight());
        }
    }
}
