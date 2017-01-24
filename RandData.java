import java.util.Random;
import java.lang.Integer;

public class RandData{

	public static void main(String[] args){

		int numNums = Integer.parseInt(args[0]);
		for(int i = 0; i < numNums; i++){
			System.out.println(Double.toString(rand()) + " " + Double.toString(rand()));
		}
		return;
	}

	private static double rand(){

		Random r = new Random();
		double randomValue = -10000 + (20000) * r.nextDouble();
		return randomValue;
	}
	
}