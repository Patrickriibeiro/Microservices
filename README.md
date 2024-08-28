## Microservices com Spring Boot

Este projeto de estudo explora a implementação de microserviços utilizando várias tecnologias e ferramentas do ecossistema Spring e outras integrações. O foco é criar uma arquitetura resiliente, escalável e fácil de gerenciar.

### Tecnologias Utilizadas

- **Spring Boot**: Framework para desenvolvimento rápido de aplicações Java.
- **Feign**: Cliente HTTP para criar APIs REST declarativas.
- **Eureka**: Serviço de registro e descoberta de serviços.
- **Spring Cloud LoadBalancer**: Balanceamento de carga de microserviços.
- **Resilience4j**: Biblioteca para implementar padrões de resiliência, como circuit breakers.
- **Swagger OpenAPI**: Documentação interativa da API.
- **Docker**: Containerização para implantação e execução de aplicações.
- **Zipkin e Sleuth**: Ferramentas de rastreamento distribuído para monitorar e depurar microserviços.

### Gerenciamento de Banco de Dados com Flyway

O Flyway é uma ferramenta poderosa para o gerenciamento de versões de banco de dados, totalmente compatível com Spring Boot e MySQL. 

**Nota:** O Flyway recentemente separou suas implementações. Agora, é necessário adicionar o núcleo do Flyway (`flyway-core`) e uma dependência específica para trabalhar com MySQL ou MariaDB.

Exemplo de dependências Maven:

```xml
<dependency>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-core</artifactId>
</dependency>
<dependency>
    <groupId>org.flywaydb</groupId>
    <artifactId>flyway-mysql</artifactId>
</dependency>
```

Os scripts de migração são executados em ordem sequencial, como `V1`, `V2`, `V3`, etc., portanto, atenção à ordem é crucial.

### Feign

O Feign é uma biblioteca Java desenvolvida pela Netflix que simplifica a criação de clientes HTTP para APIs REST. Ele abstrai a complexidade das chamadas HTTP, permitindo definições simples e declarativas.

**Principais Características:**
- **Declarativo:** Definição de interfaces anotadas para configurações HTTP.
- **Integração com Spring:** Fácil de integrar em projetos Spring Boot usando a anotação `@EnableFeignClients`.
- **Configuração de Timeout e Retry:** Configuração direta de tempos de espera e tentativas.
- **Interceptors e Customização:** Adição de interceptors para cabeçalhos personalizados, autenticação e mais.
- **Suporte a Hystrix:** Integrado para suporte a tolerância a falhas.

Exemplo de dependência Maven:

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-openfeign</artifactId>
</dependency>
```

### Eureka

Eureka é um serviço de registro de serviços, essencial para arquiteturas de microsserviços, permitindo que os serviços se registrem e descubram uns aos outros.

**Principais Características:**
- **Registro de Serviços:** Serviços se registram com Eureka para permitir descoberta por outros serviços.
- **Descoberta de Serviços:** Clientes consultam Eureka para localizar serviços.
- **Alta Disponibilidade:** Suporte a configuração em cluster para garantir disponibilidade.
- **Auto-Regeneração:** Serviços devem enviar batimentos cardíacos para confirmar a presença.

### Spring Cloud Gateway

O Spring Cloud Gateway fornece uma solução moderna de roteamento API baseada em microserviços. Ele é altamente flexível e focado em desempenho.

**Conceitos Principais:**
- **Rota:** Composta por um identificador, um predicado e uma lista de filtros.
- **Predicado:** Condições que determinam quando uma rota deve ser aplicada.
- **Filtro:** Permitem modificação de solicitações e respostas.

**Funcionalidades:**
- **Roteamento Dinâmico:** Definição e manutenção flexível de rotas.
- **Resiliência:** Integração com circuit breakers e padrões de resiliência.
- **Escalabilidade e Performance:** Baseado em Netty para alta performance.
- **Segurança:** Suporte a OAuth2, JWT, e outros padrões de segurança.

### Circuit Breaker e Resilience4j

Essas ferramentas são essenciais para construir sistemas resilientes e estáveis, gerenciando falhas e controlando a taxa de solicitações.

### Configuração da Porta da Aplicação

Para alterar a porta da aplicação, use o argumento de VM: 

```bash
-Dserver.port="Porta desejada"
```

### Docker

Url Spring Docker: https://spring.io/guides/gs/spring-boot-docker

Você deve fornecer uma visão clara e concisa de como o Dockerfile está configurado, bem como instruções para construir e executar a imagem Docker :

### 1. **Descrição do Dockerfile**
- **Imagem base**: Especifique qual imagem base está sendo usada (por exemplo, `FROM openjdk:17-jdk-alpine`).
- **Propósito**: Explique brevemente o propósito do Dockerfile, como por exemplo, "Este Dockerfile configura um ambiente de execução para um aplicativo Java com Spring Boot."

### 2. **Como Construir a Imagem Docker**
- **Comando de Build**: Inclua o comando para construir a imagem Docker. Por exemplo:
  ```bash
  docker build -t nome-da-imagem .
  ```
  Substitua `nome-da-imagem` pelo nome que você deseja dar à sua imagem.

### 3. **Como Executar a Imagem Docker**
- **Comando de Execução**: Forneça o comando para executar a imagem. Por exemplo:
  ```bash
  docker run -p 8080:8080 nome-da-imagem
  ```
  Aqui, substitua `nome-da-imagem` pelo nome da imagem que você construiu e ajuste as portas conforme necessário.

### 4. **Variáveis de Ambiente e Configurações**
- **Variáveis de Ambiente**: Liste quaisquer variáveis de ambiente que precisam ser configuradas antes de executar a imagem, e como elas podem ser configuradas. Por exemplo:
  ```bash
  docker run -e ENV_VAR=value -p 8080:8080 nome-da-imagem
  ```

### 5. **Volumes e Persistência de Dados**
- **Montagem de Volumes**: Explique como montar volumes, se necessário, para persistência de dados ou configuração adicional. Por exemplo:
  ```bash
  docker run -v /host/path:/container/path -p 8080:8080 nome-da-imagem
  ```

### 6. **Portas Expostas**
- **Portas**: Especifique quais portas são expostas e por que. Por exemplo, "A porta 8080 é exposta para acessar a aplicação web."

### 7. **Dependências Externas**
- **Dependências**: Mencione qualquer dependência externa necessária para construir ou executar a imagem. Por exemplo, "Este Dockerfile requer acesso à internet para baixar pacotes durante o build."

### 8. **Exemplos de Uso**
- **Exemplo de Execução**: Forneça um exemplo completo de como usar o Dockerfile, incluindo a construção da imagem e a execução de um contêiner.

```markdown
## Docker

### Construindo a Imagem

Para construir a imagem Docker para este projeto, utilize o seguinte comando:

```bash
docker build -t meu-aplicativo-java .
```

### Executando o Contêiner

Para executar o contêiner, utilize o comando abaixo:

```bash
docker run -p 8080:8080 meu-aplicativo-java
```

### Variáveis de Ambiente

Você pode configurar variáveis de ambiente utilizando a flag `-e`:

```bash
docker run -e ENV_VAR=value -p 8080:8080 meu-aplicativo-java
```

### Volumes

Para persistência de dados, monte um volume local:

```bash
docker run -v /host/path:/container/path -p 8080:8080 meu-aplicativo-java
```

### Dependências Externas

```bash
Este Dockerfile requer acesso à internet para baixar dependências durante o build.
```

Essas seções ajudam a garantir que os usuários entendam como construir e executar a imagem Docker, quais configurações são necessárias e como utilizar o contêiner resultante.

### Observação 
arquivo Dockerfile deve sempre começar com letra maiúscula. Além disso, todos os arquivos e subdiretórios presentes no mesmo diretório do Dockerfile serão incluídos na construção da imagem Docker. Certifique-se de que apenas os arquivos necessários para a aplicação estejam neste diretório para evitar incluir arquivos desnecessários na imagem final.

### Recursos Adicionais

- **Curso Recomendado:** [Microservices do 0 a GCP com Spring Boot, Kubernetes e Docker](https://www.udemy.com/course/microservices-do-0-a-gcp-com-spring-boot-kubernetes-e-docker/learn/lecture/26012946#overview)
