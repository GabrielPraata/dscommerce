# 🛒 DSCommerce

### Projeto completo de e-commerce com autenticação, autorização e funcionalidades administrativas e públicas

Este projeto é um estudo completo inspirado em um cenário real de e-commerce, desenvolvido com Java e Spring Boot. Contém funcionalidades essenciais como autenticação JWT, controle de permissões, cadastro de produtos, categorias, usuários, carrinho de compras e pedidos — incluindo área administrativa para usuários com papel de ADMIN.

---

### 👨‍🎓 Objetivo

Este projeto foi desenvolvido como parte de estudos avançados em backend Java, com foco em:
- Autenticação e autorização com Spring Security e JWT
- Boas práticas de arquitetura e DTOs
- Camadas de serviço, repositório e controlador REST
- Banco H2 para testes e PostgreSQL em produção
- Uso de roles para controle de acesso (CLIENT, ADMIN)
- Fluxo completo de um sistema de e-commerce

---

### 🛠️ Tecnologias

- Java 17+
- Spring Boot
- Spring Security + JWT
- Spring Data JPA
- PostgreSQL / H2
- Maven
- Git

---

### ⚙️ Funcionalidades

#### Área Pública
- 🔎 Consultar catálogo de produtos (paginado e filtrável)
- 🛒 Gerenciar carrinho (inserir, remover, alterar quantidades)
- 🧑 Cadastrar novo usuário (sign up)
- 🔐 Login e geração de token JWT

#### Cliente logado
- 🧾 Registrar pedido com base no carrinho
- 📋 Visualizar histórico de pedidos
- ✏️ Atualizar seus próprios dados

#### Admin
- 🛍️ CRUD de produtos e categorias
- 👥 CRUD de usuários
- 💳 Registrar pagamentos
- 📊 Relatórios de pedidos com filtro por data

---

### 🔑 Autenticação JWT

Para acessar as rotas protegidas, é necessário obter um token JWT via:
```http
POST /oauth/token
```

Exemplo:
```bash
curl -X POST http://localhost:8080/oauth/token \
  -u myclientid:myclientsecret \
  -d grant_type=password \
  -d username=maria@gmail.com \
  -d password=123456
```

#### Usuários para teste:

| E-mail             | Senha   | Permissões             |
|--------------------|---------|------------------------|
| alex@gmail.com     | 123456  | ROLE_OPERATOR          |
| maria@gmail.com    | 123456  | ROLE_OPERATOR, ADMIN   |

---

### 🧪 Execução local

#### Pré-requisitos:
- Java 17
- Maven
- PostgreSQL ou H2 (configurável por `spring.profiles.active`)

#### Passos:
```bash
git clone https://github.com/GabrielPraata/dscommerce.git
cd dscommerce
./mvnw spring-boot:run
```

---

### 🧪 Testes e Documentação

O projeto ainda está em desenvolvimento e receberá:
- ✅ Testes automatizados
- 📄 Documentação completa via Swagger
- 📦 Coleção de testes no Postman

👉 [Clique aqui para importar a coleção no Postman](DSCommerce.postman_collection.json)

---

### 🗃️ Modelo de Domínio

- Usuários com múltiplos papéis (CLIENT, ADMIN)
- Produtos associados a múltiplas categorias
- Pedido contendo múltiplos itens
- Status do pedido: AGUARDANDO_PAGAMENTO, PAGO, ENVIADO, ENTREGUE, CANCELADO

---

### 📊 Relacionamentos principais

- **User ⇄ Role**: muitos-para-muitos
- **Product ⇄ Category**: muitos-para-muitos
- **Order ⇄ OrderItem ⇄ Product**: composição com quantidade, preço e subtotal

---

### 🧩 Casos de uso implementados

| Caso de uso           | Acesso         |
|------------------------|----------------|
| Consultar catálogo     | Público         |
| Gerenciar carrinho     | Público         |
| Sign up / Login        | Público         |
| Registrar pedido       | Cliente         |
| Visualizar pedidos     | Cliente         |
| Atualizar perfil       | Cliente         |
| Manter produtos        | Admin           |
| Manter categorias      | Admin           |
| Manter usuários        | Admin           |
| Registrar pagamento    | Admin           |
| Relatório de pedidos   | Admin           |

---

### 👨‍💻 Autor

**Gabriel Prata**  
🔗 [GitHub](https://github.com/GabrielPraata)  
🔗 [LinkedIn](https://www.linkedin.com/in/gabrielprata/)

---

### 📄 Licença

Projeto com fins educacionais. Todos os direitos reservados ao autor e à [DevSuperior](https://devsuperior.com.br).
