package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Alumno;
import models.Curso;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		final String errorUsuarioExiste = "El alumno ya existe";
		final String errorListaAlumnosVacia = "No hay alumnos que listar.";
		final String errorListaCursosVacia = "No hay cursos con los criterios seleccionados.";
		
		String opcion = request.getParameter("option");
		System.out.println("option = " + opcion);
		String url = "menu.html";

		switch(opcion) {
			case "doAltaAlumno":
				request.getRequestDispatcher("AltaAlumnoAction").include(request, response);

				if (request.getAttribute("status").equals("ok")) {
					url="menu.html";
				} else {
					request.setAttribute("mensaje", errorUsuarioExiste);
					url="error.jsp";
				}
				break;
				
			case "doMatricularAlumno":
				request.getRequestDispatcher("MatricularAlumnoAction").include(request, response);
				url="menu.html";
				break;
				
			case "doListarAlumnos":
				request.getRequestDispatcher("ListarAlumnosAction").include(request, response);
				if (((List<Alumno>)request.getAttribute("alumnos")).size()!=0) {
					url="listar_alumnos.jsp";
				} else {
					request.setAttribute("mensaje", errorListaAlumnosVacia);
					url="error.jsp";
				}
				break;

			case "doListarAlumnosPorTema":
				request.getRequestDispatcher("ListaAlumnosPorTemaAction").include(request, response);
				url="listar_alumnos_por_tema.jsp";
				break;

			case "doAltaCurso":
				request.getRequestDispatcher("AltaCursoAction").include(request, response);
				url="menu.html";
				break;

			case "doListarCursos":
				request.getRequestDispatcher("ListarCursosAction").include(request, response);
				url="seleccion_curso.jsp";
				break;

			case "doCursosPreguntas":
				request.getRequestDispatcher("CursosPreguntasAction").include(request, response);
				url="preguntas_curso.jsp";
				break;

			case "doListarRespuestas":
				request.getRequestDispatcher("ListarRespuestasAction").include(request, response);
				url="respuestas_preguntas.jsp";
				break;

			case "doComprobarRespuesta":
				System.out.println("ENTRO EN COMPROBAR RESPUESTAAAAAAAAAAAAAAAAAAAAAAA");
				request.getRequestDispatcher("ComprobarRespuestaAction").include(request, response);
				url="resultado_pregunta.jsp";
				break;

			case "doListarCursoDuracionMenorAction":
				request.getRequestDispatcher("ListarCursoDuracionMenorAction").include(request, response);
				if (((List<Curso>)request.getAttribute("cursos")).size()!=0) {
					url="listar_cursos_duracion_menor.jsp";
				} else {
					request.setAttribute("mensaje", errorListaCursosVacia);
					url="error.jsp";
				}
				break;

			case "toAltaAlumno":
				url="alta_alumno.html";
				break;
			case "toAltaCurso":
				url="alta_curso.html";
				break;
			case "toListaCursosDuracionMenor":
				url="listar_cursos_duracion_menor.html";
				break;
			case "toFormularioTemaCurso":
				url="formulario_tema_curso.html";
				break;
			case "toMenu":
				url="menu.html";
				break;
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}


}
