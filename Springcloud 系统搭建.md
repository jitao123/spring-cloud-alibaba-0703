# Springcloud 基础搭建 

本文所有的截图都在同文件夹下的ScreenImg文件夹里面



编写快捷键

typora的无序列表快捷键

option+command+u

typora的有序列表快捷键

option+command+o





# 1,微服务治理方案网站

本来是华为云的东西，现在捐献给了apache。  [Servicecomb](http://servicecomb.apache.org/)

# 2，创建项目

1. 新建maven项目 新建的时候，直接选择maven项目，然后一步步的新建，新建完成后，直接删除src文件夹，因为这是父级依赖项目不需要写代码，只是来依赖文件
2. 依赖的maven

```

    <!--    依赖父工程-->
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>2.1.3.RELEASE</version>
    </parent>
    <!--    依赖版本的锁定-->

    <properties>
        <java.version>1.8</java.version>
        <project.build.sourceEncoding>UTF- 8</project.build.sourceEncoding>
        <project.reporting.outputEncoding>UTF -8</project.reporting.outputEncoding>
        <spring-cloud.version>Greenwich.RELEASE</spring-cloud.version>
        <spring-cloud-alibaba.version>2.1.0.RELEASE</spring-cloud-alibaba.version>
    </properties>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.springframework.cloud</groupId>
                <artifactId>spring-cloud-dependencies</artifactId>
                <version>${spring-cloud.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>

            <dependency>
                <groupId>com.alibaba.cloud</groupId>
                <artifactId>spring-cloud-alibaba-dependencies</artifactId>
                <version> ${spring-cloud-alibaba.version} </version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>


```

2.1 建立主体类domian 

```
Order
Product
User
```

2.2 建立user的微服务模块

```
1创建模块导入依赖.
2创建SpringBoot主类
3加入配置文件
4创建必要的接口和实现类(controller service dao)
```

2.3  建立Product的微服务模块  步骤同上

2.4 建立Order的微服务模块 步骤同上

### nacos 服务注册与发现 

（等价于erkua+config）

1,服务端

```
3.3.1搭建nacos环境
第1步:安装nacos
下载地址: https://github.com/alibaba/nacos/releases
下载zip格式的安装包，然后进行解压缩操作
第2步:启动nacos
#切换目录
cd nacos/bin
#命令启动  
sudo sh startup.sh -m standalone  
如果上述命令启动失败，切换当前用户 为root用户   
命令 sudo su 
再重复输入命令 sh startup.sh -m standalone  
关闭指令
sh shutdown.sh
第3步:访问nacos
打开浏览器输入http://localhost:8848/nacos.即可访问服务,默认密码是nacos/nacos
关闭命令 当nacos/bin 文件夹下

sh shutdown.sh
```

2，客户端

```
1，加入maven依赖
 <!--nacos客戸端-->
        <dependency>
        <groupId>com.alibaba.cloud</groupId>
        <artifactId>spring-cloud-starter-alibaba-nacos-discovery</artifactId>
        </dependency>
        
2，在启动类山面添加注解
@EnableDiscoveryClient
3,在yml文件中进行配置
spring
	  cloud:
     nacos:
      discovery:
        server-addr: localhost:8848
```

3, 在服务中进行相互调用

```

        // 获取服务的集群list 
        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");

        // 因为没有集群所以直接获取第一个
        ServiceInstance instance = instances.get(0);

        //获取地址和端口号
        Product product = restTemplate.getForObject("http://"+instance.getHost()+":"+instance.getPort()+"/product/" + pid, Product.class);

```

4，负载均衡

```
1，上述代码中的相互调用代码存在一定问题，如果微服务存在集群，那么永远调用的是第一个服务

负载均衡分为客户端和服务端的负载均衡
客户端主要用nginx  
```

5，在idea中模仿一个服务的集群

```
1，在启动配置里面加入一个springboot的启动配置
2，选择springboot ，点击加号
3，然后点击启动后，在nacos网站里面查看就会发现product的启动服务实例已经变成了2个
```

![image-20200718163145786](/Users/edz/Downloads/allCodeWorkSpace/learnJaveCode/spring-cloud-alibaba-0703/ScreenImg/image-20200718163145786.png)

![image-20200718163732731](/Users/edz/Downloads/allCodeWorkSpace/learnJaveCode/spring-cloud-alibaba-0703/ScreenImg/image-20200718163732731.png)

![image-20200718164158505](/Users/edz/Downloads/allCodeWorkSpace/learnJaveCode/spring-cloud-alibaba-0703/ScreenImg/image-20200718164158505.png)



### idea 中调试多个微服务的快捷管理

```
1，找到springcloud项目下面的.idea 文件夹 里面的workspace.xml 文件
2，找到文件中的RunDashboard 
3，在   <component name="RunDashboard">中加入
 <option name="configurationTypes">
      <set>
        <option value="SpringBootApplicationConfigurationType" />
      </set>
    </option>
4，保存
5，关闭当前所有的服务，重启项目就可以看见快捷管理了
```

![image-20200718165844278](/Users/edz/Downloads/allCodeWorkSpace/learnJaveCode/spring-cloud-alibaba-0703/ScreenImg/image-20200718165844278.png)

### 基于ribbon实现负载均衡

```
1，在restTemplate的bean实列注入的地方加上注解
@LoadBalanced 注解 
2，在代码中删去原来的查找服务名和服务端口的代码，直接用服务的server-name 
Product product = restTemplate.getForObject("http://service-product/product/" + pid, Product.class);
```

默认的策略是轮询

七种负载均衡的策略如下

![image-20200718172652796](/Users/edz/Downloads/allCodeWorkSpace/learnJaveCode/spring-cloud-alibaba-0703/ScreenImg/image-20200718172652796.png)

##### 改变策略的方法

```
在被调用的服务里面进行配置

service-product: # 调用提供者的名称
  ribbon: # 固定写法
    NFLoadBalancerRuleClassName: com.netflix.loadbalancer.RandomRule
```

示列代码

```
//resultful风格
    @RequestMapping("/order/prod/{pid}")
//    基于ribbon 实现负载均衡
    public Order order(@PathVariable("pid")Integer pid){
        log.info("接收到--"+pid+"\n");
        log.info("调用微服务--");
        //获取地址和端口号
        Product product = restTemplate.getForObject("http://service-product/product/" + pid, Product.class);

        log.info(JSON.toJSONString(product));

        Order order = new Order();

        order.setNumber(1);
        order.setUid(1);
        order.setUsername("测试用户");

        order.setPid(pid);
        order.setPname(product.getPname());
        order.setPprice(product.getPprice());
        order.setNumber(1);

        orderService.creatOrder(order);

        log.info("========"+JSON.toJSONString(order));
        return order;
    }

```

### 基于feign实现服务调用

1，定义

```
	Feign是Spring Cloud提供的一个声明式的伪Http客户端，它使得调用远程服务就像调用本地服务-样简单,只需要创建一个接口并添加一个注解即可。
	Nacos很好的兼容了Feign, Feign默认集成了Ribbon, 所以在Nacos下使用Eegin默认就实现了负载均衡的效果。
```

2，restTemplate的缺点

```
1，直接拼接url，代码可读性不好
2，编程，代码风格不一样
```

3，使用方法步骤

3.1  加入坐标

```
<! --feginlff-->
<dependency>
<groupId>org.springframework.cloud</groupId>
<artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
// 当前是order订单微服务进行远程调用，所有在order服务的依赖里面加入坐标
```

3.2 在该项目的启动类（主类）上面加入注解

```
@EnableFeignClients  //开启客户端
```

3.3 新建一个服务类 

```
在上面加入注解 @FeignClient("调用服务的服务名")
// 作用，指定nacos下的具体微服务名称
@FeignClient("service-product")
public interface IProductService
```

3.4 在类中定义方法，在方法的上面加上远程的url

```
  /**
     * resultFul 风格定制接口
     * @param pid
     * @return
     */
    @RequestMapping("/product/{pid}")
    Product getProductByPid(@PathVariable Integer pid);
```

3.5 在controller中的调用

```
  //像本地方法注入service调用里面的方法  
  //像调取本地方法一样调用远程服务
    @Autowired
    private IProductService productService;
```

### Sentinel--服务容错



#### jmeter压力测试工具

解压完成后的bin目录中比较重要的三个文件

1，jmeter.bat     jmeter的启动文件

2，jmeter.properties     jmeter的配置文件

可以在 jmeter.properties 文件中找到37行，将界面语言设置为 language=zh_CN

3 ，jmeter.sh

启动方法，windows 直接双击jmeter.bat 文件  ，Mac 版本 进入到jmeter文件的bin文件夹 

然后 使用输入命令 sh jmeter.sh 就启动了



新建测试用例用列

![image-20200805151921889](/Users/edz/Downloads/allCodeWorkSpace/learnJaveCode/spring-cloud-alibaba-0703/ScreenImg/image-20200805151921889.png)

线程中的设置

![image-20200805152316934](/Users/edz/Downloads/allCodeWorkSpace/learnJaveCode/spring-cloud-alibaba-0703/ScreenImg/image-20200805152316934.png)

http取样器

![image-20200805152607876](/Users/edz/Downloads/allCodeWorkSpace/learnJaveCode/spring-cloud-alibaba-0703/ScreenImg/image-20200805152607876.png)

参数配置

![image-20200805153548748](/Users/edz/Downloads/allCodeWorkSpace/learnJaveCode/spring-cloud-alibaba-0703/ScreenImg/image-20200805153548748.png)



查看结果树

![image-20200805153741732](/Users/edz/Downloads/allCodeWorkSpace/learnJaveCode/spring-cloud-alibaba-0703/ScreenImg/image-20200805153741732.png)

点击启动按钮，最后就能看见结果树中的效果了

#### 服务雪崩的雏型

当一个接口请求的数量超过了服务器的最大线程数量，就会导致其他的接口访问非常慢，如果请求的数量大大的超过了服务器的承受能力，就会导致其他的接口无法访问

#### 服务的容错

雪崩发生的原因多种多样，有不合理的容量设计,或者是高并发下某一个方法响应变慢,亦或是某台机器的资源耗尽。我们无法完全杜绝雪崩源头的发生，只有做好足够的容错，保证在一个服务发生问题， 不会影响到其它服务的正常运行。也就是"雪落而不雪崩"

#### 常见的容错思路

常见的容错思路有隔离、超时、限流、熔断、降级这几种，下面分别介绍一下。

##### 隔离

它是指将系统按照一定的原则则分为若干个服务模块， 各个模块之间相对独立,无强依赖。当有故障发生时,
能将问题和影响隔离在某个模块内部，而不扩散风险,不波及其它模块，不影响整体的系统服务。常见的隔离
方式有:线程池隔离和信号量隔离.

##### 超时

在上游服务调用下游服务的时候，设置一个 最大响应时间，如果超过这个时间，下游未作出反应， 就断开请求,释放掉线程。

##### 限流

限流就是限制系统的输入和输出流量已达到保护系统的目的。为了保证系统的稳固运行，一旦达到的需要限制的阈值,就需要限制流量并采取少量措施以完成限制流量的目的。

比如一个服务里设置每秒钟只处理3个请求 ，超过3个请求就只能排队

##### 熔断

在互联网系统中，当下游服务因访问压力过大而响应变慢或失败，上游服务 为了保护系统整体的可用性，可以暂时切断对下游服务的调用。这种牺牲局部，保全整体的措施就叫做熔断。

服务熔断一般有三种状态:
。熔断关闭状态(Closed)
服务没有故障时，熔断器所处的状态，对调用方的调用不做任何限制
。熔断开启状态(Open)
后续对该服务接口的调用不再经过网络，直接执行本地的fallback方法
。半熔断状态(Half-Open)
尝试恢复服务调用，允许有限的流量调用该服务，并监控调用成功率。如果成功率达到预期，则说明服务
已恢复，进入熔断关闭状态;如果成功率仍旧很低，则重新进入熔断关闭状态。

熔断的简单总结（发现你不行了，我就断一会,过一会我再试试，
行就再用你不行就接着断）

##### 降级

降级其实就是为服务提供一个托底方案，一旦服务无法正常调用，就使用托底方案。

#### 常见的容错组件

●Hystrix
Hystrix是由Netflix开源的一个延迟和容错库，用于隔离访问远程系统、服务或者第三方库，防止级联失败,从而提升系统的可用性与容错性。
●Resilience4J
Resilicence4I-款非常轻量、简单，并且文档非常清晰、丰富的熔断工具，这也是Hystrix官方推荐的替代产品。不仅如此，Resilicence4j还原生支持Spring Boot 1.x/2.x,而且监控也支持和prometheus等多款主流产品进行整合。

### Sentinel

Sentinel是阿里巴巴开源的一款断路器实现，本身在阿里内部已经被大规模采用，非常稳定。

Sentinel (分布式系统的流量防卫兵)是阿里开源的一套用于服务容错的综合性解决方案。它以流量为切入
点从流量控制、 熔断降级、系统负载保护等多 个维度来保护服务的稳定性。

#### Sentinel具有以下特征:

●丰富的应用场景: Sentinel 承接了阿里巴巴近10年的双十一大促流量的核心场景，例如秒杀(即突发流量控
制在系统容量可以承受的范围)、消息削峰填谷、 集群流量控制、实时熔断下游不可用应用等。
●完备的实时监控: Sentinel 提供了实时的监控功能。通过控制台可以看到接入应用的单台机器秒级数据，甚至
500台以下规模的集群的汇总运行情况。
●广泛的开源生态: Sentinel提供开箱即用的与其它开源框架/库的整合模块，例如与Spring Cloud、 Dubbo、
gRPC的整合。只需要引入相应的依赖并进行简单的配置即可快速地接入Sentinel。
●完善的SPI扩展点: Sentinel 提供简单易用、完善的SPI扩展接口。您可以通过实现扩展接口来快速地定制逻
辑。例如定制规则管理、适配动态数据源等。

#### Sentinel分为两个部分:

●核心库(ava客户端)不依赖任何框架/库，能够运行于所有Java运行时环境，同时对Dubbo / Spring Cloud
等框架也有较好的支持。
●控制台(Dashboard) 基于Spring Boot开发,打包后可以直接运行，不需要额外的Tomcat等应用容器。

#### Sentinel的引入

1，引入需要在上游引入，就是被调用的地方引入比如，order需要调用product

中的方法，就需要在order项目中引入Sentinel

```
   <!--  Sentinel  -->
        <dependency>
            <groupId>com.alibaba.cloud</groupId>
            <artifactId>spring-cloud-starter-alibaba-sentinel</artifactId>
        </dependency>
```

2，控制台(Dashboard)整合

[github.com/alibaba/Sentinel/releases](控制台(Dashboard)的下载地址)

```
启动命令
// 监听端口 -Dserver.port=8080
// -Dcsp.sentinel.dashboard.server=1ocalhost:8080  服务发现地址
// -Dproject.name=sentine1-dashboard 项目名称
// jar sentinel-dashboard-1.7.0.jar 启动jar包

java -Dserver.port=8080 -Dcsp.sentinel.dashboard.server=1ocalhost:8080 -Dproject.name=sentine1-dashboard -jar sentinel-dashboard-1.7.0.jar

本机地址的jar包路径
java -Dserver.port=8080 -Dcsp.sentinel.dashboard.server=1ocalhost:8080 -Dproject.name=sentine1-dashboard -jar /Users/edz/Downloads/allCodeWorkSpace/learnJaveCode/sentinel-dashboard-1.8.0.jar 
```

3，在所需配置的路径中编写配置

需要在cloud下面同级的位置编写配置

```
  cloud:
    nacos:
      discovery:
        server-addr: localhost:8848
    sentinel:
      transport:
        port: 9999 #跟控制台 交流的端口随意指定 一个未使用的端口即可
        dashboard: localhost:8080  #指定控制台服务的地址
```

4，启动后访问sentinel 

在启动的jar包指令里面，自定义的地址，访问就可以看见网页了，初始化密码都是sentinel和sentinel

[localhost:8080](在启动的jar包指令里面，自定义的地址，访问就可以看见网页了，初始化密码都是sentinel和sentinel)

5,懒加载机制

启动配置了sentinel的微服务，当访问本机启动的sentinel 发现没有注册到已经定义的微服务的时候，只需要访问一下该微服务定义的接口就可以在sentinel网站中加载到了

![image-20200825151203212](/Users/edz/Downloads/allCodeWorkSpace/learnJaveCode/spring-cloud-alibaba-0703/ScreenImg/image-20200825151203212.png)

