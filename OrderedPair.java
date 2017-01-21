package edu.usb.cs.csil.sswong.ClosestPair;

private class OrderedPair{

	public double x;
	public double y;

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
	
}