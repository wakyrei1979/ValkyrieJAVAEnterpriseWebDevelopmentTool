
--插入时判断是否有数据
INSERT INTO card(cardno, cardnum)
SELECT '111', '100'
FROM DUAL
WHERE NOT EXISTS(SELECT cardno FROM card WHERE cardno = '111');