package controllers;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CursosDao;

/**
 * Servlet implementation class CursosPreguntasAction
 */
@WebServlet("/CursosPreguntasAction")
public class CursosPreguntasAction extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	
	@EJB
	CursosDao dao;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int idCurso = Integer.parseInt(request.getParameter("idCurso"));
		request.setAttribute("preguntas", dao.preguntasCurso(idCurso));
	}

}
