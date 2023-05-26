package br.espm.guilherme.cotacao.api.cotacao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CotacaoRepository extends CrudRepository<CotacaoModel, String> {

    @Query(value = "select * from cotacao where moeda_id = :moedaId", nativeQuery = true)
    List<CotacaoModel> findByMoedaId(@Param("moedaId") String moedaId);

    @Query(value = "select * from cotacao where moeda_id = :moedaId and cotacao.data >= :startDate", nativeQuery = true)
    List<CotacaoModel> findByMoedaId(@Param("moedaId") String moedaId, @Param("startDate") Date starDate);

}
