package com.策略;


import java.util.List;

public interface IStrategy {

    PageInfoWithSum<?> queryDetailByPage(Long id, Integer pageNum, Integer pageSize);

    RebateOutPortDataDto<?> selectBySummaryId(Long summaryId);

    void importSuccess(List<
            RebateImportConfirmDataDetailReqDto> addReqDtos);

    String queryDownloadTemplate();

    class PageInfoWithSum<T> {

    }

    class RebateOutPortDataDto<T> {

    }

    class RebateImportConfirmDataDetailReqDto {

    }
}
