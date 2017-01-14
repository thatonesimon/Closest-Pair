package edu.usb.cs.csil.sswong.ClosestPair;

import static java.lang.Math;

private class Points{

	private ArrayList<OrderedPair> points;
	private int numPoints;
	private double closestDistance;

	public Points(ArrayList<OrderedPair> list){
		
		points = list;
		numPoints = points.size();

		// set the closest distance as the distance between
		// the first to points to have a base
		closestDistance = distanceBetween(points(0),points(1));
	
	}

	private ArrayList<OrderedPair> orderByX(){
		
		ArrayList<OrderedPair> sorted;

		for(int i = 0; i < numPoints; i++){

		}
		return sorted;
	
	}

	private ArrayList<OrderedPair> orderByY(){
		
		ArrayList<OrderedPair> sorted;

		for(int i = 0; i < numPoints; i++){

		}
		return sorted;

	}
	
	private ArrayList<OrderedPair> greedy(){
		
		int distance;
		ArrayList<OrderedPair> closest;

		// go through each pair and see if distance between
		// is smaller than current closestDistance
		for(int i = 0; i < numPoints-1; i++){
			for(int j = i+1; j < numPoints; j++){
				distance = distanceBetween(points(i),points(j));

				// if distance is smaller, then reset our array
				if(distance < closestDistance){
					closest.clear();
					closest.add(points(i));
					closest.add(points(j));
					closestDistance = distance;
				}

				// if distance is equal, add to our array
				else if(distance == closestDistance){
					closest.add(points(i));
					closest.add(points(j));
				}

				// otherwise, just continue
			}
		}
		return closest;
	
	}

	private ArrayList<OrderedPair> basicDnC(ArrayList<OrderedPair> input){
		
		int distance;
		ArrayList<OrderedPair> closest;
		if()
		int mid = numPoints/2;


		return closest;

	}

	private ArrayList<OrderedPair> DnC(ArrayList<OrderedPair> input){
		
		int distance;
		ArrayList<OrderedPair> closest;
		int mid = numPoints/2;
		


		return closest;
	}

	private double distanceBetween(OrderedPair a, OrderedPair b){
	
		return(Math.sqrt(Math.pow((b.x-a.x),2)+Math.pow(b.y-a.y),2));
	
	}
}