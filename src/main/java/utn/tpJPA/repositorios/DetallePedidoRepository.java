package utn.tpJPA.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utn.tpJPA.entidades.DetallePedido;

@Repository
public interface DetallePedidoRepository extends JpaRepository <DetallePedido,Long> {
}
