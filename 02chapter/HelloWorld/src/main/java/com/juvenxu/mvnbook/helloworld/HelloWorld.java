package com.juvenxu.mvnbook.helloworld;

/**
 * 1.主代码放到src/main/java目录,Maven会自动在这个目录搜索<br/>
 * 2.Java类的包名com.juvenxu.mvnbook.helloworldh和之前定义的groupId和artifactId相吻合
 */
public class HelloWorld {
    public String sayHello() {
        return "Hello,Maven";
    }

    public static void main(String[] args) {
        System.out.println(new HelloWorld().sayHello());
    }
}