package br.una.revisao.repository;

import br.una.revisao.entity.Contato;
import org.springframework.data.repository.CrudRepository;

public interface ContatoRepository extends CrudRepository<Contato,Long> {
}
