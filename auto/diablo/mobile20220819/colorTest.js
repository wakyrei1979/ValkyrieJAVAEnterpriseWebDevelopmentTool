//-
if (!requestScreenCapture()) {
    toast("请求截图失败");
    exit
}

//141496
log(colors.toString(
    images.pixel(captureScreen(),
    725,244)));
log(images.pixel(captureScreen(),725,244));