import java.io.*;
import java.net.*;
import java.util.*;

public class Client {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		//String filePath = "src/Client.java";
		
		System.out.println("Enter name of the file which is there in the current directory");
		//Current directory is your Project Folder, means the folder which contains src folder.
		
		String fileName = sc.nextLine();
		Socket socket = new Socket("127.0.0.1",5000);
		BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintStream p = new PrintStream(socket.getOutputStream());
		
		System.out.println("Client is Ready...");
		
		p.println(fileName);
		
		String str = "";
		while((str = br.readLine()) != null)
		{
			System.out.println(str);
		}
		
		System.out.println("Connection closed");
		br.close();
		socket.close();
		p.close();
	}

}
