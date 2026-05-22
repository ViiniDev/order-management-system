# Order Management System

Sistema simples de microsservicos para demonstrar comunicacao entre APIs, orquestracao com Docker Compose e mensageria com RabbitMQ.

## Servicos

- `product-service`: mantem um catalogo em memoria e reserva estoque.
- `order-service`: cria pedidos, consulta o `product-service` via HTTP e publica evento de pedido criado.
- `notification-service`: consome eventos do RabbitMQ e registra notificacoes processadas.

## Tecnologias

- Java 17
- Spring Boot
- Spring Web
- Spring AMQP
- WebClient
- RabbitMQ
- Docker e Docker Compose
- Maven

## Como Executar com Docker

```bash
cp .env.example .env
docker compose up --build
```

Servicos:

```text
product-service: http://localhost:8081
order-service: http://localhost:8082
notification-service: http://localhost:8083
rabbitmq-management: http://localhost:15672
```

## Fluxo de Teste

1. Liste produtos:

```http
GET http://localhost:8081/api/products
```

2. Crie um pedido:

```http
POST http://localhost:8082/api/orders
```

```json
{
  "productId": 1,
  "customerEmail": "cliente@email.com",
  "quantity": 2
}
```

3. Consulte notificacoes:

```http
GET http://localhost:8083/api/notifications
```

## Aprendizados Demonstrados

- Separacao de responsabilidades por servico.
- Comunicacao HTTP entre microsservicos.
- Publicacao e consumo de eventos com RabbitMQ.
- Orquestracao local com Docker Compose.
- Portas e variaveis de ambiente por servico.
