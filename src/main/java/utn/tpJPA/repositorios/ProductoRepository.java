package utn.tpJPA.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utn.tpJPA.entidades.Producto;

@Repository
public interface ProductoRepository extends JpaRepository <Producto,Long>{
}
