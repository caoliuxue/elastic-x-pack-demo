# elastic-x-pack-demo
## 如果elastic启用了x-pack的security管理，核心配置如下
### maven依赖中如下配置不可缺少，否则报错
~~~
		<!--es with x-pack core dependencies-->
 		<dependency>
 			<groupId>org.elasticsearch.client</groupId>
 			<artifactId>transport</artifactId>
 			<version>5.4.0</version>
 		</dependency>
 		<dependency>
 			<groupId>org.apache.logging.log4j</groupId>
 			<artifactId>log4j-api</artifactId>
 			<version>2.8.2</version>
 		</dependency>
 		<dependency>
 			<groupId>org.apache.logging.log4j</groupId>
 			<artifactId>log4j-core</artifactId>
 			<version>2.8.2</version>
 		</dependency>
 		<dependency>
 			<groupId>org.elasticsearch.client</groupId>
 			<artifactId>x-pack-transport</artifactId>
 			<version>5.4.0</version>
 		</dependency>
 		<!--es with x-pack core dependencies-->
 		

 		
~~~    
### java中配置
~~~        
    Settings settings = Settings.builder() 
             .put("cluster.name", "dev-es")
             .put("xpack.security.user", "ovp-dev:ovp-dev")
             .build();
      
~~~
~~~
    使用PreBuiltXPackTransportClient而不是PreBuiltTransportClient
~~~             
             
             