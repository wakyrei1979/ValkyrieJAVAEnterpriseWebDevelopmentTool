
import com.dtyunxi.tasly.center.rebate.dao.eo.RebateEo;
import com.dtyunxi.tasly.center.rebate.dao.mapper.RebateMapper;
import com.dtyunxi.tasly.center.rebate.dao.utils.batch.BatchExecutor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;

/**
 * 返利冻结状态更新批量处理执行器
 * @author Liu Dong
 * */
public class BatchUpdateFreezeStatusExecutor extends BatchExecutor<RebateEo> {

    private RebateMapper rebateMapper;
    private Integer freezeStatus;
    private Integer freezeStatusCheckValue;
    private boolean amountCheck;

    //output
    private List<Long> results;

    public BatchUpdateFreezeStatusExecutor(RebateMapper rebateMapper, Integer batchSize,
            Integer freezeStatus,
            Integer freezeStatusCheckValue, boolean amountCheck) {
        super(batchSize);
        this.rebateMapper = rebateMapper;
        this.freezeStatus = freezeStatus;
        this.freezeStatusCheckValue = freezeStatusCheckValue;
        this.amountCheck = amountCheck;
        this.results = new ArrayList<>();
    }

    @Override
    protected void flushInternal() {
        this.rebateMapper.batchUpdateFreezeStatus(this.freezeStatus,
                this.batches, this.freezeStatusCheckValue, amountCheck);
        String rebateIds = this.rebateMapper.selectRebateIdsOnBatchUpdateFreezeStatus();
        if (StringUtils.isNotBlank(rebateIds)) {
            this.results.addAll(Arrays.stream(rebateIds.split(","))
                    .map(Long::parseLong).collect(Collectors.toList()));
        }
    }

    public List<Long> getResults() {
        return this.results;
    }
}
