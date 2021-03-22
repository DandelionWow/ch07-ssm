ch07-ssm : SSM整合开发

SSM整合，整合中有容器。
1.第一个容器SpringMVC容器，管理COntroller控制器对象的
2.第二个容器Spring容器，管理Service，Dao，工具类对象的
我们要做的是 把使用的对象交给适合的容器对象创建和管理。
把Controller还有Web开发的相关对象，交给SpringMVC容器，这些web用的对象写在SpringMVC配置文件中

service，dao对象定义在spring的配置文件中，让spring管理这些对象。

SpringMVC容器和Spring容器是有关系的：
    SpringMVC容器是Spring容器的子容器，类似于java中的继承。
    子容器中的Controller可以访问父容器中的Service对象，就可以实现Controller使用Service对象

实现步骤：
0.使用mybatis_st的mysql数据库， 表使用student (id auto_increment, name, age)

1.新建maven web项目

2.加入依赖
    springmvc, spring, mybatis三个框架的依赖，jackson依赖，mysql驱动，druid连接池
    jsp, servlet依赖

3.写web.xml
    1)注册DispatcherServlet,目的：1.创建springmvc容器对象，才能创建Controller类对象。
                                 2.创建的是Servlet，才能接受用户的请求。

    2)注册spring的监听器：ContextLoaderListener,目的：创建Spring的容器对象，才能创建Service，Dao等对象

    3)注册字符集过滤器，解决post请求乱码的问题

4.创建包，Controller包，，，service  dao，，，实体类包

5.写SpringMVC，Spring，MyBatis配置文件
    1)SpringMVC
        组件扫描器
        jsp路径
        注解驱动
    2)Spring
        声明jdbc配置文件扫描器
        声明数据源
        声明SqlSessionFactoryBean创建SqlSessionFactory
        声明mybatis的扫描器
        声明service的注解
        声明事务配置
    3)MyBatis
    4)数据库属性配置文件

6.写代码，dao接口和mapper文件，service和实现类，controller,实体类

7.写jsp页面