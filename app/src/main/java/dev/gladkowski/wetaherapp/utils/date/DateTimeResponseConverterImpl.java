package dev.gladkowski.wetaherapp.utils.date;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.io.IOException;

/**
 * Implementation of DateTimeResponseConverter
 */
public class DateTimeResponseConverterImpl extends TypeAdapter<DateTime>
        implements DateTimeResponseConverter{

    @Override
    public void write(JsonWriter out, DateTime value) throws IOException {

    }

    @Override
    public DateTime read(JsonReader in) throws IOException {
        return new DateTime(in.nextLong() * 1000L, DateTimeZone.UTC)
                .withZone(DateTimeZone.getDefault());
    }
}
