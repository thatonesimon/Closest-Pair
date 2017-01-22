package edu.usb.cs.csil.sswong.ClosestPair;

import java.lang.Math;
import java.util.ArrayList;

import OrderedPair;

private class Points{

	private ArrayList<OrderedPair> points;

	public Points(ArrayList<OrderedPair> list){
		
		points = list;
	
	}

	private ArrayList<OrderedPair> orderByX(ArrayList<OrderedPair> list){

		ArrayList<OrderedPair> sorted = new ArrayList();
		sorted = Collections.sort(list,compX);
		return sorted;
	
	}

	private ArrayList<OrderedPair> orderByY(ArrayList<OrderedPair> list){

		ArrayList<OrderedPair> sorted = new ArrayList();
		sorted = Collections.sort(list,compY);
		return sorted;

	}
	
	private ArrayList<OrderedPair> greedy(){
		
		int distance;

		// set the closest distance as the distance between
		// the first to points to have a base
		double closestDistance = distanceBetween(points(0),points(1));

		// note that points that are paired wil always be right next to each other in the array
		ArrayList<OrderedPair> closest = new ArrayList();

		// go through each pair and see if distance between
		// is smaller than current closestDistance
		for(int i = 0; i < numPoints()-1; i++){
			for(int j = i+1; j < numPoints(); j++){
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

		if(input.size() == 2){
			return input;
		}

		if(input.size() == 3){
			ArrayList<OrderedPair> closest = new ArrayList();

			// set the closest distance as the distance between
			// the first to points to have a base
			double closestDistance = distanceBetween(input(0),input(1));
			closest.add(point(0));
			closest.add(point(1));
			if(distanceBetween(input(1),input(2)) < closestDistance){
				closest.clear();
				closest.add(input(1));
				closest.add(input(2));
				closestDistance = distanceBetween(input(1),input(2));
			}
			if(distanceBetween(input(1),input(2)) == closestDistance){
				closest.add(input(1));
				closest.add(input(2));
			}
			if(distanceBetween(input(0),input(2)) < closestDistance){
				closest.clear();
				closest.add(input(0));
				closest.add(input(2));
				closestDistance = distanceBetween(input(0),input(2));
			}
			if(distanceBetween(input(0),input(2)) == closestDistance){
				closest.add(input(0));
				closest.add(input(2));
			}
			return closest;
		}

		// split up the array in half
		int half = input.size()/2
		ArrayList<OrderedPair> left = input.sublist(0,half);
		ArrayList<OrderedPair> right = input.sublist(half+1,input.size());

		ArrayList<OrderedPair> leftClosest = basicDnC(left);
		ArrayList<OrderedPair> rightClosest = basicDnC(right);

		// see which pair in each half is closer
		double distanceL = distanceBetween(leftClosest(0),leftClosest(1));
		double distanceR = distanceBetween(rightClosest(0),leftClosest(1));

		ArrayList<OrderedPair> closest = new ArrayList();

		if(distanceL == distanceR){

		}


		// now we set up the strip
		


		return closest;

	}

	private ArrayList<OrderedPair> DnC(ArrayList<OrderedPair> input){

		if(input.size() == 2){
			return input;
		}
		
		int distance;
		ArrayList<OrderedPair> closest;
		int mid = numPoints()/2;

		
		return closest;
	}

	private double distanceBetween(OrderedPair a, OrderedPair b){

		double d = Math.sqrt(Math.pow((b.x-a.x),2)+Math.pow(b.y-a.y),2);
		long temp = f * 10000000 + 0.5; // round up
		d = temp/10000000.0;
		return d;
	
	}

	private int numPoints(){
		
		return points.size();
	}
}