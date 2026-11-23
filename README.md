# Order Management System

Sistema simples de microsserviços para demonstrar comunicação entre APIs, orquestração com Docker Compose e mensageria com RabbitMQ.

## Serviços

- `product-service`: mantém um catálogo em memória e reserva estoque.
- `order-service`: cria pedidos, consulta o `product-service` via HTTP e publica evento de pedido criado.
- `notification-service`: consome eventos do RabbitMQ e registra notificações processadas.

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

Serviços:

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

3. Consulte notificações:

```http
GET http://localhost:8083/api/notifications
```

## Aprendizados Demonstrados

- Separação de responsabilidades por serviço.
- Comunicação HTTP entre microsserviços.
- Publicação e consumo de eventos com RabbitMQ.
- Orquestração local com Docker Compose.
- Portas e variáveis de ambiente por serviço.
