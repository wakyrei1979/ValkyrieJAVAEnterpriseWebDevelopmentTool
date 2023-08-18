# -*- coding:utf-8 -*-

import json

import pandas as pd

with open('data.json', encoding='utf-8') as f:
  data = json.load(f)

df = pd.DataFrame(data['snapShot']['detailList'])



df.iloc[:,0] = df.iloc[:,0].astype(str)


# 创建Excel Writer对象，并将数据写入不同的sheet页
writer = pd.ExcelWriter('output.xlsx')
df.to_excel(writer, sheet_name='Sheet1', index=False)
writer.close()
print('导出成功!')