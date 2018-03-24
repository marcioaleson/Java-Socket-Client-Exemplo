import java.io.*;
import java.net.*;

public class TCPClient {

	public static void main(String[] args) throws Exception{
		String sentence, modifiedSentence;
		while(true){
			BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
			Socket clientSocket = new Socket("10.28.15.179", 6789);
			DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
			BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			sentence = inFromUser.readLine();
			outToServer.writeBytes(sentence + "\n");
			modifiedSentence = inFromServer.readLine();
			System.out.println("FROM SERVER: " + modifiedSentence);
			clientSocket.close();
		}
	}
}
