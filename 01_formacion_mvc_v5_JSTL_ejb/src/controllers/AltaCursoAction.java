package controllers;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CursosDao;
import models.Curso;

/**
 * Servlet implementation class AltaCursoAction
 */
@WebServlet("/AltaCursoAction")
public class AltaCursoAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	
	@EJB
	CursosDao dao;
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nombre= (String)request.getParameter("nombre");
		int duracion= Integer.parseInt(request.getParameter("duracion"));
		String fechaInicio=request.getParameter("fecha");
		SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		Date fecha = null;
		try {
			fecha = format.parse(fechaInicio);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Curso miCurso= new Curso(0, nombre, duracion, fecha);
		dao.altaCurso(miCurso);

	}

}
