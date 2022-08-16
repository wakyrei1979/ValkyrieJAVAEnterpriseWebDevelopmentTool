auto();

if (!requestScreenCapture()) {
    toast("请求截图失败");
    exit
}
var move8 = require('move8.js');
var attack = require('attack.js');
var sta="movefix";
threads.start(function () {
    events.observeKey();
    events.on("key_down", function (keyCode, events) {
        if (keyCode == keys.volume_down) {
            exit();
        }
    });
});

toast("音量下键关闭脚本");

events.on("exit", function () {
    toast("脚本已结束");
});
threads.start(function () {
    while (true) {
        move8.move();
    }
});
threads.start(function () {
    while (true) {
        move8.calmr();
    }
});