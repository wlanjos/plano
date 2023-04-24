# API Plano de saúde.
#### API REST para manter o cadastro de beneficiários de um plano de saúde.

Projeto desenvolvido em Java Spring Boot JPA Spring Security e Docker

Na Raiz do Projeto encontra-se collection do postman para usar nos testes

### Como executar api 

- Necessario docker instalado
- Realiza clone do projeto para IDE de escolha 
- Abrir o terminal e inserir o comando ***mvn clean install***
- Apos build inserir o comando ***docker-compose up --build --force-recreate*** 
---
### Utilizando a API

- Após a criação do containers a API estara disponivel na porta 8080
- o Swagger da API é http://localhost:8080/swagger-ui.html
- Utilizar a collection do postman para testar
- Deve iniciar pelo endpoint **/usuario/create** para criar o usuario na base.
- Após criar usuario ir para o endpoint **/usuario/login** , este endpoint devolve token JWT que será usado nos demais endpoints
- JWT criado, o mesmo deve ser inserido no Authorization da requisição usando o Bearer 
---

##### Observação
 
###### Teste unitario não foram feitos devido hora do commit
