# wfx

wfx

    1）统一管理模块 
    2）锁定jar包的版本 
    3）打包方式：pom dependencyManagement:锁定版本，不会产生依赖

wfx_entity 

    1）打包方式：jar，为别的模块提供依赖 
    2）依赖：lombok 
    3）Database Generator插件：可以逆向生成实体类，同时可以管理数据

wfx_dao 

    1）继承父工程 
    2）依赖：wfx_entity、mybatis、jdbc、dataSource

wfx_service 

    1）继承父工程 
    2）依赖：wfx_dao
    