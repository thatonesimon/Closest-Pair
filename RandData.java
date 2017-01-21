package edu.usb.cs.csil.sswong.ClosestPair;

class RandData{

	private static int MIN = -10000;
	private static int MAX = 10000;

	private double random(int n){

		for(int i = 0; i < n; i++){
			return MIN + (MAX - MIN) * (double) rand() / RAND_MAX;
		}

	}

	 
}