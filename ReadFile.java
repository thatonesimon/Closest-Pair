import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.lang.Math;
import java.lang.Integer;

public class ReadFile{
	
	public static void main(String[] args) throws IOException{

		if(args.length != 1){
			System.out.println("usage: closestPair [brute|basic|optimal]");
			return;
		}

		String cmd = args[0];

		// System.in is the input given to the program
		// in this case, input redirection might be used (<)
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<OrderedPair> p = new ArrayList<OrderedPair>();
		String line;
		String[] point;

		// reading points from the input file
		// throwing out lines that don't fit criteria

		while((line = input.readLine()) != null){

			// split up the line by the space
			point = line.split("\\s+");

			// if there are not just two things in the line, do nothing
			if(point.length != 2){
				continue;
			}

			// try to parse our points to double
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

			}
			catch(NumberFormatException nfe){
				// if we can't, do nothing with that line
				continue;
			}

			// if the point is already in our list
			// we may to do some extra work to check points
			// to the seventh decimal point

		}

		// if we have less than two points, we exit
		if(p.size() < 2){
			System.err.println("We need at least 2 points to compare");
			return;
		}

		Points points = new Points(p);  

		// do stuff depending on the input commands ()
		ArrayList<OrderedPair> closestPairs = new ArrayList<OrderedPair>();

		switch(cmd){
			case "brute":

				// we'll sort first so that we don't have
				// to deal with sorting for this one
				// please excuse the terrible syntax
				// points.points = points.orderByX(points.points);
				closestPairs = points.brute(points.points);

			case "basic":

				closestPairs = points.basicDnC(points.points);

			case "optimal":

				closestPairs = points.optimalDnC(points.points);

		}

		ArrayList<OrderedPair> closestPairsOrdered = new ArrayList<OrderedPair>();
		closestPairsOrdered = sortPairs(closestPairs);


		System.out.println("closest pair distance: " + points.distanceBetween(closestPairs.get(0),closestPairs.get(1)));


		for(int i = 0; i < closestPairs.size()/2; i++){
			int index = 2*i;
			System.out.print(closestPairs.get((index)).toString());
			System.out.println(closestPairs.get((index+1)).toString());

		}
	}

	public static double round7(double d) {

		d = Math.round(d * 10000000);
		d = d/10000000;
		return d;

		/*long temp = (long)((d * 10000000)+0.5);
		d = temp/10000000.0;
		return d;*/
	}

	public static ArrayList<OrderedPair> sortPairs(ArrayList<OrderedPair> input){

		// sort points in the pairs
		for(int i = 0; i < input.size()/2; i++){
			if(input.get(2*i).x > input.get(2*i+1).x){
				OrderedPair temp = new OrderedPair(input.get(2*i).x,input.get(2*i).y);
				input.set(2*i,input.get(2*i+1));
				input.set(2*i+1,temp);
			}
			else if(input.get(2*i).x == input.get(2*i+1).x){
				if(input.get(2*i).y > input.get(2*i).y){
					OrderedPair temp = new OrderedPair(input.get(2*i).x,input.get(2*i).y);
					input.set(2*i,input.get(2*i+1));
					input.set(2*i+1,temp);
				}
			}
		}

/*		// sort pairs in the list
		ArrayList<Integer> sorted = new ArrayList<Integer>();
		sorted.add(0);

		for(int i = 1; i < input.size()/2; i++){
			if(input.get(2*i).x )
		}*/

		return input;
	}
}