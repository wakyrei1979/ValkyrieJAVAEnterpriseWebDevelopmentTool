

//截图
if (!requestScreenCapture()) {
    toast("请求截图失败");
    exit
}

//141496
log(colors.toString(
    images.pixel(captureScreen(),
    725,244)));

//读图
log(colors.toString(
    images.pixel(images.read("/sdcard/2.png"),
    725,244)));