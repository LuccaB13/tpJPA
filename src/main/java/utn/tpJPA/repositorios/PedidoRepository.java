package utn.tpJPA.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utn.tpJPA.entidades.Pedido;


@Repository
public interface PedidoRepository extends JpaRepository <Pedido,Long>{
}
