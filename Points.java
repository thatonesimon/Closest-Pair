import java.lang.Math;
import java.util.ArrayList;
import java.util.Collections;

public class Points{

	public ArrayList<OrderedPair> points;

	public Points(ArrayList<OrderedPair> list){

		points = new ArrayList<OrderedPair>(list);
	
	}

	public ArrayList<OrderedPair> orderByX(ArrayList<OrderedPair> list){

		OrderedPair.CompX compX = new OrderedPair.CompX();
		Collections.sort(list,compX);
		return list;
	
	}

	private ArrayList<OrderedPair> orderByY(ArrayList<OrderedPair> list){

		OrderedPair.CompY compY = new OrderedPair.CompY();
		Collections.sort(list,compY);
		return list;

	}
	
	public ArrayList<OrderedPair> brute(){
		
		double distance;

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

	public ArrayList<OrderedPair> basicDnC(ArrayList<OrderedPair> input){

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

		// order the array by x, then
		// split up the array in half
		input = this.orderByX(input);
		int half = input.size()/2;
		ArrayList<OrderedPair> left = new ArrayList<OrderedPair>(input.subList(0,half));
		ArrayList<OrderedPair> right = new ArrayList<OrderedPair>(input.subList(half,input.size()));

		ArrayList<OrderedPair> leftClosest = basicDnC(left);
		ArrayList<OrderedPair> rightClosest = basicDnC(right);

		// see which pair in each half is closer
		double distanceL = distanceBetween(leftClosest.get(0),leftClosest.get(1));
		double distanceR = distanceBetween(rightClosest.get(0),leftClosest.get(1));

		ArrayList<OrderedPair> closest = new ArrayList<OrderedPair>();
		double bestD = distanceL;

		if(distanceL == distanceR){
			closest.addAll(leftClosest);
			closest.addAll(rightClosest);
		}
		else if(distanceL < distanceR){
			closest.addAll(leftClosest);
		}
		else{
			closest.addAll(rightClosest);
			bestD = distanceR;
		}


		// now we set up the strip
		ArrayList<OrderedPair> stripPoints = new ArrayList<OrderedPair>();
		double mid = (input.get(half).x+input.get(half+1).x)/2;
		// check left
		int i = 0;
		while(half-1-i >= 0){
			if(input.get(half-1-i).x > mid-bestD){
				stripPoints.add(input.get(half-1));
				i++;
			}
			else{
				break;
			}
		}

		// check right
		i = 0;
		while(half+i < input.size()){
			if(input.get(half+i).x < mid+bestD){
				stripPoints.add(input.get(half+i));
				i++;
			}
			else{
				break;
			}
		}

		// order them for checking
		stripPoints = this.orderByY(stripPoints);

		for(i = 0; i < stripPoints.size()-1; i++){
			for(int j = i+1; stripPoints.get(j).y < stripPoints.get(i).y+bestD; j++){
				if(distanceBetween(stripPoints.get(i),stripPoints.get(j)) < bestD){
					closest.clear();
					closest.add(stripPoints.get(i));
					closest.add(stripPoints.get(j));
					bestD = distanceBetween(stripPoints.get(i),stripPoints.get(j));
				}
				else if(distanceBetween(stripPoints.get(i),stripPoints.get(j)) == bestD){
					closest.add(stripPoints.get(i));
					closest.add(stripPoints.get(j));
				}
				if(j+1 >= stripPoints.size()){
					break;
				}
			}
		}

		return closest;

	}

	public ArrayList<OrderedPair> DnC(ArrayList<OrderedPair> input){

		if(input.size() == 2){
			return input;
		}
		
		int distance;
		ArrayList<OrderedPair> closest = new ArrayList<OrderedPair>();
		int mid = numPoints()/2;
		
		return closest;
	}

	public double distanceBetween(OrderedPair a, OrderedPair b){

		double d = Math.sqrt(Math.pow((b.x-a.x),2)+Math.pow(b.y-a.y,2));
		int temp = (int)((d * 10000000) + 0.5);
		d = temp/10000000.0;
		return d;
	
	}

	private int numPoints(){
		
		return points.size();

	}

}