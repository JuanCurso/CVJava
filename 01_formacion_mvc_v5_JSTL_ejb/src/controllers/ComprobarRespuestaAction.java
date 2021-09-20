package controllers;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CursosDao;
import models.Curso;

/**
 * Servlet implementation class ComprobarRespuestaAction
 */
@WebServlet("/ComprobarRespuestaAction")
public class ComprobarRespuestaAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	
	@EJB
	CursosDao dao;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idRespuesta = Integer.parseInt(request.getParameter("respuesta"));
		System.out.println(idRespuesta);
		boolean correcta = dao.comprobarRespuesta(idRespuesta);
		System.out.println(correcta);
		request.setAttribute("resultado", correcta?"Correcta":"Incorrecta");

	}

}
