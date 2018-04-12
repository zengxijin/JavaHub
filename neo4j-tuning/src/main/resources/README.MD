
Consumer_Complaints.csv下载地址：
https://catalog.data.gov/dataset/consumer-complaint-database


原来的文件里面的数据，尤其是投诉内容有很多特殊字符，直接通过
```
LOAD CSV FROM "file:///xxx.csv" ...
```
导进去的是会报错，需要清洗，文件Consumer_Complaints_clean.csv是经过清洗之后的文件内容，可以直接导进去；


在64G，8核的Linux机器上，导入的节点和边的时间是1分钟之类就完成
