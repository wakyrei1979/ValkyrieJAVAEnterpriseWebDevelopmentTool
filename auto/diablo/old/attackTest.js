//截图
if (!requestScreenCapture()) {
    toast("请求截图失败");
    exit
}
//472,75,1100,549
//var m= images.read("/sdcard/21.png");
var pm=captureScreen();
images.save(pm,"/sdcard/30.png");
var p = images.findMultiColors(pm,
 "#650D0D", [
    [-1,0, "#681212"],
    [-1,1, "#681212"],
    [1,0, "#650D0D"],
], {
    region: [472, 75, 628, 474],
    threshold: 4
});
log(p);
//longClick(p.x,p.y);