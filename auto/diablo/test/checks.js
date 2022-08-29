
var checks = {};
var screen;
var checkspng = images.read("/sdcard/checks.png");
checks.check = function () {
    screen = images.threshold(images.captureScreen(), 100, 255, "BINARY");
    if (checkMBlood()) {
        main_s = "attack";
    } else {
        main_s = "move";
    }
}

//668,37,762,56
function checkMBlood() {
    if(images.findImage(screen,checkspng,{
        region: [668,37,95,20],
        threshold: 1
    })){
        return false;//全黑色没有怪物血条
    }else{
        return true;
    }
}



module.exports = checks;