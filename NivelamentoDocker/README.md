## Nivelamento Docker

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