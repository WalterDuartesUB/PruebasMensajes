import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Aplicacion {

	public static void main(String[] args) {
		System.out.println("Soy el cliente");
		
		//Creo una conexion al servidor
		try( Socket s = new Socket( "127.0.0.1",8888) )
		{
			
			ObjectOutputStream oos = new ObjectOutputStream( s.getOutputStream() );
			
			//Envio un mensaje de hola mundo para probar
			oos.writeObject( new MensajeHello("Hola mundo") );
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
