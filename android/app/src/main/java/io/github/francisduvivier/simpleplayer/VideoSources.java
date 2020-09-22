package io.github.francisduvivier.simpleplayer;

public class VideoSources {
    static final VideoSourceData[] sources = new VideoSourceData[]{
            new VideoSourceData("VOD Test Stream", "https://storage.googleapis.com/wvmedia/clear/h264/tears/tears.mpd"),
            new VideoSourceData("Live Test Stream", BuildConfig.LIVE_STREAM_ADDRESS)
    };
}
