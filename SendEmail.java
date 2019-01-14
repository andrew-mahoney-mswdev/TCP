import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class SendEmail {
	
	public static void getReply(BufferedReader in) throws IOException{
		String reply = in.readLine();
		System.out.println(reply);
	}

	public static void main(String[] args) throws IOException{
		String serverIP = "***.co.nz";
		int serverPort = 25;
		Socket socket = new Socket(InetAddress.getByName(serverIP), serverPort);
		PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

		BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));		
		getReply(in);
		
		out.println("HELO ***.co.nz");
		getReply(in);
		out.println("MAIL FROM:<***.co.nz>");
		getReply(in);
		out.println("RCPT TO:<***.co.nz>");
		getReply(in);
		out.println("DATA");
		getReply(in);
		out.println("This is an email sent with SMTP layer on the TCP protocol.");
		out.println(".");
		getReply(in);
		out.println("QUIT");
		getReply(in);

		out.close();
		in.close();
		socket.close();
	}

}
