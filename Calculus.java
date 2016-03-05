import java.util.ArrayList;
import java.util.Stack;

public class Calculus {
	static Stack<Function> stack;
	private static ArrayList<String> variables=null;
	private static ArrayList<Double> values=null;
	public Calculus(){
	}
	
	//returns the value variable "variable" is set to
	public static double getValue(String variable){
		for(int i=0;i<getVariables().size();i++){
			if(getVariables().get(i).equals(variable)) return getValues().get(i);
		}
		return 0;
	}
	
	
	//returns length of the gradient of FunctionExpression, as a FuctionExpression
	public static FunctionExpression lengthOfGradient(FunctionExpression fE){
		ArrayList<FunctionExpression> derivatives = getDerivatives(fE);
		FunctionExpression out=null;
		for(int i=0;i<derivatives.size();i++){
			FunctionExpression a=FunctionExpression.exp(derivatives.get(i), 2.0);
			if(out==null)out=a;
			else out=FunctionExpression.sum(out, a);
		}
		return out;
	}
	
	//returns a list of all partial derivatives
	public static ArrayList<FunctionExpression> getDerivatives(FunctionExpression fE){
		ArrayList<FunctionExpression> f=new ArrayList<FunctionExpression>();
		ArrayList<String> var=Calculus.getVariables();
		for(int i=0;i<var.size();i++){
			FunctionExpression temp=computeDerivative(var.get(i), fE);
			f.add(FunctionExpression.simplifyExpression(temp));
		}
		return f;
	}
	//returns the value of the FunctionExpression evaluated at the point
	public static double compute(FunctionExpression fE){
		if(fE==null) return 0;
		if(variables==null){
			System.out.println("ERROR: Variables have no yet been set!");
			return 0;
		}
		Stack<Function> temp=stack;
		stack=new Stack<Function>();
		computeRekursion(fE);
		double out=stack.pop().evaluate();
		stack=temp;
		return out;
	}
	
	public void printStack(){
		if(stack.empty())return;
		System.out.println("Print Stack");
		for(int i=0;i<stack.size();i++){
			stack.elementAt(i).print();
		}
	}

	// returns the derivative of FunctionExpression with respect to <withRespectTo>, as a FunctionExpression 
	public static FunctionExpression computeDerivative(String withRespectTo,FunctionExpression fE){
		if(fE==null) return null;
		FunctionExpression out=null;
		if(fE.function.expression.equals("+")||fE.function.expression.equals("-")){
			FunctionExpression temp=new FunctionExpression(new Function(new String(fE.function.expression)));
			
			FunctionExpression derivativeLeft=computeDerivative(withRespectTo,fE.left);
			FunctionExpression derivativeRight=computeDerivative(withRespectTo,fE.right);
			if(derivativeLeft!=null)temp.addLeft(derivativeLeft);		
			if(derivativeRight!=null)temp.addRight(derivativeRight);
			if(derivativeLeft==null&&derivativeRight==null) return null;
			if(derivativeLeft==null&&derivativeRight!=null)	temp= derivativeRight;
			if(derivativeLeft!=null&&derivativeRight==null) temp= derivativeLeft;
			out= temp;
		}
		else if(fE.function.expression.equals("/")){
			out=computeDerivative(withRespectTo, FunctionExpression.product(fE.left, FunctionExpression.exp(fE.right, -1)));
		}
		else if(fE.function.expression.equals("*")){
			FunctionExpression tempPlus=new FunctionExpression(new Function("+"));
			FunctionExpression tempMul1=new FunctionExpression(new Function("*"));
			FunctionExpression tempMul2=new FunctionExpression(new Function("*"));
			
			FunctionExpression derivativeLeft=computeDerivative(withRespectTo,fE.left);
			FunctionExpression derivativeRight=computeDerivative(withRespectTo,fE.right);
			
			FunctionExpression copyLeft=null;
			FunctionExpression copyRight=null;
			if(fE.left!=null) copyLeft=fE.left.copy();
			if(fE.right!=null) copyRight=fE.right.copy();
			
			if(derivativeLeft==null) tempMul1=null;
			else {
				tempMul1.addRight(copyRight);
				tempMul1.addLeft(derivativeLeft);
				tempPlus.addLeft(tempMul1);
			}
			
			if(derivativeRight==null) tempMul2=null;
			else {
				tempMul2.addLeft(copyLeft);
				tempMul2.addRight(derivativeRight);
				tempPlus.addRight(tempMul2);
			}
			if(derivativeLeft==null&&derivativeRight==null) return null;
			if(derivativeLeft==null) tempPlus= tempMul2;
			if(derivativeRight==null) tempPlus= tempMul1;
			out= tempPlus;
		}
		else if(fE.function.expression.equals("^")){
			if(fE.right.function.expression.equals("const")){
				if(fE.right.function.value==0) return null;
				FunctionExpression muliEx=FunctionExpression.exp(fE.left.copy(), new Function("const", "/", (fE.right.function.value-1) ));
				FunctionExpression Exp=FunctionExpression.product(muliEx, new Function("const", "/", (fE.right.function.value)));
				FunctionExpression f=computeDerivative(withRespectTo, fE.left);
				if(f!=null)out=(FunctionExpression.product(Exp, f));
				else return null;
			}
		}
		else if(!ifOperator(fE.function.expression)) return out=derive(withRespectTo,fE);
		return FunctionExpression.simplifyNode(out);
	}
	
	//add a derivative of an arbitraryFunction in the table by appending
	//else if(fE.function.expression.equals("arbitraryFunction")){
	//			FunctionExpression temp=arbitraryFuntion.copy();
	//			temp.function.expression="derivativeOfArbitraryFunction";
	//			out=temp;
	//}
	//append just before "derive" handles differentiation of composite functions (after last else if)
	//returns the derivative of a FunctionExpression as a FunctionExpression 
	public static FunctionExpression derive(String withrespectTo,FunctionExpression fE){
		if(fE.function==null) return null;
		if(fE.function.compose==null&&!(fE.function.variable.equals(withrespectTo))) return null;
		FunctionExpression out=null;
		if(fE.function.expression.equals("sin")){
			FunctionExpression temp=fE.copy();
			temp.function.expression="cos";
			out=temp;
		}
		else if(fE.function.expression.equals("cos")){
			FunctionExpression temp=fE.copy();
			temp.function.expression="sin";
			out= FunctionExpression.product(temp,-1.0);
		}
		else if(fE.function.expression.equals("ln")){
			FunctionExpression temp=fE.copy();
			temp.function.expression=""+(fE.function.variable);
			out= FunctionExpression.exp(temp,-1.0);
		}
		else if(withrespectTo.equals(fE.function.variable)){
			FunctionExpression temp=new FunctionExpression(new Function("const", "/", 1.0));
			out= temp;
		}
		else if(fE.function.expression.equals("const")) return null;
		//computes derivatives of composed functions, if needed
		if(fE.function.compose!=null){
			FunctionExpression temp=computeDerivative(withrespectTo,fE.function.compose);
			if(temp==null) return null;
			out=FunctionExpression.product(out, temp);
		}
		return FunctionExpression.simplifyNode(out);
	}
	
	private static void computeRekursion(FunctionExpression fE){
		if(fE!=null){
			computeRekursion(fE.left);
			computeRekursion(fE.right);
			if(!ifOperator(fE.function.expression)){
				stack.push(fE.function);
			}
			else{
				//printStack();
				Function b=stack.pop();
				Function a=stack.pop();
				stack.push(new Function("const","/",compute(fE.function.expression,a,b)));
			}
		}
	}
	
	private static double compute(String operator, Function a, Function b){
		switch(operator.charAt(0)){
			case '+': return a.evaluate()+b.evaluate();
			case '-': return a.evaluate()-b.evaluate();
			case '*': return a.evaluate()*b.evaluate();
			case '/': return a.evaluate()/b.evaluate();
			case '^': return Math.pow(a.evaluate(), b.evaluate());
		}
		return 0;
	}
	
	private static boolean ifOperator(String s){
		return (s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")||s.equals("^"));
	}

	public static ArrayList<String> getVariables() {
		return variables;
	}

	public static void setVariables(ArrayList<String> variables) {
		Calculus.variables = variables;
	}

	public static ArrayList<Double> getValues() {
		return values;
	}

	public static void setValues(ArrayList<Double> values) {
		Calculus.values = values;
	}
	
	public static void setValue(String variable, double value){
		for(int i=0;i<getVariables().size();i++){
			if(getVariables().get(i).equals(variable)) {
				values.set(i, value);
			}
		}
	}
	
	public boolean isValid(String s){
		for(int i=0;i<getVariables().size();i++){
			if(getVariables().get(i).equals(s)) return true;
		}
		return false;
	}

}
