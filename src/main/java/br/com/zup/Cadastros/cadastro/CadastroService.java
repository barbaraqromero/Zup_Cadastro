package br.com.zup.Cadastros.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CadastroService {
  @Autowired
  private CadastroRepository cadastroRepository;

  public void cadastrarCliente(Cadastro cadastro) {
    Cadastro novoCadastro = new Cadastro();
    novoCadastro.setCpf(cadastro.getCpf());
    novoCadastro.setNome(cadastro.getNome());
    novoCadastro.setSobrenome(cadastro.getSobrenome());
    novoCadastro.setCidade(cadastro.getCidade());
    novoCadastro.setBairro(cadastro.getBairro());
    novoCadastro.setNomeDoParenteProximo(cadastro.getNomeDoParenteProximo());
    novoCadastro.setMoraSozinho(cadastro.isMoraSozinho());
    novoCadastro.setTemPet(cadastro.isTemPet());
    novoCadastro.setIdade(cadastro.getIdade());
    novoCadastro.setDataDoCadastro(exibirDataAtual());
    cadastroRepository.save(novoCadastro);
  }

  public LocalDate exibirDataAtual() {
    LocalDate dataAtual = LocalDate.now();
    return dataAtual;

  }

  public List<Cadastro> aplicarFiltros(Boolean moraSozinho, Boolean temPet, Integer idade) {
    if (moraSozinho != null) {
      return cadastroRepository.findAllByMoraSozinho(moraSozinho);
    }
    if (temPet != null) {
      return cadastroRepository.findAllByTemPet(temPet);
    }
    if (idade != null) {
      return cadastroRepository.findAllByIdade(idade);
    }
    Iterable<Cadastro> cadastros = cadastroRepository.findAll();
    return (List<Cadastro>) cadastros;
  }
}
