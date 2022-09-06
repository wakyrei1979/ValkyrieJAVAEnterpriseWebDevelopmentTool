SET @rebateIds := NULL;


UPDATE rebate
SET freeze_status=1
WHERE id IN (1, 2, 3) AND freeze_status = 0 AND remaining_amount != occupied_amount AND
        (SELECT @rebateIds := CONCAT_WS(',', id, @rebateIds)) IS NOT NULL;


SELECT @rebateIds;