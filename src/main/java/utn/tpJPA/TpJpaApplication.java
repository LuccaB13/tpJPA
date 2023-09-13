package utn.tpJPA;

import org.springframework.stereotype.Repository;
import utn.tpJPA.entidades.*;
import utn.tpJPA.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Date;

@SpringBootApplication
public class TpJpaApplication {

	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	DomicilioRepository domicilioRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	FacturaRepository facturaRepository;
	@Autowired
	DetallePedidoRepository detallePedidoRepository;
	@Autowired
	ProductoRepository productoRepository;
	@Autowired
	RubroRepository rubroRepository;

	public static void main(String[] args) {
		SpringApplication.run(TpJpaApplication.class, args);
	}

	@Bean
	CommandLineRunner init(ClienteRepository personaRepo,DomicilioRepository domicilioRepository,PedidoRepository pedidoRepository,FacturaRepository facturaRepository,DetallePedidoRepository detallePedidoRepository,ProductoRepository productoRepository,RubroRepository rubroRepository) {
		return args -> {
			System.out.println("-----------------ESTOY FUNCIONANDO---------");
			Cliente cliente = new Cliente();
			cliente.setNombre("Juan");
			cliente.setApellido("Pérez");
			cliente.setTelefono("11111");
			cliente.setEmail("ejemplo@ejemplo.com");
			Cliente cliente2 = new Cliente();
			cliente2.setNombre("Pepe");
			cliente2.setApellido("Lopez");
			cliente2.setTelefono("111221");
			cliente2.setEmail("ejemplo1@ejemplo.com");

			Domicilio domicilio1= new Domicilio();
			domicilio1.setCalle("Calle 1");
			domicilio1.setNumero("11");
			domicilio1.setLocalidad("San Martín");

			Domicilio domicilio2= new Domicilio();
			domicilio2.setCalle("Calle 2");
			domicilio2.setNumero("22");
			domicilio2.setLocalidad("Mendoza");

			Domicilio domicilio3= new Domicilio();
			domicilio3.setCalle("Calle 3");
			domicilio3.setNumero("33");
			domicilio3.setLocalidad("Rivadavia");

			cliente.agregarDomicilio(domicilio1);
			cliente.agregarDomicilio(domicilio2);
			cliente2.agregarDomicilio(domicilio3);

			Pedido pedido=new Pedido();
			pedido.setEstado("entregado");
			pedido.setTipoEnvio("retira");
			pedido.setTotal(100);
			pedido.setFecha(new Date());

			cliente.agregarPedido(pedido);

			Factura factura=new Factura();
			factura.setNumero(1111);
			factura.setDescuento(0);
			factura.setFormaPago("efectivo");
			factura.setTotal(100);
			factura.setFecha(new Date());

			pedido.agregarFactura(factura);

			DetallePedido detallePedido=new DetallePedido();
			detallePedido.setCantidad(1);
			detallePedido.setSubtotal(0);


			pedido.agregarDetallePedido(detallePedido);

			Producto producto=new Producto();
			producto.setTipo("Insumo");
			producto.setTiempoEstimadoCocina(40);
			producto.setDenominacion("ejemplo");
			producto.setPrecioVenta(600);
			producto.setPrecioCompra(200);
			producto.setStockActual(15);
			producto.setStockMinimo(5);
			producto.setUnidadMedida("nn");
			producto.setReceta("Ejemplo");

			detallePedido.setProducto(producto);

			Rubro rubro=new Rubro();
			rubro.setDenominacion("Ejemplo");
			rubro.agregarProducto(producto);


			// Guardar el objeto Persona en la base de datos
//        PersonaRepository personaRepository = context.getBean(PersonaRepository.class);
			clienteRepository.save(cliente);
			clienteRepository.save(cliente2);
			rubroRepository.save(rubro);



			// Recuperar el objeto Persona desde la base de datos
			Cliente clienteRecuperado = clienteRepository.findById(cliente.getId()).orElse(null);
			if (clienteRecuperado != null) {
				System.out.println("Nombre: " + clienteRecuperado.getNombre());
				System.out.println("Apellido: " + clienteRecuperado.getApellido());
				System.out.println("Telefono: " + clienteRecuperado.getTelefono());
				System.out.println("Email: " + clienteRecuperado.getEmail());
			}

		};

	}


}
