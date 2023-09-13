package utn.tpJPA.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utn.tpJPA.entidades.Factura;


@Repository
public interface FacturaRepository extends JpaRepository <Factura,Long> {
}
