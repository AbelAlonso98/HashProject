package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.file.Files;

public class Cliente {
	public static void main(String[] args) {
		try {
			// Estructura general de comunicacion por sockets
			Socket s = new Socket("localhost", 9999);
			ObjectOutputStream out = new ObjectOutputStream(s.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			
			// Mando un file creado por mi con texto random dentro
			System.out.println("Probando con un archivo");
			File f = new File(".//src//main//TestFile");
			out.writeObject(Files.readAllBytes(f.toPath()));
			out.flush();
			System.out.println(in.readLine());
			
			// Mando un String random
			System.out.println("\nProbando con un string");
			String testString = "Lore, lore, macu, macu... FIESTOOOOON";
			out.writeObject(testString.getBytes());
			out.flush();
			System.out.println(in.readLine());
			
			// Mando un objeto SERIALIZABLE de una clase creada por mi con 3 atributos
			System.out.println("\nProbando con un objeto");
			Test t = new Test("Abel", "Alonso", 25);
			out.writeObject(t);
			out.flush();
			System.out.println(in.readLine());
			
			
			} catch (UnknownHostException e) {
				System.err.println("Host no encontrado");
				e.printStackTrace();
			} catch (IOException e) {
				System.err.println("Error de entrada/salida");
				e.printStackTrace();
			} 
		
	}

}
