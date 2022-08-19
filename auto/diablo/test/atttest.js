var mox = 310;
var moy = 580;
if (!requestScreenCapture()) {
    toast("请求截图失败");
    exit();
}
sleep(1000);
threads.start(function() {
    events.observeKey();
    events.on("key_down", function(keyCode, events) {
        if (keyCode == keys.volume_down) {
            exit();
        }
    });
});
events.on("exit", function() {
    toast("脚本已结束");
});
threads.start(function() {
            for (var k = 1; k <= 50; k++) {
                var img = images.clip(
                    captureScreen(),
                    880, 40, 20, 20
                );
                var hb = images.threshold(
                    images.grayscale(img),
                    //100, 255, "BINARY");
                    70, 255, "BINARY");
                // images.save(hb, "/sdcard/hb001.png");
                images.save(hb, "/sdcard/tmp01.png");
                var point = null;
                for (var i = 0; i < 2; i++) {
                    for (var j = 0; j < 2; j++) {
                        point = findColor(hb, "#ffffff", {
                            region: [
                                i * 10,
                                j * 10,
                                10, 10
                            ],
                            threshold: 0
                        });
                        if (point) {
                            break;
                        }
                    }
                    if (point) {
                        break;
                    }
                }
                //toast(p); }
                //}

                //1230 610    1360 560
                if (point) {
                    toast("act:" + k);
                    click(1230, 610);
                    press(1360, 560, 1000);
                    click(1230, 610);
                    press(1360, 560, 2000);
                    sleep(500);
                    atkmove();
                } else {
                    toast("noact:" + k);
                }
                sleep(1000);
            }
            toast("end");
            //}
        };

        function atkmove() {
            var blood = images.threshold(
                captureScreen(),
                100, 255, "BINARY");
            images.save(blood, "/sdcard/tmp02.png");
            var p = images.findMultiColors(
                blood, "#ff0000", [
                    [0, 0, "#ff0000"],
                    [0, 1, "#ff0000"],
                    [0, 2, "#ff0000"],
                    [1, 0, "#ff0000"],
                    [1, 1, "#ff0000"],
                    [1, 2, "#ff0000"]
                ], {
                    region: [400, 80, 750, 470],
                    threshold: 0
                }
            );
            //770 360   310 580
            if (p) {
                var x;
                var y;
                var px = p.x - 770;
                var py = p.y - 360;
                var pxabs = Math.abs(px);
                var pyabs = Math.abs(py);
                if (pxabs > pyabs) {
                    x = px * 100 / pxabs;
                    y = py * 100 / pxabs;
                } else {
                    x = px * 100 / pyabs;
                    y = py * 100 / pyabs;
                }
                //var rmox = random(-20, 20) + mox;
                //var rmoy = random(-20, 20) + moy;
                //swipe(rmox, rmoy, rmox + x, rmoy + y, 1000);
                //}
                swipe(mox, moy, mox + x, moy + y, 1000);
                //}
                log(p + "," + x + "," + y);
                //}y;
                //swipe(rmox, rmoy, rmox + x, rmoy + y, 1000);
            }

            //}

            //}
            //};
        }