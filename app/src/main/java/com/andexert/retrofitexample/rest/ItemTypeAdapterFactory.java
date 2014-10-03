package com.andexert.retrofitexample.rest;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.TypeAdapterFactory;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;

/**
 * Created by lukas on 6/10/14.
 */
public class ItemTypeAdapterFactory implements TypeAdapterFactory {

    public <T> TypeAdapter<T> create(Gson gson, final TypeToken<T> type) {

        final TypeAdapter<T> delegate = gson.getDelegateAdapter(this, type);
        final TypeAdapter<JsonElement> elementAdapter = gson.getAdapter(JsonElement.class);

        return new TypeAdapter<T>() {

            public void write(JsonWriter out, T value) throws IOException
            {
                delegate.write(out, value);
            }

            public T read(JsonReader in) throws IOException
            {

                JsonElement jsonElement = elementAdapter.read(in);
                if (jsonElement.isJsonObject())
                {
                    JsonObject jsonObject = jsonElement.getAsJsonObject();
                    if (jsonObject.has("cod") && jsonObject.get("cod").getAsInt() == 404)
                    {
                        throw new IllegalArgumentException(jsonObject.get("message").getAsString());
                    }
                }

                return delegate.fromJsonTree(jsonElement);
            }
        }.nullSafe();
    }
}
