# 替换一个字符串（字段）里所有的空格、tab键、换行、回车


UPDATE rebate_month_region
SET REGION_NAME=
    REPLACE(
        REPLACE(
            REPLACE(
                REPLACE(
                    REPLACE(REGION_NAME, CHAR(9), ''),
                    CHAR(10), ''),
                CHAR(13), ''),
            ' ', ''),
        '\r\n', '');


# ASCII 编码一览表（淡黄色背景为控制字符，白色背景为可显示字符）
# 二进制	十进制	十六进制	字符/缩写	解释
# 00000000	0	00	NUL (NULL)	空字符
# 00000001	1	01	SOH (Start Of Headling)	标题开始
# 00000010	2	02	STX (Start Of Text)	正文开始
# 00000011	3	03	ETX (End Of Text)	正文结束
# 00000100	4	04	EOT (End Of Transmission)	传输结束
# 00000101	5	05	ENQ (Enquiry)	请求
# 00000110	6	06	ACK (Acknowledge)	回应/响应/收到通知
# 00000111	7	07	BEL (Bell)	响铃
# 00001000	8	08	BS (Backspace)	退格
# 00001001	9	09	HT (Horizontal Tab)	水平制表符
# 00001010	10	0A	LF/NL(Line Feed/New Line)	换行键
# 00001011	11	0B	VT (Vertical Tab)	垂直制表符
# 00001100	12	0C	FF/NP (Form Feed/New Page)	换页键
# 00001101	13	0D	CR (Carriage Return)	回车键
# 00001110	14	0E	SO (Shift Out)	不用切换
# 00001111	15	0F	SI (Shift In)	启用切换
# 00010000	16	10	DLE (Data Link Escape)	数据链路转义
# 00010001	17	11	DC1/XON
# (Device Control 1/Transmission On)	设备控制1/传输开始
# 00010010	18	12	DC2 (Device Control 2)	设备控制2
# 00010011	19	13	DC3/XOFF
# (Device Control 3/Transmission Off)	设备控制3/传输中断
# 00010100	20	14	DC4 (Device Control 4)	设备控制4
# 00010101	21	15	NAK (Negative Acknowledge)	无响应/非正常响应/拒绝接收
# 00010110	22	16	SYN (Synchronous Idle)	同步空闲
# 00010111	23	17	ETB (End of Transmission Block)	传输块结束/块传输终止
# 00011000	24	18	CAN (Cancel)	取消
# 00011001	25	19	EM (End of Medium)	已到介质末端/介质存储已满/介质中断
# 00011010	26	1A	SUB (Substitute)	替补/替换
# 00011011	27	1B	ESC (Escape)	逃离/取消
# 00011100	28	1C	FS (File Separator)	文件分割符
# 00011101	29	1D	GS (Group Separator)	组分隔符/分组符
# 00011110	30	1E	RS (Record Separator)	记录分离符
# 00011111	31	1F	US (Unit Separator)	单元分隔符
# 00100000	32	20	(Space)	空格