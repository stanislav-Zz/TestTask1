package com.example.testtask.model;

public class Camera {
    private int id;
    private SourceData sourceDataUrl;
    private TokenData tokenDataUrl;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SourceData getSourceDataUrl() {
        return sourceDataUrl;
    }

    public void setSourceDataUrl(SourceData sourceDataUrl) {
        this.sourceDataUrl = sourceDataUrl;
    }

    public TokenData getTokenDataUrl() {
        return tokenDataUrl;
    }

    public void setTokenDataUrl(TokenData tokenDataUrl) {
        this.tokenDataUrl = tokenDataUrl;
    }
}
