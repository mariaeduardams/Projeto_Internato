## Projeto Internato (sistemas para internet-p3-tarde-uniesp)
## Grupo Main

- Maria Eduarda Maia
- Lucas Accioly
- João Victor Soares

## Arquitetura do Projeto:

O projeto foi estruturado com arquitetura em camadas inspirada em DDD (Domain-Driven Design) de forma simplificada.  
Essa organização melhora a legibilidade, manutenção e escalabilidade do sistema.

## Motivos da Escolha:
Cada camada tem uma função bem definida (controlador, serviço, repositório);
Alterações em uma camada não afetam diretamente as outras por conta da arquitetura do projeto;
Camadas isoladas facilitam testes unitários e de integração.

## Tecnologias Utilizadas

- Java 21;
- Spring Boot 3.4.5;
- Spring Web;
- Spring Data JPA;
- Spring Boot DevTools;
- Spring Boot Starter Validation;
- PostgreSQL Driver;
- Lombok;
- Jakarta Persistence (inclusa via Spring Data JPA);
- Maven para gerenciamento de dependências.

## Banco de Dados

- Utiliza PostgreSQL (com driver incluído no runtime);
- As configurações estão no application.properties;
- As tabelas criadas estão em resoures.

