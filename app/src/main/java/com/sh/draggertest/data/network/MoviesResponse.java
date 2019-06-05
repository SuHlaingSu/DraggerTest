package com.sh.draggertest.data.network;

import com.google.gson.annotations.SerializedName;
import com.sh.draggertest.data.room.Movies;

import java.util.List;

public class MoviesResponse {
    @SerializedName("results")
    private List<Movies> results;
    @SerializedName("total_pages")
    private int total_pages;

    public List<Movies> getResults() {
        return results;
    }

    public void setResults(List<Movies> results) {
        this.results = results;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }
}
