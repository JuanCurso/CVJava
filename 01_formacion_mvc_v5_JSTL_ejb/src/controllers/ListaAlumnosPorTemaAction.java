package controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlumnosDao;

/**
 * Servlet implementation class ListaAlumnosPorCurso
 */
@WebServlet("/ListaAlumnosPorTemaAction")
public class ListaAlumnosPorTemaAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	
	@EJB
	AlumnosDao dao;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String tema = request.getParameter("tema");
		
		request.setAttribute("alumnos", dao.listarAlumnosPorTema(tema));

	}

}
