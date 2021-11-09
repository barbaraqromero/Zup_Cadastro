package br.com.zup.Cadastros.cadastro;

import br.com.zup.Cadastros.cadastro.execptions.CadastroDuplicadoException;
import br.com.zup.Cadastros.cadastro.execptions.CadastroNaoExisteException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CadastroService {
  @Autowired
  private CadastroRepository cadastroRepository;

  public void cadastrarCliente(Cadastro cadastro) {
    if (cadastroRepository.existsById(cadastro.getCpf())) {
      throw new CadastroDuplicadoException();
    }
    cadastro.setDataDoCadastro(LocalDate.now());
    cadastroRepository.save(cadastro);
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

  public void deletarCadastro(String cpf) {
    if (cadastroRepository.existsById(cpf)) {
      cadastroRepository.deleteById(cpf);
    } else {
      throw new CadastroNaoExisteException();
    }

  }

  public Cadastro pesquisarCadastroPorID(String cpf) {
    Optional<Cadastro> cadastroOptional = cadastroRepository.findById(cpf);
    if (cadastroOptional.isPresent()) {
      return cadastroOptional.get();
    }
    throw new CadastroNaoExisteException();
  }
}
