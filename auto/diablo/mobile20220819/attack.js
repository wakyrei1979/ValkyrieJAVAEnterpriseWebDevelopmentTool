if (!requestScreenCapture()) {
    toast("请求截图失败");
    exit
}
//var tt = "iVBORw0KGgoAAAANSUhEUgAAAAoAAAAKCAYAAACNMs+9AAAAAXNSR0IArs4c6QAAAARzQklUCAgICHwIZIgAAACCSURBVBiVVZDBDcMwDAPvAk3Ud4Huv5TZhxQ7sQEDFkmJop/vLyBkkbmE1xEoCMkiOWgG7FcQaq0FD1LXRR1xSKQa9D1KR9vdFOqmBIc/Qw3qFtb+5N0VRa8trtwkc6wqF4eE4SIQMwtme8Jb1XFVOF6YbXdMO4xQCMRHdi1o0tqVP6ziN+SWvPtUAAAAAElFTkSuQmCC";
//var tt="iVBORw0KGgoAAAANSUhEUgAAAAoAAAAKCAYAAACNMs";
var tt = "iVBORw0KGgoAAAANSUhEUgAAAAoAAAAKCAYAAACNMs+9AAAAAXNSR0IArs4c6QAAAARzQklUCAgICHwIZIgAAABnSURBVBiVfZBRDsAgDEIfxqPsY9n978c+1K4aHYnRBIRSXfdjAGPa3eF4AVBDsBArqu1k06GN8ETEHykJf0RCIKiamWUCRVr1SBZTU6mAvugCYIVFP5+z3fZSNpO1yAx7lDnUTmt7AUV/GqJ0/dhnAAAAAElFTkSuQmCC";
var pp = images.findImage(
    captureScreen(),
    images.fromBase64(tt), {
        region: [400, 80, 750, 500],
        threshold: 0.9
    }
);
toast(pp.x + "," + pp.y);
log(pp.x + "," + pp.y);
log(
    images.toBase64(images.clip(
        captureScreen(),
        270, 450, 10, 10)));