Esta documentação tem o intuito de descrever a API Rest desenvolvida, tecnologias utilizadas e como conectar e interagir com a API.

O código está sendo executado por uma plataforma serverless para deploy de apps, o Koyeb: https://www.koyeb.com/.

As tecnologias utilizadas nesse projeto foram:

- *Java versão 17*;

- *Framework Spring Boot: Spring Web (para construção de endpoints), Data JPA(abstração e persistência de dados) e Security (autenticação e autorização*;

- *Banco de dados: PostgreSQL (hospedado em Aiven: https://aiven.io/ )*; 

- *Servidor web: Apache Tomcat (integrado ao Spring Boot)*;

- *Build: Maven*; 

A URL base dessa API é: https://faint-margit-thatsmyself-81229139.koyeb.app/

Como se conectar e interagir com a API?

Será necessário um cliente HTTP, como por exemplo o Postman ou o Insomnia.

1) Autenticação:
   
   Essa API usa JWT (JSON Web Token) para fazer a autenticação. Isso quer dizer que será necessário fazer um registro e login para obtenção de um Bearer Token, a fins de acessar os endpoints protegidos.
   
   O fluxo de autenticação segue o padrão: registro, login e token.
   
   Para realizar o registro, faça um POST seguinte endpoint: https://faint-margit-thatsmyself-81229139.koyeb.app/auth/register e insira um objeto no body da requisição: {"username":"seu_username","password:sua_senha"}. Este método gerará um hash para a password.  A password gerada será usada no próximo passo.
   
   Para realizar o login, faça outro POST no seguinte endpoint: https://faint-margit-thatsmyself-81229139.koyeb.app/auth/login e agora utilize {"username": "o mesmo do registro", "password": "o hash da password gerada pelo registro"}. Isso irá retornar um token que irá durar 24h para utilizar o CRUD da API.

2) Interação com a API:

   É importante ressaltar que, como a API usa o JWT, será necessário fazer uma alteração em Authorization. O Auth Type deverá ser Bearer Token e o Bearer Token é o token que foi gerado a partir do login.

   Com a Authorization em Auth Type e o Bearer Token devidamente fornecido, o endpoint usado para fazer o CRUD dessa api é: https://faint-margit-thatsmyself-81229139.koyeb.app/api/products .

   Nessa API os métodos disponíveis para requisições são GET, POST e DELETE.

*CÓDIGOS DE STATUS*

Essa API foi projetada para retornar códigos de status HTTP para diferentes situações, visando facilitar depuração e o consumo da API. O corpo da resposta geralmente fornecerá as informações necessárias sobre a resposta da API.

Alguns códigos frequentes que aparecerão nessa API:
  - Código 200 (OK): A requisição a API foi bem-sucedida;

  - Código 201 (Created): Indica que um novo recurso foi criado com sucesso (geralmente retornado em requisições POST);

  - Código 204 (No Content): Significa que a requisição foi um sucesso, porém não há nada para retornar;

  - Código 400 (Bad request): Pode ser um indicativo de sintaxe inválida, dados com formatação errada ou parâmetros obrigatórios ausentes;

  - Código 401 (Unauthorized): Esse código indica que o token de autenticação utilizado está ausente ou inválido;

  - Código 403 (Forbidden): A API entendeu a requisição mas você não tem permissão para acessar os dados;

  - Código 404 (Not found): O recurso solicitado não foi encontrado no banco de dados;

  - Código 500 (Internal server error): Erro interno. Geralmente indicando um problema no código da API
  

   

   
   


