package br.com.zup.Cadastros.cadastro;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CadastroRepository extends CrudRepository<Cadastro, String> {
  List<Cadastro> findAllByMoraSozinho(Boolean moraSozinho);

  List<Cadastro> findAllByTemPet(Boolean temPet);

  List<Cadastro> findAllByIdade(Integer idade);
}
