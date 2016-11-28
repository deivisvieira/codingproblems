# CloudApi system
Java library modelada para gerenciar um sistema de cloud computing.

Funcionalidades:
* Adição de novas instancias 
 * *URL* http://localhost:8080/runinstance/x , x é o nome
* Listagem de instancias
 * *URL* http://localhost:8080/runinstance
* Autenticação e Autorização básica:
 * usuário: user - senha: gerada automaticamente na inicialização da aplicação

## Arquitetura
Arquitetura baseada na linguagem Java

Tecnologias:
* Java: Linguagem base de desenvolvimento
* Libraries: 
 * Spring Boot: Framework Java para desenvolvimento Web (Spring MVC)
 * Maven: Gerenciador de dependências
 * Flyway: Gerenciamento de versionamento da base
 * H2: Database Embedded
 * JUnit: Testes unitários
 * MockMvc: Teste integração

## Usage
* Configurar projeto
 * [Instalar Maven](http://maven.apache.org/install.html)
 * Acessar raiz do diretório do projeto
 * Executar mvn install
 
* Executar testes unitários
 * mvn test 

