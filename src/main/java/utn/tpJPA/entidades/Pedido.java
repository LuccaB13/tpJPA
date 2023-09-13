package utn.tpJPA.entidades;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.FetchType;


import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pedido implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String estado;
    private Date fecha;
    private String tipoEnvio;
    private double total;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="factura_id")
    private Factura factura;
    public void agregarFactura(Factura fact){
        factura=fact;
    }
    @OneToMany(cascade= CascadeType.ALL, orphanRemoval = true,fetch=FetchType.EAGER)
    @JoinColumn(name="pedido_id")
    @Builder.Default
    private List<DetallePedido> detallePedidos = new ArrayList<>();
    public void agregarDetallePedido(DetallePedido det){
        detallePedidos.add(det);
    }

}
