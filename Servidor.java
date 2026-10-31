/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente.servidor;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author Luis TR
 */
public class Servidor {
    public static void main(String[] args) {
        int puerto = 6000;
        byte[] bufferPeticion = new byte[1024];

        try (DatagramSocket socketUDP = new DatagramSocket(puerto)) {
            System.out.println("Servidor UDP listo en el puerto " + puerto);
            

            while(true){
                // 1. Esperar señal de petición del cliente
                DatagramPacket peticion = new DatagramPacket(bufferPeticion, bufferPeticion.length);
                socketUDP.receive(peticion);

                InetAddress direccionCliente = peticion.getAddress();
                int puertoCliente = peticion.getPort();

                // 2. Preparar el flujo binario con todos los datos requeridos
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                DataOutputStream dos = new DataOutputStream(baos);

                // Escribimos los datos en orden estricto
                dos.writeInt(1);                    // Int
                dos.writeDouble(12.342);            // Double
                dos.writeFloat(1.23f);              // Float
                dos.writeLong(129039023L);          // Long
                dos.writeUTF("Hola equipo 7");      // String
                dos.writeChar('C');                 // Char

                // Para el arrayInt escribimos primero su tamaño y luego sus elementos
                int[] arrayInt = {1, 2, 3, 4};
                dos.writeInt(arrayInt.length);
                for (int numero : arrayInt) {
                    dos.writeInt(numero);
                }

                byte[] datosRespuesta = baos.toByteArray();

                // 3. Enviar el DatagramPacket de vuelta al cliente
                DatagramPacket respuesta = new DatagramPacket(datosRespuesta, datosRespuesta.length, direccionCliente, puertoCliente);
                socketUDP.send(respuesta);
                System.out.println("Enviando datos al cliente...");
                System.out.println("Datos transmitidos con exito al cliente.");
            }
        } catch (Exception e) {
            System.out.println("Error en el servidor: " + e.getMessage());
        }
    }
}
