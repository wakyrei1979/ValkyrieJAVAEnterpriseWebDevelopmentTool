package com.controler;

import cn.hutool.core.io.IoUtil;
import java.io.InputStream;
import javax.servlet.http.HttpServletResponse;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;

public class 文件相关 {
    @GetMapping("/downloadTemplate")
    public void downloadTemplate(HttpServletResponse response) {
        try {
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''template-import-business-expenses.xlsx");
            ClassPathResource resource = new ClassPathResource("template/excel/template-import-business-expenses.xlsx");
            InputStream in = resource.getInputStream();
            IoUtil.copy(in, response.getOutputStream());
        } catch (Exception e) {
        }
    }
}
