if (!requestScreenCapture()) {
    toast("请求截图失败");
    exit
}
var p = images.findMultiColors(captureScreen(),
 "#543334", [
    [1, 0, "#674846"],
    [0, 2, "#671111"],
    [0, 4, "#593D3E"],
    [1, 4, "#674743"],
    [2, 2, "#650D0D"]
], {
    region: [270, 120, 900, 460]
    //threshold: 5
});
log(1111)
log(p);