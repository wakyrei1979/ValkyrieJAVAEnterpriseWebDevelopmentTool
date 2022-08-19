// 摇杆 
var mox = 306;
var moy = 580;
var mmx = 0;
var mmy = 0;
var act8mk = [0, 0, 0, 0, 0, 0, 0, 0];
var act8 = 0;
var mCheckMapx = 1200; //1235 1275 1310
//var mCheckMapy = 24;
//var mCheckMapy = 0;//55 95
//var mCheckMapy = 35;
var mCheckMapy = 150;
//var mCheckMapW = 210;//120
//var mCheckMapW = 75;
var mCheckMapW = 200;
//var mCheckMapH = 160;
//var mCheckMapH = 89;
var mCheckMapH = 20;
var mrv = 60;
var cols = 03;
var moveTime;
var move8 = {};
move8.move = function() {
    calmmxy();
    if (sta == "move") {
        log("act8:"+act8);
        moveTime = Date.now();
        var rmox = random(-20, 20) + mox;
        var rmoy = random(-20, 20) + moy;
        swipe(rmox, rmoy, rmox + mmx, rmoy + mmy, 10000);
    }
    //sta="move";
}
move8.calmr = function() {
    if ((sta == "move") &
        (Date.now() - moveTime > 1000)) {
        var mp1 = images.clip(captureScreen(), mCheckMapx, mCheckMapy, mCheckMapW, mCheckMapH);
        //sleep(1000);
        //sleep(1000);
        sleep(800);
        var mp2 = images.clip(captureScreen(), mCheckMapx, mCheckMapy, mCheckMapW, mCheckMapH);
        if (images.findImage(mp1, mp2, {
                threshold: 0.9
            })) {
            sta = "movefix";
            var rmox = random(-20, 20) + mox;
            var rmoy = random(-20, 20) + moy;
            //longClick(rmox, rmoy);
            press(rmox, rmoy, 100);
            log("set movefix");
        }
    }
}

function calmmxy() {
    if (sta == "movefix") {
        calact8();
        if (act8 == 1) {
            mmx = 0;
            mmy = -60;
        } else if (act8 == 2) {
            mmx = 60;
            mmy = -60;
        } else if (act8 == 3) {
            mmx = 60;
            mmy = 0;
        } else if (act8 == 4) {
            mmx = 60;
            mmy = 60;
        } else if (act8 == 5) {
            mmx = 0;
            mmy = 60;
        } else if (act8 == 6) {
            mmx = -60;
            mmy = 60;
        } else if (act8 == 7) {
            mmx = -60;
            mmy = 0;
        } else if (act8 == 8) {
            mmx = -60;
            mmy = -60;
        }
        sta = "move";
        notchangeAct8times = 1;
    } else {
        notchangeAct8times = notchangeAct8times + 1;
    }
}

function calact8() {
    var num = 0;
    for (var i = 0; i < act8mk.length; i++) {
        if (act8mk[i] == 0) {
            num++;
        }
    }
    if (num == 0) {
        act8mk = [0, 0, 0, 0, 0, 0, 0, 0];
        num = 8;
    }
    var tmp = random(1, num);
    var tmp2 = 0;
    for (var i = 0; i < act8mk.length; i++) {
        if (act8mk[i] == 0) {
            tmp2++;
            if (tmp2 == tmp) {
                act8mk[i] = 1;
                act8 = i + 1;
            }
        }
    }
}
module.exports = move8;