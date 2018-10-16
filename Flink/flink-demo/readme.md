## Flink
This the project for tunning Flink API and programming demo.

build the project:
```bash
gradle clean build
```
download the Flink execution env pkg:
```bash
# you need to download the right version to fit the App code
https://archive.apache.org/dist/flink/flink-1.4.2/flink-1.4.2-bin-hadoop24-scala_2.11.tgz
```
start the Flink:(in Windows and Local mode)
```bash
e:\flink\flink-1.4.2\bin
λ start-local.bat
```

run the jar in flink:
```bash
flink run -c <MainClass> <path-of-jar> --src <input-path-file> --dst <output-path-file>
```
sample:
```bash
flink run -c com.bkjf.credit.SimpleTest e:\flink\flink-demo-1.0-SNAPSHOT.jar --src e:\flink\input.txt --dst e:\flink\output.txt
```

xijin.zeng@bkjk.com