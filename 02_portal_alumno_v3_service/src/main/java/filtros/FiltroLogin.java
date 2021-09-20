package filtros;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import model.Alumno;

/**
 * Servlet Filter implementation class FiltroLogin
 */
@WebFilter(value = {"/login.jsp", "/"})
public class FiltroLogin implements Filter {

    /**
     * Default constructor. 
     */
    public FiltroLogin() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		//Si existe la cookie, no pasamos por la pagina de login
		Alumno alumno=(Alumno)((HttpServletRequest)request).getSession().getAttribute("alumno");
		System.out.println("alumno filtro:" + alumno);
		if (alumno==null) {
			Cookie[] cookies=((HttpServletRequest)request).getCookies();
			if (cookies!=null) {
				for (Cookie c:cookies) {
					if(c.getName().equals("usuario")) {
						//guardamos el usuario de la sesión
						((HttpServletRequest)request).setAttribute("usuario", c.getValue());
						//transferimos la petición al buscador
						System.out.println("encuentra lo cookie");
						request.getRequestDispatcher("recuperarAlumno").forward(request, response);
						return;
					}
				}
				
			}
			
		} else {
			request.getRequestDispatcher("inicio").forward(request, response);
			
		}
		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
