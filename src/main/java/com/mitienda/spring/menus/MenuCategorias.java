package com.mitienda.spring.menus;

import java.util.List;

import com.mitienda.spring.controllers.CategoryController;
import com.mitienda.spring.models.Categorias;

public class MenuCategorias extends Menu {
	
	private CategoryController ctrl = CategoryController.getInstance();

	public String toString() {
		// TODO Auto-generated method stub
		return "¿Qué  acción quiere realizar? \n" + "1.Crear nueva categoría \n" + "2.Ver categorías \n"
				+ "3.Actualizar una categoría \n" + "4.Borrar una categoría \n" +

				"0.Volver al menú principal";
	}

	@Override
	public Menu siguienteMenu(String opcion) {

		switch (opcion) {
		case "1":
			crearCategoria();
			break;
		case "2":
			verCategorias();
			break;

		case "3":
			actualizarCategoria();
			break;
		case "4":
			borrarCategoria();
			break;

		case "0":
			return new MenuPrincipal();

		default:
			System.out.println("Opción no válida");
			break;
		}
		return new MenuCategorias();

	}

	private void crearCategoria() {
		Categorias cat = new Categorias();
		System.out.println("Introduzca un nombre para la categoría");
		cat.setName(MenuController.campoValido("^[^,]+$"));
	 
		ctrl.save(cat);
	}

	private void verCategorias() {
	 
		List<Categorias> listaCat = ctrl.list();
		System.out.println("Tabla Categoria: ");
		System.out.println("ID \t Nombre");
		for (Categorias cat : listaCat) { 
			System.out.print(cat.getId() + "\t");
			System.out.print(cat.getName() + "\n");
		}
	}

	private void actualizarCategoria() {
		Categorias cat = MenuController.eligeCategoria();
		if (cat == null) {
			return;
		}
		System.out.println("Introduzca un nombre para la categorí a");
		cat.setName(MenuController.campoValido("^[^,]+$"));
		ctrl.save(cat);
	}

	private void borrarCategoria() {
		Categorias cat = MenuController.eligeCategoria();
		if (cat == null) {

			return;
		}
		ctrl.delete(cat);
	}

}
