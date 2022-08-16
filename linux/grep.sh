#1.找异常
#后50行
grep -A 50 'MemberDataAccessException: 分公司们不存在，数据需要初' platform.2018-12-12.0.log
#前50行
grep -B 50 'MemberDataAccessException: 分公司们不存在，数据需要初' platform.2018-12-12.0.log
#前后50行
grep -B 50 'MemberDataAccessException: 分公司们不存在，数据需要初' platform.2018-12-12.0.log
#2.光标移动
行首 Ctrl + a
行尾 Ctrl + e
#3.清屏
printf '\ec'
Ctrl + l
#4.解压
gzip -d catalina.out-20211014.gz
#5.转义空格  '\'
grep 'hello\ world' platform.2018-12-12.0.log
#6.转义中括号  [[]    []]
grep 'amount[[]322.00[]]' platform.2018-12-12.0.log