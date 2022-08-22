package com.mulesoft.connector.github.internal.Domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Reactions{
    public String url;
    public int total_count;
    @JsonProperty("+1")
    public int plusOne;
    @JsonProperty("-1")
    public int minusOne;
    public int laugh;
    public int hooray;
    public int confused;
    public int heart;
    public int rocket;
    public int eyes;

    public Reactions(String url, int total_count, int plusOne, int minusOne, int laugh, int hooray, int confused, int heart, int rocket, int eyes) {
        this.url = url;
        this.total_count = total_count;
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
        return total_count;
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
