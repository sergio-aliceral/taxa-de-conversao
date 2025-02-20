# Taxa de Conversão - API REST

## Descrição
Esta é uma API REST desenvolvida em **Spring Boot** para consulta de taxas de conversão entre moedas. A API consome a **ExchangeRate-API** para obter os valores das taxas de conversão e armazena os dados em um banco de dados embutido (**Nitrite**).

A API foi containerizada utilizando **Docker** e inclui testes de integração com **Testcontainers**.

---

## Tecnologias Utilizadas
- **Java 21**
- **Spring Boot 3.4.2**
- **Spring Web** (para criação da API REST)
- **Spring Cloud OpenFeign** (para consumo da ExchangeRate-API)
- **Nitrite Database** (banco de dados embutido)
- **Testcontainers** (para testes de integração)
- **Docker** (para containerização da aplicação)
- **SpringDoc OpenAPI** (para documentação da API - Swagger)

---

## Configuração e Execução

### 1. **Requisitos**
Antes de iniciar, garanta que você possui:
- **Java 21** instalado
- **Maven** instalado
- **Docker** instalado e rodando (caso deseje executar via container)

---

### 2. **Executando a API**
#### **Opção 1: Via Maven (localmente)**

1. Clone o repositório:
   ```sh
   git clone git@github.com:sergio-aliceral/taxa-de-conversao.git
   cd taxa-de-conversao
   ```
2. Compile e execute a aplicação:
   ```sh
   mvn clean install
   mvn spring-boot:run
   ```
3. A API estará rodando em: `http://localhost:8080`

---

#### **Opção 2: Via Docker**
1. Construa a imagem Docker:
   ```sh
   docker build -t taxa-de-conversao .
   ```
2. Execute o container:
   ```sh
   docker run -p 8080:8080 taxa-de-conversao
   ```
3. A API estará rodando em: `http://localhost:8080`

---

## **Documentação da API** (Swagger UI)
Após iniciar a API, a documentação estará disponível em:
- **Swagger UI:** `http://localhost:8080/swagger-ui/index.html`
- **Especificação OpenAPI:** `http://localhost:8080/v3/api-docs`

---

## **Testes**
### **Testes Unitários e de Integração**
Os testes podem ser executados com:
```sh
mvn test
```
Caso deseje rodar apenas os testes de integração com Testcontainers:
```sh
mvn verify
```

---

## **Variáveis de Ambiente**
Para configurar a API, utilize as seguintes variáveis de ambiente:
```properties
EXCHANGE_RATE_API_KEY=your-api-key
EXCHANGE_RATE_API_URL=https://api.exchangerate-api.com/v4/latest
```
Caso esteja utilizando Docker, você pode definir essas variáveis ao rodar o container:
```sh
docker run -e EXCHANGE_RATE_API_KEY=your-api-key -e EXCHANGE_RATE_API_URL=https://api.exchangerate-api.com/v4/latest -p 8080:8080 taxa-de-conversao
```

---

## **Endpoints Principais**

| Método  | Endpoint                              | Descrição |
|---------|-------------------------------------|-------------|
| GET     | `/taxa-conversao/{moedaBase}/{moedaAlvo}` | Retorna a taxa de conversão entre duas moedas |

Exemplo de requisição:
```sh
curl -X GET http://localhost:8080/taxa-conversao/USD/BRL
```


