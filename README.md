# microservices
Projeto de estudo microservices : Microservices utilizando: Feign, Eureka, Spring Cloud LoadBalancer, Resilience4j, Swagger OpenAPI, Docker, Zipkin e Sleuth.


Flyway : O Flyway é uma ferramenta poderosa para gerenciamento de versões de banco de dados e é totalmente compatível com o Spring Boot e MySQL.

Obs: FlyWay decidiu separar as implementações. Por isso hoje precisamos adicionar o FlyWay core e uma nova dependência específica para trabalhar com o MySQL ou o MariaDB se for o caso.

os V1, V2, V3 são as ordens que o flyway irá executar os scripts, atenção nessa questão.

<dependency>
   <groupId>org.flywaydb</groupId>
   <artifactId>flyway-core</artifactId>
</dependency>
por

<dependency>
   <groupId>org.flywaydb</groupId>
   <artifactId>flyway-mysql</artifactId>
</dependency>





Feign : O Feign é uma biblioteca Java criada pela Netflix que facilita a criação de clientes HTTP para se comunicar com APIs REST. Ele oferece uma maneira simples e declarativa de definir as interações HTTP, abstraindo a complexidade de lidar com chamadas HTTP diretamente. Aqui estão alguns dos principais conceitos e características do Feign:

Principais Características do Feign
Declarativo: Com Feign, você define interfaces e as anota com informações sobre as requisições HTTP, como endpoints e métodos HTTP (GET, POST, etc.).
Integração Simples com Spring: Feign é amplamente usado em projetos Spring Boot, especialmente em arquiteturas de microsserviços. Com a anotação @EnableFeignClients, você pode habilitar facilmente o Feign no seu projeto.
Reduz a Verbosidade: Em vez de escrever código boilerplate para realizar chamadas HTTP, você simplesmente define métodos nas interfaces e Feign cuida do resto.
Configuração de Timeout e Retry: Você pode configurar facilmente comportamentos como tempo de espera (timeout) e tentativas (retry) diretamente nas interfaces ou em configurações globais.
Interceptors e Customização: Feign permite a adição de interceptors para adicionar cabeçalhos personalizados, autenticação, logging, etc.
Suporte a Hystrix: Integrado com Hystrix para fornecer tolerância a falhas e circuit breakers.

<dependency>
	<groupId>org.springframework.cloud</groupId>
	<artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>



Eureka discovery/registry : Eureka é um serviço de registro de serviços desenvolvido pela Netflix como parte do seu conjunto de ferramentas de infraestrutura. Ele é um componente essencial para arquiteturas de microsserviços, permitindo que serviços descubram e se comuniquem uns com os outros. Aqui está um detalhamento sobre o Eureka:

Principais Características do Eureka
Registro de Serviços: Serviços (ou instâncias de aplicativos) se registram com o servidor Eureka, fornecendo suas informações de localização (como URLs) para que outros serviços possam encontrá-los.
Descoberta de Serviços: Serviços clientes podem consultar o servidor Eureka para obter a localização de outros serviços registrados. Isso permite a comunicação dinâmica e a escalabilidade entre microsserviços.
Alta Disponibilidade: Eureka suporta configuração em cluster para alta disponibilidade. Vários servidores Eureka podem replicar informações entre si para garantir que o registro de serviços esteja sempre disponível.
Auto-Regeneração: Serviços que se registram no Eureka precisam enviar batimentos cardíacos (heartbeats) periodicamente. Se o Eureka não receber um heartbeat dentro de um período específico, ele considera que o serviço está offline e remove-o do registro.
Integração com Spring Cloud: Spring Cloud Netflix facilita a integração do Eureka em aplicações Spring Boot, tornando o processo de registro e descoberta de serviços mais simples.


spring cloud routing (gateway) :  O Spring Cloud Gateway é um projeto da Spring que fornece uma solução de roteamento API baseada em microserviços. Ele é uma alternativa moderna ao Zuul, com foco em flexibilidade e desempenho. Abaixo, vou detalhar os principais conceitos e funcionalidades do Spring Cloud Gateway:

Conceitos Principais
Route (Rota):

Uma rota é o conceito central no Spring Cloud Gateway. Cada rota é composta por um identificador, um predicado e uma lista de filtros.
O predicado é uma condição que, se satisfeita, ativa a rota (por exemplo, correspondência de caminho de URL).
Os filtros podem modificar a solicitação ou resposta antes ou depois de rotear para o destino.
Predicate (Predicado):

Predicados são condições que verificam se uma rota deve ser aplicada a uma solicitação. Exemplos incluem correspondência de caminho de URL, cabeçalhos HTTP, parâmetros de consulta, etc.
Filter (Filtro):

Filtros permitem a modificação de solicitações e respostas. Eles podem ser de pré-rota (modificando a solicitação antes de enviá-la ao destino) ou de pós-rota (modificando a resposta antes de enviá-la de volta ao cliente).
Funcionalidades
Roteamento Dinâmico:

O Spring Cloud Gateway permite definir rotas dinamicamente, facilitando a configuração e a manutenção dos caminhos de roteamento.
Resiliência:

Integrado com circuit breakers (como o Resilience4j), permitindo a implementação de padrões de resiliência.
Escalabilidade e Performance:

Baseado no Netty, um framework de rede assíncrono de alto desempenho, o que o torna altamente escalável e eficiente em termos de performance.
Segurança:

Integração com OAuth2, JWT e outros padrões de segurança, facilitando a autenticação e autorização.
Facilidade de Configuração:

Rotas, predicados e filtros podem ser configurados de forma declarativa usando arquivos de configuração YAML ou programaticamente através de Java.

O Circuit Breaker e as bibliotecas do Resilience4j são ferramentas poderosas para construir sistemas resilientes e estáveis, especialmente em ambientes de microserviços e sistemas distribuídos. Utilizar esses padrões ajuda a gerenciar falhas, controlar a taxa de solicitações e isolar componentes, aumentando a robustez e a capacidade de recuperação das aplicações.

Comando para alterar porta da aplicação em VM ARGUMENTS : -Dserver.port="Porta desejada". 

Caso alguém tenha interesse : 
Curso Erudio : https://www.udemy.com/course/microservices-do-0-a-gcp-com-spring-boot-kubernetes-e-docker/learn/lecture/26012946#overview
