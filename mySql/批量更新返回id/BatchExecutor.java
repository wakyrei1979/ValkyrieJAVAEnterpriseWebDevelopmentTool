
import com.dtyunxi.tasly.center.rebate.dao.eo.RebateEo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Liu Dong
 * */
public abstract class BatchExecutor<T> {

    protected List<T> batches ;
    protected Integer batchSize ;

    protected Integer i ;

    protected BatchExecutor(Integer batchSize) {
        this.batchSize = batchSize;
        this.batches = new ArrayList<>();
        i = 0 ;
    }

    public void execute(T record){
        this.batches.add(record);
        if((i++) == this.batchSize - 1){
            flush();
        }
    }

    public void flush(){
        if(this.batches.size() > 0) {
            flushInternal();
            i = 0;
            this.batches.clear();
        }
    }

    protected abstract void flushInternal();
}
