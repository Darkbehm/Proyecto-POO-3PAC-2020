package edu.unah.poo.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.unah.poo.model.Empleado;
import edu.unah.poo.model.Factura;
import edu.unah.poo.model.IdProductoVendido;
import edu.unah.poo.model.Limpieza;
import edu.unah.poo.model.LoteEnLimpieza;
import edu.unah.poo.model.LoteEnlatado;
import edu.unah.poo.model.LoteMateriaPrima;
import edu.unah.poo.model.Pescado;
import edu.unah.poo.model.ProductoVendido;
import edu.unah.poo.service.ServiceEmpleado;
import edu.unah.poo.service.ServiceFactura;
import edu.unah.poo.service.ServiceLimpieza;
import edu.unah.poo.service.ServiceLoteEnLimpieza;
import edu.unah.poo.service.ServiceLoteEnlatado;
import edu.unah.poo.service.ServiceLoteMateriaPrima;
import edu.unah.poo.service.ServicePescado;
import edu.unah.poo.service.ServiceProductoVendido;

@Controller
public class Controlador {
	@Autowired
	ServiceEmpleado serviceEmpleado;
	@Autowired
	ServiceFactura serviceFactura;
	@Autowired
	ServiceLimpieza serviceLimpieza;
	@Autowired
	ServiceLoteEnlatado serviceLoteEnlatado;
	@Autowired
	ServiceLoteEnLimpieza serviceLoteEnLimpieza;
	@Autowired
	ServiceLoteMateriaPrima serviceLoteMateriaPrima;
	@Autowired
	ServicePescado servicePescado;
	@Autowired
	ServiceProductoVendido serviceProductoVendido;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	/*
	 * =============================================================================
	 * ===== Encriptar
	 * =============================================================================
	 * =====
	 */
	
	@RequestMapping(value="/encriptar")
	public String encriptarContrasenias() {
		
		List<Empleado> empleados = this.serviceEmpleado.obtenerLista();
		String contrasenia= this.passwordEncoder.encode("1234");
		for (Empleado e : empleados) {
			e.setContrasenia(contrasenia);
			this.serviceEmpleado.crear(e);
		}
		return "encriptar";
	}
	
	
	
	/*
	 * =============================================================================
	 * ===== Empleado
	 * =============================================================================
	 * =====
	 */

	@GetMapping("/empleado/form")
	public String registrarEmpleado() {
		return "registroEmpleado";
	}

	@RequestMapping(value = "/empleado/crear")

	public String crearEmpleado(@RequestParam(name = "id") int idEmpleado, @RequestParam(name = "nombre") String nombre,
			@RequestParam(name = "telefono") int telefono, @RequestParam(name = "contrasenia") String contrasenia,
			@RequestParam(name = "puesto") String puesto, @RequestParam(name = "direccion") String direccion,
			@RequestParam(name = "fechaDeNacimiento") @DateTimeFormat(iso = ISO.DATE) LocalDate fechaDeNacimientoStr,
			@RequestParam(name = "fechaDeContratacion") @DateTimeFormat(iso = ISO.DATE) LocalDate fechaDeContratacion) {

		Empleado tmpEmpleado = new Empleado(idEmpleado, nombre, telefono, direccion, fechaDeNacimientoStr, puesto,
				fechaDeContratacion, this.passwordEncoder.encode(contrasenia));

		this.serviceEmpleado.crear(tmpEmpleado);

		return "registroEmpleado";
	}
	@RequestMapping(value = "/empleado/buscar", method = RequestMethod.GET)
	public Empleado buscarEmpleado(@RequestParam(name = "id") int idEmpleado) {
		return this.serviceEmpleado.buscar(idEmpleado);
	}

	@RequestMapping(value = "/empleado/listar", method = RequestMethod.GET)
	public String listarEmpleado(Model model) {
		List<Empleado> empleados = this.serviceEmpleado.obtenerLista();
		model.addAttribute("empleados", empleados);
		return "listadoEmpleado";
	}

	@GetMapping("/empleado/detalle/{id}")
	public String detalleEmpleado(@PathVariable("id") int id, Model model) {
		Empleado empleado = this.serviceEmpleado.buscar(id);
		model.addAttribute("empleado", empleado);
		return "detalleEmpleado";
	}

	/*
	 * =============================================================================
	 * ===== Pescado
	 * =============================================================================
	 * =====
	 */

	@GetMapping("/pescado/form")
	public String registrarPescado() {
		return "registroPescado";
	}

	@RequestMapping(value = "/pescado/crear")
	public String crearPescado(@RequestParam(name = "idPescado") int idPescado,
			@RequestParam(name = "nombre") String nombre, @RequestParam(name = "tamanioPromedio") int tamanioPromedio,
			@RequestParam(name = "color") String color, @RequestParam(name = "tipo") String tipo) {

		Pescado tmpPescado = new Pescado(idPescado, tamanioPromedio, nombre, color, tipo);
		this.servicePescado.crear(tmpPescado);

		return "registroPescado";
	}

	@RequestMapping(value = "/pescado/buscar", method = RequestMethod.GET)
	public Pescado buscarPescado(@RequestParam(name = "idPescado") int idPescado) {
		return this.servicePescado.buscar(idPescado);
	}

	@RequestMapping(value = "/pescado/listar", method = RequestMethod.GET)
	public String listarPescado(Model model) {
		List<Pescado> pescados = this.servicePescado.obtenerLista();
		model.addAttribute("pescados", pescados);
		return "listadoPescado";
	}

	@GetMapping("/pescado/detalle/{id}")
	public String detallePescado(@PathVariable("id") int id, Model model) {
		Pescado pescado = this.servicePescado.buscar(id);
		model.addAttribute("pescado", pescado);
		return "detallePescado";
	}


	/*
	 * =============================================================================
	 * ===== Lote Materia Prima
	 * =============================================================================
	 * =====
	 */

	@GetMapping("/lote/materiaprima/form")
	public String registrarLoteMateriaPrima() {
		return "registroMateriaPrima";
	}

	@RequestMapping(value = "/lote/crearLoteMateriaPrima")
	public String crearLoteMateriaPrima(@RequestParam(name = "idLote") int idLote,
			@RequestParam(name = "precioPorUnidadDeMedida") int precioPorUnidadDeMedida,
			@RequestParam(name = "cantidad") int cantidad, @RequestParam(name = "unidadDeMedida") String unidadDeMedida,
			@RequestParam(name = "indiceDeCalidad") int indiceDeCalidad,
			@RequestParam(name = "idPescado") int idPescado, @RequestParam(name = "idEmpleado") int idEmpleado,
			@RequestParam(name = "proveedor") String proveedor, @RequestParam(name = "estado") String estado) {

		Empleado empleado = this.serviceEmpleado.buscar(idEmpleado);
		Pescado pescado = this.servicePescado.buscar(idPescado);

		LoteMateriaPrima tmpLoteMateriaPrima = new LoteMateriaPrima(idLote, cantidad, precioPorUnidadDeMedida,
				unidadDeMedida, indiceDeCalidad, pescado, proveedor, estado, empleado);

		this.serviceLoteMateriaPrima.crear(tmpLoteMateriaPrima);

		return "registroMateriaPrima";
	}

	@RequestMapping(value = "/lote/buscarLoteMateriaPrima", method = RequestMethod.GET)
	public LoteMateriaPrima buscarLoteMateriaPrima(@RequestParam(name = "idLote") int idLote) {
		return this.serviceLoteMateriaPrima.buscar(idLote);
	}

	@RequestMapping(value = "/lote/listarLoteMateriaPrima", method = RequestMethod.GET)
	public String listarLoteMateriaPrima(Model model) {
		List<LoteMateriaPrima> loteMateriaPrima = this.serviceLoteMateriaPrima.obtenerLista();
		model.addAttribute("loteMateriaPrima", loteMateriaPrima);
		return "listadoMateriaPrima";
	}

	@GetMapping("/lote/materiaprima/detalle/{id}")
	public String detalleLoteMateriaPrima(@PathVariable("id") int id, Model model) {
		LoteMateriaPrima loteMateriaPrima = this.serviceLoteMateriaPrima.buscar(id);
		model.addAttribute("loteMateriaPrima", loteMateriaPrima);
		return "detalleMateriaPrima";
	}

	/*
	 * =============================================================================
	 * ===== Lote En Limpieza
	 * =============================================================================
	 * =====
	 */

	@RequestMapping(value = "/Limpieza/lote/crear/{id}", method = RequestMethod.POST)
	public String crearLoteEnLimpieza(@RequestParam(name = "idLote") int idLote, @PathVariable("id") int idLimpieza,Model model) {

		LoteMateriaPrima lote = this.serviceLoteMateriaPrima.obtener(idLote);

		Limpieza limpieza = this.serviceLimpieza.obtener(idLimpieza);

		LoteEnLimpieza tmpLoteEnLimpieza = new LoteEnLimpieza(idLote, idLimpieza, limpieza, lote);
		
		this.serviceLoteEnLimpieza.crear(tmpLoteEnLimpieza);

		model.addAttribute("limpieza",limpieza);

		return "registroLoteEnLimpieza";
	}

	@RequestMapping(value = "/Limpieza/lote/buscar", method = RequestMethod.GET)
	public LoteEnLimpieza buscarLoteEnLimpieza(@RequestParam(name = "idLote") int idLote) {
		return this.serviceLoteEnLimpieza.buscar(idLote);
	}

	@RequestMapping(value = "/Limpieza/lote/listar/{id}", method = RequestMethod.GET)
	public String listarLoteEnLimpieza(@PathVariable("id") int idLimpieza, Model model) {
		Limpieza limpieza = this.serviceLimpieza.buscar(idLimpieza);
		List<LoteEnLimpieza> lotesEnLimpieza = this.serviceLoteEnLimpieza.obtenerListaPorLimpieza(limpieza);
		model.addAttribute("lotesEnLimpieza", lotesEnLimpieza);
		return "listadoLoteEnLimpieza";
	}

	@RequestMapping(value = "/Limpieza/lote/listar/todos", method = RequestMethod.GET)
	public String listarLoteEnLimpieza(Model model) {
		List<LoteEnLimpieza> lotesEnLimpieza = this.serviceLoteEnLimpieza.obtenerLista();
		model.addAttribute("lotesEnLimpieza", lotesEnLimpieza);
		return "listadoLoteEnLimpieza";
	}
	
	/*
	 * =============================================================================
	 * ===== Limpieza
	 * =============================================================================
	 * =====
	 */

	@GetMapping("/Limpieza/form")
	public String registrarLimpieza() {
		return "registroLimpieza";
	}

	@RequestMapping(value = "/limpieza/crear")
	public String crearLimpieza(@RequestParam(name = "idEmpleado") int idEmpleado,
			@RequestParam(name = "idLimpieza") int idLimpieza, 
			@RequestParam(name = "horaInicial") String horaInicial,
			@RequestParam(name = "horaFinal") String horaFinal,
			@RequestParam(name = "numeroEmpleados") int numeroEmpleados,
			Model model) {
		
		int numeroEnlatados=0;
		Empleado empleado = this.serviceEmpleado.buscar(idEmpleado);

		Limpieza limpieza = new Limpieza(idLimpieza, horaInicial, horaFinal, numeroEmpleados, numeroEnlatados,
				empleado);

		this.serviceLimpieza.crear(limpieza);

		model.addAttribute("limpieza", limpieza);

		return "registroLoteEnLimpieza";
	}
	
	
	@RequestMapping("/Limpieza/terminar")
	public String terminarLimpieza(Model model) {
		return "terminarLimpieza";
	}
	
	@RequestMapping(value="/limpieza/terminar/id", method = RequestMethod.POST )
	public String terminarLimpieza(@RequestParam(name = "idLimpieza") int idLimpieza,Model model) {
		model.addAttribute("limpieza", this.serviceLimpieza.buscar(idLimpieza));
		return "terminarLimpiezaDatos";
	}
	
	@RequestMapping(value = "/limpieza/terminar/{id}", method = RequestMethod.POST)
	public String terminarLimpieza( Model model,
			@RequestParam(name = "numeroEnlatados") int numeroEnlatados,
			@RequestParam(name = "precioporlata") int precioporlata,
			@RequestParam(name = "precioporlata") int tamanioLata,
			@RequestParam(name = "fechaDePrecio") @DateTimeFormat(iso = ISO.DATE) LocalDate fechaDePrecio,
			@PathVariable(name = "id") int idLimpieza) {
		

		Limpieza limp =this.serviceLimpieza.obtener(idLimpieza);
		List<LoteEnLimpieza> lotesProcesados = this.serviceLoteEnLimpieza.obtenerListaPorLimpieza(this.serviceLimpieza.buscar(idLimpieza));
		
		//recorremos todos los elementos de la lista y actualizamos y creamos cada lote
		lotesProcesados.forEach((lote)->{
			// Actualizamos el lote de materia prima y el estado ahora sera procesado
			LoteMateriaPrima LoteAActualizar = this.serviceLoteMateriaPrima.obtener(lote.getLote().getIdLote());
			LoteAActualizar.setEstado("Procesado");
			this.serviceLoteMateriaPrima.crear(LoteAActualizar);
			

			limp.setNumeroEnlatados(limp.getNumeroEnlatados()+numeroEnlatados);
			this.serviceLimpieza.crear(limp);
			
			int idLoteEnlatado= idLimpieza + 10000 + LoteAActualizar.getIdLote() ;
			


			this.crearLoteEnlatado(idLoteEnlatado, precioporlata, LoteAActualizar.getCantidad(), "Latas", LoteAActualizar.getIndiceDeCalidad(),
					LoteAActualizar.getPescado().getIdPescado(), tamanioLata, fechaDePrecio);

		});
		
		model.addAttribute("limpieza", this.serviceLimpieza.buscar(idLimpieza));

		return "detalleLimpieza";
	}

	@RequestMapping(value = "/limpieza/buscar", method = RequestMethod.GET)
	public Limpieza buscarLimpieza(@RequestParam(name = "idLimpieza") int idLimpieza) {
		return this.serviceLimpieza.buscar(idLimpieza);
	}

	@RequestMapping(value = "/limpieza/listar", method = RequestMethod.GET)
	public String listarLimpieza(Model model) {
		List<Limpieza> limpieza = this.serviceLimpieza.obtenerLista();
		model.addAttribute("limpieza", limpieza);
		return "listadoLimpieza";
	}

	@GetMapping("/limpieza/detalle/{id}")
	public String detalleLimpieza(@PathVariable("id") int id, Model model) {
		Limpieza limpieza = this.serviceLimpieza.buscar(id);
		model.addAttribute("limpieza", limpieza);
		return "detalleLimpieza";
	}
	

	/*
	 * =============================================================================
	 * ===== Lote Enlatado
	 * =============================================================================
	 * =====
	 */

	public LoteEnlatado crearLoteEnlatado( 
			int idLote,
			int precioPorCantidadDeMedida,
			int cantidad,  
			String unidadDeMedida,
			int indiceDeCalidad,
			int idPescado, 
			int tamanioLata,
			LocalDate fechaDePrecio) {

		Pescado pescado = this.servicePescado.buscar(idPescado);

		LoteEnlatado tmpLoteEnlatado = new LoteEnlatado(idLote, cantidad, precioPorCantidadDeMedida, unidadDeMedida,
				indiceDeCalidad, pescado, tamanioLata, fechaDePrecio);

		this.serviceLoteEnlatado.crear(tmpLoteEnlatado);
		return tmpLoteEnlatado;
	}
	
	@RequestMapping(value = "/lote/buscarLoteEnlatado", method = RequestMethod.GET)
	public LoteEnlatado buscarLoteEnlatado(@RequestParam(name = "idLote") int idLote) {
		return this.serviceLoteEnlatado.buscar(idLote);
	}

	@RequestMapping(value = "/lote/listarLoteEnlatado", method = RequestMethod.GET)
	public String  listarLoteEnlatado(Model model) {
		List<LoteEnlatado> enlatado= this.serviceLoteEnlatado.obtenerLista();
		model.addAttribute("enlatado", enlatado);
		return "listadoEnlatado";
	}
	

	@GetMapping("/lote/enlatado/detalle/{id}")
	public String detalleEnlatado(@PathVariable("id") int id, Model model) {
		LoteEnlatado enlatado = this.serviceLoteEnlatado.buscar(id);
		model.addAttribute("enlatado", enlatado);
		return "detalleEnlatado";
	}
	
	/*
	 * =============================================================================
	 * ===== Factura
	 * =============================================================================
	 * =====
	 */
	@GetMapping(value = "/factura/form")
	public String registrarFactura() {
		return "registroFactura";
	}
	
	@RequestMapping(value = "/factura/crear")
	public String crearFactura(Model model,
			@RequestParam(name = "numeroFactura") int numeroFactura,
			@RequestParam(name = "fechaVenta") @DateTimeFormat(iso = ISO.DATE) LocalDate fechaVenta,
			@RequestParam(name = "lugar") String lugar,
			@RequestParam(name = "idEmpleado") int idEmpleado) {

		Empleado empleado = this.serviceEmpleado.buscar(idEmpleado);

		Factura tmpFactura = new Factura(numeroFactura, fechaVenta, lugar, empleado);

		this.serviceFactura.crear(tmpFactura);
		model.addAttribute("factura", tmpFactura);
		return "registroProductoVendido";
	}

	@RequestMapping(value = "/factura/buscar", method = RequestMethod.GET)
	public Factura buscarFactura(@RequestParam(name = "numeroFactura") int numeroFactura) {
		return this.serviceFactura.buscar(numeroFactura);
	}

	@RequestMapping(value = "/factura/listar", method = RequestMethod.GET)
	public String listarFactura(Model model) {
		List<Factura> facturas= this.serviceFactura.obtenerLista();
		model.addAttribute("facturas", facturas);
		return "listadoFactura";
	}
	
	@GetMapping(value="/factura/detalle/{id}")
	public String detalleFactura(@PathVariable("id") int id, Model model) {
		Factura factura= this.serviceFactura.buscar(id);
		List<ProductoVendido> productos = this.serviceProductoVendido.obtenerListaPorFactura(factura);
		model.addAttribute("factura",factura);
		model.addAttribute("productos",productos);
		return "detalleFactura";
	}
	
	/*
	 * =============================================================================
	 * ===== Producto Vendido
	 * =============================================================================
	 * =====
	 */

	@RequestMapping(value = "/producto/vender/{id}")
	public String crearProductoVendido(Model model,
			@PathVariable("id") int numeroFactura,
			@RequestParam(name = "idLote") int idLote, 
			@RequestParam(name = "precio") float precio,
			@RequestParam(name = "cantidad") int cantidad) {

		LoteEnlatado loteenlatado = this.serviceLoteEnlatado.buscar(idLote);
		Factura factura = this.serviceFactura.buscar(numeroFactura);

		ProductoVendido tmpProductoVendido = new ProductoVendido(idLote, numeroFactura, precio, cantidad, loteenlatado,
				factura);
		
		this.serviceProductoVendido.crear(tmpProductoVendido);
			
		//rebajamos la cantidad del lote
		LoteEnlatado LoteAActualizar = this.serviceLoteEnlatado.obtener(idLote);
		LoteAActualizar.setCantidad(LoteAActualizar.getCantidad()-cantidad);
		this.serviceLoteEnlatado.crear(LoteAActualizar);

		model.addAttribute("factura", factura);
		return "registroProductoVendido";
	}

	@RequestMapping(value = "/producto/buscar", method = RequestMethod.GET)
	public ProductoVendido buscarProductoVendido(@RequestParam(name = "numeroFactura") int numeroFactura,
			@RequestParam(name = "idLimpieza") int idLote) {
		IdProductoVendido idproducto = new IdProductoVendido(numeroFactura, idLote);
		return this.serviceProductoVendido.buscar(idproducto);
	}

	@RequestMapping(value = "/producto/listar", method = RequestMethod.GET)
	public  String listarProductoVendido(Model model) {
		List<ProductoVendido> productos= this.serviceProductoVendido.obtenerLista();
		model.addAttribute("productos", productos);
		return "listadoProductos";
	}
	
	//FINAL 
	
}
