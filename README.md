## OSS
一个用于**学习**、**记录**、**研究**以及**维护**的[项目](http://www.notreami.com)。

### 一，项目计划
（1）一个gradle项目管理，maven包管理的javaweb项目；

（2）规范java文件、配置文件以及view文件存放目录。（遵守gradle默认的web项目目录分布约定）；

（3）servlet、jsp基础搭建

（4）SSM架构搭建；

### 二，servlet、jsp基础学习和记录
#### 1，web.xml
* web-app
* icon
* display-name
* description
* context-param
* listener
* filter
* servlet
* session-config
* welcome-file-list
* error-page

web.xml的加载顺序是：
	
	ServletContext->context-param->listener->filter->servlet

而同一类型之间的调用顺序是根据对应的mapping的顺序进行调用的。

#### 2，Servlet
（1）普通型

（2）异步处理

（3）新增注解

（4）可插性(web-fragment)

 需要导出对应的jar(META-INF和java包代码)
#### 3，Filter
（1）普通型

（2）注解
#### 4，Listener
（1）普通型

（2）注解

### 三，JSP、EL、JSTL学习和记录
#### 1，JSP
（1）脚本元素
#### 2，EL
#### 3，JSTL


### 四,Mybatis





备忘:主题,国际化