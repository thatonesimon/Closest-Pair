import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Test{
	
	public static void main(String[] args) throws IOException{

		// System.in is the input given to the program
		// in this case, input redirection might be used (<)

		
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<OrderedPair> p = new ArrayList<OrderedPair>();
		String line = "";
		String result = "";
		String[] point;

		while(true){

			line = input.readLine();
			if(line == null){
				break;
			}

			point = line.split("\\s+");

			if(point.length != 2){
				continue;
			}

			try{
				double x = Double.parseDouble(point[0]);
				double y = Double.parseDouble(point[1]);
				// truncate the two points to 7 decimal points
				x = round7(x);
				y = round7(y);

				// turn points into an ordered pair
				OrderedPair op = new OrderedPair(x,y);

				if(p.contains(op)){
					// do nothing with that line
					continue;
				}

				// given that the line is two number values separated by one space 
				// and is not already in our list of points, we add it to our list
				p.add(op);

				result = result + point[0] + " " + point[1] + "\n";


			}
			catch(NumberFormatException nfe){
				// if we can't, do nothing with that line
				continue;
			}

		}

		System.out.print(result);
		


		// try{
		// 	line = input.readLine();
		// 	System.out.println(line);
		// }
		// catch(IOException ioe){
		// 	System.out.println("fuck");
		// }

		// double d = 1.123456789;
		// double e = 2.345678912;
		// Double f = 3.645234519;

		// d = round7(d);
		// e = round7(e);
		// f = round7(f);

		// System.out.println(Double.toString(d));
		// System.out.println(Double.toString(e));
		// System.out.println(Double.toString(f));


	}

	public static double round7(double d) {
		int temp = (int)((d * 10000000)+0.5);
		d = temp/10000000.0;
		return d;
	}

}