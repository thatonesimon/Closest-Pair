package edu.usb.cs.csil.sswong.ClosestPair;

class RandData{

	private static int min = -10000;
	private static int max = 10000;

	private double random(int n){
		
		for(int i = 0; i < n; i++){
			return min + (max - min) * (double)rand() / RAND_MAX;
		}
	}

	 
}