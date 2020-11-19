package integracao.bancodedados.contatos;

import java.util.List;
import java.util.stream.Stream;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ContatoRepository extends JpaRepository<Contato, Long> {

	
		//procurar
	Contato findFirstByNome(String nome);

		//procurar por nome ,igno// 
	List<Contato> findAllByNomeIgnoreCaseContaining(String nome);

	//ordem alfabetica
	@Query(value = "SELECT c FROM Contato c")
	List<Contato> buscaTodosContatosComOrdenacao(Sort sort);
	
	//ordem alfabetica
	@Query(value = "SELECT D FROM Contato D")
	List<Contato> buscaTodosContatosComOrdenacao2(Sort sort);
	
	//ordem alfabetica
	@Query(value = "SELECT c FROM Contato c ORDER BY nome")
	Stream<Contato> buscaTodosContatos();


}

	
	
/*
		//procurar
	Contato findFirstByNome(String nome);

		//procurar por nome, ignorar
	List<Contato> findAllByNomeIgnoreCaseContaining(String nome);
	
	//ordem alfabetica
	@Query (value = "select c from Contato c")
	List<Contato> buscaTodosContatosComOrdenacao(Sort sort);
	//ordem alfabetica
	@Query (value = "select c from Contato D")
	List<Contato> buscaTodosContatosComOrdenacao2(Sort sort);
	////ordem alfabetica com S
	@Query (value = "select c from Contato c order by nome")
	Stream<Contato> buscaTodosContatos();
	
	*/


