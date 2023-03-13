package com.controler;

import cn.hutool.core.io.IoUtil;
import com.策略.IStrategy;
import com.策略.factory.StrategyEnum;
import com.策略.factory.StrategyFactory;
import java.io.InputStream;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.bind.annotation.GetMapping;

public class 文件相关 {
    @Resource
    public StrategyFactory strategyFactory;
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
        IStrategy iStrategy = strategyFactory.get(StrategyEnum.BUSINESS_EXPENSES);
    }
}
