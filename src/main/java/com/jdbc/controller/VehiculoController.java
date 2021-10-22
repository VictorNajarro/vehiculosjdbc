package com.jdbc.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jdbc.dao.VehiculoDAO;
import com.jdbc.model.Vehiculo;

@WebServlet("/vehiculoController")
public class VehiculoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	VehiculoDAO vehiculoDAO = new VehiculoDAO();

	public VehiculoController() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String opcion = request.getParameter("opcion");

		if (opcion.equals("registro")) {
			// RequestDispatcher rd = request.getRequestDispatcher("registro.jsp");
			// rd.forward(request, response);
			mostrarPagina(request, response, "registro.jsp");
		} else if (opcion.equals("editar")) {
			int id = Integer.parseInt(request.getParameter("id"));
			VehiculoDAO vehiculoDAO = new VehiculoDAO();
			Vehiculo vehiculo = new Vehiculo();
			vehiculo = vehiculoDAO.getVehiculo(id);
			System.out.println(vehiculo);
			request.setAttribute("vehiculo", vehiculo);
			mostrarPagina(request, response, "editar.jsp");
		} else if (opcion.equals("eliminar")) {
			try {
				if (vehiculoDAO.delete(Integer.parseInt(request.getParameter("id")))) {
					System.out.println("Registro eliminado correctamente...");
					List<Vehiculo> lista = vehiculoDAO.getAll();
					request.setAttribute("vehiculos", lista);
					mostrarPagina(request, response, "index.jsp");
				} else {
					System.out.println("Registro no eliminado");
				}
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}// Fin doGet

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String opcion = request.getParameter("opcion");
		if (opcion.equals("crear")) {
			Vehiculo vehiculo = new Vehiculo();
			vehiculo = llenarVehiculo(request);

			/*
			 * vehiculo.setPlaca(request.getParameter("placa"));
			 * vehiculo.setMarca(request.getParameter("marca"));
			 * vehiculo.setModelo(request.getParameter("modelo"));
			 * vehiculo.setAnio(request.getParameter("anio"));
			 * vehiculo.setCilindraje(request.getParameter("cilindraje"));
			 * vehiculo.setConsumo(request.getParameter("consumo"));
			 */

			try {
				if (vehiculoDAO.save(vehiculo)) {
					System.out.println("Registro guardado correctamente...");
				} else {
					System.out.println("Registro no guardado");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}

			List<Vehiculo> lista = vehiculoDAO.getAll();
			request.setAttribute("vehiculos", lista);

			// RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			// rd.forward(request, response);

			mostrarPagina(request, response, "index.jsp");

		} else if (opcion.equals("editar")) {
			mostrarPagina(request, response, "editar.jsp");
			Vehiculo vehiculo = new Vehiculo();
			VehiculoDAO vehiculoDAO = new VehiculoDAO();
			vehiculo.setId(Integer.parseInt(request.getParameter("id")));
			vehiculo = llenarVehiculo(request);
			try {
				vehiculoDAO.update(vehiculo);
				System.out.println("Registro editado satisfactoriamente...");
				List<Vehiculo> lista = vehiculoDAO.getAll();
				request.setAttribute("vehiculos", lista);

				mostrarPagina(request, response, "index.jsp");

			} catch (SQLException e) {
				e.printStackTrace();
			}

		} else if (opcion.equals("actualizar")) {
			Vehiculo vehiculo = new Vehiculo();
			VehiculoDAO vehiculoDAO = new VehiculoDAO();

			vehiculo.setId(Integer.parseInt(request.getParameter("id")));

			vehiculo.setPlaca(request.getParameter("placa"));
			vehiculo.setMarca(request.getParameter("marca"));
			vehiculo.setModelo(request.getParameter("modelo"));
			vehiculo.setAnio(request.getParameter("anio"));
			vehiculo.setCilindraje(request.getParameter("cilindraje"));
			vehiculo.setConsumo(request.getParameter("consumo"));
			try {
				vehiculoDAO.update(vehiculo);
				System.out.println("Registro editado satisfactoriamente...");

				List<Vehiculo> lista = vehiculoDAO.getAll();
				request.setAttribute("vehiculos", lista);
				mostrarPagina(request, response, "index.jsp");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}// fin de doPost

	private void mostrarPagina(HttpServletRequest request, HttpServletResponse response, String pagina)
			throws ServletException, IOException {

		RequestDispatcher rd = request.getRequestDispatcher(pagina);
		rd.forward(request, response);

	}

	private Vehiculo llenarVehiculo(HttpServletRequest request) {

		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setPlaca(request.getParameter("placa"));
		vehiculo.setMarca(request.getParameter("marca"));
		vehiculo.setModelo(request.getParameter("modelo"));
		vehiculo.setAnio(request.getParameter("anio"));
		vehiculo.setCilindraje(request.getParameter("cilindraje"));
		vehiculo.setConsumo(request.getParameter("consumo"));

		return vehiculo;

	}

}// fin de vehiculoController
