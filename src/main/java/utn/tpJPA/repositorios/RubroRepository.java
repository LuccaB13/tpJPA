package utn.tpJPA.repositorios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import utn.tpJPA.entidades.Rubro;

@Repository
public interface RubroRepository extends JpaRepository <Rubro,Long>{
}
