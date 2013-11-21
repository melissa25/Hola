package chat;

import java.net.Socket;

public class Hilo implements Runnable{ //Runnable es una interface para crear hilos

	Socket cliente ;
	String mensaje;//recibir mensajes
	public Hilo (Socket socket, String m )  {
		// TODO Auto-generated constructor stub
		
		this.cliente = socket;
		this.mensaje = m;
		
		
		
	}
	
	
	
	public void run()
	{
		
		Runnable escribir = new cliente_write();
    	Thread cliente_write = new Thread();
    	
    	Runnable leer = new cliente_read();
    	Thread cliente_read = new Thread();
    	
    	
	}

}
