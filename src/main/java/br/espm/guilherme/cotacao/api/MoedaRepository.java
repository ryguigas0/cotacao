package br.espm.guilherme.cotacao.api;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoedaRepository extends CrudRepository<MoedaModel, String> {

}
