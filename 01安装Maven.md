# Maven的安装配置

## 在Windows下安装Maven

### 检查JDK安装

- 检查JAVA_HOME环境变量，当安装完JDK时就需要配置JAVA_HOME和JRE_HOME

```bash
C:\Users\PC>echo %JAVA_HOME%
C:\Program Files\Java\jdk1.8.0_181
```

- 检查Java的版本

```bash
C:\Users\PC>java -version
java version "1.8.0_181"
Java(TM) SE Runtime Environment (build 1.8.0_181-b13)
Java HotSpot(TM) 64-Bit Server VM (build 25.181-b13, mixed mode)
```

### 下载Maven

最新Maven版本时3.5.4,对于Java需要1.7以上.[下载地址](http://maven.apache.org/download.cgi)

### 本地安装

1. 新建M2_HOME环境变量指向Mave的安装目录
2. 在Path环境变量末尾添加`;%M2_HOME\bin`，可以在命令行直接运行maven的命令
3. 在cmd命令行中执行`mvn -v`可以输出maven的相关信息,这些显示当前maven使用3.2.5版本，Maven的安装目录,Java版本,java的安装目录，默认语言，系统版本

```bash
C:\Users\PC>mvn -v
Apache Maven 3.2.5 (12a6b3acb947671f09b81f49094c53f426d8cea1; 2014-12-15T01:29:23+08:00)
Maven home: D:\javaproject\maven
Java version: 1.8.0_181, vendor: Oracle Corporation
Java home: C:\Program Files\Java\jdk1.8.0_181\jre
Default locale: zh_CN, platform encoding: GBK
OS name: "windows 10", version: "10.0", arch: "amd64", family: "dos"
```

### 升级Maven

升级Mave只需要下载新版本的maven并解压，调整M2_HOME的可以了

## 在基于unix下安装Maven(待补充)

## 安装目录分析

目录|描述
|-|-|
bin|包含了mvn的运行脚本
boot|包含了一个类加载器,mvn使用自己的类加载器加载类库
conf|配置文件目录，settings.xml是全局的配置文件
lib|mvn运行需要加载java类库

### .m2目录

在当前用户目录会有个.m2的目录,这个放置了Maven本地仓库(.m2/repository),默认所有的构件都会被存放到这个目录中,方便重用
## 设置HTTP代理

## 安装m2eclipse插件

## Maven安装最佳实践
