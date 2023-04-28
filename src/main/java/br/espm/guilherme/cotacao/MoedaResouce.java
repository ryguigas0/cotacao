package br.espm.guilherme.cotacao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoedaResouce {

    @Autowired
    public MoedaService moedaService;

    @GetMapping("/moedas")
    public List<MoedaTO> getMoedas() {
        return moedaService.list();
    }

    @PostMapping("/moeda")
    public void postMoeda(@RequestBody MoedaTO newMoeda) {
        moedaService.create(newMoeda);
    }

    @DeleteMapping("/moedas/{id}")
    public void deleteMoeda(@PathVariable("id") String id){
        moedaService.delete(id);
    }
}
