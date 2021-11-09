package br.com.zup.Cadastros.cadastro.exceptions;

public class CadastroDuplicadoException extends RuntimeException {

  public CadastroDuplicadoException(String mensagem) {
    super(mensagem);
  }
}
