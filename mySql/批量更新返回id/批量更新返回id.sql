-- 返回ID
SET @rebateIds := NULL;

UPDATE rebate
SET freeze_status=1
WHERE id IN (1, 2, 3) AND freeze_status = 0 AND remaining_amount != occupied_amount AND
        (SELECT @rebateIds := CONCAT_WS(',', id, @rebateIds)) IS NOT NULL;

SELECT @rebateIds;

-- 返回ID 和更新值（只返回了4，5）
SET @IDs := NULL;

update b2bdev.order_credit_operate_test t
set OCCUPY_AMOUNT_EXPIRE = OCCUPY_AMOUNT_EXPIRE + CANCLE_QUANTITY_UNEXPIRE
where id in (4,5) and (SELECT @IDs := CONCAT_WS(';   ', CONCAT_WS(',',id,OCCUPY_AMOUNT_EXPIRE,CANCLE_QUANTITY_UNEXPIRE), @IDs)) IS NOT NULL;

select CONVERT (@IDs USING utf8);

-- 返回ID 和更新值（错误的写法返回了全部）
SET @IDs := NULL;

update b2bdev.order_credit_operate_test t
set OCCUPY_AMOUNT_EXPIRE = OCCUPY_AMOUNT_EXPIRE + CANCLE_QUANTITY_UNEXPIRE
where (SELECT @IDs := CONCAT_WS(';   ', CONCAT_WS(',',id,OCCUPY_AMOUNT_EXPIRE,CANCLE_QUANTITY_UNEXPIRE), @IDs)) IS NOT NULL
 and id in (4,5)
;

select CONVERT (@IDs USING utf8);

