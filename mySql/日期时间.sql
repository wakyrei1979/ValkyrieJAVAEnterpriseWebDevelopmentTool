# long转时间
select from_unixtime(1496387400);

# 减一天
SELECT DATE_SUB(
        DATE_FORMAT(now(), '%Y-%m-%d'),
        INTERVAL -1 DAY);

# 分别取年、月、日、时间
SELECT id, phone, time, year(time), month(time), DAY(time), TIME(time)
FROM user
WHERE phone = 'xxxxxx';

# 格式化时间
SELECT count(1), DATE_FORMAT(APPLY_TIME, '%Y-%m-%d') AS d
FROM `return_money`
GROUP BY DATE_FORMAT(APPLY_TIME, '%Y-%m-%d')
ORDER BY d DESC;

# 格式化时间
SELECT count(1), DATE_FORMAT(APPLY_TIME, '%Y-%m-%d-%H-%i-%S') AS d
FROM `return_money`
GROUP BY DATE_FORMAT(APPLY_TIME, '%Y-%m-%d-%H-%i-%S')
ORDER BY d DESC;