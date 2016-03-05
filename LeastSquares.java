
public class LeastSquares {
	
	public static double[] solve(double[][] equations, double[] vector){
		double[][] aT=Matrix.transpose(equations);
		double[][] eT=Matrix.prod(aT, equations);
		if(eT==null) return null;
		double[]b=Matrix.prod(aT,vector);
		if(b==null) return null;
		eT=Matrix.appendColumn(eT, b);
		if(eT==null) return null;
		return (new EquationSolver(eT, (eT[0].length-1), eT.length)).solve();
	}
	
}
