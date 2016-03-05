public class Function{
	String variable;
	String expression;
	double value;	
	FunctionExpression compose=null;
	
	public Function(String expression, String variable, double value) {
		this.variable = variable;
		this.expression = expression;
		this.value=value;
	}
	
	public Function(String expression){
		this.expression=expression;
	}
	
	public Function copy(){
		Function temp=new Function(expression);
		temp.value=value;
		temp.variable=variable;
		if(compose!=null)temp.compose=compose.copy();
		return temp;
	}
	
	public void compose(FunctionExpression f){
		compose=f;
	}
	
	public void print(){
		System.out.println("Function: "+expression);
		System.out.println("Variable: "+variable);
		System.out.println("Value: "+value);
		if(compose!=null)System.out.println("Compose: "+compose.function.expression);
	}
	
	//add arbitrary function "genericFunction" by appending
	//if(expression.equals("genericFunction") return mapValue();
	public double evaluate(){
		double value;
		if(variable.equals("/"))value=this.value;
		else value=Calculus.getValue(variable);
		if(compose!=null){
			value= Calculus.compute(compose);
		}
		if(expression.equals("const")) return this.value;
		if(expression.equals("sin")) return Math.sin(value);
		if(expression.equals("cos")) return Math.cos(value);
		if(expression.equals("ln")) return Math.log(value);
		if(expression.equals(variable)) return value;
		return 0;
	}
}
