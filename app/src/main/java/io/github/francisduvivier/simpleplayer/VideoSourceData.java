package io.github.francisduvivier.simpleplayer;

import androidx.annotation.NonNull;

public class VideoSourceData {
    @NonNull
    String title;
    @NonNull
    String url;

    public VideoSourceData(@NonNull String title, @NonNull String url) {
        this.title = title;
        this.url = url;
    }

    @Override
    public String toString() {
        return this.title;
    }
}