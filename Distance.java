public class Distance {
	
	private static double dotProduct(int[] pointA, int[] pointB, int[] pointC)
	{
	    double[] AB = new double[2];
	    double[] BC = new double[2];
	    AB[0] = pointB[0] - pointA[0];
	    AB[1] = pointB[1] - pointA[1];
	    BC[0] = pointC[0] - pointB[0];
	    BC[1] = pointC[1] - pointB[1];
	    double dot = AB[0] * BC[0] + AB[1] * BC[1];

	    return dot;
	}

	public static double vecProduct(int[] pointA, int[] pointB, int[] pointC)
	{
	    double[] AB = new double[2];
	    double[] AC = new double[2];
	    AB[0] = pointB[0] - pointA[0];
	    AB[1] = pointB[1] - pointA[1];
	    AC[0] = pointC[0] - pointA[0];
	    AC[1] = pointC[1] - pointA[1];
	    double cross = AB[0] * AC[1] - AB[1] * AC[0];

	    return cross;
	}

	private static double distance(int[] pointA, int[] pointB)
	{
	    double d1 = pointA[0] - pointB[0];
	    double d2 = pointA[1] - pointB[1];

	    return Math.sqrt(d1 * d1 + d2 * d2);
	}


	public static double pointToLine(int[] pointA, int[] pointB, int[] pointC, 
	    boolean isSegment)
	{
	    double dist = vecProduct(pointA, pointB, pointC) / distance(pointA, pointB);
	    if (isSegment)
	    {
	        double dot1 = dotProduct(pointA, pointB, pointC);
	        if (dot1 > 0) 
	            return distance(pointB, pointC);

	        double dot2 = dotProduct(pointB, pointA, pointC);
	        if (dot2 > 0) 
	            return distance(pointA, pointC);
	    }
	    return Math.abs(dist);
	} 

}
