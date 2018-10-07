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

## 编写主代码

## 编写测试代码

## 打包和运行

## 使用Archetype生成项目骨架
