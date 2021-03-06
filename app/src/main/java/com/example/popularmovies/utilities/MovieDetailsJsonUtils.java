package com.example.popularmovies.utilities;

import com.example.popularmovies.models.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MovieDetailsJsonUtils {

    private static final String RESULTS = "results";
    private static final String TITLE = "title";
    private static final String POSTER_PATH = "poster_path";
    private static final String RELEASE_DATE = "release_date";
    private static final String VOTE_AVERAGE = "vote_average";
    private static final String OVERVIEW = "overview";

    private static final String POSTER_BASE_URL = "http://image.tmdb.org/t/p/";
    private static final String POSTER_SIZE = "w500";

    public static Movie[] getSimpleWeatherStringsFromJson(String json) throws JSONException {

        JSONObject moviesJson = new JSONObject(json);

        JSONArray moviesResultJsonArray = moviesJson.optJSONArray(RESULTS);

        Movie[] moviesDetailsArray = new Movie[moviesResultJsonArray.length()];

        for(int i = 0; i < moviesResultJsonArray.length(); i++){
            String movieTitle = moviesResultJsonArray.getJSONObject(i).optString(TITLE);
            String moviePoster = moviesResultJsonArray.getJSONObject(i).optString(POSTER_PATH);
            String movieRelease = moviesResultJsonArray.getJSONObject(i).optString(RELEASE_DATE);
            String movieRate = moviesResultJsonArray.getJSONObject(i).optString(VOTE_AVERAGE);
            String movieOverview = moviesResultJsonArray.getJSONObject(i).optString(OVERVIEW);

            moviesDetailsArray[i] =
                    new Movie(movieTitle,
                            POSTER_BASE_URL+POSTER_SIZE+moviePoster,
                            movieRelease,
                            movieRate,
                            movieOverview);
        }

        return moviesDetailsArray;

    }
}
