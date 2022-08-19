if (!requestScreenCapture()) {
    toast("请求截图失败");
    exit();
}
sleep(2000);
var m = images.captureScreen();

var h = images.grayscale(m);

images.save(h, "/sdcard/h0819.png");



images.save(
    images.threshold(
        h, 100, 255, "BINARY"),
    "/sdcard/hb0819.png"
); 
//);
images.save(
    images.threshold(
        m, 100, 255, "BINARY"),
    "/sdcard/2z0819.png"
//); "
); 