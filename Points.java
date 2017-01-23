package edu.usb.cs.csil.sswong.ClosestPair;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Collections;

public class Points{

	private ArrayList<OrderedPair> points;

	public Points(ArrayList<OrderedPair> list){

		points = new ArrayList<OrderedPair>(list);
	
	}

	private ArrayList<OrderedPair> orderByX(ArrayList<OrderedPair> list){

		ArrayList<OrderedPair> sorted = new ArrayList<OrderedPair>();
		CompX compX = new CompX();
		sorted = Collections.sort(list,compX);
		return sorted;
	
	}

	private ArrayList<OrderedPair> orderByY(ArrayList<OrderedPair> list){

		ArrayList<OrderedPair> sorted = new ArrayList<OrderedPair>();
		CompY compY = new CompY();
		sorted = Collections.sort(list,compY);
		return sorted;

	}
	
	private ArrayList<OrderedPair> greedy(){
		
		int distance;

		// set the closest distance as the distance between
		// the first to points to have a base
		double closestDistance = distanceBetween(points.get(0),points.get(1));

		// note that points that are paired wil always be right next to each other in the array
		ArrayList<OrderedPair> closest = new ArrayList<OrderedPair>();

		// go through each pair and see if distance between
		// is smaller than current closestDistance
		for(int i = 0; i < numPoints()-1; i++){
			for(int j = i+1; j < numPoints(); j++){
				distance = distanceBetween(points.get(i),points.get(j));

				// if distance is smaller, then reset our array
				if(distance < closestDistance){
					closest.clear();
					closest.add(points.get(i));
					closest.add(points.get(j));
					closestDistance = distance;
				}

				// if distance is equal, add to our array
				else if(distance == closestDistance){
					closest.add(points.get(i));
					closest.add(points.get(j));
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
			ArrayList<OrderedPair> closest = new ArrayList<OrderedPair>();

			// set the closest distance as the distance between
			// the first to points to have a base
			double closestDistance = distanceBetween(input.get(0),input.get(1));
			closest.add(input.get(0));
			closest.add(input.get(1));

			if(distanceBetween(input.get(1),input.get(2)) < closestDistance){
				closest.clear();
				closest.add(input.get(1));
				closest.add(input.get(2));
				closestDistance = distanceBetween(input.get(1),input.get(2));
			}
			if(distanceBetween(input.get(1),input.get(2)) == closestDistance){
				closest.add(input.get(1));
				closest.add(input.get(2));
			}
			if(distanceBetween(input.get(0),input.get(2)) < closestDistance){
				closest.clear();
				closest.add(input.get(0));
				closest.add(input.get(2));
				closestDistance = distanceBetween(input.get(0),input.get(2));
			}
			if(distanceBetween(input.get(0),input.get(2)) == closestDistance){
				closest.add(input.get(0));
				closest.add(input.get(2));
			}
			return closest;
		}

		// split up the array in half
		int half = input.size()/2;
		ArrayList<OrderedPair> left = new ArrayList<OrderedPair>(input.sublist(0,half));
		ArrayList<OrderedPair> right = new ArrayList<OrderedPair>(input.sublist(half+1,input.size()));

		ArrayList<OrderedPair> leftClosest = basicDnC(left);
		ArrayList<OrderedPair> rightClosest = basicDnC(right);

		// see which pair in each half is closer
		double distanceL = distanceBetween(leftClosest.get(0),leftClosest.get(1));
		double distanceR = distanceBetween(rightClosest.get(0),leftClosest.get(1));

		ArrayList<OrderedPair> closest = new ArrayList<OrderedPair>();

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