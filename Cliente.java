package cliente.servidor;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Arrays;

public class Cliente {
    public static void main(String[] args) {
        String host = "localhost";
        int puerto = 6000;

        try (DatagramSocket socketUDP = new DatagramSocket()) {
            InetAddress direccionServidor = InetAddress.getByName(host);

            // 1. Enviar un paquete vacío para "saludar" al servidor e iniciar la transmisión
            byte[] peticionVacia = new byte[1];
            DatagramPacket enviarPeticion = new DatagramPacket(peticionVacia, peticionVacia.length, direccionServidor, puerto);
            socketUDP.send(enviarPeticion);

            // 2. Recibir la respuesta del servidor
            byte[] bufferRespuesta = new byte[2048];
            DatagramPacket paqueteRecibido = new DatagramPacket(bufferRespuesta, bufferRespuesta.length);
            socketUDP.receive(paqueteRecibido);

            // 3. Leer y deserializar los datos binarios en orden
            ByteArrayInputStream bais = new ByteArrayInputStream(paqueteRecibido.getData());
            DataInputStream dis = new DataInputStream(bais);

            int vInt = dis.readInt();
            double vDouble = dis.readDouble();
            float vFloat = dis.readFloat();
            long vLong = dis.readLong();
            String vString = dis.readUTF();
            char vChar = dis.readChar();
            
            // Reconstruir el arreglo leyendo su longitud primero
            int longitudArray = dis.readInt();
            int[] vArrayInt = new int[longitudArray];
            for (int i = 0; i < longitudArray; i++) {
                vArrayInt[i] = dis.readInt();
            }

            // 4. Salida en consola idéntica a tu formato solicitado
            System.out.println("Cliente:");
            System.out.println("Recibo de servidor:");
            System.out.println("Int: " + vInt);
            System.out.println("Double: " + vDouble);
            System.out.println("Float: " + vFloat);
            System.out.println("Long: " + vLong);
            System.out.println("String: " + vString);
            System.out.println("Char: " + vChar);
            System.out.println("ArrayInt: " + Arrays.toString(vArrayInt));

        } catch (Exception e) {
            System.out.println("Error en el cliente: " + e.getMessage());
        }
    }   
}
