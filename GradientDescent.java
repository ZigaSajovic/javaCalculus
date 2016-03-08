import java.util.ArrayList;


public class GradientDescent {
	static double error=0.000001;
	static int maxIter=-1;
	static double stepSize=0.0001;
	static double maxStep=5;
	static private double div=1.0;
	
	public static void setMaxStep(double max){
		maxStep=max;
	}
	
	public static void setError(double e){
		error=e;
	}
	
	public static void setMaxIter(int max){
		maxIter=max;
	}
	
	private static double error(ArrayList<Double> a,ArrayList<Double> b){
		if(a==null||b==null) return 100000;
		double out=0;
		for(int i=0;i<a.size();i++){
			out+=Math.pow((a.get(i)-b.get(i)),2);
		}
		return Math.sqrt(out);
	}
	
	
	public static void printList(ArrayList<Double> b){
		for(int i=0;i<b.size();i++){
			System.out.println(b.get(i));
		}
	}
	
	public static ArrayList<Double> descent(ArrayList<Double> startPoint,FunctionExpression functionExpression, boolean saddle){
		if(!saddle) return descent(startPoint,functionExpression);
		else return descent(startPoint,Calculus.lengthOfGradient(functionExpression));
	}
	
	public static ArrayList<Double> descent(ArrayList<Double> startPoint,FunctionExpression functionExpression){
		ArrayList<Double> newEstimate=null;
		ArrayList<Double> oldEstimate;
		if(startPoint==null)oldEstimate=Calculus.getValues();
		else oldEstimate=new ArrayList<Double>(startPoint);
		ArrayList<FunctionExpression> derivatives=Calculus.getDerivatives((functionExpression));
		double oldEval=Calculus.compute(functionExpression);
	//	int iterCount=0;
		Calculus.setValues(startPoint);		
		while(error(oldEstimate,newEstimate)>error){
		//	System.out.println("\nstart");
		//	printList(oldEstimate);
		//	System.out.println("end");
			newEstimate=new ArrayList<Double>(oldEstimate);
			double newEval=0;
			do{
				Calculus.setValues(newEstimate);
				oldEstimate=new ArrayList<Double>(newEstimate);
				for(int i=0;i<derivatives.size();i++){
					double step=stepSize/div*Calculus.compute(derivatives.get(i));
					if(Math.abs(step)>maxStep) {
						if(step>=0) step=maxStep;
						else step=-maxStep;
					}
					oldEstimate.set(i, (oldEstimate.get(i) - step));
				}
				Calculus.setValues(oldEstimate);
				newEval=Calculus.compute(functionExpression);
				div*=10;
				//System.out.println("V iteraciji "+iterCount+"  - "+oldEval+" , "+newEval);
			}
			while(newEval>oldEval);
			oldEval=newEval;
			div=1.0;
		//	iterCount++;
			if(oldEval<0.1)break;
		}
		//System.out.println("\nNumber of Iterations: "+iterCount);
		//System.out.println(oldEval);
		//Util.printListDouble(oldEstimate);
		return oldEstimate;
	}
}
