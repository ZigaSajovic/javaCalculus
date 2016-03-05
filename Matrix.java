
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
	
	public static double[][] prod(double[][] a, double[][]b){
		int aX=a[0].length;
		int aY=a.length;
		int bX=b[0].length;
		int bY=b.length;
		if(aX!=bY) return null;
		double[][]out=new double[aY][bX];
		for(int i=0;i<aY;i++){
			for(int j=0;j<bX;j++){
				double sum=0;
				for(int k=0;k<aX;k++){
					sum+=a[i][k]*b[k][j];
				}
				out[i][j]=sum;
			}
		}
		return out;
	}
	
	public static double[][] transpose(double[][]a){
		int aX=a[0].length;
		int aY=a.length;
		double[][]out=new double[aX][aY];
		for(int i=0;i<aY;i++){
			for(int j=0;j<aX;j++) out[j][i]=a[i][j];
		}
		return out;
	}
	
	public static double[][] appendColumn(double[][]a, double[]b){
		int aX=a[0].length;
		int aY=a.length;
		int bY=b.length;
		if(aY!=bY) return null;
		double[][]out=new double[aY][aX+1];
		for(int i=0;i<aY;i++){
			for(int j=0;j<aX;j++) out[i][j]=a[i][j];
			out[i][aX]=b[i];
		}
		return out;
	}
	
	public static double[] prod(double[][] a,double[] input){
		int aY=a.length;
		int aX=a[0].length;
		int inY=input.length;
		if(aX!=inY) return null;
		double[] out =new double[aY];
		for(int i=0;i<aY;i++){
			out[i]=0;
			for(int j=0;j<inY;j++){
				out[i]+=a[i][j]*input[j];
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
