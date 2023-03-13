package com.策略2;

import java.util.List;

public abstract class Strategy {

    public PageInfoWithSum<?> queryDetailByPage(Long id, Integer pageNum, Integer pageSize) {
        return null;
    }

    public RebateOutPortDataDto<?> selectBySummaryId(Long summaryId) {
        return null;
    }

    public void importSuccess(List<RebateImportConfirmDataDetailReqDto> addReqDtos) {

    }

    public String queryDownloadTemplate() {
        return null;
    }

    class PageInfoWithSum<T> {

    }

    class RebateOutPortDataDto<T> {

    }

    class RebateImportConfirmDataDetailReqDto {

    }
}
