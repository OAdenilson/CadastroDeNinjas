# 🥷 Cadastro de Ninjas

API REST desenvolvida com Spring Boot para gerenciamento de ninjas, com operações completas de CRUD, autenticação e interface web.

---

## 📋 Sobre o Projeto

O **Cadastro de Ninjas** é um projeto de estudo desenvolvido para praticar os fundamentos do ecossistema Spring, incluindo persistência de dados, versionamento de banco, documentação de API e boas práticas de desenvolvimento backend.

---

## 🚀 Tecnologias Utilizadas

- **Java** — Linguagem principal
- **Spring Boot** — Framework base da aplicação
- **Spring Data JPA** — Persistência e mapeamento objeto-relacional
- **Spring Security** — Autenticação e controle de acesso
- **H2 Database** — Banco de dados em memória
- **Flyway** — Versionamento e migrations do banco de dados
- **Thymeleaf** — Template engine para interface web
- **Swagger / OpenAPI** — Documentação interativa da API
- **Lombok** — Redução de boilerplate
- **SQL** — Consultas e manipulação de dados

---

## ⚙️ Pré-requisitos

Antes de rodar o projeto, certifique-se de ter instalado:

- [Java 17+](https://www.oracle.com/java/technologies/downloads/)
- [Maven](https://maven.apache.org/)
- [Git](https://git-scm.com/)

---

## 🔧 Como Rodar o Projeto

**1. Clone o repositório**
```bash
git clone https://github.com/OAdenilson/CadastroDeNinjas.git
```

**2. Acesse a pasta do projeto**
```bash
cd CadastroDeNinjas
```

**3. Configure as variáveis de ambiente**

Crie um arquivo `.env` na raiz do projeto com as seguintes variáveis:
```env
DB_USERNAME=seu_usuario
DB_PASSWORD=sua_senha
JWT_SECRET=sua_chave_secreta
```

> ⚠️ Nunca compartilhe seu arquivo `.env`. Ele já está no `.gitignore`.

**4. Execute o projeto**
```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em: `http://localhost:8080`

---

## 🔐 Autenticação

O projeto utiliza autenticação com login e senha. Para acessar os endpoints protegidos, é necessário realizar login primeiro para obter o token de acesso.

---

## 📚 Documentação da API

Com a aplicação rodando, acesse a documentação interativa pelo Swagger:

```
http://localhost:8080/swagger-ui.html
```

---

## 📌 Funcionalidades

- [x] Cadastrar ninja
- [x] Listar todos os ninjas
- [x] Buscar ninja por ID
- [x] Atualizar dados do ninja
- [x] Deletar ninja
- [x] Autenticação com login e senha
- [x] Documentação via Swagger
- [x] Interface web com Thymeleaf
- [x] Versionamento do banco com Flyway

