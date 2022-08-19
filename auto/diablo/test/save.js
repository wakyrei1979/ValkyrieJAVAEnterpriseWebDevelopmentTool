

if(!requestScreenCapture()){
    toast("请求截图失败");
    exit();
}sleep(2000);
var img = captureScreen();
images.saveImage(img, 
"/sdcard/0819.png","png",100);