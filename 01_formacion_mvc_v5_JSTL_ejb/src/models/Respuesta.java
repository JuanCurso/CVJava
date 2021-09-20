package models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "respuestas")
public class Respuesta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idRespuesta;
	
	private String texto;
	private int correcta;
	
	@ManyToOne
	@JoinColumn(name = "idPregunta", referencedColumnName = "idPregunta")
	private Pregunta pregunta;

	public Respuesta() {
		super();
	}



	public Respuesta(int idRespuesta, String texto, int correcta, Pregunta pregunta) {
		super();
		this.idRespuesta = idRespuesta;
		this.texto = texto;
		this.correcta = correcta;
		this.pregunta = pregunta;
	}



	public int getIdRespuesta() {
		return idRespuesta;
	}

	public void setIdRespuesta(int idRespuesta) {
		this.idRespuesta = idRespuesta;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public int getCorrecta() {
		return correcta;
	}

	public void setCorrecta(int correcta) {
		this.correcta = correcta;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}



	@Override
	public String toString() {
		return "Respuesta [idRespuesta=" + idRespuesta + ", texto=" + texto + ", correcta=" + correcta + ", pregunta="
				+ pregunta + "]";
	}


}
