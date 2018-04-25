import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Aplicacion implements EntendedorMensajeHello 
{
	
	public static void main(String[] args) {
		Aplicacion app = new Aplicacion();
		
		System.out.println("Soy el server");
		
		//Creo el puerto de escucha
		try( ServerSocket ss = new ServerSocket(8888) )
		{
			//Espero una conexion
			Socket s = ss.accept();
			
			try( ObjectInputStream ois = new ObjectInputStream( s.getInputStream() ) )
			{
				try 
				{
	
					//Pido el mensaje que llego
					Mensaje mensaje = (Mensaje)ois.readObject();
					
					//"Interpreto" el mensaje que me pasaron
					mensaje.interpretar( app );
					
				} 
				catch (ClassNotFoundException e) 
				{
					e.printStackTrace();
				}
			}
			
		}
		catch (IOException e) 
		{

		}
	}

	@Override
	public void hello(MensajeHello mensajeHello) 
	{
		//Muestro el mensaje que me llego
		System.out.println( mensajeHello.getMensaje() );		
	}
}
