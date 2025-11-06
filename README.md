# IMEPAC Spring Boot - Projeto Integrador

Projeto de exemplo com Spring Boot + Thymeleaf com CRUD para Usuário, Cliente e Orçamento.

## Como usar

1. Abra no IntelliJ (File > Open) apontando para a pasta do projeto.
2. Rode `mvn spring-boot:run` ou execute a classe `br.edu.imepac.InepacApplication`.
3. Acesse `http://localhost:8080`:
   - Usuários: `/usuarios`
   - Clientes: `/clientes`
   - Orçamentos: `/orcamentos`
4. H2 Console: `http://localhost:8080/h2-console` (URL: `jdbc:h2:mem:imepacdb`)

Feito para Java 21 e Spring Boot 3.x.
