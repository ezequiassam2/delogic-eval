## Visão geral da avaliação
A base do projeto é uma troca fictícia de ingressos para eventos, que está sendo portado para um aplicativo da web baseado em Java implantado com springboot. 
 - Parte 1 de a avaliação consiste na migração dos dados existentes para um banco de dados relacional.
 - Parte 2 concentra-se na geração de um modelo POJO e uma camada de acesso a dados. 
 - Parte 3 uma API RESTful rudimentar é introduzida utilizando a funcionalidade implementada na Parte 2. 
 - Finalmente, a Parte 4 introduz alguma lógica de negócios para implementar um recurso promocional.

## Diretrizes de Avaliação
1. Depois de receber um convite para o projeto de avaliação, você poderá começar a trabalhar e comprometendo-se conforme sua conveniência.
    * Você pode usar ramificações de recursos e solicitações de mesclagem, mas isso é puramente sua escolha e não é obrigatório.

2. Alguns detalhes/especificidades são intencionalmente omitidos para permitir diferentes
escolhas de design ou implementação a serem feitas. Não há um único correto
responder.
    * No entanto, observe que alguns detalhes _são_ intencionalmente prescritivos e devem ser seguidas, sempre que possível. Isto é principalmente para estar atento ao seu tempo e manter o foco em tarefas relevantes e significativas. Em caso de dúvida, veja 4. abaixo.

3. Um dos componentes da avaliação é mostrar a aplicação de testes 

## Parte 1
Na primeira parte da avaliação, você analisará os extratos de dados do aplicativo de troca de ingressos de eventos existente (consulte o [diretório de dados](/data) e
projetar um esquema relacional para os dados, incluindo o DDL e DML relevantes roteiros. Isso será empacotado em [compatível com Flyway](https://flywaydb.org/) migrações de esquema.

### Diretrizes e suposições
- O JDK de destino é Java 17 e o banco de dados SQL é compatível com MySQL 8.0.
    - Quando implantado, o aplicativo usará o MySQL 8.0 oficial [imagem](https://hub.docker.com/_/mysql/) e Amazon Corretto 17 [imagem](https://hub.docker.com/_/amazoncorretto) (variante Alpine, `amazoncorretto:17-alpine-jdk`).
- O esquema deve ser normalizado, incluindo definições de chave estrangeira.
- Os tipos de dados devem ser escolhidos cuidadosamente para facilitar o mapeamento POJO na Parte 2.
- Índices adicionais podem ser adicionados posteriormente (como migrações Flyway), conforme necessário em partes subsequentes da avaliação.

### Tarefas
- [ ] Projete um esquema normalizado e crie um script MySQL DDL correspondente.
    - Crie uma tabela para cada uma das 7 exportações de dados (descritas no seção Dicionário de dados abaixo).
- [ ] Prepare uma _v1_ [migração versionada Flyway](https://documentation.red-gate.com/fd/migrations-184127470.html) que encapsula o script DDL de criação de esquema.
- [ ] Preparar uma migração com versão _v2_ Flyway que preencha o banco de dados das exportações de dados fornecidas no [diretório de dados](/data).
- [ ] Crie um [Gradle](https://docs.gradle.org/current/userguide/userguide.html) build que invoca Flyway e executa suas migrações.
   - Consulte este [tutorial] do Flyway(https://documentation.red-gate.com/flyway/quickstart-how-flyway-works/quickstart-guides/quickstart-gradle) se estiver usando Flyway com Gradle pela primeira vez.
   - Adição de detalhes sobre o Flyway [Gradle Task](https://documentation.red-gate.com/fd/gradle-task-184127407.html) 
- [ ] Adicione o [wrapper Gradle](https://docs.gradle.org/current/userguide/gradle_wrapper.html)
e envie-o para o repositório de origem.

### Dicionário de dados
A exportação de dados consiste em 7 arquivos no [diretório de dados](/data), correspondendo às seguintes entidades:

- Users (sellers and buyers)
- Venues
- Categories
- Dates (2008 only)
- Events
- Event Ticket Listings
- Event Ticket Sales

#### Users
Pipe-separated fields:
- user id (primary key)
- username
- first name
- last name
- address:
    - city
    - state
    - email
    - phone
- preference flags:
    - sports
    - theatre
    - concerts
    - jazz
    - classical
    - opera
    - rock
    - vegas
    - broadway
    - musicals

#### Venues
Pipe-separated fields:
- venue id (primary key)
- venue name
- city
- state
- seating capacity

#### Categories
Pipe-separated fields:
- category id (primary key)
- category group
- category name
- category description

#### Dates
Pipe-separated fields:
- id (primary key)
- calendar date
- day
- week
- month
- quarter
- year
- holiday flag

#### Events
Pipe-separated fields:
- event id (primary key)
- venue id
- category id
- date id
- event name
- event start time

#### Listings
Pipe-separated fields:
- listing id (primary key)
- seller id
- event id
- date id
- number of tickets
- price per ticket
- total price
- listing timestamp

#### Sales
Tab-separated fields:
- sale id (primary key)
- listing id
- seller id
- buyer id
- event id
- date id
- quantity sold
- price paid
- commission amount
- sale timestamp

## Parte 2
Na Parte 2, você criará um modelo POJO e uma camada de acesso a dados que será invocado a partir da compilação do Gradle que você criou na Parte 1.

### Diretrizes e suposições
- Use uma versão recente do [JPA](https://spring.io/guides/gs/accessing-data-jpa) para isso conjunto de tarefas.

### Tarefas
- [ ] Realize a confecção das entidades que representem as tabelas geradas na etapa anterior
- [ ] Use [JPA] para a criação de repositorios das tabelas/entidades
- [ ] Para facilitar a revisão, envie o código-fonte gerado para a fonte repositório.

## Parte 3
Na Parte 3, você apresentará webservices RESTful ao seu aplicativo, que utilizará a camada de acesso a dados que você criou na Parte 2.

### Diretrizes e suposições
- Recomenda-se o uso de uma versão recente do Spring Boot e jUnit, mas você está bem-vindo para usar qualquer estrutura Java adequada de sua escolha.

### Tarefas
- [ ] Exponha dois endpoints de API RESTful somente leitura para cada uma das entidades que você criado nas Partes 1 e 2. Um endpoint retornará todos os IDs dessa entidade e o outro recuperará uma entidade por ID e retornará sua representação JSON.
  - Considere adicionar suporte de paginação para grandes conjuntos de resultados, se o tempo permitir.
- [ ] Escreva um ou mais testes jUnit que exercitem e validem seu serviço método(s).
  - Seus testes podem assumir que o banco de dados já foi pré-preenchido com os dados de sua migração _v2_ Flyway da Parte 2.

## Parte 4
Na parte final, você implementará alguma lógica de negócios que apresenta um recurso promocional básico em seu aplicativo. O objetivo do recurso é promover inventário de ingressos não vendidos, definido como listagens de ingressos de eventos que não ter um conjunto completo de vendas correspondentes.

### Tarefas
- [ ] Implementar um endpoint de serviço da web que receba três solicitações parâmetros como entrada:
  1. data de contexto (obrigatório)
  2. ID da categoria do evento (opcional)
  3. cidade do evento (opcional)

O serviço retornará até 10 IDs de listagem para a data de contexto especificada e categoria de evento opcional e cidade, classificada pela proximidade da data do evento
data de contexto passada (sem excedê-la). Em outras palavras, o evento será exibida uma listagem que tenha ingressos não vendidos e que esteja mais próxima da data de contexto primeiro na lista.
- [ ] Implemente um ou mais testes jUnit para exercitar e validar seu implementação.