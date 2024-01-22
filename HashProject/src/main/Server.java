package main;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Server {

	public static void main(String[] args) {
		try {
			ServerSocket ss = new ServerSocket(9999);
			System.out.println("Waiting for clients");
			Socket s = ss.accept();
			System.out.println("Connection established");

			PrintWriter out = new PrintWriter(s.getOutputStream(), true);
			ObjectInputStream in = new ObjectInputStream(s.getInputStream());

			MessageDigest md = MessageDigest.getInstance("SHA-256");

			byte[] auxHash;
			StringBuilder sb;
			while (true) {
				sb = new StringBuilder();
				auxHash = md.digest((byte[]) in.readObject());
//				auxHash = md.digest(SerializationUtils.serialize(in.readObject()));
				for (byte b : auxHash)
					sb.append(b);
				out.println(sb.toString());

			}

		} catch (IOException e) {
			System.err.println("Error de entrada/salida");
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			System.err.println("El algoritmo de encriptacion es erroneo");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.err.println("Clase no encontrada");
			e.printStackTrace();
		} 

	}

}
