# 🧊 Fridge API — Gerenciador de Alimentos

Uma API REST simples e prática, desenvolvida em **Java 21** e **Spring Boot 4**, criada para fins de estudo para gerenciar alimentos dentro de uma geladeira. O projeto implementa um CRUD básico seguindo a arquitetura em camadas e boas práticas para quem está dando os primeiros passos no ecossistema Spring.


---

## 📺 Referência de Estudo

Este projeto foi construído com base e aprofundamento do conteúdo prático:
- 🎥 **Vídeo Tutorial / Referência:** [Spring Boot CRUD Tutorial no YouTube](https://youtu.be/g4y0yADhsJA?si=M6Zq2_883OKflPGP)
- 🎯 **Objetivo:** Compreender a fundo a arquitetura em camadas (`Controller` -> `Service` -> `Repository` -> `Model`), injeção de dependências, verbos HTTP (GET, POST, PUT, DELETE), manipulação de `Optional`, tratamento de status codes REST e banco de dados H2.

---

## 🚀 Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 4.1.1**
  - **Spring Web / WebMVC** (Endpoints REST)
  - **Spring Data JPA** (Persistência e abstração de banco de dados)
  - **Hibernate** (ORM)
- **H2 Database** (Banco em memória rápido para desenvolvimento e testes)
- **Maven** (Gerenciamento de dependências e build)

---

## 🏛️ Arquitetura em Camadas

O projeto adota a separação de responsabilidades em camadas bem definidas:

```text
       [Cliente HTTP: Bruno, Postman, Navegador]
                         │
                         ▼
             1. Controller (FoodController)
       • Recebe requisições HTTP (GET, POST, PUT, DELETE)
       • Mapeia rotas e parâmetros (@PathVariable, @RequestBody)
       • Retorna os dados serializados em JSON
                         │
                         ▼
               2. Service (FoodService)
       • Regras de negócio da aplicação
       • Validações e atualização segura de dados
                         │
                         ▼
             3. Repository (FoodRepository)
       • Interface que estende JpaRepository
       • Comunicação direta com o banco sem necessidade de SQL manual
                         │
                         ▼
                4. Model (Food Entity)
       • Entidade JPA que mapeia a tabela no banco
                         │
                         ▼
               [ Banco de Dados H2 ]
```

---

## 🗄️ Estrutura da Entidade `Food`

| Campo | Tipo | Descrição |
| :--- | :--- | :--- |
| `id` | `Long` | Identificador único autoincrementado (Primary Key) |
| `name` | `String` | Nome do alimento (ex: `Queijo Mussarela`) |
| `quantity` | `Integer` | Quantidade disponível na geladeira |
| `expirationDate` | `LocalDate` | Data de validade no formato `YYYY-MM-DD` |

---

## 🌐 Endpoints da API

**URL Base:** `http://localhost:8080/food`

| Método | Rota | Descrição | Status de Sucesso |
| :--- | :--- | :--- | :---: |
| **`GET`** | `/food` | Lista todos os alimentos da geladeira | `200 OK` |
| **`GET`** | `/food/{id}` | Busca um alimento específico pelo ID | `200 OK` |
| **`POST`** | `/food` | Adiciona um novo alimento à geladeira | `200 OK` / `201 Created` |
| **`PUT`** | `/food/{id}` | Atualiza os dados de um alimento existente | `200 OK` |
| **`DELETE`** | `/food/{id}` | Remove um alimento da geladeira | `200 OK` |

---

## 🧪 Exemplos de Requisições (JSON)

### 1. Criar Alimento (`POST /food`)
```json
{
  "name": "Leite Integral",
  "quantity": 2,
  "expirationDate": "2026-11-15"
}
```

### 2. Atualizar Alimento (`PUT /food/1`)
```json
{
  "name": "Leite Desnatado",
  "quantity": 3,
  "expirationDate": "2026-11-20"
}
```

---

## 🛠️ Como Executar o Projeto

### Pré-requisitos
- **JDK 21** instalado
- Git instalado (opcional)

### Passo a passo
1. Clone o repositório ou acerte a pasta do projeto:
   ```bash
   cd Fridge
   ```
2. Execute a aplicação via Maven Wrapper:
   - **No Windows (PowerShell/CMD):**
     ```powershell
     .\mvnw.cmd spring-boot:run
     ```
   - **No Linux/Mac:**
     ```bash
     ./mvnw spring-boot:run
     ```
3. A API estará disponível em: `http://localhost:8080/food`

---

## 🗃️ Acesso ao Console do Banco de Dados H2

Para visualizar as tabelas e dados salvos no banco em memória:

1. Acesse no navegador: `http://localhost:8080/h2-console`
2. Preencha as credenciais exatamente como configurado no `application.yml`:
   - **Driver Class:** `org.h2.Driver`
   - **JDBC URL:** `jdbc:h2:mem:fridgedb`
   - **User Name:** `rich`
   - **Password:** *(deixe em branco)*
3. Clique em **Connect**.
4. Execute queries diretamente no console, como:
   ```sql
   SELECT * FROM FOOD;
   ```

---

## 👨‍💻 Autor

Desenvolvido por **Richard** ([@richdssz](https://github.com/richdssz)).
