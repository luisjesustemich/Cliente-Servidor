# Cliente-Servidor

OBJETIVO GENERAL
Implementar una aplicación cliente-servidor sencilla utilizando las clases DatagramSocket y DatagramPacket de Java, con el fin de comprender el funcionamiento de la comunicación mediante el protocolo UDP y verificar el intercambio de datos entre dos aplicaciones en una red.

FUNDAMENTOS TEÓRICOS
DatagramSocket
La clase DatagramSocket forma parte del paquete java.net y proporciona la funcionalidad necesaria para implementar comunicaciones basadas en UDP dentro del lenguaje Java.

Un DatagramSocket puede utilizarse tanto para enviar como para recibir datagramas. Cuando se crea un socket asociado a un puerto específico, este queda a la espera de recibir mensajes provenientes de otros dispositivos conectados a la red. De igual manera, puede ser utilizado para enviar información a una dirección IP y puerto determinados.

Principales funciones:

Crear puntos de comunicación utilizando UDP.
Enviar paquetes de datos hacia otros equipos.
Recibir información proveniente de clientes o servidores.
Administrar puertos de comunicación.
Facilitar la implementación de aplicaciones distribuidas.
En esta práctica, el servidor utiliza un DatagramSocket para permanecer escuchando solicitudes de los clientes, mientras que el cliente emplea otro DatagramSocket para enviar peticiones y recibir respuestas.

DatagramPacket
La clase DatagramPacket, también perteneciente al paquete java.net, representa un paquete de datos que puede ser enviado o recibido mediante un DatagramSocket.

Un DatagramPacket contiene toda la información necesaria para la transmisión de datos:

Los datos que se desean enviar.
El tamaño de los datos.
La dirección IP de destino.
El puerto de destino.
Cuando un cliente desea comunicarse con un servidor, primero crea un DatagramPacket con la información que desea transmitir. Posteriormente, dicho paquete es enviado mediante un DatagramSocket.

De manera similar, cuando un servidor recibe información, esta llega encapsulada dentro de un DatagramPacket.

La combinación de DatagramSocket y DatagramPacket permite establecer una comunicación entre aplicaciones sin necesidad de mantener una conexión permanente.

DESARROLLO
Para la realización de esta práctica se desarrollará una aplicación cliente-servidor utilizando el protocolo UDP mediante las clases DatagramSocket y DatagramPacket del lenguaje Java.

El sistema estará compuesto por dos programas: un servidor y un cliente.

Inicialmente, el servidor permanecerá en espera de solicitudes a través de un puerto específico. Por otra parte, el cliente enviará una petición al servidor para solicitar información.

Una vez recibida la solicitud, el servidor procesará la petición y enviará como respuesta diferentes tipos de datos, tales como:

Valores enteros.
Números decimales.
Cadenas de texto.
Caracteres.
Arreglos.
Posteriormente, el cliente recibirá la información enviada por el servidor y la mostrará en pantalla para verificar que la comunicación se realizó correctamente.

De esta manera, se comprobará el funcionamiento de la comunicación mediante UDP y el intercambio de información entre aplicaciones distribuidas.
