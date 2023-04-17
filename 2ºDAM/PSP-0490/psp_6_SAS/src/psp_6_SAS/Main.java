package psp_6_SAS;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Main {

	public static void main(String[] argv) throws IOException {
		// ASOCIO EL SOCKET AL PUERTO 12345
		DatagramSocket socket = new DatagramSocket(12345);
		// CREO EL TABLERO

		int i = 0, j = 0, m = 0;
		int[][] A = new int[3][4]; // Se crea una matriz de 5 filas y 4 columnas

		int[] premios = new int[12];
		System.out.println("Decidiéndo donde van a estar los premios: ");
		int premio1 = 0, premio2 = 0, premio3 = 0;
		while (premio1 == premio2 || premio2 == premio3) {
			premio1 = (int) (12 * Math.random());
			premio2 = (int) (12 * Math.random());
			premio3 = (int) (12 * Math.random());
		}
		// Se introducen por teclado los valores de la matriz
		premios[premio1] = 1;
		premios[premio2] = 2;
		premios[premio3] = 3;
		m = 0;
		// relleno el tablero
		for (i = 0; i < 3; i++) {
			for (j = 0; j < 4; j++) {
				A[i][j] = premios[m];
				m++;
			}
		}
		// Mostrar por pantalla los valores que contiene la matriz
		System.out.println("Tablero con premios:");
		for (i = 0; i < A.length; i++) {
			for (j = 0; j < A[i].length; j++) {
				System.out.print(A[i][j] + " ");
			}
			System.out.println();
		}

		// ESPERANDO DATAGRAMA
		while (Boolean.TRUE) {
			System.out.println("Servidor esperando datagrama....");
			DatagramPacket recibo;
			byte[] bufer = new byte[1024];
			recibo = new DatagramPacket(bufer, bufer.length);
			socket.receive(recibo);

			String mensaje = new String(recibo.getData()).trim();

			// Lo paso a mayúsculas
			String[] parts = mensaje.split("-");
			int coordenadaX = Integer.valueOf(parts[0]) - 1;
			int coordenadaY = Integer.valueOf(parts[1]) - 1;

			System.out.println("Servidor Recibe: " + coordenadaX + " y " + coordenadaY);
			if (coordenadaX > 4 || coordenadaY > 3) {
				System.out.println("Coordenadas incorrectas, jugador pierde turno");
				InetAddress IPOrigen = recibo.getAddress();
				int puerto = recibo.getPort();
				// Enviando datagrama al cliente
				byte[] mensaje_codificado = new byte[1024];
				// System.out.println("Este es tu mensaje en mayúsculas: " + mensaje);
				int premio_o_no = 0;
				String cad = "Vuelve a intentarlo";
				mensaje_codificado = cad.getBytes();// codifico String a bytes
				DatagramPacket envio = new DatagramPacket(mensaje_codificado, mensaje_codificado.length, IPOrigen,
						puerto);
				socket.send(envio);
				socket.close();

			} else {

				// InetAddress destino = InetAddress.getLocalHost();
				InetAddress IPOrigen = recibo.getAddress();
				int puerto = recibo.getPort();

				// Enviando datagrama al cliente
				byte[] mensaje_codificado = new byte[1024];
				// System.out.println("Este es tu mensaje en mayúsculas: " + mensaje);
				int premio_o_no = A[coordenadaX][coordenadaY];
				String cad = "";
				if (premio_o_no == 0) {
					cad = "Vuelve a intentarlo";
				} else {
					cad = "premio por valor de " + premio_o_no;
				}
				mensaje_codificado = cad.getBytes();// codifico String a bytes
				DatagramPacket envio = new DatagramPacket(mensaje_codificado, mensaje_codificado.length, IPOrigen,
						puerto);
				socket.send(envio);

				// El socket mirará lo que ha recibido y si ha llegado algún asterísco deje de
				// estar abierto a recibir nada más
				// socket.close();
			}
		}
	}

}
