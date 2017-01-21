package edu.usb.cs.csil.sswong.ClosestPair;

private class OrderedPair{

	public double x;
	public double y;

	class compX implements Comparator<OrderedPair>{

		public int compare(OrderedPair a, OrderedPair b){
			return a.x.compareTo(b.x);
		}
	}

	class compY implements Comparator<OrderedPair>{
		
		public int compare(OrderedPair a, OrderedPair b){
			return a.y.compareTo(b.y)
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
	
}