package cliente_servidor;

import java.io.Serializable;

public class MensajeChat implements Serializable {

	private String nick, ip, texto;

	public MensajeChat(String nick, String ip, String texto) {
		this.nick = nick;
		this.ip = ip;
		this.texto = texto;
	}

	public String getNick() {
		return nick;
	}

	public String getIp() {
		return ip;
	}

	public String getTexto() {
		return texto;
	}

	@Override
	public String toString() {
		return "mensajeChat [nick=" + nick + ", ip=" + ip + ", texto=" + texto + "]";
	}
	

}
