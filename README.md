# 📦 api cabeb sistema [<img align="right" src="https://img.shields.io/badge/release-v0.0.1-green">](https://github.com/CABEB-Technology/cabeb-sistema-api-java/releases)

Bem-vindo(a).

Olá, como vai?! Meu nome é [Brendson](https://github.com/br3nds0n) e estive à  frente do projeto final do curso de ADS junto com meu [grupo](#-autores), para melhor organização dividimos o projeto em três onde a aplicação do `font-end` está hospedada em outro repositorio [clique aqui](https://github.com/CABEB-Technology/cabeb-sistema-web-vue) para visualizar o projeto.

Viemos por meio deste repositorio entregar a aplicação `back-end` do TCC. Esperamos que você goste!

## ℹ index

-   [📥 download](#-download)
    -   [setup](#-setup)
    -   [starting](#-starting)
        * [docker](#-docker)
-   [🛠 tecnologias](#-tecnologias)
-   [✍🏼 autores](#-autores)
-   [📝 license](#-license)

## 📥 download

Antes de começar, você precisará ter as seguintes ferramentas instaladas em sua máquina:
[Git](https://git-scm.com), [JDK17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) este projeto usa o java **_17_**, o uso do drive do [PostgreSQL](https://www.postgresql.org/download/) também será necessário (ou qualquer outro banco SQL). Além disso, é bom ter um editor para trabalhar com código como [Intelij](https://www.jetbrains.com/idea/)  .

### 💻 setup

```php
# clonar este repositório
$ git clone https://github.com/CABEB-Technology/cabeb-sistema-api-java.git

# acesse a pasta do projeto
$ cd cabeb-sistema-api-java

# instale as dependências
$ ./mvnw install
```

### ⚙ Configurar variáveis de ambiente

```bash
# configuração banco de dados
spring.jpa.properties.hibernate.dialect = org.hibernate.dialect.PostgreSQLDialect
spring.datasource.url = jdbc:postgresql://<servidor>:5432/<banco>

spring.jpa.hibernate.ddl-auto = update
spring.jpa.hibernate.show-sql = true

spring.datasource.username = <user>
spring.datasource.password = <password>

# configuração de segurança
spring.security.user.name = cabeb
spring.security.user.password = 123456
spring.main.allow-circular-references = true

jwt.secret = 6777eb32e428b63738210ddfe846c5ce

# configuração de servidor
server.port = 5000
server.servlet.contextPath=/api
url.web = http://localhost:8080/
```

### 🐳 docker
> caso opte pela utilização do `docker-compose`.
```php
# gere o arquivo .jar
$ ./mvnw clean package -DskipTests

# build a imagem
$ docker build -t cabeb_sistema_api .

# executando o comando
$ docker-compose up

# aplicação iniciará em um container do docker.
```
<br>

## ▶ starting

```php
# executando o comando
$ ./mvnw spring-boot:run

# --- [ ou ] ---

# rode o executável
$ ./run

# aplicação iniciará em <http://localhost:5000/api>
```

<br>

## 🛠 tecnologias

As seguintes ferramentas/tecnologias foram usadas na construção e teste do projeto. Ao clicar no ícone da tecnologia, você será redirecionado ao site oficial para instalação:

<br>

|                                   logo                                     |                       Framework                       | Version  |
| :------------------------------------------------------------------------: |:-----------------------------------------------------:|:--------:|
| <img height="35" width="40" src="https://skillicons.dev/icons?i=idea">     |     [Intelij](https://www.jetbrains.com/idea/)        |  `2022`  |
| <img height="35" width="40" src="https://skillicons.dev/icons?i=java">     |          [Java](https://www.java.com/pt-BR/)          | `17.0.0` |
| <img height="35" width="40" src="https://skillicons.dev/icons?i=spring">   |        [SpringBoot](https://start.spring.io/)         | `2.7.0`  |
| <img height="35" width="40" src="https://skillicons.dev/icons?i=maven">    |           [Maven](https://maven.apache.org)           | `4.0.0`  |
| <img height="35" width="40" src="https://skillicons.dev/icons?i=postgres"> |  [PostgreSQL](https://www.postgresql.org/download/)   | `8.7.3`  |
| <img height="35" width="40" src="https://skillicons.dev/icons?i=docker">   |           [Docker](https://www.docker.com/)           | `1.27.4` |

<br>

## ✍🏼 autores

<table>
  <tr>
   <tr align=center>
        <th><a href="https://github.com/br3nds0n"><strong> Brendson Victor </strong><a></th>
        <th><a href="https://github.com/G0nz4g4n"><strong> Ediclei Gonzaga </strong><a></th>
        <th><a href="https://github.com/BryanLucasCabral"><strong> Bryan Lucas </strong><a></th>
        <th><a href="https://github.com/Caroll8silva"><strong> Caroline Silva </strong><a></th>
        <th><a href="https://github.com/AdryanNeves"><strong> Adryan Daniel</strong><a></th>
  </tr>
    <td align="center">
      <a href="https://github.com/br3nds0n">
        <img src="https://user-images.githubusercontent.com/82064724/185726784-e8d151e8-29d6-4475-ba50-ca23f9429650.png" width="110"/></a><br>
        <sub>
            <a href="https://www.linkedin.com/in/brendson/" target="_blank" rel="noreferrer" rel="noopener">
              <img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" alt="Linkedin"/>
            </a></br>
          </div>
        </sub>
    </td>
      <td align="center">
      <a href="https://github.com/G0nz4g4">
        <img src="https://avatars.githubusercontent.com/u/92478744?v=4" width="110"/></a><br>
        <sub>
            <a href="https://www.linkedin.com/in/ediclei-gonzaga/" target="_blank" rel="noreferrer" rel="noopener">
              <img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" alt="Linkedin"/>
            </a></br>
          </div>
        </sub>
    </td>
     <td align="center">
      <a href="https://github.com/BryanLucasCabral">
        <img src="https://avatars.githubusercontent.com/u/89997058?v=4" width="110"/></a><br>
        <sub>
            <a href="https://www.linkedin.com/in/bryan-nascimento-b37757209/" target="_blank" rel="noreferrer" rel="noopener">
              <img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" alt="Linkedin"/>
            </a></br>
          </div>
        </sub>
    </td>
      <td align="center">
      <a href="https://github.com/Caroll8silva">
        <img src="https://media-exp1.licdn.com/dms/image/C4E03AQHiBlxVSFmACQ/profile-displayphoto-shrink_800_800/0/1654480060896?e=1669852800&v=beta&t=KvZts2zXewTmigdwtGLmYrvUPUXTTwDGXfeZgFEJm8E" width="110"/></a><br>
        <sub>
            <a href="https://www.linkedin.com/in/carolinnesilva/" target="_blank" rel="noreferrer" rel="noopener">
              <img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" alt="Linkedin"/>
            </a></br>
          </div>
        </sub>
    </td>
    <td align="center">
      <a href="https://github.com/AdryanNeves">
        <img src="https://media-exp1.licdn.com/dms/image/C4D03AQFImzxAjnaWMg/profile-displayphoto-shrink_800_800/0/1658975694238?e=1669852800&v=beta&t=qw1RlcAmUI3SEOAVO9qvBBEE2xxbXlURpFkXec5v8B8" width="110"/></a><br>
        <sub>
            <a href="https://www.linkedin.com/in/adryan-daniel-0b11461aa/" target="_blank" rel="noreferrer" rel="noopener">
              <img src="https://img.shields.io/badge/LinkedIn-0077B5?style=for-the-badge&logo=linkedin&logoColor=white" alt="Linkedin"/>
            </a></br>
          </div>
        </sub>
    </td>
  </tr>
</table>

<br>

## 📝 license

Este repositório está licenciado sob **MIT LICENSE**. Para informações mais detalhadas, leia o arquivo [LICENSE](./LICENSE) contido neste repositório.

<br> 

[[ ↑ voltar ]](#-api-autenticação-cabeb-sistema-)
