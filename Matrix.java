package polyDraw.math;

public class Matrix {
	static double[][] matrix;
	
	
	public static int[] prodInt(int[] input){
		int[] out =new int[2];
		out[0]=0;
		out[1]=0;
		for(int i=0;i<2;i++){
			for(int j=0;j<2;j++){
				out[i]+=matrix[i][j]*input[j];
			}
		}
		return out;
	}
	
	public static double[] prodDouble(double[] input){
		double[] out =new double[2];
		out[0]=0;
		out[1]=0;
		for(int i=0;i<2;i++){
			for(int j=0;j<2;j++){
				out[i]+=matrix[i][j]*input[j];
			}
		}
		return out;
	}
	
	public static void setRotMatrixRad(double kot){
		matrix=new double[2][2];
		matrix[0][0]=Math.cos((kot));
		matrix[1][0]=-Math.sin((kot));
		matrix[0][1]=Math.sin((kot));
		matrix[1][1]=Math.cos((kot));
	}
	
	public static void setRotMatrixDeg(double kot){
		matrix=new double[2][2];
		matrix[0][0]=Math.cos(Math.toRadians(kot));
		matrix[1][0]=-Math.sin(Math.toRadians(kot));
		matrix[0][1]=Math.sin(Math.toRadians(kot));
		matrix[1][1]=Math.cos(Math.toRadians(kot));
	}
}
