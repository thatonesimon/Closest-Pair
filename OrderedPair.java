package edu.usb.cs.csil.sswong.ClosestPair;

import java.util.Comparator;

public class OrderedPair{

	public Double x;
	public Double y;

	class CompX implements Comparator<OrderedPair>{

		public int compare(OrderedPair a, OrderedPair b){
			if(a.x == b.x){
				return a.y.compareTo(b.y);
			}
			return a.x.compareTo(b.x);
		}
	}

	class CompY implements Comparator<OrderedPair>{

		public int compare(OrderedPair a, OrderedPair b){
			if(a.y == b.y){
				return a.x.compareTo(b.x);
			}
			return a.y.compareTo(b.y);
		}
	}

	public OrderedPair(double x, double y){
		this.x = x;
		this.y = y;
	}

	public boolean smallerX(OrderedPair other){
		if(this.x < other.x){
			return true;
		}
		if(this.x == other.x){
			if(this.y < other.y){
				return true;
			}
		}
		return false;
	}

	public boolean smallerY(OrderedPair other){
		if(this.y < other.y){
			return true;
		}
		if(this.y == other.y){
			if(this.x < other.x){
				return true;
			}
		}
		return false;
	}

	public String toString(){

		String result = "(" + Double.toString(x) + ", " + Double.toString(y) + ") ";
		return result;
	}
	
}