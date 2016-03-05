public class Vec {
	
	public static double dotProd(double[] a, double[] b){
		return a[0]*b[0]+a[1]*b[1];
	}
	
	public static double[] prod(double[] a,double b){
		double[] out=new double[2];
		out[0]=a[0]*b;
		out[1]=a[1]*b;
		return out;
	}
	
	public static double[] sumD(double[] a,double[] b){
		double[] out=new double[2];
		out[0]=a[0]+b[0];
		out[1]=a[1]+b[1];
		return out;
	}
	
	public static double[] sum(int[] a,double[] b){
		double[] out=new double[2];
		out[0]=a[0]+b[0];
		out[1]=a[1]+b[1];
		return out;
	}
	
	public static int[] sumInt(int[] a,double[] b){
		int[] out=new int[2];
		out[0]=a[0]+(int)b[0];
		out[1]=a[1]+(int)b[1];
		return out;
	}
	
	public static int[] subInt(int[] a,int[] b){
		int[] out=new int[2];
		out[0]=a[0]-(int)b[0];
		out[1]=a[1]-(int)b[1];
		return out;
	}
	
	public static int[] sumInt(int[] a,int[] b){
		int[] out=new int[2];
		out[0]=a[0]+(int)b[0];
		out[1]=a[1]+(int)b[1];
		return out;
	}
	
	public static double[] add(double[] a,double[] b){
		double[] out=new double[2];
		out[0]=a[0]+b[0];
		out[1]=a[1]+b[1];
		return out;
	}
	
	public static double[] normalize(double[] a, int size){
		double sum=0;
		for(int i=0;i<size;i++){
			sum+=a[i]*a[i];
		}
		sum=Math.sqrt(sum);
		for(int i=0;i<size;i++)a[i]/=sum;
		return a;
	}
	
	public static double normDouble(double[]a){
		return Math.sqrt(Math.pow(a[0], 2)+Math.pow(a[1], 2));
	}
	
	public static double normInt(int[]a){
		return Math.sqrt(Math.pow(a[0], 2)+Math.pow(a[1], 2));
	}

}
