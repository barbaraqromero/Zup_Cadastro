package br.com.zup.Cadastros.cadastro.config;


import br.com.zup.Cadastros.cadastro.execptions.CadastroDuplicadoException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

  @ExceptionHandler(CadastroDuplicadoException.class)
  public MensagemDeErro cadastroDuplicadoExcepttion (CadastroDuplicadoException duplicidade){
    return new MensagemDeErro(duplicidade.getLocalizedMessage());

  }
}
