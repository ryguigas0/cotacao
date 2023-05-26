package br.espm.guilherme.cotacao.api.cotacao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.espm.guilherme.cotacao.api.moeda.MoedaService;
import br.espm.guilherme.cotacao.api.moeda.MoedaTOResponse;

@Service
public class CotacaoService {

    @Autowired
    CotacaoRepository repo;

    @Autowired
    MoedaService moedaService;

    public List<CotacaoResponseTO> findByMoedaId(String siglaMoeda) {
        MoedaTOResponse moeda = moedaService.findBySigla(siglaMoeda);

        if (moeda == null) {
            throw new RuntimeException("MOEDA NÃO ENCONTRADA");
        }

        return repo.findByMoedaId(moeda.id())
                .stream()
                .map(
                        cotacao -> new CotacaoResponseTO(
                                cotacao.getId(), cotacao.getValor(), moeda, cotacao.getData()))
                .toList();
    }

    public List<CotacaoResponseTO> findByMoedaId(String siglaMoeda, Date starDate) {
        MoedaTOResponse moeda = moedaService.findBySigla(siglaMoeda);

        if (moeda == null) {
            throw new RuntimeException("MOEDA NÃO ENCONTRADA");
        }

        return repo.findByMoedaId(moeda.id(), starDate)
                .stream()
                .map(
                        cotacao -> new CotacaoResponseTO(
                                cotacao.getId(), cotacao.getValor(), moeda, cotacao.getData()))
                .toList();
    }

    public CotacaoResponseTO createCotacao(CotacaoRequestTO cotacaoRequestTO) {

        MoedaTOResponse moeda = moedaService.find(cotacaoRequestTO.moedaId())
                .orElseThrow(() -> new RuntimeException("MOEDA NÃO ENCONTRADA"));

        CotacaoModel cotacaoModel = repo.save(new CotacaoModel(cotacaoRequestTO));

        return new CotacaoResponseTO(cotacaoModel.getId(), cotacaoModel.getValor(), moeda, cotacaoModel.getData());
    }
}
