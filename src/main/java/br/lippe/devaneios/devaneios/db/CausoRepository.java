package br.lippe.devaneios.devaneios.db;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface CausoRepository extends JpaRepository<Causo, String> {

}