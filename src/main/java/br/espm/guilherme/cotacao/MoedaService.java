package br.espm.guilherme.cotacao;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class MoedaService {
    private static final ArrayList<MoedaTOResponse> moedas = new ArrayList<>();

    static {
        moedas.add(new MoedaTOResponse(UUID.randomUUID().toString(), "Dolar", "U$", "USD"));
        moedas.add(new MoedaTOResponse(UUID.randomUUID().toString(), "Libra", "£", "LIB"));
    }

    public List<MoedaTOResponse> list() {
        return moedas;
    }

    public void create(MoedaTORequest moeda) {
        MoedaTOResponse newMoeda = new MoedaTOResponse(UUID.randomUUID().toString(),
                moeda.nome(), moeda.simbolo(), moeda.sigla());

        moedas.add(newMoeda);
    }

    public void delete(String id) {
        moedas.removeIf(moeda -> moeda.id().equals(id));
    }
}
