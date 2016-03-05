public class FunctionExpression {
	FunctionExpression left;
	FunctionExpression right;
	Function function;
	
	public FunctionExpression(Function function){
		this.function=function;
		this.left=null;
		this.right=null;
	}
	
	public FunctionExpression copy(){
		Function f=this.function.copy();
		FunctionExpression temp=new FunctionExpression(f);
		if(left!=null)temp.addLeft(left.copy());
		if(right!=null)temp.addRight(right.copy());
		return temp;
	}
	
	public void printByLevel(){
		int i=0;
		System.out.println("Level "+i);
		while(printByLevelRecursion(this, 0, i)) {
			i++;
			System.out.println("\nLevel "+i);
		}
	}
	
	public boolean printByLevelRecursion(FunctionExpression fE,int n, int N){
		if(fE==null) return false;
		if(n==N){
			fE.function.print();
			return true;
		}
		else{
			boolean temp1=printByLevelRecursion(fE.left, n+1, N);
			boolean temp2=printByLevelRecursion(fE.right, n+1, N);
			if(temp1||temp2) return true;
			else return false;
		}
	}
	
	public void addLeft(FunctionExpression left){
		this.left=left;
	}
	
	public void addRight(FunctionExpression right){
		this.right=right;
	}
	
	public static FunctionExpression sum(Function a, Function b){
		FunctionExpression out=new FunctionExpression(new Function("+"));
		out.addLeft(new FunctionExpression(a));
		out.addRight(new FunctionExpression(b));
		return out;
	}
	
	public static FunctionExpression sum(Function a, FunctionExpression b){
		FunctionExpression out=new FunctionExpression(new Function("+"));
		out.addLeft(new FunctionExpression(a));
		out.addRight(b);
		return out;
	}
	
	public static FunctionExpression sum(FunctionExpression a, Function b){
		FunctionExpression out=new FunctionExpression(new Function("+"));
		out.addLeft(a);
		out.addRight(new FunctionExpression(b));
		return out;
	}
	
	public static FunctionExpression sum(FunctionExpression a, FunctionExpression b){
		FunctionExpression out=new FunctionExpression(new Function("+"));
		out.addLeft(a);
		out.addRight(b);
		return out;
	}
	
	public static FunctionExpression sum(Function a, double b){
		FunctionExpression out=new FunctionExpression(new Function("+"));
		out.addLeft(new FunctionExpression(a));
		out.addRight(new FunctionExpression(new Function("const","/",b)));
		return out;
	}
	
	public static FunctionExpression sum(FunctionExpression a, double b){
		FunctionExpression out=new FunctionExpression(new Function("+"));
		out.addLeft(a);
		out.addRight(new FunctionExpression(new Function("const","/",b)));
		return out;
	}
	
	public static FunctionExpression sub(FunctionExpression a, double b){
		FunctionExpression out=new FunctionExpression(new Function("-"));
		out.addLeft(a);
		out.addRight(new FunctionExpression(new Function("const","/",b)));
		return out;
	}
	
	public static FunctionExpression sub(FunctionExpression a, FunctionExpression b){
		FunctionExpression out=new FunctionExpression(new Function("-"));
		out.addLeft(a);
		out.addRight(b);
		return out;
	}
	
	public static FunctionExpression div(Function a, Function b){
		FunctionExpression out=new FunctionExpression(new Function("/"));
		out.addLeft(new FunctionExpression(a));
		out.addRight(new FunctionExpression(b));
		return out;
	}
	
	public static FunctionExpression div(FunctionExpression a, Function b){
		FunctionExpression out=new FunctionExpression(new Function("/"));
		out.addLeft(a);
		out.addRight(new FunctionExpression(b));
		return out;
	}
	
	public static FunctionExpression div(Function a, double b){
		FunctionExpression out=new FunctionExpression(new Function("/"));
		out.addLeft(new FunctionExpression(a));
		out.addRight(new FunctionExpression(new Function("const","/",b)));
		return out;
	}
	
	public static FunctionExpression div(FunctionExpression a, double b){
		FunctionExpression out=new FunctionExpression(new Function("/"));
		out.addLeft(a);
		out.addRight(new FunctionExpression(new Function("const","/",b)));
		return out;
	}
	
	public static FunctionExpression div(FunctionExpression a, FunctionExpression b){
		FunctionExpression out=new FunctionExpression(new Function("/"));
		out.addLeft(a);
		out.addRight(b);
		return out;
	}
	
	public static FunctionExpression product(Function a, Function b){
		FunctionExpression out=new FunctionExpression(new Function("*"));
		out.addLeft(new FunctionExpression(a));
		out.addRight(new FunctionExpression(b));
		return out;
	}
	
	public static FunctionExpression product(FunctionExpression a, Function b){
		FunctionExpression out=new FunctionExpression(new Function("*"));
		out.addLeft(a);
		out.addRight(new FunctionExpression(b));
		return out;
	}
	
	public static FunctionExpression product(Function a, FunctionExpression b){
		FunctionExpression out=new FunctionExpression(new Function("*"));
		out.addLeft(new FunctionExpression(a));
		out.addRight(b);
		return out;
	}
	
	public static FunctionExpression product(Function a, double b){
		FunctionExpression out=new FunctionExpression(new Function("*"));
		out.addLeft(new FunctionExpression(a));
		out.addRight(new FunctionExpression(new Function("const","/",b)));
		return out;
	}
	
	public static FunctionExpression product(FunctionExpression a, double b){
		FunctionExpression out=new FunctionExpression(new Function("*"));
		out.addLeft(a);
		out.addRight(new FunctionExpression(new Function("const","/",b)));
		return out;
	}
	
	public static FunctionExpression product(FunctionExpression a, FunctionExpression b){
		FunctionExpression out=new FunctionExpression(new Function("*"));
		out.addLeft(a);
		out.addRight(b);
		return out;
	}
	
	public static FunctionExpression exp(Function a, Function b){
		FunctionExpression out=new FunctionExpression(new Function("^"));
		out.addLeft(new FunctionExpression(a));
		out.addRight(new FunctionExpression(b));
		return out;
	}
	
	public static FunctionExpression exp(FunctionExpression a, Function b){
		FunctionExpression out=new FunctionExpression(new Function("^"));
		out.addLeft(a);
		out.addRight(new FunctionExpression(b));
		return out;
	}
	
	public static FunctionExpression exp(Function a, double b){
		FunctionExpression out=new FunctionExpression(new Function("^"));
		out.addLeft(new FunctionExpression(a));
		out.addRight(new FunctionExpression(new Function("const","/",b)));
		return out;
	}
	
	public static FunctionExpression exp(FunctionExpression a, double b){
		FunctionExpression out=new FunctionExpression(new Function("^"));
		out.addLeft(a);
		out.addRight(new FunctionExpression(new Function("const","/",b)));
		return out;
	}
	
	public FunctionExpression diff(Function a, Function b){
		FunctionExpression out=new FunctionExpression(new Function("-"));
		out.addLeft(new FunctionExpression(a));
		out.addRight(new FunctionExpression(b));
		return out;
	}
	

	
	public static FunctionExpression simplifyNode(FunctionExpression fE){
		if(fE==null) return null;
		if(fE.function.expression.equals("*")){
			if(fE.left.function.expression.equals("const")&&fE.left.function.value==1) return fE.right;
			if(fE.right.function.expression.equals("const")&&fE.right.function.value==1) return fE.left;
		}
		if(fE.function.expression.equals("^")){
			if(fE.right.function.expression.equals("const")&&fE.right.function.value==1) return fE.left;
		}
		if(fE.function.expression.equals("+")||fE.function.expression.equals("-")){
			if(fE.left.function.expression.equals("const")&&fE.left.function.value==0) return fE.right;
			if(fE.right.function.expression.equals("const")&&fE.right.function.value==0) return fE.left;
		}
		return fE;
	}
	
	public static FunctionExpression simplifyExpression(FunctionExpression fE){
		if(fE==null)return null;
		fE.left=simplifyExpression(fE.left);
		fE.right=simplifyExpression(fE.right);
		return simplifyNode(fE);
	}
	
}

