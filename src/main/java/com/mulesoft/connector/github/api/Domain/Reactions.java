package com.mulesoft.connector.github.api.Domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Reactions{
    private String url;
    @JsonProperty("total_count")
    private int totalCount;
    @JsonProperty("+1")
    private int plusOne;
    @JsonProperty("-1")
    private int minusOne;
    private int laugh;
    private int hooray;
    private int confused;
    private int heart;
    private int rocket;
    private int eyes;

    public Reactions(){}
    public Reactions(String url, int total_count, int plusOne, int minusOne, int laugh, int hooray, int confused, int heart, int rocket, int eyes) {
        this.url = url;
        this.totalCount = total_count;
        this.plusOne = plusOne;
        this.minusOne = minusOne;
        this.laugh = laugh;
        this.hooray = hooray;
        this.confused = confused;
        this.heart = heart;
        this.rocket = rocket;
        this.eyes = eyes;
    }

    public String getUrl() {
        return url;
    }

    public int getTotal_count() {
        return totalCount;
    }

    public int getPlusOne() {
        return plusOne;
    }

    public int getMinusOne() {
        return minusOne;
    }

    public int getLaugh() {
        return laugh;
    }

    public int getHooray() {
        return hooray;
    }

    public int getConfused() {
        return confused;
    }

    public int getHeart() {
        return heart;
    }

    public int getRocket() {
        return rocket;
    }

    public int getEyes() {
        return eyes;
    }
}
