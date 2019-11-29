package src.menus;

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

import src.models.Categorias;
import src.models.Clientes;
import src.models.Factura;
import src.models.FacturaLinea;
import src.models.Producto;
import src.models.*;

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
		System.out.println("Introduzca la ID del objeto de " + factura.getTable() + " que quiera seleccionar ");
		try {
			id = Integer.parseInt(this.keyboard.nextLine());
		} catch (NumberFormatException ex) {
			System.out.println("Id no válida");
			return null;
		}
		Object pedido =  factura.getByid(id);

		return pedido;
		return null;
	}

	public static FacturaLinea eligeLineaFactura() {
		return (FacturaLinea) MenuController.getInstance().seleccionarObjeto(new FacturaLinea());
	}


	private FacturaLinea seleccionarObjeto(FacturaLinea facturaLinea) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Clientes eligeCliente() {
		return (Clientes) MenuController.getInstance().seleccionarObjeto(new Clientes());
	}


	private Clientes seleccionarObjeto(Clientes clientes) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Producto eligeProducto() {
		return (Producto) MenuController.getInstance().seleccionarObjeto(new Producto());
	}


	private Producto seleccionarObjeto(Producto producto) {
		// TODO Auto-generated method stub
		return null;
	}

	public static Categorias eligeCategoria() {
		return (Categorias) MenuController.getInstance().seleccionarObjeto(new Categorias());
	}


	private Categorias seleccionarObjeto(Categorias categorias) {
		// TODO Auto-generated method stub
		return null;
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
