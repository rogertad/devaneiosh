package br.lippe.devaneios.devaneios.db;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface LocalRepository extends CrudRepository<Local, Long>{
    
    List<Local> findByNome(String name);

    Local findById(long id);

    List<Local> findByNomeContaining(String nome);

}
