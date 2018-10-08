# Maven的简单使用入门

## 编写POM

Maven项目的核心是pom.xml.POM是Project Ojbect Model的缩写。

+ 一个HelloWord的例子

建立HelloWord的文件夹，在文件夹中创建pom.xml,内容如下:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
        xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
        xsi:schemaLocation="http://maven.apache.org/POM/4.0.0
        http://maven.apache.org/maven-v4_0_0.xsd">
        <modelVersion>4.0.0</modelVersion>
        <groupId>com.juvenxu.mvnbook</groupId>
        <artifactId>hello-world</artifactId>
        <version>1.0-SNAPSHOT</version>
        <name>Maven Hello World Project</name>
</project>
```

xml的简单解释:  

+ `modelVersion`在maven2和3只能写4.0.0，固定写法

+ `<?xml version="1.0" encoding="UTF-8"?>`是XML的固定写法，包含了xml的版本和文字的编码格式，一个的配置文件都是应该是UTF-8

+ `<project>`是根元素，用于整个项目，`xmlns`,`xmlns:xsi`,`xsi:schemaLocation`属性不是必须，加上去后有些IDE可以自动读取xsi:schemaLocation指定的内容，帮忙我们快速编辑和校验pom.xml

+ `groupId`,`artifactId`,`version`是pom.xml的重点，它描述了一个**项目基本坐标**

属性      |描述
----------|----------
groupId   |和项目所在的组织或公司存在关联,比如apache建立了一个myapp项目,应该叫做:org.apache.myapp
artifactId|当前Maven项目唯一的Id,整个常常和groupId搞混淆,你可以它当成模块名称或者项目全称理解
version   |当前版本，1.0-SNAPSHOT表示正在开发的版本

+ `name`属性项目的友好名称，不是必填项

>没有任何实际的Java代码，我们就能够定义一个Maven项目的POM，这体现了Maven的一大优点，它能让项目对象模型最大程度地与实际代码相对独立，我们可以称之为解耦或者正交性。这在很大程度上避免了Java代码和POM代码的相互影响(原文)

## 编写主代码

1. 主代码放到src/main/java目录,Maven会自动在这个目录搜索
2. Java类的包名com.juvenxu.mvnbook.helloworldh和之前定义的groupId和artifactId相吻合

```java
package com.juvenxu.mvnbook.helloworld;

public class HelloWorld {
    public String sayHello() {
        return "Hello,Maven";
    }

    public static void main(String[] args) {
        System.out.println(new HelloWorld().sayHello());
    }
}
```

在命令行中运行`mvn clean compile`

```bash
[INFO] Scanning for projects...
[INFO]
[INFO] ------------------------------------------------------------------------
[INFO] Building Maven Hello World Project 1.0-SNAPSHOT
[INFO] ------------------------------------------------------------------------
[INFO]
[INFO] --- maven-clean-plugin:2.5:clean (default-clean) @ hello-world ---
[INFO] Deleting C:\Users\PC\Desktop\maven文档\learnMaven\02chapter\HelloWorld\target
[INFO]
[INFO] --- maven-resources-plugin:2.6:resources (default-resources) @ hello-world ---
[WARNING] Using platform encoding (GBK actually) to copy filtered resources, i.e. build is platform dependent!
[INFO] skip non existing resourceDirectory C:\Users\PC\Desktop\maven文档\learnMaven\02chapter\HelloWorld\src\main\resources
[INFO]
[INFO] --- maven-compiler-plugin:3.1:compile (default-compile) @ hello-world ---
[INFO] Changes detected - recompiling the module!
[WARNING] File encoding has not been set, using platform encoding GBK, i.e. build is platform dependent!
[INFO] Compiling 1 source file to C:\Users\PC\Desktop\maven文档\learnMaven\02chapter\HelloWorld\target\classes
[WARNING] /C:/Users/PC/Desktop/maven文档/learnMaven/02chapter/HelloWorld/src/main/java/com/juvenxu/mvnbook/helloworld/HelloWorld.java:[5,78] 编码GBK的不可映射字符[INFO] ------------------------------------------------------------------------
[INFO] BUILD SUCCESS
[INFO] ------------------------------------------------------------------------
[INFO] Total time: 1.025 s
[INFO] Finished at: 2018-10-09T01:01:23+08:00
[INFO] Final Memory: 13M/243M
[INFO] ------------------------------------------------------------------------
```

从日志结果可以看到执行过程:clean->resources->compile(虽然输入clean compile)

+ clean任务:清理target目录，Maven所有的构建都放到target目录
+ resources任务:由于没有resources目录就跳过了
+ compiler任务:将HelloWorld.java编译到target目录中

## 编写测试代码

## 打包和运行

## 使用Archetype生成项目骨架
