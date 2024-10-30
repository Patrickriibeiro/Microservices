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

### Observação 
arquivo Dockerfile deve sempre começar com letra maiúscula. Além disso, todos os arquivos e subdiretórios presentes no mesmo diretório do Dockerfile serão incluídos na construção da imagem Docker. Certifique-se de que apenas os arquivos necessários para a aplicação estejam neste diretório para evitar incluir arquivos desnecessários na imagem final.

O comando `mvn clean package -DskipTests` é utilizado com o Maven, uma ferramenta de automação de build amplamente usada em projetos Java :

1. **`mvn`**: Este é o comando para invocar o Maven. Ele é o ponto de partida para qualquer operação do Maven.

2. **`clean`**: Este é um dos "goals" (metas) ou comandos básicos do Maven. O `clean` remove todos os arquivos gerados pelo build anterior do diretório `target`. Essencialmente, ele limpa o ambiente para garantir que você esteja começando com uma configuração limpa e sem conflitos ou arquivos de build anteriores.

3. **`package`**: Este é outro "goal" do Maven. O `package` compila o código-fonte do projeto, executa testes (por padrão) e empacota o código compilado em um formato distribuível, como um JAR (Java ARchive) ou WAR (Web Application Archive), dependendo da configuração do projeto. O arquivo resultante é colocado no diretório `target`.

4. **`-DskipTests`**: Este é um parâmetro de linha de comando que define uma propriedade do sistema no Maven. `-D` é usado para definir propriedades, e `skipTests` é o nome da propriedade. Quando você usa `-DskipTests`, está dizendo ao Maven para não executar os testes durante o processo de build. É importante notar que, com `-DskipTests`, os testes não serão executados, mas ainda serão compilados. 

