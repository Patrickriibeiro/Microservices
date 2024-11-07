## Microservices com Spring Boot

Este projeto de estudo explora a implementação de microserviços utilizando várias tecnologias e ferramentas do ecossistema Spring e outras integrações. O foco é criar uma arquitetura resiliente, escalável e fácil de gerenciar, adequada para atender às demandas de sistemas modernos.

### Tecnologias Utilizadas

- **Spring Boot**: Um framework que simplifica o desenvolvimento de aplicações Java, permitindo a criação de serviços autônomos de maneira rápida e eficiente. Com configuração mínima, o Spring Boot permite que os desenvolvedores se concentrem na lógica de negócios, em vez de na configuração.

- **Feign**: Uma biblioteca cliente HTTP que facilita a comunicação entre microserviços, permitindo a criação de APIs REST de forma declarativa. Com o Feign, você pode definir interfaces Java que representam chamadas de serviço, abstraindo a complexidade de gerenciar as solicitações HTTP.

- **Eureka**: Um serviço de registro e descoberta que facilita a comunicação entre microserviços. Com o Eureka, cada serviço se registra automaticamente no servidor Eureka, permitindo que outros serviços descubram e se conectem a ele facilmente. Isso ajuda a manter a flexibilidade e escalabilidade da arquitetura.

- **Spring Cloud LoadBalancer**: Uma solução de balanceamento de carga que distribui as requisições entre as instâncias de serviço disponíveis. Isso assegura que a carga seja distribuída uniformemente, melhorando a performance e a resiliência do sistema.

- **Resilience4j**: Uma biblioteca projetada para ajudar a implementar padrões de resiliência em sistemas distribuídos, como circuit breakers e fallback. O Resilience4j permite que você proteja seus serviços contra falhas, garantindo que, em caso de problemas, o sistema continue a funcionar corretamente.

- **Swagger OpenAPI**: Uma ferramenta que gera documentação interativa para APIs REST. O Swagger permite que desenvolvedores e usuários explorem as operações disponíveis na API de forma intuitiva, facilitando a comunicação entre equipes e a integração de sistemas.

- **Docker**: Uma plataforma que permite a containerização de aplicações, garantindo que elas possam ser executadas de forma consistente em qualquer ambiente. Com o Docker, você pode criar, implantar e gerenciar contêineres de maneira eficiente.

- **Zipkin e Sleuth**: Ferramentas de rastreamento distribuído que ajudam a monitorar e depurar chamadas entre microserviços. O Zipkin coleta dados de rastreamento, enquanto o Sleuth adiciona informações de rastreamento automaticamente às suas requisições, permitindo que você identifique gargalos de desempenho e analise o fluxo de chamadas.

### Gerenciamento de Banco de Dados com Flyway

O Flyway é uma ferramenta poderosa para o gerenciamento de versões de banco de dados, totalmente compatível com Spring Boot e MySQL. Ele permite que você controle a evolução do seu esquema de banco de dados de maneira sistemática e segura.

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

Os scripts de migração são executados em ordem sequencial, como `V1`, `V2`, `V3`, etc., portanto, a ordem é crucial para evitar erros de migração.

### Feign

O Feign é uma biblioteca Java desenvolvida pela Netflix que simplifica a criação de clientes HTTP para APIs REST. Ele abstrai a complexidade das chamadas HTTP, permitindo definições simples e declarativas.

**Principais Características:**

- **Declarativo**: Permite a definição de interfaces com anotações que representam os endpoints da API, tornando o código mais legível e fácil de manter.
- **Integração com Spring**: O Feign se integra facilmente a projetos Spring Boot, permitindo o uso da anotação `@EnableFeignClients` para ativar o suporte ao Feign.
- **Configuração de Timeout e Retry**: Permite que você configure o tempo de espera e o número de tentativas de chamadas de serviço de forma direta, melhorando a robustez das comunicações.
- **Interceptors e Customização**: Suporte para adicionar interceptors para cabeçalhos personalizados, autenticação e manipulação de erros.
- **Suporte a Hystrix**: O Feign é compatível com Hystrix, permitindo que você implemente padrões de tolerância a falhas em suas chamadas de serviço.

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

- **Registro de Serviços**: Cada serviço se registra com o Eureka, que mantém um registro centralizado, permitindo que outros serviços descubram onde estão localizados.
- **Descoberta de Serviços**: Os clientes consultam o Eureka para localizar outros serviços, facilitando a comunicação em ambientes dinâmicos.
- **Alta Disponibilidade**: O Eureka suporta configuração em cluster para garantir que o serviço de registro permaneça disponível mesmo em caso de falhas.
- **Auto-Regeneração**: Os serviços enviam batimentos cardíacos para o Eureka, garantindo que apenas serviços ativos estejam disponíveis para descoberta.

### Spring Cloud Gateway

O Spring Cloud Gateway fornece uma solução moderna de roteamento API baseada em microserviços. Ele é altamente flexível e focado em desempenho.

**Conceitos Principais:**

- **Rota**: Composta por um identificador, um predicado (condições que determinam quando uma rota deve ser aplicada) e uma lista de filtros (que permitem modificação de solicitações e respostas).
- **Predicado**: Condições que determinam quando uma rota deve ser aplicada, como o método HTTP ou o caminho da URL.
- **Filtro**: Permitem modificar a requisição ou a resposta, como adicionar cabeçalhos, realizar autenticação ou registrar logs.

**Funcionalidades:**

- **Roteamento Dinâmico**: Definição e manutenção flexível de rotas, permitindo que você altere as rotas em tempo real.
- **Resiliência**: Integração com circuit breakers e padrões de resiliência, garantindo que o sistema continue a operar mesmo em caso de falhas.
- **Escalabilidade e Performance**: Baseado em Netty para alta performance e suporte a escalabilidade horizontal.
- **Segurança**: Suporte a padrões de segurança como OAuth2 e JWT, facilitando a implementação de autenticação e autorização.

### Circuit Breaker e Resilience4j

Essas ferramentas são essenciais para construir sistemas resilientes e estáveis. O padrão Circuit Breaker ajuda a gerenciar falhas e controlar a taxa de solicitações, evitando sobrecarga em serviços que estão enfrentando problemas. O Resilience4j é uma biblioteca leve que oferece suporte para a implementação desse padrão e outros, como fallback e bulkhead.

### Visão Geral do Zipkin
O Zipkin coleta e armazena traces (rastros) das requisições que passam por diversos serviços em um sistema distribuído, permitindo visualizar como cada serviço interage e identificando gargalos ou falhas.

Trace e Span:

Trace: Representa o ciclo de vida completo de uma requisição, desde o início até a conclusão.
Span: Cada trace é composto de um ou mais spans, que representam um bloco individual de trabalho dentro do trace. Por exemplo, cada chamada a um serviço ou banco de dados pode ser um span.
Agente de Coleta:

Em cada serviço, um agente ou biblioteca de tracing (como spring-cloud-sleuth para Spring Boot) coleta informações sobre as requisições e as envia ao Zipkin.
Cada serviço precisa gerar e propagar o ID do trace e dos spans para manter o encadeamento correto entre os serviços.
Armazenamento:

O Zipkin armazena os dados em um banco de dados, como MySQL, Cassandra, ou Elasticsearch, onde os traces e spans ficam disponíveis para consulta.
Interface de Visualização:

A interface gráfica do Zipkin exibe os traces, permitindo inspecionar cada span, ver o tempo que cada serviço levou para processar e identificar atrasos ou falhas.
Integração com o Spring Boot:

Em aplicações Spring Boot, a biblioteca spring-cloud-sleuth integra com o Zipkin para criar e propagar automaticamente os spans e traces.
A configuração do Zipkin geralmente envolve a definição do URL do servidor Zipkin para onde as informações de tracing devem ser enviadas.
Documentação do Setup
Para documentar a implementação do Zipkin, você pode seguir este exemplo:

Dependências:

java
Copiar código
dependencies {
    implementation 'org.springframework.cloud:spring-cloud-starter-sleuth'
    implementation 'org.springframework.cloud:spring-cloud-starter-zipkin'
}
Configuração:

yaml
Copiar código
spring:
  zipkin:
    base-url: http://localhost:9411 # URL do servidor Zipkin
  sleuth:
    sampler:
      probability: 1.0 # Configuração para coletar todas as requisições (para produção, ajustar)
Inicialização do Zipkin:

Instale o Zipkin e inicie o servidor (docker run -d -p 9411:9411 openzipkin/zipkin) ou configure um servidor próprio.
Visualização de Traces:

Acesse http://localhost:9411 para visualizar os traces e investigar o comportamento dos serviços.
Esse setup ajuda a rastrear e entender o fluxo de dados, ajudando na identificação de gargalos e facilitando a manutenção de sistemas distribuídos.


### Configuração da Porta da Aplicação

Para alterar a porta da aplicação, use o argumento de VM:

```bash
-Dserver.port="Porta desejada"
```

Esse comando permite que você especifique a porta na qual sua aplicação Spring Boot deve escutar, facilitando a execução de múltiplas instâncias ou a integração com outros serviços.

### Observação

O arquivo Dockerfile deve sempre começar com letra maiúscula. Além disso, todos os arquivos e subdiretórios presentes no mesmo diretório do Dockerfile serão incluídos na construção da imagem Docker. Certifique-se de que apenas os arquivos necessários para a aplicação estejam neste diretório para evitar incluir arquivos desnecessários na imagem final.

O comando `mvn clean package -DskipTests` é utilizado com o Maven, uma ferramenta de automação de build amplamente usada em projetos Java:

1. **`mvn`**: Este é o comando para invocar o Maven. Ele é o ponto de partida para qualquer operação do Maven.
2. **`clean`**: Este comando remove todos os arquivos gerados pelo build anterior do diretório `target`, garantindo que você esteja começando com uma configuração limpa e sem conflitos.
3. **`package`**: Este comando compila o código-fonte do projeto, executa testes (por padrão) e empacota o código compilado em um formato distribuível, como um JAR ou WAR, dependendo da configuração do projeto.
4. **`-DskipTests`**: Este parâmetro diz ao Maven para não executar os testes durante o processo de build, embora os testes ainda sejam compilados. Isso é útil quando você deseja realizar uma compilação rápida, sem a execução dos testes.
