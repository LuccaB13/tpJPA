package utn.tpJPA.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.FetchType;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;

    private String apellido;
    private String telefono;
    private String email;
    @OneToMany(cascade= CascadeType.ALL, orphanRemoval = true,fetch=FetchType.EAGER)
    @JoinColumn(name="cliente_id")
    @Builder.Default
    private List<Domicilio> domicilios = new ArrayList<>();
    public void agregarDomicilio(Domicilio domi){
        domicilios.add(domi);
    }

    @OneToMany(cascade= CascadeType.ALL, orphanRemoval = true,fetch=FetchType.EAGER)
    @JoinColumn(name="cliente_id")
    @Builder.Default
    private List<Pedido> pedidos = new ArrayList<>();
    public void agregarPedido(Pedido pedido){
        pedidos.add(pedido);
    }
}
