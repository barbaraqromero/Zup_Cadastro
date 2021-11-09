package br.com.zup.Cadastros.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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


}
