package integracao.bancodedados.contatos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest  //o @DataJpaTest não insere os dados
public class ContatosRepositoryIntegrationTest {
	
	//injetar 
	@Autowired
	private ContatoRepository contatoRepository;

	//a primeira coisa que o código fará - criando método que vai ter um contato e o objeto instanciado e salvar no banco de dados
	@Before
	public void start() {
		ContatoModel contato = new ContatoModel("Chefe", "0y", "9xxxxxxx9");
		contatoRepository.save(contato);
		contato = new ContatoModel("Novo Chefe", "0y", "8xxxxxxx8");
		contatoRepository.save(contato);
		contato = new ContatoModel("chefe Mais Antigo", "0y", "7xxxxxxx7");
		contatoRepository.save(contato);
		contato = new ContatoModel("Amigo", "0z", "5xxxxxxx5");
		contatoRepository.save(contato);
	}


	@Test
	public void buscaNome () throws Exception {
		
		ContatoModel  contato = contatoRepository.findFirstByNome("Chefe");
		//verificação se é verdade que tem um nome = Chefe - só executa se for verdade
		Assert.assertTrue(contato.getNome().contentEquals("Chefe"));
				
	}
	
	
	

	
}
