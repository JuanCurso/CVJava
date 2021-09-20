<nav class="navbar navbar-expand-lg navbar-dark bg-primary my-5">
  <a class="navbar-brand" href="#">Portal del alumno</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
	      <c:choose>
	      	<c:when test = "${empty sessionScope.alumno}">
		      <li class="nav-item disabled">
		        <a class="nav-link disabled" href="inicio">Inicio <span class="sr-only">(current)</span></a>
		      </li>
	      	</c:when>
	      	<c:otherwise>
		      <li class="nav-item active">
		        <a class="nav-link" href="inicio">Inicio <span class="sr-only">(current)</span></a>
		      </li>
	      	</c:otherwise>
	      </c:choose>
	  <li class="nav-item dropdown">
	      <c:choose>
	      	<c:when test = "${empty sessionScope.alumno}">
		        <a class="nav-link dropdown-toggle disabled" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		          Menu
		        </a>
	      	</c:when>
	      	<c:otherwise>
		        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
		          Menu
		        </a>
	      	</c:otherwise>
	      </c:choose>
          <div class="dropdown-menu" aria-labelledby="navbarDropdown">
            <a class="dropdown-item" href="listarCursosDeUnAlumno">Listar cursos</a>
            <a class="dropdown-item" href="listarCursosParaMatricular">Matricular curso</a>
          </div>
      </li>
    </ul>
      <c:choose>
      	<c:when test = "${empty sessionScope.alumno}">
	      <span class="text-light bg-primary">Alumno: <span class="text-light bg-primary font-italic">desconocido</span></span>
      	</c:when>
      	<c:otherwise>
	      <span class="text-light bg-primary">Alumno: <span class="text-light bg-primary font-italic">${sessionScope.alumno.nombre}</span></span>
	      <a href="alumnoLogout" class="ml-2 btn btn-secondary btn-sm active" role="button" aria-pressed="true">Logout</a>
      	</c:otherwise>
      </c:choose>
  </div>
</nav>