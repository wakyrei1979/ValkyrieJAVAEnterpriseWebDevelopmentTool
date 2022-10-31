package com.策略.confirmData.imp;


import com.策略.confirmData.IConfirmDataStrategy;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class BusinessExpensesConfirmDataStrategy implements IConfirmDataStrategy {

    @Override
    public PageInfoWithSum<?> queryDetailByPage(Long id, Integer pageNum, Integer pageSize) {
        return null;
    }

    @Override
    public RebateOutPortDataDto<?> selectBySummaryId(Long summaryId) {
        return null;
    }

    @Override
    public void importSuccess(List<RebateImportConfirmDataDetailReqDto> addReqDtos) {

    }

    @Override
    public String queryDownloadTemplate() {
        return null;
    }
}
