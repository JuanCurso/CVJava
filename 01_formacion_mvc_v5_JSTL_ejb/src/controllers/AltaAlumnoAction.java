package controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AlumnosDao;
import models.Alumno;

/**
 * Servlet implementation class AltaAlumnoAction
 */
@WebServlet("/AltaAlumnoAction")
public class AltaAlumnoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	
	@EJB
	AlumnosDao dao;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usuario= request.getParameter("usuario");
		String password= request.getParameter("password");
		String nombre= request.getParameter("nombre");
		String email= request.getParameter("email");
		int edad= Integer.parseInt(request.getParameter("edad"));
		
		Alumno miAlumno= new Alumno(usuario, password, nombre, email, edad);

		if (dao.altaAlumno(miAlumno)==null)
				request.setAttribute("status", "ok");
		else
				request.setAttribute("status", "ko");

	}

}
