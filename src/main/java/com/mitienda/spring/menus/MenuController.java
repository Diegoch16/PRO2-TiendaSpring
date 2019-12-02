package com.mitienda.spring.menus;

import java.text.ParseException;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.mitienda.spring.controllers.CategoryController;
import com.mitienda.spring.controllers.ClienteController;
import com.mitienda.spring.controllers.FacturaController;
import com.mitienda.spring.controllers.FacturaLineaController;
import com.mitienda.spring.controllers.ProductoController;
import com.mitienda.spring.models.Categorias;
import com.mitienda.spring.models.Clientes;
import com.mitienda.spring.models.Factura;
import com.mitienda.spring.models.FacturaLinea;
import com.mitienda.spring.models.Producto;

public class MenuController {
	
	private FacturaController ctrl = FacturaController.getInstance();
	private FacturaLineaController ctrl2 = FacturaLineaController.getInstance();
	private ProductoController ctrl3 = ProductoController.getInstance();
	private ClienteController ctrl4 = ClienteController.getInstance();
	private CategoryController ctrl5 = CategoryController.getInstance();

	private Menu menu;
	private Scanner keyboard;
	private static MenuController instance;

	private MenuController() {
		this.keyboard = new Scanner(System.in);
	}

	public static MenuController getInstance() {
		if (instance == null) {
			instance = new MenuController();
		}
		return instance;
	}

	public void callMenus() {
		menu = new MenuPrincipal();
		while (menu != null) {
			navegarMenu();
		}
		keyboard.close();
		System.out.println("ByeBye");
	}

	public Scanner getKeyboard() {
		return this.keyboard;
	}

	public void navegarMenu() {
		String opcion;
		System.out.println(menu.toString());
		opcion = this.keyboard.nextLine();
		menu = menu.siguienteMenu(opcion);
	}

	/*public Object seleccionarObjeto(Object obj) {

		int id = -1;
		List<Object> tabla = obj.list();
		if (tabla.isEmpty()) {
			System.out.println("No hay nada en la tabla");
			return null;
		}

		for (Object dbo : tabla) {
			System.out.println(dbo.getId() + " " + dbo.toString());
		}
		System.out.println("Introduzca la ID del objeto de " + obj.getTable() + " que quiera seleccionar ");
		try {
			id = Integer.parseInt(this.keyboard.nextLine());
		} catch (NumberFormatException ex) {
			System.out.println("Id no válida");
			return null;
		}
		Object pedido =  obj.getByid(id);

		return pedido;
	}//*/
	
	private String validarCampo(String regex) {
		String datos;
		datos = keyboard.nextLine();

		while (!Pattern.matches(regex, datos)) {
			System.out.println("El valor introducido para el campo no es válido");
			datos = keyboard.nextLine();
		}
		return datos;
	}

	public static String campoValido(String regex) {
		return MenuController.getInstance().validarCampo(regex);
	}

	public static Factura eligeFactura() {
		return (Factura) MenuController.getInstance().seleccionarObjeto(new Factura());
	}

	private Factura seleccionarObjeto(Factura factura) {
		
		int id = -1;
		List<Factura> tabla = ctrl.list();
		if (tabla.isEmpty()) {
			System.out.println("No hay nada en la tabla");
			return null;
		}

		for (Factura dbo : tabla) {
			System.out.println(dbo.getId() + " " + dbo.toString());
		}
		System.out.println("Introduzca la ID del objeto de facturas que quiera seleccionar ");//<-- getTable()
		try {
			id = Integer.parseInt(this.keyboard.nextLine());
		} catch (NumberFormatException ex) {
			System.out.println("Id no válida");
			return null;
		}
		Factura fc =  Factura.getInstance().getByid(factura, id); //<-- getByid()

		return fc;
	}

	public static FacturaLinea eligeLineaFactura() {
		return (FacturaLinea) MenuController.getInstance().seleccionarObjeto(new FacturaLinea());
	}


	private FacturaLinea seleccionarObjeto(FacturaLinea facturaLinea) {
		int id = -1;
		List<FacturaLinea> tabla = ctrl2.list();
		if (tabla.isEmpty()) {
			System.out.println("No hay nada en la tabla");
			return null;
		}

		for (FacturaLinea dbo : tabla) {
			System.out.println(dbo.getId() + " " + dbo.toString());
		}
		System.out.println("Introduzca la ID del objeto de facturasLinea que quiera seleccionar ");//<-- getTable()
		try {
			id = Integer.parseInt(this.keyboard.nextLine());
		} catch (NumberFormatException ex) {
			System.out.println("Id no válida");
			return null;
		}
		FacturaLinea fcl =  FacturaLinea.getInstance().getByid(facturaLinea, id); //<-- getByid()

		return fcl;
	}

	public static Clientes eligeCliente() {
		return (Clientes) MenuController.getInstance().seleccionarObjeto(new Clientes());
	}


	private Clientes seleccionarObjeto(Clientes clientes) {
		int id = -1;
		List<Clientes> tabla = ctrl4.list();
		if (tabla.isEmpty()) {
			System.out.println("No hay nada en la tabla");
			return null;
		}

		for (Clientes dbo : tabla) {
			System.out.println(dbo.getId() + " " + dbo.toString());
		}
		System.out.println("Introduzca la ID del objeto de clientes que quiera seleccionar ");//<-- getTable()
		try {
			id = Integer.parseInt(this.keyboard.nextLine());
		} catch (NumberFormatException ex) {
			System.out.println("Id no válida");
			return null;
		}
		Clientes c =  Clientes.getInstance().getByid(clientes, id); //<-- getByid()

		return c;
	}

	public static Producto eligeProducto() {
		return (Producto) MenuController.getInstance().seleccionarObjeto(new Producto());
	}


	private Producto seleccionarObjeto(Producto producto) {
		int id = -1;
		List<Producto> tabla = ctrl3.list();
		if (tabla.isEmpty()) {
			System.out.println("No hay nada en la tabla");
			return null;
		}

		for (Producto dbo : tabla) {
			System.out.println(dbo.getId() + " " + dbo.toString());
		}
		System.out.println("Introduzca la ID del objeto de producto que quiera seleccionar ");//<-- getTable()
		try {
			id = Integer.parseInt(this.keyboard.nextLine());
		} catch (NumberFormatException ex) {
			System.out.println("Id no válida");
			return null;
		}
		Producto p =  Producto.getInstance().getByid(producto, id); //<-- getByid()

		return p;
	}

	public static Categorias eligeCategoria() {
		return (Categorias) MenuController.getInstance().seleccionarObjeto(new Categorias());
	}


	private Categorias seleccionarObjeto(Categorias categorias) {
		int id = -1;
		List<Categorias> tabla = ctrl5.list();
		if (tabla.isEmpty()) {
			System.out.println("No hay nada en la tabla");
			return null;
		}

		for (Categorias dbo : tabla) {
			System.out.println(dbo.getId() + " " + dbo.toString());
		}
		System.out.println("Introduzca la ID del objeto de categorias que quiera seleccionar ");//<-- getTable()
		try {
			id = Integer.parseInt(this.keyboard.nextLine());
		} catch (NumberFormatException ex) {
			System.out.println("Id no válida");
			return null;
		}
		Categorias ca =  Categorias.getInstance().getByid(categorias, id); //<--getByid()

		return ca;
	}

	public static Date validarFecha() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

		Date fecha = new Date();
		String datos;
		boolean validado = false;

		datos = MenuController.getInstance().getKeyboard().nextLine();

		while (!validado) {
			try {
				fecha = sdf.parse(datos);
				validado = true;
			} catch (ParseException e) {
				System.err.println("Error: el formato de la fecha debe ser: yyyy/MM/dd");
				e.printStackTrace();
			}
		}
		return fecha;
	}
	
	

}
