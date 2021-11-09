package br.com.zup.Cadastros.cadastro.execptions;

public class CadastroDuplicadoException extends RuntimeException {

  public CadastroDuplicadoException(String mensagem) {
    super(mensagem);
  }
}
