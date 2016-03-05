public class EquationSolver {
	
	double[][] matrix;
	int sizeX;
	int sizeY;
	
	public EquationSolver(double[][] m, int x, int y){
		sizeX=x;
		sizeY=y;
		matrix=m;
	}
	
	public void print(){
		for(int i=0;i<sizeY;++i){
			for(int j=0;j<sizeX+1;++j)System.out.print(matrix[i][j]+" ,");
			System.out.println();
		}
		System.out.println();
	}
	
	public double[] solve(){
		for(int i=0;i<sizeX-1;++i){
			double pivot=matrix[i][i];
			for(int j=i+1;j<sizeY;++j){
				double p=matrix[j][i]/pivot;
				for(int k=i;k<sizeX;++k){
					matrix[j][k]-=p*matrix[i][k];
				}
				matrix[j][sizeX]-=p*matrix[i][sizeX];
			}
		}
		
		for(int i=sizeX-1;i>=0;--i){
			double pivot=matrix[i][i];
			for(int j=i-1;j>=0;--j){
				double p=matrix[j][i]/pivot;
				for(int k=i;k<sizeX;++k){
					matrix[j][k]-=p*matrix[i][k];
				}
				matrix[j][sizeX]-=p*matrix[i][sizeX];
			}
		}
		double[] out=new double[sizeX];
		for(int i=0;i<sizeY;++i){
			matrix[i][sizeX]/=matrix[i][i];
			out[i]=matrix[i][sizeX];
		}
		return out;
	}
}
