package viaversion.viaversion.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

public final class GsonUtil {
   private static final JsonParser JSON_PARSER = new JsonParser();
   private static final Gson GSON = getGsonBuilder().create();

   public static Gson getGson() {
      return GSON;
   }

   public static GsonBuilder getGsonBuilder() {
      return new GsonBuilder();
   }

   public static JsonParser getJsonParser() {
      return JSON_PARSER;
   }
}
