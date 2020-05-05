import java.io.*;
import java.net.*;

public class Servidor2 {

	public static void main (String[] args) {
		
		ServerSocket yo = null;
		Socket cliente = null;
		BufferedReader entrada;
		DataOutputStream salida;
		String llego;
		
		try {
			yo = new ServerSocket(5000);
			System.out.println("Servidor esta en linea");
			
			cliente = yo.accept();
			System.out.println("La conexion se ha establecido");
			
			entrada = new BufferedReader(new InputStreamReader(cliente.getInputStream()));
			salida = new DataOutputStream(cliente.getOutputStream());
			
			do {
				llego = entrada.readLine();
				System.out.println("Llego " + llego);
				salida.writeInt(llego.length());
			} while (llego.length() != 0);
			System.out.println("La conexión ha finalizado");
			
			entrada.close();
			cliente.close();
			yo.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}	
		
	}
	
}
