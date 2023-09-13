package utn.tpJPA.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utn.tpJPA.entidades.Domicilio;

@Repository
public interface DomicilioRepository extends JpaRepository<Domicilio,Long> {
}
