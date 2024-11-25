# 🗂️ TodoList - RocketSeat

Bem-vindo ao **Gerenciador de Tarefas**, um projeto desenvolvido para facilitar a organização e gestão de tarefas.

## 🚀 Tecnologias Utilizadas

- **Java**: versão 17
- **Spring Boot**: versão 3.0.11
- **Maven**: para gerenciamento de dependências
- **IntelliJ IDEA**: como IDE principal
- **Insomnia**: para testes de APIs
- **Lombok**: para reduzir a verbosidade do código
- **Spring Data JPA**: para persistência de dados
- **H2 Database Engine**: banco de dados em memória
- **Spring Initializr**: para configuração inicial do projeto

## 🌐 Acesso ao Banco de Dados H2

O H2 Database Engine pode ser acessado pelo seguinte endpoint:  
**`http://localhost:8080/h2-console`**

- **Username**: `admin`
- **Password**: `admin`

## ⚙️ Funcionalidades Principais

- **Validação de Username**: não é permitido usuários com nomes duplicados no banco de dados.
- **Retornos HTTP**: configurados para fornecer respostas claras e padronizadas.
- **Limitação de Caracteres**: aplicadas onde necessário.
- **Geração de UUIDs**: assegurando identificadores únicos para registros.
- **Relacionamento entre Tabelas**: implementado para estruturar as entidades do sistema.

## 📦 Deploy

Este projeto foi configurado para deploy utilizando o **[Render](https://render.com/)**.

### 🔧 Dockerfile Configurado

Foi configurado um **Dockerfile** para facilitar o processo de deploy, garantindo portabilidade e consistência no ambiente de execução.

## 🚧 Como Rodar o Projeto Localmente

1. Clone o repositório:
   ```bash
   git clone <url-do-repositorio>
    ````
2. Navegue até a pasta do projeto:
   ```bash
   cd gerenciador-de-tarefas
    ````
3. Compile e rode o projeto com Maven:
   ```bash
   mvn spring-boot:run
    ````
4. Acesse a API pelo navegador ou pela ferramenta Insomnia.

## 📝 Observações

Certifique-se de que você possui os seguintes pré-requisitos instalados:

- **Java 17**
- **Maven**
- **Docker** (caso queira rodar o projeto em contêineres)
