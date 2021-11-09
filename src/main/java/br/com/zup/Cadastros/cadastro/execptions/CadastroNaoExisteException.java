package br.com.zup.Cadastros.cadastro.execptions;

public class CadastroNaoExisteException extends RuntimeException{

  public CadastroNaoExisteException(String mensagem) {
    super(mensagem);
  }
}
