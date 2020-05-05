import java.io.*;
import java.net.*;

public class Cliente2 {

	public static void main (String[] comando) {
		
		Socket yo = null;
		PrintWriter alServidor;
		BufferedReader delTeclado;
		DataInputStream delServidor;
		String teclado;
		
		try {
			
			try {
				yo = new Socket("localhost", 5000);
				
			}catch(UnknownHostException e) {
				System.out.println(e.getMessage());
				System.exit(1);
			}
		
			System.out.println("Ya se conecto el cliente");
			
			delTeclado = new BufferedReader(new InputStreamReader(System.in));
			alServidor = new PrintWriter(yo.getOutputStream(), true);
			delServidor = new DataInputStream(yo.getInputStream());
			
			do {
				System.out.println("Digita: ");
				teclado = delTeclado.readLine();
				alServidor.println(teclado);
				System.out.println("Longitud = " +delServidor.readInt());
			} while (teclado.length() != 0);
		
			System.out.println("Ya termino de enviar");
			
			delServidor.close();
			delTeclado.close();
			alServidor.close();
			yo.close();
		
		} catch (IOException e) {
			System.out.println(e.getMessage());
			System.exit(1);
		}
		
		
	}	
		
}
