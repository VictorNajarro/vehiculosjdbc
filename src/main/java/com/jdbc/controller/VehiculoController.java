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
			RequestDispatcher rd = request.getRequestDispatcher("registro.jsp");
			rd.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String opcion = request.getParameter("opcion");
		if (opcion.equals("crear")) {
			Vehiculo vehiculo = new Vehiculo();
			vehiculo.setPlaca(request.getParameter("placa"));
			vehiculo.setMarca(request.getParameter("marca"));
			vehiculo.setModelo(request.getParameter("modelo"));
			vehiculo.setAnio(request.getParameter("anio"));
			vehiculo.setCilindraje(request.getParameter("cilindraje"));
			vehiculo.setConsumo(request.getParameter("consumo"));
			
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
			
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);

		}// fin de if

	}
}
