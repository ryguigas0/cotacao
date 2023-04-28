package br.espm.guilherme.cotacao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class MoedaService {
    private static final List<MoedaTO> moedas = new ArrayList<>();

    static {
        moedas.add(new MoedaTO(UUID.randomUUID().toString(), "Dolar", "U$", "USD"));
        moedas.add(new MoedaTO(UUID.randomUUID().toString(), "Libra", "£", "LIB"));
    }

    public List<MoedaTO> list() {
        return moedas;
    }

    public void create(MoedaTO moeda) {
        moedas.add(moeda);
    }

    public void delete(String id) {
        moedas.removeIf(moeda -> moeda.id().equals(id));
    }
}
