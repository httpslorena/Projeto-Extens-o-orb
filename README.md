# 🌐 ØRB NETWORKS - Sistema de Gerenciamento de Usuários

![Java](https://img.shields.io/badge/Java-21-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.7-brightgreen)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue)
![License](https://img.shields.io/badge/License-MIT-yellow)

Sistema web completo de cadastro e gerenciamento de usuários desenvolvido com **Spring Boot**, **Thymeleaf**, **Spring Security** e **MySQL**.

---

## 📋 Índice

- [Sobre o Projeto](#sobre-o-projeto)
- [Vídeo de Demonstração](#vídeo-de-demonstração)
- [Funcionalidades](#funcionalidades)
- [Tecnologias Utilizadas](#tecnologias-utilizadas)
- [Pré-requisitos](#pré-requisitos)
- [Instalação e Configuração](#instalação-e-configuração)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Como Usar](#como-usar)
- [Capturas de Tela](#capturas-de-tela)
- [Desenvolvedor](#desenvolvedor)

---

## 🎯 Sobre o Projeto

**ØRB NETWORKS** é um projeto acadêmico full-stack desenvolvido para a disciplina de **Sistemas de Informação**. O sistema permite o cadastro, autenticação e gerenciamento de usuários, com uma interface temática cyberpunk/neon.

### Objetivos do Projeto:
- Implementar um CRUD completo
- Aplicar conceitos de autenticação e autorização
- Trabalhar com persistência de dados (JPA/Hibernate)
- Desenvolver uma interface responsiva e moderna

---

## 🎥 Vídeo de Demonstração

**Assista à demonstração completa do projeto:**  
[![Vídeo de Demonstração](https://img.shields.io/badge/YouTube-Assistir%20Demonstração-red?style=for-the-badge&logo=youtube)](https://youtu.be/5JpoE52Nw38)

**Link direto:** https://youtu.be/5JpoE52Nw38

> **No vídeo você verá:**
> - ✅ Sistema de autenticação e login
> - ✅ Área restrita e controle de acesso
> - ✅ CRUD de usuários (deletar)
> - ✅ Integração com banco de dados MySQL
> - ✅ Todas as funcionalidades em ação

---

## ⚡ Funcionalidades

✅ **Cadastro de Usuários** - Registro com username, email e senha  
✅ **Autenticação Segura** - Login com Spring Security e BCrypt  
✅ **Gerenciamento de Usuários** - Listagem e exclusão de usuários cadastrados  
✅ **Página Inicial Pública** - Acesso sem necessidade de login  
✅ **Área Restrita** - Acesso à lista de usuários apenas após login  
✅ **Design Cyberpunk** - Interface moderna com tema neon  
✅ **Persistência de Dados** - MySQL com JPA/Hibernate  

---

## 🛠️ Tecnologias Utilizadas

### Backend:
- **Java 21**
- **Spring Boot 3.5.7**
  - Spring Web
  - Spring Data JPA
  - Spring Security
- **MySQL 8.0**
- **Hibernate (JPA)**
- **BCrypt** (criptografia de senhas)

### Frontend:
- **Thymeleaf** (template engine)
- **HTML5 / CSS3**
- **JavaScript**
- **Google Fonts** (Orbitron, Rajdhani)

### Ferramentas:
- **Maven** (gerenciamento de dependências)
- **VSCode** (IDE)
- **MySQL Workbench**
- **Git / GitHub**

---

## 📦 Pré-requisitos

Antes de executar o projeto, certifique-se de ter instalado:

- **Java JDK 21** ou superior
- **Maven 3.8+**
- **MySQL 8.0+**
- **IDE** (VSCode, IntelliJ IDEA, Eclipse)
- **Git**

---

## 🚀 Instalação e Configuração

### 1. Clone o repositório:
```bash
git clone https://github.com/httpslorena/Projeto-Extens-o-orb.git
```

### 2. Configure o banco de dados MySQL:

**Crie o banco de dados:**
```sql
CREATE DATABASE projeto;
```

**Configure o `application.properties`:**

Edite o arquivo `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/projeto
spring.datasource.username=root
spring.datasource.password=SUA_SENHA_AQUI
spring.jpa.hibernate.ddl-auto=update
server.port=8081
```

### 3. Execute o projeto:

**Usando Maven:**
```bash
mvn spring-boot:run
```

**Ou compile e execute o JAR:**
```bash
mvn clean package
java -jar target/atividade-0.0.1-SNAPSHOT.jar
```

### 4. Acesse no navegador:
```
http://localhost:8081/
```

---

## 📁 Estrutura do Projeto

```
projeto-orb/
│
├── src/
│   ├── main/
│   │   ├── java/com/formulario/atividade/
│   │   │   ├── config/
│   │   │   │   └── SecurityConfig.java
│   │   │   ├── controller/
│   │   │   │   └── UsuarioController.java
│   │   │   ├── model/
│   │   │   │   └── Usuario.java
│   │   │   ├── repository/
│   │   │   │   └── UsuarioRepository.java
│   │   │   ├── service/
│   │   │   │   ├── DetalhesUsuarioService.java
│   │   │   │   └── UsuarioService.java
│   │   │   └── AtividadeApplication.java
│   │   │
│   │   └── resources/
│   │       ├── static/
│   │       │   ├── css/
│   │       │   │   └── style.css
│   │       │   └── img/
│   │       │       ├── madame.jpg
│   │       │       ├── mamba.jpg
│   │       │       └── zig.jpg
│   │       ├── templates/
│   │       │   ├── admin_painel.html
│   │       │   ├── cadastrar.html
│   │       │   ├── home.html
│   │       │   ├── login.html
│   │       │   ├── sobre.html
│   │       │   └── usuarios.html
│   │       └── application.properties
│   │
│   └── test/
│
├── pom.xml
└── README.md
```

---

## 💻 Como Usar

### 1. **Página Inicial (Home)**
- Acesse `http://localhost:8081/`
- Visualize informações sobre boates underground de SP
- Escolha entre fazer login ou cadastrar

### 2. **Cadastrar Novo Usuário**
- Clique em "CRIAR CONTA / CADASTRAR"
- Preencha: Username, Email e Senha
- Clique em "INICIAR CADASTRO"

### 3. **Fazer Login**
- Clique em "INICIAR SESSÃO (LOGIN)"
- Entre com seu Username e Senha
- Após login, você será redirecionado para a home

### 4. **Acessar Lista de Usuários**
- **Após estar logado**, clique em "ACESSAR MATRIZ DE USUÁRIOS"
- Visualize todos os usuários cadastrados
- Utilize o botão "EXCLUIR" para remover usuários

### 5. **Sobre o Projeto**
- Clique em "INFORMAÇÕES DO PROJETO"
- Veja detalhes técnicos e informações do desenvolvedor

---

## 📸 Capturas de Tela

> **💡 Dica:** Para adicionar suas próprias imagens, tire prints das telas e salve na pasta `img/` do projeto.

### Página Inicial (Home)
![Página Home](img/home.png)
*Interface principal com tema cyberpunk/neon e informações sobre boates underground*

### Login
![Tela de Login](img/login.png)
*Tela de autenticação segura com Spring Security*

### Cadastro
![Formulário de Cadastro](img/cadastro.png)
*Formulário de registro com validação de dados e criptografia de senha*

### Lista de Usuários
![Matriz de Usuários](img/usuarios.png)
*Matriz de dados com todos os usuários cadastrados e opção de exclusão*

---

## 🔐 Segurança

O projeto implementa as seguintes medidas de segurança:

✅ **Senhas criptografadas** com BCrypt  
✅ **Autenticação** via Spring Security  
✅ **Rotas protegidas** - `/usuarios` requer autenticação  
✅ **Validação de dados** no frontend e backend  
✅ **Proteção contra SQL Injection** (JPA/Hibernate)  

---

## 🎓 Contexto Acadêmico

**Disciplina:** Sistemas de Informação  
**Período:** 1º Semestre - Noturno  
**Turma:** A  
**Ano:** 2025  

### Conceitos Aplicados:
- Arquitetura MVC (Model-View-Controller)
- ORM (Object-Relational Mapping) com JPA
- Injeção de Dependências
- Segurança de Aplicações Web
- Persistência de Dados
- RESTful principles

---

## 🚧 Melhorias Futuras

- [ ] Implementar funcionalidade de Editar usuário
- [ ] Adicionar paginação na lista de usuários
- [ ] Implementar recuperação de senha
- [ ] Adicionar validação de email (confirmação)
- [ ] Sistema de roles (ADMIN, USER)
- [ ] Dashboard com estatísticas
- [ ] API RESTful documentada com Swagger

---

## 👤 Desenvolvedor

**Lorena**  
Estudante de Sistemas de Informação - 1º Semestre  
📧 Email: lorena.alves.pereira@uni9.edu.br  
🐱 GitHub: [@httpslorena](https://github.com/httpslorena)

---

## 📄 Licença

Este projeto é um trabalho acadêmico e está disponível para fins educacionais.

---



---

**ØRB NETWORKS | COPYRIGHT 2025 | PROTOCOL 7.1.A**

*"Explorando o futuro da tecnologia, uma linha de código por vez."* 🚀
