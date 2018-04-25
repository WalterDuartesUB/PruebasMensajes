import java.io.Serializable;

public class MensajeHello extends Mensaje implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mensaje;

	
	public MensajeHello(String mensaje) {	
		this.setMensaje(mensaje);
	}

	@Override
	public void interpretar(EntendedorMensajeHello app) {
		app.hello( this );
	}

	public String getMensaje() {
		return mensaje;
	}

	protected void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
