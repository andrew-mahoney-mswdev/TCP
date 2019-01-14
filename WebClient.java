import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class WebClient {

	public static void main(String[] args) throws IOException{
		String serverIP = "google.com";
		int serverPort = 80;

		Socket socket = new Socket(InetAddress.getByName(serverIP), serverPort);
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		
		out.print("GET /robots.txt\r\n\r\n");
		out.flush();

		String message = in.readLine();
		do {
			System.out.println(message);
			message = in.readLine();
		} while (message != null);
		
		in.close();
		out.close();
		socket.close();
	}

}
