package br.espm.guilherme.cotacao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public List<MoedaTOResponse> getMoedas() {
        return moedaService.list();
    }

    @GetMapping("/moeda/{id}")
    public ResponseEntity<?> getMoeda(@PathVariable("id") String id) {

        try {
            Optional<MoedaTOResponse> searchResult = moedaService.find(id);

            MoedaTOResponse moeda = searchResult.orElseThrow();

            return new ResponseEntity<MoedaTOResponse>(moeda, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/moeda")
    public void postMoeda(@RequestBody MoedaTORequest newMoeda) {
        moedaService.create(newMoeda);
    }

    @DeleteMapping("/moedas/{id}")
    public void deleteMoeda(@PathVariable("id") String id) {
        moedaService.delete(id);
    }
}
