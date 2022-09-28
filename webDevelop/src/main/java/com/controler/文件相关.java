package com.controler;

import java.io.InputStream;

public class 文件相关 {
    @GetMapping("/downloadTemplate")
    @ApiOperation(value = "下载折让总表导入表Excel模板", notes = "下载折让总表导入表Excel模板")
    public void downloadTemplate(HttpServletResponse response) {
        try {
            response.setContentType("application/vnd.ms-excel");
            response.setCharacterEncoding("utf-8");
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''template-import-business-expenses.xlsx");
            ClassPathResource resource = new ClassPathResource("template/excel/template-import-business-expenses.xlsx");
            InputStream in = resource.getInputStream();
            IoUtil.copy(in, response.getOutputStream());
        } catch (Exception e) {
            throw new ModuleRebateException("800001");
        }
    }
}
