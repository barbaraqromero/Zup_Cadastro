package br.com.zup.Cadastros.cadastro.exceptions;

public class CadastroNaoExisteException extends RuntimeException{

  public CadastroNaoExisteException(String mensagem) {
    super(mensagem);
  }
}
