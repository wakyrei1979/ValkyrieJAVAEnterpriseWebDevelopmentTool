package org.字符串;

public class 文件名 {

    public static void main(String[] args) {
        String path = "/aaaa/bbb/template/cfc9-4ac3-afc9-9245d990b5d4.pdf";
        String fName = path.trim();
        String fileName = fName.substring(fName.lastIndexOf("/")+1);
    }
}
