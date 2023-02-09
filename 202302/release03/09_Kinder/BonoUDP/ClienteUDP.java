import java.net.*;
import java.io.*;

public class ClienteUDP {

  public static void main(String args[]) {
    try {
      DatagramSocket socketUDP = new DatagramSocket();
      byte[] mensaje = args[0].getBytes();
      InetAddress hostServidor = InetAddress.getByName("localhost");

      // Construimos un datagrama para enviar el mensaje al servidor
      socketUDP.send(new DatagramPacket(mensaje, args[0].length(), hostServidor, 6789));

      // Construimos el DatagramPacket con la respuesta
      byte[] bufer = new byte[1000];
      DatagramPacket respuesta = new DatagramPacket(bufer, bufer.length);
      socketUDP.receive(respuesta);

      // Enviamos la respuesta del servidor a la salida estandar
      System.out.println("Respuesta: " + new String(respuesta.getData()));
      socketUDP.close();

    } catch (SocketException e) {
      System.out.println("Socket: " + e.getMessage());
    } catch (IOException e) {
      System.out.println("IO: " + e.getMessage());
    }
  }
}
