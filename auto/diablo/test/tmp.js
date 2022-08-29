if (!requestScreenCapture()) {
    toast("请求截图失败");
    exit();
}
sleep(2000); 
// var checkspng = images.read("/sdcard/checks.png");
var screen = images.threshold(images.captureScreen(), 100, 255, "BINARY");
// var checkspng  = images.clip(screen,668,37,95,20);
var checkspng  = images.clip(screen,668,37,95,20);
images.save(screen,"/sdcard/screenchecks.png");
    var p = images.findImage(screen,checkspng,{
        region: [667,36,96,21],
        threshold: 1
    });
    if (p){
        log("1");
    }else{
        log(2);
    }
       log(p);