package io.github.francisduvivier.simpleplayer;

public class VideoSources {
    private static final String serverHost = "192.168.0.197:8080";
    static final VideoSourceData[] sources = new VideoSourceData[]{
            new VideoSourceData("VOD Test Stream", "https://storage.googleapis.com/wvmedia/clear/h264/tears/tears.mpd"),
            new VideoSourceData("Live Test Stream", "http://"+serverHost+"/stream1/manifest.m3u8")
    };
}
