package edu.usb.cs.csil.sswong.ClosestPair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

class ReadFile{

	private Points p;
	
	public static void main(String[] args){

		BufferedReader br = null;


		// BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// System.in takes in data from file input by <



		// after getting the list of points into p.points



		ArrayList<OrderedPair> closestPairs;

		System.out.println("closest pair distance: " + p.closestDistance);
		for(int i = 0; i < closestPairs.size(); i++){
			System.out.print("(" + Double.toString(closestPairs(i).x) + ", " + Double.toString(closestPairs(i).y) + ") ");
		}
	}
}