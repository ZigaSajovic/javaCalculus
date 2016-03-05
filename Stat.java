package polyDraw.math;

import java.util.ArrayList;

import polyDraw.util.Util;


public class Stat {
	
	public static double meanDouble(ArrayList<Double> data){
		double sum=0;
		for(int i=0;i<data.size();i++){
			sum+=data.get(i);
		}
		return sum/data.size();
	}
	
	public static double momentDouble(ArrayList<Double> data, double at, int n){
		double sum=0;
		for(int i=0;i<data.size();i++){
			sum+=Math.pow((data.get(i)-at),n);
		}
		return sum/data.size();
	}
	
	public static double[] momentVec(ArrayList<double[]> data, int subSize, double[] mean, int n){
		double[] out=new double[subSize];
		for(int i=0;i<data.size();i++){
			for(int j=0;j<subSize;j++){
				out[j]+=Math.pow((data.get(i)[j]-mean[j]),n);
			}			
		}
		for(int j=0;j<subSize;j++){
			out[j]/=data.size();
		}
		return out;
	}
	
	public static double[] momentVecD(ArrayList<int[]> data, int subSize, double[] mean, int n){
		double[] out=new double[subSize];
		for(int i=0;i<data.size();i++){
			for(int j=0;j<subSize;j++){
				out[j]+=Math.pow((data.get(i)[j]-mean[j]),n);
			}			
		}
		for(int j=0;j<subSize;j++){
			out[j]/=data.size();
		}
		return out;
	}
	public static double meanFromIndex(ArrayList<Integer> index, ArrayList<Double> data){
		double sum=0;
		for(int i=0;i<index.size();i++){
			sum+=data.get(index.get(i));
		}
		return sum/index.size();
	}
	
	public static double[] mean(ArrayList<double[]> data, int subSize){
		double[] out=new double[subSize];
		for(int i=0;i<data.size();i++){
			for(int j=0;j<subSize;j++){
				out[j]+=data.get(i)[j];
			}			
		}
		for(int j=0;j<subSize;j++){
			out[j]/=data.size();
		}
		return out;
	}
	
	public static double[] meanD(ArrayList<int[]> data, int subSize){
		double[] out=new double[subSize];
		for(int i=0;i<data.size();i++){
			for(int j=0;j<subSize;j++){
				out[j]+=data.get(i)[j];
			}			
		}
		for(int j=0;j<subSize;j++){
			out[j]/=data.size();
		}
		return out;
	}
	
	public static int[] meanInt(ArrayList<int[]> data, int subSize){
		int[] out=new int[subSize];
		for(int i=0;i<data.size();i++){
			for(int j=0;j<subSize;j++){
				out[j]+=data.get(i)[j];
			}			
		}
		for(int j=0;j<subSize;j++){
			out[j]/=data.size();
		}
		return out;
	}
	
	public static double[] meanFomIndexAbs(ArrayList<Integer> index,ArrayList<double[]> data, int subSize){
		double[] out=new double[subSize];
		for(int i=0;i<index.size();i++){
			for(int j=0;j<subSize;j++){
				out[j]+=Math.abs(data.get(index.get(i))[j]);
			}			
		}
		for(int j=0;j<subSize;j++){
			out[j]/=index.size();
		}
		return out;
	}
	
	public static ArrayList<double[]>meansFromIndexVecAbs(ArrayList<ArrayList<Integer>> index,ArrayList<double[]> data, int subSize){
		ArrayList<double[]> out=new ArrayList<double[]>();
		for(int i=0;i<index.size();i++){
			out.add(meanFomIndexAbs(index.get(i), data, subSize));
		}
		return out;
	}
	
	public static double[] meanFomIndex(ArrayList<Integer> index,ArrayList<double[]> data, int subSize){
		double[] out=new double[subSize];
		for(int i=0;i<index.size();i++){
			for(int j=0;j<subSize;j++){
				out[j]+=data.get(index.get(i))[j];
			}			
		}
		for(int j=0;j<subSize;j++){
			out[j]/=index.size();
		}
		return out;
	}
	
	public static ArrayList<double[]>meansFromIndexVec(ArrayList<ArrayList<Integer>> index,ArrayList<double[]> data, int subSize){
		ArrayList<double[]> out=new ArrayList<double[]>();
		for(int i=0;i<index.size();i++){
			out.add(meanFomIndex(index.get(i), data, subSize));
		}
		return out;
	}
	
	public static ArrayList<Double>meansFromIndex(ArrayList<ArrayList<Integer>> index,ArrayList<Double> data){
		ArrayList<Double> out=new ArrayList<Double>();
		for(int i=0;i<index.size();i++){
			out.add(meanFromIndex(index.get(i), data));
		}
		return out;
	}
	
	public static ArrayList<Integer> findEquals(ArrayList<Double> in, double error){
		ArrayList<Integer> max=new ArrayList<Integer>();
		ArrayList<Integer> temp;
		for(int i=0;i<in.size();i++){
			if(in.get(i)<0) continue;
			temp=new ArrayList<Integer>();
			temp.add(i);
			for(int j=0;j<in.size();j++){
				if(i==j||in.get(j)<0)continue;
				if(Math.abs(in.get(i)-in.get(j))<error){
					temp.add(j);
				}
			}
			if(temp.size()>max.size())max=temp;
		}
		return max;
	}
	
	public static ArrayList<Integer> findEqualsCons(ArrayList<Double> in, double error){
		ArrayList<Integer> max=new ArrayList<Integer>();
		ArrayList<Integer> temp;
		for(int i=0;i<in.size();i++){
			if(in.get(i)<0) continue;
			temp=new ArrayList<Integer>();
			temp.add(i);
			for(int j=i+1;j<in.size();j++){
				if(i==j||in.get(j)<0)break;
				if(Math.abs(in.get(i)-in.get(j))<error){
					temp.add(j);
				}
				else break;
			}
			if(temp.size()>max.size())max=temp;
		}
		return max;
	}
	
	public static ArrayList<Integer> findEqualsVec(ArrayList<double[]> in){
		ArrayList<Integer> max=new ArrayList<Integer>();
		ArrayList<Integer> temp;
		for(int i=0;i<in.size();i++){
			if(in.get(i)==null) continue;
			temp=new ArrayList<Integer>();
			temp.add(i);
			for(int j=0;j<in.size();j++){
				if(i==j||in.get(j)==null)continue;
				if((Vec.dotProd(in.get(i), in.get(j)))>=0.95){
					temp.add(j);
				}
			}
			if(temp.size()>max.size())max=temp;
		}
		return max;
	}
	
	public static ArrayList<Integer> findNequalsVec(ArrayList<double[]> in){
		ArrayList<Integer> max=new ArrayList<Integer>();
		ArrayList<Integer> temp;
		for(int i=0;i<in.size();i++){
			if(in.get(i)==null) continue;
			temp=new ArrayList<Integer>();
			temp.add(i);
			for(int j=0;j<in.size();j++){
				if(i==j||in.get(j)==null)continue;
				if((Vec.dotProd(in.get(i), in.get(j)))<=-0.95){
					temp.add(j);
				}
			}
			if(temp.size()>max.size())max=temp;
		}
		return max;
	}
	
	public static ArrayList<ArrayList<Integer>> getEquals(ArrayList<Double> in, double error){
		ArrayList<Double> data=Util.copy(in);
		ArrayList<ArrayList<Integer>> out=new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp;
		while((temp=findEquals(data, error)).size()!=0){
			out.add(temp);
			for(int i=0;i<temp.size();i++) data.set(temp.get(i), -1.0);
		}
		return out;
	}
	
	public static ArrayList<ArrayList<Integer>> getEqualsCons(ArrayList<Double> in, double error){
		ArrayList<Double> data=Util.copy(in);
		ArrayList<ArrayList<Integer>> out=new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp;
		while((temp=findEqualsCons(data, error)).size()!=0){
			out.add(temp);
			for(int i=0;i<temp.size();i++) data.set(temp.get(i), -1.0);
		}
		return out;
	}
	
	public static ArrayList<ArrayList<Integer>> getParallel(ArrayList<double[]> in){
		ArrayList<double[]> data=Util.copyVec(in);
		ArrayList<ArrayList<Integer>> out=new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp;
		while((temp=findEqualsVec(data)).size()!=0){
			out.add(temp);
			for(int i=0;i<temp.size();i++) data.set(temp.get(i), null);
		}
		return out;
	}
	
	public static ArrayList<ArrayList<Integer>> getNparallel(ArrayList<double[]> in){
		ArrayList<double[]> data=Util.copyVec(in);
		ArrayList<ArrayList<Integer>> out=new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> temp;
		while((temp=findNequalsVec(data)).size()!=0){
			out.add(temp);
			for(int i=0;i<temp.size();i++) data.set(temp.get(i), null);
		}
		return out;
	}
}
