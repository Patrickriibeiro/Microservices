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

Para "tagear" uma imagem Docker como `latest` no Docker Registry, você pode usar o comando `docker tag`. Esse comando permite que você crie um alias (`latest`) para uma imagem que já tenha sido criada. Vou descrever o processo:

### Passos para "tagear" uma imagem como `latest`

1. Primeiro, construa ou tenha a imagem que deseja "tagear":
   ```bash
   docker build -t meu-repositorio/minha-imagem:v1 .
   ```

2. Em seguida, crie uma tag `latest` para a mesma imagem:
   ```bash
   docker tag meu-repositorio/minha-imagem:v1 meu-repositorio/minha-imagem:latest
   ```

3. Agora, faça o push para o registry (ex.: Docker Hub, AWS ECR, etc.):
   ```bash
   docker push meu-repositorio/minha-imagem:latest
   ```

### Resumo
O comando completo seria:

```bash
docker build -t meu-repositorio/minha-imagem:v1 .
docker tag meu-repositorio/minha-imagem:v1 meu-repositorio/minha-imagem:latest
docker push meu-repositorio/minha-imagem:latest
```

Essa prática de "tagear" a última versão como `latest` é útil para manter o ambiente atualizado com a versão mais recente.

Para buscar imagens no Docker Hub diretamente pela linha de comando, você pode usar o comando `docker search`. Esse comando permite que você procure por imagens disponíveis no Docker Registry (Docker Hub) com base em uma palavra-chave.

### Exemplo de Uso

```bash
docker search nome-da-imagem
```

Por exemplo, para buscar imagens relacionadas ao MySQL:

```bash
docker search mysql
```

### Explicação dos Campos Retornados

O comando `docker search` exibe uma lista de imagens com as seguintes informações:

- **NAME**: Nome da imagem.
- **DESCRIPTION**: Descrição breve sobre o que a imagem faz.
- **STARS**: Número de "estrelas" ou avaliações positivas que a imagem recebeu.
- **OFFICIAL**: Indica se a imagem é oficial (geralmente feita e mantida pela própria empresa que fornece o software, como MySQL, Redis, etc.).
- **AUTOMATED**: Mostra se a imagem é gerada automaticamente a partir de um repositório (como o GitHub) com base em arquivos de configuração.

### Filtros Úteis

Você pode adicionar opções para refinar a busca:

- `--filter=stars=[número]`: Mostra apenas imagens com um certo número de estrelas (avaliações).
  
  ```bash
  docker search --filter=stars=100 mysql
  ```

- `--filter=is-official=true`: Mostra apenas imagens oficiais.

  ```bash
  docker search --filter=is-official=true mysql
  ```

Esses filtros ajudam a encontrar imagens confiáveis e amplamente usadas.

Para remover uma imagem Docker local, você pode usar o comando `docker rmi`. Esse comando aceita o ID ou o nome da imagem como argumento.

### Comando Básico

```bash
docker rmi nome-da-imagem
```

ou, se preferir, usando o ID da imagem:

```bash
docker rmi id-da-imagem
```

### Exemplo Prático

1. Primeiro, liste as imagens para identificar o nome ou ID da imagem que deseja remover:

   ```bash
   docker images
   ```

2. Em seguida, remova a imagem:

   ```bash
   docker rmi mysql:latest
   ```

### Forçar a Remoção

Se a imagem estiver sendo usada por um ou mais containers, você pode adicionar a opção `-f` (forçar):

```bash
docker rmi -f nome-da-imagem
```

### Remover Todas as Imagens

Para remover todas as imagens de uma vez:

```bash
docker rmi $(docker images -q)
```

Isso irá limpar todas as imagens, liberando espaço em disco.

O comando `docker logs -f` é usado para visualizar os logs de um container em tempo real. O `-f` (ou `--follow`) permite acompanhar o fluxo contínuo dos logs, similar ao comando `tail -f`.

### Exemplo de Uso

```bash
docker logs -f nome-do-container
```

ou, se preferir, usando o ID do container:

```bash
docker logs -f id-do-container
```

### Opções Úteis

- **`--tail [N]`**: Limita o número de linhas exibidas a partir do final dos logs. Por exemplo, para mostrar apenas as últimas 50 linhas:

  ```bash
  docker logs -f --tail 50 nome-do-container
  ```

- **`--since [tempo]`**: Mostra logs a partir de um determinado tempo. Você pode especificar em minutos, horas, etc. Exemplo:

  ```bash
  docker logs -f --since 1h nome-do-container
  ```

Esse comando é muito útil para monitorar aplicações e debugar problemas em containers em execução.

### Dependências Externas

```bash
Este Dockerfile requer acesso à internet para baixar dependências durante o build.
```

### Observação 
arquivo Dockerfile deve sempre começar com letra maiúscula. Além disso, todos os arquivos e subdiretórios presentes no mesmo diretório do Dockerfile serão incluídos na construção da imagem Docker. Certifique-se de que apenas os arquivos necessários para a aplicação estejam neste diretório para evitar incluir arquivos desnecessários na imagem final.


Parece que sua distribuição Ubuntu está rodando no **WSL 1**, enquanto o Docker Desktop está configurado para o **WSL 2**. Para usar o Docker de forma mais eficiente com o Ubuntu no WSL, você precisará atualizar o Ubuntu para o WSL 2. 

Aqui está como fazer isso:

### Passo 1: Converter o Ubuntu para WSL 2

No **PowerShell**, execute o seguinte comando para definir a versão do WSL para a distribuição Ubuntu:

```powershell
wsl --set-version Ubuntu 2
```

Isso irá converter a sua distribuição Ubuntu para WSL 2. Esse processo pode demorar um pouco, dependendo do tamanho da instalação.

### Passo 2: Verifique a Conversão

Após o término da conversão, você pode verificar se o Ubuntu está no WSL 2 com o comando:

```powershell
wsl -l -v
```

A saída deverá mostrar `VERSION 2` ao lado do Ubuntu.

### Passo 3: Ative a Integração WSL no Docker Desktop

1. Abra o **Docker Desktop**.
2. Vá para **Settings** > **Resources** > **WSL Integration**.
3. Ative a opção de integração com o Ubuntu (ou a opção **Enable integration with my default WSL distro**).

Após esses passos, o Ubuntu estará configurado para o WSL 2 e integrado com o Docker Desktop, permitindo que você utilize o Docker e o Docker Compose com a distribuição Ubuntu no WSL.



Agora que o Ubuntu está configurado para o WSL 2, você está pronto para integrá-lo ao Docker Desktop. Vamos garantir que tudo está funcionando corretamente:

### Passo 1: Inicie o WSL e o Ubuntu

Abra o **Ubuntu** novamente, seja pelo menu Iniciar ou executando o comando no PowerShell:

```powershell
wsl -d Ubuntu
```

Isso deve iniciar o Ubuntu com o WSL 2.

### Passo 2: Verifique a Integração com o Docker Desktop

1. Abra o **Docker Desktop**.
2. Vá até **Settings** > **Resources** > **WSL Integration**.
3. Certifique-se de que a opção **Enable integration with my default WSL distro** está marcada ou que **Ubuntu** está especificamente selecionado para a integração.
4. Clique em **Apply & Restart** se precisar salvar essas alterações.

### Passo 3: Teste o Docker no Ubuntu

Agora, no terminal do Ubuntu, verifique se o Docker está funcionando corretamente executando:

```bash
docker --version
docker-compose --version
```

Se ambos os comandos retornarem a versão do Docker, você está pronto para usar o Docker e o Docker Compose no Ubuntu com WSL 2!

Aqui estão as funções dos comandos `docker compose up -d` e `docker-compose down`:

1. **`docker compose up -d`**:
   - Esse comando inicia todos os contêineres definidos no arquivo `docker-compose.yml` no modo **desanexado** (`-d`), o que significa que eles vão rodar em segundo plano.
   - Esse comando é usado para **subir** os serviços e mantê-los rodando, permitindo que você continue usando o terminal.
   - Exemplo de uso:
     ```bash
     docker compose up -d
     ```

2. **`docker-compose down`**:
   - Esse comando encerra e **remove todos os contêineres, redes e volumes** criados pelo `docker-compose.yml`.
   - É usado quando você quer **parar** e **limpar** tudo que foi criado pelo `docker-compose`.
   - Exemplo de uso:
     ```bash
     docker-compose down
     ```

Esses comandos são fundamentais para gerenciar contêineres Docker usando o Docker Compose!


O comando `docker ps -a` é usado para listar todos os contêineres Docker no sistema, incluindo aqueles que estão parados.

### Detalhes do Comando

```bash
docker ps -a
```

Esse comando exibe informações detalhadas, como:

- **Container ID**: ID do contêiner.
- **Image**: A imagem Docker da qual o contêiner foi criado.
- **Command**: O comando que está sendo executado pelo contêiner.
- **Created**: Quando o contêiner foi criado.
- **Status**: Mostra se o contêiner está em execução, parado ou em outro estado.
- **Ports**: Portas mapeadas do contêiner.
- **Names**: Nome do contêiner.

Se você quiser ver apenas os contêineres em execução, pode usar:

```bash
docker ps
```


O comando `docker container ls` é usado para listar apenas os contêineres que estão **em execução** no Docker. Esse comando é equivalente a `docker ps`.

### Exemplos de Uso

1. **Listar contêineres em execução:**
   ```bash
   docker container ls
   ```

2. **Listar todos os contêineres (em execução e parados):**
   Para ver todos os contêineres, incluindo os que estão parados, adicione a flag `-a`:
   ```bash
   docker container ls -a
   ```

Esse comando mostra detalhes como o ID do contêiner, a imagem, o comando em execução, status, portas e nome do contêiner.
