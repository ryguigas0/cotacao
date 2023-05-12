# API de cotacao

## Como rodar

1. Clone o projeto
2. `mvn clean install`
3. `java -jar target/cotacao-0.0.1-SNAPSHOT.jar`

## Rotas

### Backoffice

- Página de admin: `/backoffice`

### API

- Detalhamento de moeda: `GET /api/moeda/{id}`
- Listagem de moedas: `GET /api/moedas`
- Criação de moeda: `POST /api/moeda`
- Remoção de moeda: `DELETE /api/moeda/{id}`

Coleção do insomnia disponível em: `cotacao_insomnia_collection.json`

## Função das classes

- `resources/application.properties`: configuração do servidor
- `resources/static/`: pasta com arquivos estaticos
- `resources/templates/`: pasta com os templates de páginas
- `resources/ddl.sql`: DDL (Data Definition Language) faz a definição do banco de dados
- API
  - `cotacao/api/MoedaTORequest.java`: TO signifca Transfer Object (ou DTO, Data  Transfer Object) para receber os dados de uma requisição
  - `cotacao/api/MoedaTOResponse.java`: TO signifca Transfer Object (ou DTO, Data  Transfer Object) para responsder dados requeridos para uma requisição
  - `cotacao/api/MoedaResouce.java`: Resource é responsável por:
    - receber dados do Service e enviar para o cliente
    - autorizar (permisão da identidade) e autenticar (verificar identidade) requisições
  - `cotacao/api/MoedaService.java`: Service é responsável por comunicar com o dados do banco de dados de acordo com a requisição e pode transformar o resultado e enviar um TO para o Resource
- Backoffice
  - `cotacao/backoffice/BackofficeService.java`: Serviço é responsável por devolver a página de administração de moedas
