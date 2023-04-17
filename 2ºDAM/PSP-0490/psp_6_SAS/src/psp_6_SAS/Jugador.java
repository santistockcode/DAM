package psp_6_SAS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.charset.StandardCharsets;
import java.util.Optional;
import java.util.Scanner;

public class Jugador {
	// private static Scanner sc = new
	// Scanner(System.in).useDelimiter("\\s*\\*\\s*");

	public static void main(String[] argv) throws IOException {
		DatagramSocket clienteSocket = new DatagramSocket();
		Scanner sc = new Scanner(System.in);
		String data = "";
		int intentos = 0;
		// DATOS DEL SERVIDOR AL QUE ENVIAR EL MENSAJE
		InetAddress IPServidor = InetAddress.getLocalHost();
		int puerto = 12345;
		boolean terminaJuego = false;

		while (!terminaJuego) {
			// INTRODUCE DATOS POR TECLADO
			System.out.println("Introduce coordenadaX, terminará al meter un asterisco: ");
			// ATASCO: el resto del código funciona, lo que no consigo es que el buffered
			// read coga los char del teclado UNO A UNO
			// tengo que esperar a que pulse enter
			StringBuilder response = new StringBuilder();
			data = sc.next();
			if(data.equals("*")){terminaJuego = true;break;}
			response.append(data);
			System.out.println("Ahora introduce coordenadas y");
			response.append("-");
			data = sc.next();
			if(data.equals("*")){terminaJuego = true;break;}
			response.append(data);

			byte[] enviados = new byte[1024];
			enviados = response.toString().getBytes();

			// ENVIANDO DATAGRAMA AL SERVIDOR
			DatagramPacket envio = new DatagramPacket(enviados, enviados.length, IPServidor, puerto);
			clienteSocket.send(envio);

			// RECIBIENDO DATAGRAMA DEL SERVIDOR
			byte[] recibidos = new byte[1024]; 
			DatagramPacket recibo = new DatagramPacket(recibidos, recibidos.length);
			System.out.println("Esperando datagrama que vuelve....");
			clienteSocket.receive(recibo);
			//String mensaje = new String(recibo.getData());
			// System.out.println(mensaje);
			//String[] datos = null;
            //System.arraycopy(recibo.getData(), recibo.getOffset(), recibidos, 0, recibo.getLength());
            String msg = new String (recibo.getData(), 0, recibo.getLength());
			if (msg.equals("Vuelve a intentarlo")) {
				System.out.println("vuelve a intentarlo");
			} else {
				System.out.println("bandera");
				clienteSocket.close();
				terminaJuego = true;
				break;
			}
			intentos++;
			if(intentos==4) {break;} //AQUÍ CONTROLAMOS QUUE NO LLEGUE A LOS 4 INTENTOS
		}
		System.out.println("Terminó el juego porquue o bien se rindió u obtuvo premio");

	}

}
