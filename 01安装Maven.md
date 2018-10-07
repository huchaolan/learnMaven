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

在当前用户目录(**Windows会有个以用户名称命名的目录**)会有个.m2的目录,这个放置了Maven本地仓库(.m2/repository),默认所有的构件都会被存放到这个目录中,方便重用

## 设置HTTP代理

代理是用于两个场景:1.安全因素,2.访问速度  
修改配置文件:settings.xml

```xml
<proxies>
    <proxy>
        <id>proxy-name</id>
        <active>true</active>
        <protocol>http</protocol>
        <host>123.123.123.123</host>
        <port>3894</port>
        <!--
        <username>****</username>
        <password>****</password>
        <nonProxyHosts>*.google.com|*.repository</nonProxyHosts>
        -->
    </proxy>
</proxies>
```

1. Maven运行配置多个代理,一个proxy元素代表一个代理,默认第一个被激活的代理生效
2. id为代理的名称,active是激活代理,protocol是代理的使用协议
3. 重要的是host和port是代理的ip地址和端口
4. username和password是设置登录代理的用户和密码
5. nonProxyHosts表示访问该域名不用代理,多个域名使用|分隔

## 安装m2eclipse插件

介绍下m2eclipse的组件
模块名称|描述
-|-
Maven SCM handler for Subclipse|模块能够直接从Subversion服务器检出Maven项目,需要安装Subclipse
Maven SCM Integration|Maven域SCM集成核心模块,它利用各种SCM工具实现Maven项目的签出和具体化等操作
Maven issue tracking configurator for Mylyn3.x|使用POM中的缺陷跟踪系统信息链接Mylyn到服务器
Maven SCM handler for Team/CVS|从CVS服务器签出Maven项目
Maven Integration for WTP|自动读取POM信息并配置WTP项目
M2Eclipse Extensions Development Support|支持M2eclipse扩展
Project configurators for commonly used maven plugins|支持一些Maven插件和Eclipse集成

## Maven安装最佳实践

- 设置MAVEN_OPTS环境变量

运行MVN命令时间上运行Java命令,运行java命令时使用的参数可以在运行mvn命令使用通常推荐的属性`-Xms128m -Xmx512m`,提升java运行时的最大内存可以保证Maven运行时不会抛出`OutOfMemeoryError`异常

- 配置用户范围的settings.xml

配置文件分为全局级别和用户级别.全局级别是作用整个机器上的所有用户,用户级别只影响当前使用的用户,推荐使用用户级别的配置文件,可以避免影响其他用户使用,如果有实际的需求要影响全局用户,在配置全局级别配置文件
全局级别配置文件:`$M2_HOME/conf/settings.xml`
用户级别配置文件:`~/.m2/settings.xml`
>当用户级别配置文件不存在,直接拷贝全局级别配置文件到~/.m2目录

- 不用使用IDE内嵌的Maven

当安装Eclipse的Maven插件后,会自带一个内嵌的Maven,即使你没有安装Maven也可以使用,但是这些通常不稳定,而且不能执行命令行,推荐要安装一个Maven并在Eclipse中将Maven插件指定到安装的版本  
>Eclipse->Preferences->Maven->Installations->点击Add指定新的Maven运行环境
