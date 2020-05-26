#`一 init`

    1.创建maven工程,引入依赖
    2.编写servlet类,以及jsp文件
    3.运行访问:http://localhost:8080/simple-framework/hello
    
#`二至五是知识串讲,是贯穿spring核心的底层知识`

#`二 泛型是编译器的约束,编译后会擦除泛型信息`

    1.证明:编译泛型类查看.class文件会发现是没有泛型的
    2.泛型不支持继承:
    3.解决:
    com.demo.demo.generic.GenericDemo.main
        1.使用通配符,不指定具体类型,使用时进行强转,这样会使得泛型检查失去意义,和泛型设计初衷是相悖的
        2.给泛型加上边界   <? extends E>   
        3.给泛型加下边界  泛型实参的子类必须是E  ->从避免运行时 参数类型转换异常的角度讲: 这种方式是相较上面两种最安全的

#`三 工厂模式`

    1.简单工厂:
        提供统一的工厂类实现工厂抽象接口,根据客户端指定类型,判断创建所需的类型
        缺点:每次新增需求,都需要在工厂实现类新增代码,违背了开闭原则
        com.demo.pattern.simple.MouseFactory
        
    2.工厂模式
        将工厂抽象出来:com.demo.pattern.method.MouseFactory
        当需要新的类类型,只需新增工厂实现类,不影响之前代码
        缺点:添加新产品时时,还需添加徐其数量相对的工厂实现了类,'拖家带口',增加了系统的复杂度,代码臃肿
             只支持同一类产品的创建
             
    3.抽象工厂
        com.demo.pattern.abstractf.ComputerFactory
        提供一个创建一系列相关或相互依赖对象的接口
            抽象工厂模式侧重的是同一产品族->同时定义多个抽象
            工厂方法更加侧重同一产品等级
        解决了工会模式只支持生产一种产品的弊端
            新增一个产品族时,只需要增加一个新的具体工厂,不需要修改代码
        缺点
            更多的类型加入抽象工厂时,所有的实现都需要修改 --违背开闭原则
            
    4. spring的解决方案:
        结合了工厂模式和反射机制的spring-ioc容器值得借鉴
        
#`四 反射机制  --java.lang.reflect`
    
    1.允许程序在运行时进行自我检查,并对内部成员进行操作
    
    2.作用:
        在运行时判断任意一个对象所属的类
        在运行时获取类的对象
        在运行时访问java对象的属性,方法,构造方法等
        
    3.Class类:
        用来表示运行时类型信息的对应类
            每个类都有唯一一个与之对应的Class对象
            Class类为类类型,而Class对象为类类型对象
            
    4.Class类的特点:
        也是类的一种,class则是关键字(用来声明类)
        Class类只有一个私有的构造函数,只有JVM能够创建Class类的实例
        JVM中只有唯一一个和类相对应的Class对象来描述其类型信息(包名+类名+同一个类加载器创建出来的)
        @see java.lang.Class
        
    5.获取Class对象的三种方式
        Objec->getClass()  --实例方法
        任何数据类型(包括基本数据类型)都有一个'静态'的class属性  --静态方法
        通过Class类的静态方法: forName(String className)   --常用
        
    6.Class对象就像一面镜子,透过这面镜子可以看到类的结构
    
    7.反射的获取源?
        用xml来保存类相关的信息以供反射读取调用
        注解方式保存类相关的信息供反射调用
        
#`五 注解`

    1.提供一种为程序元素设置元数据的方法
        元数据是添加到程序元素如方法,字段,类,和包上的额外信息
        注解是一种分散式的元数据设置方式,XML是集中式的设置方式
        注解不能直接干扰程序代码的运行
        
    2.@see java.lang.annotation.Annotation
    3.所有注解都继承自 Annotation
        反编译注解的.class文件
            cd src/main/java/demo/annotation    javac TestAnnotation.java 
        javap -verbose annotation.TestAnnotation
            ->  public interface demo.annotation.TestAnnotation extends java.lang.annotation.Annotation

            
    4.注解的功能:
        作为特定的标记,告诉编译器一些信息
        编译时动态处理,如动态生成代码(如:lombok)
        运行时动态处理,作为额外信息的载体,如:获取注解信息
        
    5.注解的分类:
        5.1 标准注解: Overrride Desprecated SuppressWarnings
        5.2 元注解(用于定义注解的注解): @Target  @Retention  @Inherited @Documented
            @Target 注解的作用目标 
                @see java.lang.annotation.ElementType
            @Retention 注解的声明周期
                SOURCE  源代码保留,编译后会去除 
                CLASS   源代码+.class文件
                RUNTIME 运行时保留  如:@Autowired  --反射时也可从注解中获取额外信息
            @Documented  注解是否应当被包含在JavaDoc文档中
            @Inherited 是否允许子类继承该注解
        5.3 自定义注解
            注解支持的数据类型
                所有基本数据类型
                String类型
                Class类型
                Enum类型
                Annotation类型
                以上类型的数组
        5.4 Class Constructr Method Field 这些跟反射息息相关的类都实现了 AnnotatedElement 接口
            AnnotatedElement提供了多种方法来获取不同定义方式下的注解
                Annotation[] getAnnotations();
                <T extends Annotation> T getAnnotation(Class<T> annotationClass);
                default boolean isAnnotationPresent(Class<? extends Annotation> annotationClass)   指定类型注解是否存在于此元素上
        5.5 解析自定义注解:----附源码跟踪技巧
            demo.annotation.AnnotationParser
                main函数添加vm参数:-Djdk.proxy.ProxyGenerator.saveGeneratedFiles=true -XX:+TraceClassLoading    --保存代理对象,并打印程序所加载用到的类
                    可以看到生成了一个动态代理对象:$Proxy1.class   --com/sun/proxy/$Proxy1.class
                        源码剖析:com.sun.proxy.$Proxy1#gender   return (String)super.h.invoke(this, m6, (Object[])null);
                            调用了父类Proxy的invoke方法(区分于反射的同名方法)
                                查看java.lang.reflect.InvocationHandler实现了类:sun.reflect.annotation.AnnotationInvocationHandler
                                    侧面说明了spring的强大--合理的命名就能定位到实现类
        5.6 注解的工作原理
            通过键值对的形式为注解属性赋值
            编译器检查注解的使用范围,将注解信息写入元素属性表
            运行时JVM将RUNTIME的所有注解属性取出并并最终保存到map里   --这里指的是针对单个Class文件
            创建AnnotationInvocationHandler实例并传入前面的map
            JVM使用JDK动态代理为注解生成代理类,并初始化处理器
            调用invoke方法,通过传入(被加了目标注解的)方法名返回注解对应的属性值
            
    6.上述技术点对自研框架的意义:
        使用注解标记需要工厂管理的实例,并依据注解属性做精细控制
            spring:@Controller
            
    7.控制翻转IOC-Inversion of Control
        依托一个类似工厂的IoC容器
        将对象的创建,依赖关系的管理,以及生命周期交由IoC容器管理
        降低系统在实现上的复杂性和耦合度,易于扩展,满足开闭原则
        IOC是Spring Core最核心部分
        需要先了解依赖注入(Dependency Inversion)  --Set注入 接口注入 注解注入 构造器注入
            以行李箱设计为例
                轮子<--底盘<--箱体<--行李箱      上层建筑依赖下层建筑->可维护性低  轮子改了(如:修改构造函数),所有建筑构造函数全部都得改
                行李箱<--箱体<--底盘<--轮子      (注入)上层控制下层          
        IOC优势:
            避免在各处使用new来创建对象,并且可以做到统一维护
            创建实例时不需要了解其中细节
            反射+工厂模式的结合,满足开闭原则

#六 框架  
       
##### 1. 框架具备的最基本功能
    1.1 解析配置,如xml,注解等
    1.2 定位与注册对象
    1.3 注入对象
    1.4 提供通用工具类(非必要)
    
##### 2. IOC容器的实现
    1. 需要实现的点:
        创建注解->提取标记对象->实现容器->依赖注入
    2. extractPacakgeClass里面需要完成的事情
        获取到类的加载器
        通过类加载器加载到加载的资源信息
        依据不同的资源类型,采用不同的方式获取资源的集合
        
        2.1 获取项目类加载器的目的?
            获取项目发布的实际路径  如:com.demo
            
        2.2 为什么不让用户传入绝对路径?
            不够友好: 不同机器之间的路径可能不同
            如果打的是war包或者jar包,根本找不到路径
        
        2.3 类加载器ClassLoader
            *.java文件->Java编译器->字节码(.class文件)->类加载器Classloader->字节码校验器->解释器->操作系统平台
            根据一个指定类的名称,找到或者生成其对应的字节码
            加载Java应用所需的资源
            
            @see org.simpleframework.util.ClassUtil.getClassLoader
                java.lang.Thread.getContextClassLoader ->java.lang.ClassLoader.getResource  ->返回 java.net.URL
                    URL:协议+   域名(主机名)+端口号+      路+             请求参数+引用位置
                        http://www.news.cn.8080/Public/GetValidateCode?time=123#index
            获取包下类的集合
                org.simpleframework.util.ClassUtil.extractPackageClass
        2.4 单例模式 --确保一个类只有一个实例,并对外提供统一的访问方式   --阅读源码:  ObjectInputStream的readObject
            饿汉模式:
            懒汉模式
            加入双重检查锁机制的懒汉模式能确保线程安全
            装备了枚举的饿汉模式能低于反射与序列化的进攻,****满足容器需求****
    3. 实现容器
        保存Class对象及其实例的载体
        容器的加载
        容器的操作方式
        
        3.1 实现容器的加载
            配置的管理与获取
            获取指定范围内的Class对象  -> org.simpleframework.core.BeanContainer.BEAN_ANNOTATION
            一句配置提取Class对象,连同实例一并存入容器   -> org.simpleframework.core.BeanContainer.loadBeans
            -->测试:org.simpleframework.core.BeanContainerTest.loadBeansTest  对BeanContainer对象打端点进行跟踪更佳...
        3.2 实现容器的操作方式(容器的增删改查)
            增加删除操作  --org.simpleframework.core.BeanContainer.addBean  removeBean
            根据Class获取对应实例 --org.simpleframework.core.BeanContainer.getBean
            获取所有的Class实例  --org.simpleframework.core.BeanContainer.getClasses
            通过注解获取被注解标记的Class   org.simpleframework.core.BeanContainer.getClassesByAnnotation
            通过超类获取对应的子类Class    org.simpleframework.core.BeanContainer.getClassesBySuper     --验证isAssignableFrom()方法 ->demo.api.assignable.AssignableDemo
            获取容器载体保存Class的数量
        3.3 Spring框架作用域
            singleton
            prototype  每次getBean都产生新的实例
            request     每次http请求都产生新实例
            session session级别的
            globalsession 全局http session
    4.实现容器依赖注入
        目前容器里面的Bean实例仍可能是不完备的
            实例某些必须的成员变量还没被创建出来 ->引出依赖注入的概念
        实现思路
            定义相关的注解标签
            实现创建被注解标记的成员变量实例,并将其注入到成员变量
            依赖注入的使用
        核心方法实现:org.simpleframework.inject.DependencyInjector.doIoc 
        测试:org.simpleframework.inject.DependencyInjectorTest.doIocTest
            
            