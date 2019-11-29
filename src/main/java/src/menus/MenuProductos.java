package src.menus;

import java.util.List;


import src.models.Categorias;
import src.models.Producto;

import com.mitienda.spring.controllers.ProductoController;

public class MenuProductos extends Menu {
	
	private ProductoController ctrl = ProductoController.getInstance();
	
	public String toString() {
		// TODO Auto-generated method stub
		return "Que acción quiere realizar? \n" + "1.Crear nuevo producto \n" + "2.Ver productos \n"
				+ "3.Ver productos de una categor�a\n" + "4.Editar un producto\n" + "5.Borrar un producto \n" +

				"0.Volver al menú principal";

	}

	public Menu siguienteMenu(String opcion) {

		switch (opcion) {
		case "1":
			crearProducto();
			break;
		case "2":
			verProductos();
			break;
		case "3":
			verProductosCat();
			break;
		case "4":
			editarProducto();
			break;
		case "5":
			borrarProducto();
			break;
		case "0":
			return new MenuPrincipal();
		default:
			System.out.println("Opción no válida");
			break;

		}
		return new MenuProductos();
	}

	private void crearProducto() {
		Producto prod = new Producto();

		System.out.println("Elija la categoría del producto");
		Categorias cat = MenuController.eligeCategoria();
		if (cat == null) {
			System.out.println("Categor�a no v�lida");
			return;
		}

		System.out.println("Introduzca el nombre del producto");
		prod.setNombre(MenuController.campoValido("^[^,]+$"));
		System.out.println("Introduzca el precio del producto (en centimos)");
		prod.setPrecio(Integer.parseInt(MenuController.campoValido("^[^,]+$")));
		System.out.println("Introduzca la cantidad de producto en stock ");
		prod.setStock(Integer.parseInt(MenuController.campoValido("^[^,]+$")));

		prod.setId_categoria(cat.getId());
		ctrl.save(prod);
	}

	private void verProductos() {
		List<Producto> prodList = ctrl.list();
		for (Producto obj : prodList) {
			System.out.println(obj.getId() + " " + obj.toString());
		}
	}

	private void verProductosCat() {
		Categorias cat = MenuController.eligeCategoria();
		if (cat == null) {
			System.out.println("Categor�a no encontrada");
			return;
		}
		List<Producto> prodList = ctrl.list();
		for (Producto obj : prodList) {
			Producto prod = (Producto) obj;
			if (prod.getId_categoria() == cat.getId()) {
				System.out.println(prod.getId() + " " + prod.toString());
			}
		}
	}

	private void editarProducto() {
		Producto prod = MenuController.eligeProducto();
		if (prod == null) {
			System.out.println("Producto no encontrado");
			return;
		}
		System.out.println("Elija la nueva categoría del producto");
		Categorias cat = MenuController.eligeCategoria();
		if (cat == null) {
			System.out.println("Categoría no válida");
			return;
		}

		System.out.println("Introduzca el nombre del producto Actual: " + prod.getNombre());
		prod.setNombre(MenuController.campoValido("^[^,]+$"));
		System.out.println("Introduzca el precio del producto (en centimos) Actual: " + prod.getPrecio());
		prod.setPrecio(Integer.parseInt(MenuController.campoValido("^[^,]+$")));
		System.out.println("Introduzca la cantidad de producto en stock Actual: " + prod.getStock());
		prod.setStock(Integer.parseInt(MenuController.campoValido("^[^,]+$")));

		prod.setId_categoria(cat.getId());
		ctrl.save(prod);
	}

	private void borrarProducto() {
		Producto prod = MenuController.eligeProducto();
		if (prod == null) {
			System.out.println("Producto no encontrado");
			return;
		}
		ctrl.delete(prod);

	}

}
