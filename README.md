# creative-personal-backend 个人工具箱项目

# 更新日志：

## 20230624
全局异常封装，使用切面完成


## 20230511
1、新增（查询全部用户列表）接口，引入**pageHelper**，实现分页查询  

2、接口请求的返回结果统一格式，使用UnionReturnConfig配置来全局实现



## 20230324
1、加入日志打印切面**RequestLogAspect**，所有的web请求都打印出来入参、出参  

2、引入时间工具类DateUtils，包含各类时间操作方法


## 20230301

配置mysql数据库，并引入**MyBatis PLUS**, 提高增删改查的效率  

建表user 并以此为案例 新建web请求接口 串起来模块内各层


## 20230227 

Java后端工程模板  **maven多模块管理**，分为:

-- backend-common ： 公共模块，存放通用组件

-- backend-dao ： 数据持久层，与数据库进行交互，实现数据访问。

-- backend-manager ：封装通用业务处理逻辑，如缓存、中间件处理等。与DAO层交互，对多个DAO的组合复用。

-- backend-servcie ：相对具体的业务逻辑服务层，一般不可复用

-- backend-web： 请求处理层，处理访问控制、参数校验等基本操作。




