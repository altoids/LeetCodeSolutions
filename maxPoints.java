import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;


public class maxPoints {

	private class Point {
		 				int x;
		 				int y;
		 				Point() { x = 0; y = 0; }
		 				Point(int a, int b) { x = a; y = b; }
	}
	
	Point p0;
	public int maxPoints(Point[] points) {
		int maxpoints = 0;
		if (points.length <= 2)
			return points.length;
		
		for (int i = 0; i< points.length; i++){
			p0 = points[i];
			Arrays.sort(points, new Comparator<Point>() {
				public int compare(Point p1, Point p2){
					if ((slopeTo(p0, p1) - slopeTo(p0, p2)) > 0.0)
						return 1;
					else if ((slopeTo(p0, p1) - slopeTo(p0, p2)) < 0.0)
						return -1;
					else return 0;
				}
			});
			
			int count = 2;
			double slope = slopeTo(p0, points[1]);
			
			for (int index = 2; index < points.length; index ++) {
				double targetslope = slopeTo(p0, points[index]);
				if (targetslope == Double.NEGATIVE_INFINITY || Double.compare(slope, targetslope) == 0 ) 
					count ++;
				else if (slope == Double.NEGATIVE_INFINITY){
					count ++;
					slope = targetslope;
				}
				else {
					slope = targetslope;
					count = 2;
				}
				if (count > maxpoints)
					maxpoints = count;
			}
		}
		return maxpoints;
    }
	
	public double slopeTo(Point origin, Point that) {
        // degenerate line segment (between a point and itself)
        if (origin.x == that.x && origin.y == that.y) 
            return Double.NEGATIVE_INFINITY;
        else if (origin.y == that.y) // horizontal line
            return +0.0;
        else if (origin.x == that.x) // vertical line
            return Double.POSITIVE_INFINITY;
        
        // only the normal cases here
        return (double) (that.y - origin.y) / (that.x - origin.x);

    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		maxPoints mp = new maxPoints();
		int N = 4;
		Point[] points = new Point[N];
		Random rm = new Random();
		points[0] = mp.new Point(1,1);
		points[1] = mp.new Point(1,1);
		points[2] = mp.new Point(2,2);
		points[3] = mp.new Point(2,2);
		System.out.println(mp.maxPoints(points));

	}

}
