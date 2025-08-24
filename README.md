# API CalangoBets

Esta é a API backend da aplicação CalangoBets, responsável por autenticação de usuários, gerenciamento de conta, e histórico de jogos.

⚠️ Esta API é institucional e serve apenas para demonstração. Não é recomendada para produção sem ajustes de segurança.

## Tecnologias

* Java 17
* Spring Boot
* Spring Security 
* JWT para autenticação
* MongoDB

## Rodando localmente

1. Clonar o repositório
2. Configurar banco de dados (MongoDB ou SQL)
3. Ajustar application.properties ou application.yml com credenciais
4. Executar a aplicação com:
```
./mvnw spring-boot:run
```
5. A API estará disponível em localhost:8080.