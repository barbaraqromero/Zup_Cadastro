package br.com.zup.Cadastros.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/cadastros")
public class CadastroController {
  @Autowired
  private CadastroService cadastroService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void cadastrarCliente(@RequestBody Cadastro cadastro) {
    cadastroService.cadastrarCliente(cadastro);

  }

  @GetMapping
  public List<ResumoDTO> aplicarFiltros(@RequestParam(required = false) boolean moraSozinho,
                                        @RequestParam(required = false) boolean temPet,
                                        @RequestParam(required = false) Integer idade) {

    List<ResumoDTO> resumo = new ArrayList<>();
    for (Cadastro referencia : cadastroService.aplicarFiltros(moraSozinho, temPet, idade)) {
      resumo.add(new ResumoDTO(referencia.getCpf(), referencia.getNome(), referencia.getSobrenome()));
    }
    return resumo;

  }


}
