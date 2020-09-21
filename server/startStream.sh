ffmpeg -re -f lavfi -i testsrc=size=480x360:rate=24 -c:v h264 -pix_fmt yuv420p -profile:v main -hls_flags delete_segments \
 stream1/manifest.m3u8