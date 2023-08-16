package org.字符串;

public class 文件名 {

    public static void main(String[] args) {
        //去掉路径
        String path = "/aaaa/bbb/template/cfc9-4ac3-afc9-9245d990b5d4.pdf";
        String fName = path.trim();
        String fileName = fName.substring(fName.lastIndexOf("/")+1);
        System.out.println(fileName);

        //去掉.pdf
        String str = "example.pdf";
        if (str.endsWith(".pdf")) {
            str = str.substring(0, str.length() - 4);
        }
        System.out.println(str);
    }
}
