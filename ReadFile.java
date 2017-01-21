package edu.usb.cs.csil.sswong.ClosestPair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class ReadFile{
	
	public static void main(String[] args){

		// System.in is the input given to the program
		// in this case, input redirection might be used (<)
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<OrderedPair> p;
		String line;
		String[] point;

		// reading points from the input file
		// throwing out lines that don't fit criteria
		while(line = input.readLine()){

			// split up the line by the space
			point = line.split(" ");

			// if there are not just two things in the line, do nothing
			if(point.length != 2){
				continue;
			}

			// try to parse our points to double
			try{
				double x = Double.parseDouble(point[0]);
				double y = Double.parseDouble(point[1]);
			}
			catch(NumberFormatException nfe){
				// if we can't, do nothing with that line
				continue;
			}

			// truncate the two points to 7 decimal points
			x = round7(x);
			y = round7(y);

			// turn points into an ordered pair
			OrderedPair op = new OrderedPair(x,y);

			// if the point is already in our list
			// we may to do some extra work to check points
			// to the seventh decimal point
			if(p.contains(op)){
				// do nothing with that line
				continue;
			}

			// given that the line is two number values separated by one space 
			// and is not already in our list of points, we add it to our list
			p.add(op);

		}

		// if we have less than two points, we exit
		if(p.size() < 2){
			System.err.println("We need at least 2 points to compare");
			return;
		}

		Points points = new Points(p);  

		// do stuff depending on the input commands ()
		ArrayList<OrderedPair> closestPairs;

		System.out.println("closest pair distance: " + p.closestDistance);
		for(int i = 0; i < closestPairs.size(); i++){
			System.out.print("(" + Double.toString(closestPairs(i).x) + ", " + Double.toString(closestPairs(i).y) + ") ");
		}
	}

	private double round7(double f) {
		long temp = f * 10000000 + 0.5; // round up
		double d = temp/10000000.0;
		return d;
	}
}