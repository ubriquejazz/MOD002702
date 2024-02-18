# UDP Sockets en JAVA
Java proporciona 2 clases para dar soporte a la comunicación via datagramas UDP, todas ellas contenidas en el paquete java.net. Estas clases son DatagramaPacket y DatagramSocket

## DatagramPacket: 
proporciona constructores para crear instancias a partir de los datagramas recibidos y para crear instancias de datagramas que van a ser enviados.

Constructores para datagramas que van a ser enviados: DatagramPacket(byte[] buf, int length) y DatagramPacket(byte[] buf, int length, InetAddress address, int port). Estos constructores crean una instancia de datagrama compuesta por una cadena de bytes que almacena el mensaje, la longitud del mensaje y la dirección de Internet y el número de puerto local del conector destino, tal y como sigue:

        +-----------+--------------------+----------------+--------------------+
        |  MENSAJE  |  LONGITUD MENSAJE  |  DIRECCION IP  |  NÚMERO DE PUERTO  |
        +-----------+--------------------+----------------+--------------------+

Constructores para datagramas recibido: DatagramPacket(byte[] buf, int offset, int length) y DatagramPacket(byte[] buf, int offset, int length, InetAddress address, int port). Estos constructores nos permiten crear instancias de los datagramas recibidos, especificando la cadena de bytes en la que alojar el mensaje, la longitud de la misma y el offset dentro de la cadena.

Dentro de esta clase hay métodos para obtener los diferentes componentes de un datagrama, tanto recibido como enviado:
- getData() : para obtener el mensaje contenido en el datagrama.
- getAddress() : para obtener la dirección IP.
- getPort(): para obtener el puerto.

# DatagramSocket: 
maneja sockets para enviar y recibir datagramas UDP. Proporciona tres constructores:

- DatagramSocket(): constructor sin argumentos que permite que el sistema elija un puerto entre los que estén libres y selecciona una de las direcciones locales.

- DatagramSocket(int port): constructor que toma un número de puerto como argumento, apropiado para los procesos que necesitan un número de puerto (servicios).

- DatagramSocket(int port, InetAddress laddr): constructor que toma como argumentos el número de puerto y una determinada dirección local.

La clase DatagramSocket proporciona varios métodos, destacamos los más utilizados:

* send(DatagramPacket p) y receive(DatagramPacket p): estos métodos sirven para transmitir datagramas entre un par de conectores. El argumento de send es una instancia de DatagramPacket conteniendo el mensaje y el destino. El argumento de receive es un DatagramPacket vacío en el que colocar el mensaje, su longitud y su origen. Ambos métodos pueden lanzar excepciones IOException
        
* setSoTimeout(int timeout): este método permite establecer un tiempo de espera límite. Cuando se fija un límite, el método receive se bloquea durante el tiempo fijado y después lanza una excepción InterruptedIOException
        
* connect(InetAddress address, int port): este método se utiliza para conectarse a un puerto remoto y a una dirección Internet concretos, en cuyo caso el conector sólo podrá enviar y recibir mensajes de esa dirección.

Vamos a ver un ejemplo sencillo en el que utilizamos ambas clases: una aplicación cliente/servidor en el que el servidor reenvía el mismo mensaje que le envían los diferentes clientes. 

https://www.it.uc3m.es/celeste/docencia/cr/2003/PracticaSocketsUDP/