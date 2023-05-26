package br.espm.guilherme.cotacao.api.moeda;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MoedaRepository extends CrudRepository<MoedaModel, String> {

    @Query(value = "select * from moeda where sigla = :siglaMoeda", nativeQuery = true)
    public Optional<MoedaModel> findBySigla(@Param("siglaMoeda") String siglaMoeda);
}
