package org.jsonparse;


import java.util.Map;


public class JsonParse {

    public static void main(String[] args) {
        // 假设jsonString是你要解析的json数据
        String jsonString = "{\"assignDataMap\":{\"KM01\":{\"belongMonthNoAssignToSencondCom\":[{\"useRebateAmount\":20,\"rebateBelongToDate\":\"2023-03\"}],\"belongMonthAssignToSencondCom\":[{\"useRebateAmount\":20,\"rebateBelongToDate\":\"2023-03\",\"priorityUseSecondLevelEnterprise\":\"i98-u77\",\"secondCrmName\":\"大大泡泡唐朝公司\"}],\"useAssignToSecondEnterpri\":0,\"useAutoAssign\":0}}}";

        // 使用fastjson解析json数据
        Data data = com.alibaba.fastjson.JSON.parseObject(jsonString, Data.class);

        // 获取解析结果
        Map<String, Object> assignDataMap = data.getAssignDataMap();

        // 进一步处理解析结果
        // ...

        // 示例：获取KM01节点下的相关数据
        Map<String, Object> km01Data = (Map<String, Object>) assignDataMap.get("KM01");
        System.out.println(km01Data);
    }
    class Data {
        private Map<String, Object> assignDataMap;

        public Map<String, Object> getAssignDataMap() {
            return assignDataMap;
        }

        public void setAssignDataMap(Map<String, Object> assignDataMap) {
            this.assignDataMap = assignDataMap;
        }
    }
}
