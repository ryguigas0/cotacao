# API de cotacao

- `src/main/resources/application.properties`: configuração do servidor
- `src/main/java/br/espm/guilherme/cotacao/MoedaTORequest.java`: TO signifca Transfer Object (ou DTO, Data  Transfer Object) para receber os dados de uma requisição
- `src/main/java/br/espm/guilherme/cotacao/MoedaTOResponse.java`: TO signifca Transfer Object (ou DTO, Data  Transfer Object) para responsder dados requeridos para uma requisição
- `src/main/java/br/espm/guilherme/cotacao/MoedaResouce.java`: Resource é responsável por:
  - receber dados do Service e enviar para o cliente
  - autorizar (permisão da identidade) e autenticar (verificar identidade) requisições
- `src/main/java/br/espm/guilherme/cotacao/MoedaService.java`: Service é responsável por comunicar com o dados do banco de dados de acordo com a requisição e pode transformar o resultado e enviar um TO para o Resource
