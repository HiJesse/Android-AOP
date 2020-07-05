Android-AOP
---

文档 : [Android 开发中使用 AOP](http://blog.csdn.net/l2show/article/details/63684383)


## Android Gradle AOP 插件

基于AspectJ 1.9.0版本实现的Gradle插件.在根项目的`build.gradle`引入插件依赖. 

```
buildscript {
    repositories {
        ...
        mavenCentral()
        ...
    }
    dependencies {
        ...
        classpath 'com.github.hijesse:android-aop:1.9.0'
        ...
    }
}
```

在需要使用AOP编译的Application或Library模块的`build.gradle`文件中引入AOP插件. 引入插件后再编译期会同步java配置并初始化AspectJ compiler.

```
apply plugin: 'cn.jesse.aop.android-aop'
```

## 插桩使用

具体使用示例可以参考`sample/ActivityAop`或上面的文档.