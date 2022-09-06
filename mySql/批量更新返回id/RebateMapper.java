

public interface RebateMapper {
    @Update({"<script>",
            "SET @rebateIds := null;",
            "update rebate",
            "<set>",
                "freeze_status=#{freezeStatus}",
            "</set>",
            "<where>",
                "id in",
                "<foreach collection=\"rebateList\" item=\"rebate\" open=\"(\" separator=\",\" close=\")\">",
                    "#{rebate.id}",
                "</foreach>",
                "and freeze_status=#{freezeStatusCheck}",
                "<if test=\"amountCheck\">",
                "and remaining_amount != occupied_amount",
                "</if>",
                "and ( SELECT @rebateIds := CONCAT_WS(',', id, @rebateIds) ) is not null",
            "</where>",
            "order by id asc;",
            "</script>"})
    void batchUpdateFreezeStatus(@Param("freezeStatus") Integer freezeStatus,
            @Param("rebateList") List<RebateEo> rebateEoList,
            @Param("freezeStatusCheck") Integer freezeStatusCheckValue,
            @Param("amountCheck") boolean amountCheck);

    @Select("select CONVERT (@rebateIds USING utf8);")
    String selectRebateIdsOnBatchUpdateFreezeStatus();
}
