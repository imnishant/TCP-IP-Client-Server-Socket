import java.io.*;
import java.net.*;

public class Server {

	public static void main(String[] args) throws UnknownHostException,IOException, InterruptedException {
		
		
		ServerSocket ssocket = new ServerSocket(5000);
		System.out.println("Server is up and running!");
		Socket socket = ssocket.accept();
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintStream p = new PrintStream(socket.getOutputStream());
		
		String filePath = br.readLine();
		File file = new File(filePath);
		BufferedReader breader = new BufferedReader(new FileReader(file));
		String str = "";
		while((str = breader.readLine()) != null)
		{
			p.println(str);
			Thread.sleep(1000);
		}	
		
		System.out.println("Connection Closed");
		ssocket.close();
		socket.close();
		br.close();
		breader.close();
		p.close();
		
	}

}
