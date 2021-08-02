package br.lippe.devaneios.devaneios.db;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface CausoRepository extends JpaRepository<Causo, String> {

}