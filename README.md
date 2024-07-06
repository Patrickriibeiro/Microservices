# microservices
Microservices utilizando: Feign, Eureka, Spring Cloud LoadBalancer, Resilience4j, Swagger OpenAPI, Docker, Zipkin e Sleuth.


Flyway : O Flyway é uma ferramenta poderosa para gerenciamento de versões de banco de dados e é totalmente compatível com o Spring Boot e MySQL.

Obs: FlyWay decidiu separar as implementações. Por isso hoje precisamos adicionar o FlyWay core e uma nova dependência específica para trabalhar com o MySQL ou o MariaDB se for o caso.

<dependency>
   <groupId>org.flywaydb</groupId>
   <artifactId>flyway-core</artifactId>
</dependency>
por

<dependency>
   <groupId>org.flywaydb</groupId>
   <artifactId>flyway-mysql</artifactId>
</dependency>
