package com.策略.imp;


import com.策略.IStrategy;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class AStrategy implements IStrategy {

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
