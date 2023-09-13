package utn.tpJPA.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utn.tpJPA.entidades.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository <Cliente,Long> {
}
