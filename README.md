# TableManager

Sistema em Java para gerenciamento e distribuição otimizada de mesas em um restaurante, 
calculando automaticamente a melhor alocação de lugares com base nas reservas existentes.

## Funcionalidades
- Cálculo da capacidade total do restaurante
- Desconto automático de reservas fixas
- Algoritmo de distribuição inteligente de mesas
- Consulta de disponibilidade por tipo de mesa (2, 4 ou 6 lugares)

## Como funciona
O sistema recebe as reservas já confirmadas, subtrai do total de lugares disponíveis 
e encontra a combinação ideal de mesas de 6, 4 e 2 lugares que acomoda os clientes 
restantes usando o menor número de mesas possível.

## Tecnologias
- Java

## Estrutura
- `Tablemanager.java` — classe principal, executa o fluxo do sistema
- `ConsultaMesas.java` — lógica de distribuição e consulta de mesas

## Como usar
1. Clone o repositório
2. Compile e execute a classe `Tablemanager`
3. O sistema exibirá automaticamente a distribuição otimizada e as mesas disponíveis por tipo
