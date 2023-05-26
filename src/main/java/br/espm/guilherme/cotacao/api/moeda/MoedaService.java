package br.espm.guilherme.cotacao.api.moeda;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoedaService {

    @Autowired
    private MoedaRepository repo;

    public List<MoedaTOResponse> list() {
        List<MoedaTOResponse> moedas = new ArrayList<>();

        repo.findAll().forEach(m -> {
            moedas.add(new MoedaTOResponse(m.getId(), m.getNome(), m.getSimbolo(), m.getSigla()));
        });

        return moedas;
    }

    public void create(MoedaTORequest moeda) {
        repo.save(new MoedaModel(moeda));
    }

    public void delete(String id) {
        repo.deleteById(id);
    }

    public Optional<MoedaTOResponse> find(String id) {
        return repo.findById(id).map(m -> {
            return new MoedaTOResponse(m.getId(), m.getNome(), m.getSimbolo(), m.getSigla());
        });
    }
}
