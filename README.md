# Exchange Rate

Este projeto fornece um serviço simples para obter taxas de câmbio usando uma API externa. Ele utiliza as bibliotecas `Gson` para parse de JSON e `dotenv` para carregar variáveis de ambiente. O serviço consulta a API de câmbio e retorna as taxas de câmbio para uma moeda base fornecida.

## Funcionalidades

- Conversão de diferentes moedas
- Interface amigável e intuitiva

## Como Executar o Projeto

1. Clone o repositório:
  ```bash
  git clone https://github.com/seu-usuario/exchange.git
  ```
2. Navegue até o diretório do projeto:
  ```bash
  cd Exchange-rate
  ```
## Interação via Console

O projeto possui uma interface de console onde você pode inserir a moeda de origem, a moeda de destino e o valor a ser convertido. A aplicação então consulta a API do exchangerate-api para obter a taxa de câmbio atual e exibe o valor convertido.

## Pré-requisitos

Antes de rodar o projeto, certifique-se de que os seguintes pré-requisitos estão instalados em sua máquina:

- Java 17 ou superior
- Dependências: `Gson`, `dotenv`
