# senpure-io-server 的使用实例

 **有状态的(长连接)** 分布式集群框架探索实例。用户端连接一个网关端口，不需要知道具体的服务有多少实例ip和端口是多少。
服务实例启动的时候注册到网关。用户的所有请求经过网关转发的具体的服务实例，服务实例的消息经过网关下发给具体的用户。
 网关，服务，服务实例，都是可以 动态扩展的。

## 名词解释

1. 网关
   + 消息转发中间站
2. 服务
    + 可以独立运行的源程序，如一个登陆服务，一个游戏副本程序。
3. 服务实例 
    + 一个服务的具体运行实例 一个服务可能运行多个服务实例在同一个电脑或不同的电脑上
    ，同一个服务的不同的服务实例它们的功能可能相同也可能不同。
4. 用户
   + 使用服务的人或程序    


## senpure-io-server功能

1. 服务实例的动态增加或减少
2. 服务实例功能增量更新
   + 可在用户正在使用服务的过程中，更新新功能。 新连接的用户
   使用新增加的服务，原先的用户 使用完成旧服务后， 再次使用服务会无感知使用新服务
3. 用户快速加入场景   
   + 如玩家A 只知道一个为666666的房间号，不在需要其他参数，即可加入房间
4. 服务间的互相同步调用或异步调用    
5. 用户同步调用服务或异步回调服务   
6. 可降级为直连模式 
   + 用户直接连接服务实例
    
## 本程序功能

本程序模拟一个运动游戏，提供了足球游戏和排球游戏的玩法(具体并没有实现，使用hello world代替)。玩家(用户)
登陆游戏后，可进行创建房间，然后邀请玩家一起游戏的玩法。通过登陆，登陆同一个账号，账号切换，加入房间，游戏掉线，功能更新等
功能探索 senpure-io-server 的可行性。

## 模块介绍

|     模块   | 说明                                                             | 备注             |
|:------------|:--------------------------------------------------------------------|:-----------------|
|senpure-sport-admin|性能统计模块||
|senpure-sport-bean|通信协议模块||
|senpure-sport-client|使用javafx模拟游戏客户端||
|senpure-sport-data|数据服务模块提供登陆，玩家信息查询等功能，因为是简单实现并没有做持久化等功能，本例子中不能运行多实例||
|senpure-sport-eureka|依赖spring-cloud的注册中心，可更换|要运行多实例需要修改配置，没有必要|
|senpure-sport-gateway|网关，可运行多实例||
|senpure-sport-football|模拟的足球玩法，可运行多实例||
|senpure-sport-volleyball|模拟的排球玩法，可运行多实例||
|senpure-sport-dispatcher|房间号分配器与雪花算法分配器，可运行多实例||
|senpure-sport-helper|帮助一键更改其他模块配置，生成快捷启动方式的工具||
|products|执行maven package 生成的可运行程序||

## 功能体验

1. 将 [senpure](https://github.com/senpure/senpure) 导入本地 执行 maven install
   + 如果下载的products体验包可直接跳到第三步
2. 将 [senpure-sport](https://github.com/senpure/senpure-sprot) 导入本地 执行maven package
3. 进入products/senpure-sport-helper 修改application.properties配置
   + |     配置   | 说嘛                                                              | 备注             |
     |:------------|:--------------------------------------------------------------------|:-----------------|
     |helper.generateBatLink | 是否生成快捷模式|默认 true 注意杀毒软件会进行拦截|
     |helper.databaseUrl | 数组库地址|默认 localhost:3306|
     |helper.databaseUsername | 数组库账号|默认 root|
     |helper.databasePassword | 数组库密码|默认 root|
     |helper.eurekaServiceUrl | 注册中心地址|默认 localhost:8761|
     |helper.gatewayUseCode | 网关直接使用硬配置|默认 false|
4. 执行products/senpure-sport-helper下的start.bat
   + 该操作会修改好所有的配置文件，并且在products目录下生成快捷启动方式如果helper.generateBatLink配置为tue的话。
   + 没有什么特别情况只需要修改数据库地址，账号，密码即可
5. 启动 senpure-sport-eureka 模块
   + 启动过程中会有一些错误信息，是正常情况
6. 启动 senpure-sport-dispatcher 
   + 可不启动该模块
7. 启动 senpure-sport-gateway,senpure-sport-data 等其他任意模块不分先后顺序
8. senpure-sport-dispatcher 如果没有启动
   + senpure-sport-gateway ,senpure-sport-football , senpure-sport-volleyball不支持多实例。
    
如果电脑配置有些低将全部服务在一台电脑启动可能会有卡顿。
    

   

