import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.IOException;

public class Test{
	
	public static void main(String[] args) throws IOException{

		// System.in is the input given to the program
		// in this case, input redirection might be used (<)
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String line;

		while(input.ready()){
			line = input.readLine();
			System.out.println(line);
		}

		// try{
		// 	line = input.readLine();
		// 	System.out.println(line);
		// }
		// catch(IOException ioe){
		// 	System.out.println("fuck");
		// }

	}

}