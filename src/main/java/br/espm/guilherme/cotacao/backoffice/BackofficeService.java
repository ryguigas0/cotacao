package br.espm.guilherme.cotacao.backoffice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BackofficeService {

    @GetMapping("/backoffice")
    public String showBackoffice(){
        return "backoffice";
    }
}
