import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class TCPClientSimplest {

	static String message = "SHUTDOWN";
	
	public static void main(String[] args) throws IOException{
		String serverIP = "*.*.*.*";
		int serverPort = 80;
		Socket socket = new Socket(InetAddress.getByName(serverIP), serverPort);
		PrintWriter out = new PrintWriter(socket.getOutputStream());
		
		for (int count = 0; count < 10; count++) {
			out.write(message + " " + count + "\n");
			out.flush();
			try {Thread.sleep(1000);} catch (InterruptedException e) {};
		}

		out.write("SHUTDOWN");
		out.flush();
		out.close();
		socket.close();
	}

}
