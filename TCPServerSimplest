import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerSimplest {
	
	public static void main(String[] args) throws IOException {
		System.out.print(InetAddress.getLocalHost().getCanonicalHostName() + " ");
		ServerSocket socket = new ServerSocket(80);
		System.out.println(socket.getLocalPort());
		Socket worker = socket.accept();
		BufferedReader in = new BufferedReader(new InputStreamReader(worker.getInputStream()));
		
		String message;
		do {
			message = in.readLine();
			System.out.println(message);
		} while (!message.equals("SHUTDOWN"));

		worker.close();
		socket.close();
	}

}
