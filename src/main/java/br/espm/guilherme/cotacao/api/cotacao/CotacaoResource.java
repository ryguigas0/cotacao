package br.espm.guilherme.cotacao.api.cotacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.espm.guilherme.cotacao.api.moeda.MoedaService;

@RequestMapping("/api/cotacao")
@RestController
public class CotacaoResource {

    @Autowired
    CotacaoService cotacaoService;

    @Autowired
    MoedaService moedaService;

    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd' 'HH:mm");

    @GetMapping("/{sigla}")
    public ResponseEntity<?> listBySigla(@PathVariable("sigla") String siglaMoeda,
            @RequestParam(name = "start-date", required = false) String startDate)
            throws ParseException, RuntimeException {

        List<CotacaoResponseTO> cotacoes;

        if (startDate == null) {
            cotacoes = cotacaoService.findByMoedaId(siglaMoeda);
        } else {
            cotacoes = cotacaoService.findByMoedaId(siglaMoeda, sdf.parse(startDate));
        }

        return new ResponseEntity<List<CotacaoResponseTO>>(cotacoes, HttpStatus.OK);

    }

    @PostMapping("/criar")
    public ResponseEntity<CotacaoResponseTO> criarCotacao(@RequestBody() CotacaoRequestTO cotacaoRequestTO) {
        return new ResponseEntity<CotacaoResponseTO>(cotacaoService.createCotacao(cotacaoRequestTO),
                HttpStatus.CREATED);
    }

}
