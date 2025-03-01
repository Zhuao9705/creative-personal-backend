# creative-personal-backend

更新日志：

20230227 Java后端工程模板，集成了通用能力，帮助快速创建新应用

maven多模块管理，分为:

-- backend-common ： 公共模块，存放通用组件

-- backend-dao ： 数据持久层，与数据库进行交互，实现数据访问。

-- backend-manager ：通用处理层，封装通用业务处理逻辑，如缓存、中间件处理等；与DAO层交互，对多个DAO组装复用。

-- backend-servcie ：业务逻辑层，实现具体的业务逻辑

-- backend-web： 请求处理层，处理访问控制、参数校验等基本操作。




