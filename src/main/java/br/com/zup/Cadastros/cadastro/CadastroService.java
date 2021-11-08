package br.com.zup.Cadastros.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroService {
    @Autowired
    private CadastroRepository cadastroRepository;

    public Cadastro cadastrarCliente (Cadastro novoCadastro){
        //Cadastro cadastro = new Cadastro();
        cadastroRepository.save(novoCadastro);
        return novoCadastro;
    }
}
