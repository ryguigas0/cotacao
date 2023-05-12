# API de cotacao

## Como rodar

1. Clone o projeto
2. `mvn clean install`
3. `java -jar target/cotacao-0.0.1-SNAPSHOT.jar`

## Rotas

### Backoffice

- Página de admin: `/backoffice`

### API

- Detalhamento de moeda: `GET /moeda/{id}`
- Listagem de moedas: `GET /moedas`
- Criação de moeda: `POST /moeda`
- Remoção de moeda: `DELETE /moeda/{id}`

Coleção do insomnia disponível em: `cotacao_insomnia_collection.json`

## Função das classes

- `src/main/resources/application.properties`: configuração do servidor
- `src/main/java/br/espm/guilherme/cotacao/MoedaTORequest.java`: TO signifca Transfer Object (ou DTO, Data  Transfer Object) para receber os dados de uma requisição
- `src/main/java/br/espm/guilherme/cotacao/MoedaTOResponse.java`: TO signifca Transfer Object (ou DTO, Data  Transfer Object) para responsder dados requeridos para uma requisição
- `src/main/java/br/espm/guilherme/cotacao/MoedaResouce.java`: Resource é responsável por:
  - receber dados do Service e enviar para o cliente
  - autorizar (permisão da identidade) e autenticar (verificar identidade) requisições
- `src/main/java/br/espm/guilherme/cotacao/MoedaService.java`: Service é responsável por comunicar com o dados do banco de dados de acordo com a requisição e pode transformar o resultado e enviar um TO para o Resource
