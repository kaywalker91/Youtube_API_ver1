package com.kaywalker.youtube_api.network;

import com.kaywalker.youtube_api.models.ModelHome;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Url;

public class YoutubeAPI {

    public static final String BASE_URL = "https://www.googleapis.com/youtube/v3/";
    public static final String KEY = "key=AIzaSyC8MBXNccFgofuIb9D3Pw-Hvyd8wlFUzUg";
    public static final String sch = "search?";
    public static final String chid = "&channelId=UCLHoRDAmtWE5lKJVSvf0pAg";
    public static final String mx = "&maxResults=15";
    public static final String ord = "&order=date";
    public static final String part = "&part=snippet";

    public interface HomeVideo{
        @GET
        Call<ModelHome> getYT(@Url String url);
    }

    private static HomeVideo homeVideo = null;

    public static HomeVideo getHomeVideo(){
        if (homeVideo == null) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            homeVideo = retrofit.create(HomeVideo.class);
        }
        return homeVideo;
    }
}
