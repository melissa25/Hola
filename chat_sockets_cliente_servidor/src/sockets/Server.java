package sockets;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.*;


public class Server {
	
	    ServerSocket sserver; //clase abstracta para crear socket
	    //crear constructor no de vuelve nada sirve para inicializar una clase o objeto	
	    Socket scliente;//cliente 
	    int puerto=12345;
	    DataInputStream streamIn;//se va a escribir sobre el socket
	    String buffer; // para poder leer en el canal con el formato utf (podeer leer con los caracteres)poder leer en el socket

	public Server() {
		// TODO Auto-generated constructor stub
		try //trata de conectarse 
        {
            System.out.println("Reservando puerto"+puerto+"Reservando...");
            sserver=new ServerSocket(puerto);//reservo el puerto, creo el socket del servidor
           
           //algo de llamarrla o from
          //  Runnable ncliente = new Hilo(scliente,buffer);  
          //  Thread cliente = new Thread(ncliente);
          //  cliente.start();
            
            
            
            
           // un socket server permite que le recibir peticionesdel cliente y un socket manda peticiones
            
           // al server socket
            
          
            
            open();//una llamada al metodo open , abre el socket
            boolean terminar=false;
            while (!terminar)
            {
                try 
                {
                	scliente = sserver.accept();//se acepta el socket del cliente
                	Runnable nuevoCliente = new Hilo(scliente,buffer);//nuevoCliente e hilo implementan a runnable
                	Thread cliente = new Thread();//cliente implementa a thread
                	cliente.start();
                  // String buffer=streamIn.readUTF();//mientras no termine voy a leer//lee todo lo que venga del cliente
                  																													
                	System.out.println(buffer);
                //  terminar=buffer.equals("Adios");//terminar es verdadero si en el buffer se escribio ADIOS
                }catch (IOException ieo )
                {
                    terminar=true;
                }
            }
            close();
        }
        catch(IOException ioe){
            System.out.println(ioe);//mandar a llamar un mensaje de error
            
            
        }
	}
	
	 public void open()throws IOException//metodo para abrir el canal y se envien mensajes
	    {
	        streamIn=new DataInputStream (new BufferedInputStream(scliente.getInputStream()));//leer
	        
	    }
	    
	    public void close()throws IOException
	    {
	        if (scliente!=null)
	            scliente.close();
	        if (streamIn!=null)
	            streamIn.close();
	    }
	    
	  

}
