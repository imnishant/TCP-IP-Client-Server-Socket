import java.io.*;
import java.net.*;
import java.util.*;

public class Client {

	public static void main(String[] args) throws UnknownHostException, IOException, NoSuchElementException {
		String filePath = "src/RSA.java";
		Socket socket = new Socket("192.168.0.114",1235);
		Scanner scan = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintStream p = new PrintStream(socket.getOutputStream());
		
		System.out.println("Client is Ready...");
		
		p.println(filePath);
		
		String str = "";
		while((str = br.readLine()) != null)
		{
			System.out.println(str);
		}
		
		System.out.println("Connection closed");
		scan.close();
		br.close();
		socket.close();
		p.close();
	}

}
