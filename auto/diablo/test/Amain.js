auto();
//脚本关闭
if (!requestScreenCapture()) {
    toast("请求截图失败");
    exit
}

threads.start(function () {
    events.observeKey();
    events.on("key_down", function (keyCode, events) {
        if (keyCode == keys.volume_down) {
            exit();
        }
    });
});

toast("音量下键关闭脚本");


//正式脚本
// var move8 = require('./move8');
// var attack = require('./attack');
var checks = require('./checks');
events.on("exit", function () {
    toast("脚本已结束");
});

//主状态
var main_s;
var child_s;
//主线程
threads.start(function () {
    while (true) {
        switch(main_s)
        {
            case "move":
                // move8.move();
                break;
            case "attack":
                // attack.act();
                break;
        }
        toast(main_s);
        sleep(500); 
    }
});
//检测状态
threads.start(function () {
    while (true) {
        checks.check();
        sleep(200); 
    }
});