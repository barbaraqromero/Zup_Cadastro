package br.com.zup.Cadastros.cadastro.config;


import br.com.zup.Cadastros.cadastro.exceptions.CadastroDuplicadoException;
import br.com.zup.Cadastros.cadastro.exceptions.CadastroNaoExisteException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvice {

  @ExceptionHandler(CadastroDuplicadoException.class)
  @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
  public MensagemDeErro cadastroDuplicadoExcepttion(CadastroDuplicadoException duplicidade) {
    return new MensagemDeErro(duplicidade.getLocalizedMessage());

  }

  @ExceptionHandler(CadastroNaoExisteException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  public MensagemDeErro cadastroNaoExisteException(CadastroNaoExisteException inexistente) {
    return new MensagemDeErro(inexistente.getLocalizedMessage());
  }

  public List<MensagemDeErro> tratarErrosDeValidacao(MethodArgumentNotValidException exception) {
    List<MensagemDeErro> errosDeValidacao = new ArrayList<>();

    for (FieldError referencia : exception.getFieldErrors()) {
      errosDeValidacao.add(new MensagemDeErro(referencia.getDefaultMessage()));
    }
    return errosDeValidacao;
  }


}





