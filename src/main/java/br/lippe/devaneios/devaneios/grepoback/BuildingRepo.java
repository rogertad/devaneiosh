package br.lippe.devaneios.devaneios.grepoback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuildingRepo extends CrudRepository<Building, Long> {

}