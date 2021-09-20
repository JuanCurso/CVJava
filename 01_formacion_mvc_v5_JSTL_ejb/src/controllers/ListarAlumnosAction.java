package controllers;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlumnosDao;
import models.Alumno;

/**
 * Servlet implementation class ListarAlumnosAction
 */
@WebServlet("/ListarAlumnosAction")
public class ListarAlumnosAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	
	@EJB
	AlumnosDao dao;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Alumno> alumnos = dao.listarAlumnos();

		request.setAttribute("alumnos", alumnos);
	}

}
