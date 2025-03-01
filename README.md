# creative-personal-backend

# 更新日志：

## 20230301

配置mysql数据库，并引入mybatis plus, 提高增删改查的效率
建表user 并以此为案例 新建web请求接口 串起来模块内各层




## 20230227 

Java后端工程模板  maven多模块管理，分为:

-- backend-common ： 公共模块，存放通用组件

-- backend-dao ： 数据持久层，与数据库进行交互，实现数据访问。

-- backend-manager ：通用业务处理层，它有如下特征:

对第三方平台封装的层，预处理返回结果及转化异常信息;

对Service层通用能力的下沉，如缓存方案、中间件通用处理;

与DAO层交互，对多个DAO的组合复用.

-- backend-servcie ：相对具体的业务逻辑服务层，一般不可复用

-- backend-web： 请求处理层，处理访问控制、参数校验等基本操作。




