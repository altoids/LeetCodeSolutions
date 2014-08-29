
public class Sqrt {
	
	public int sqrt(int x) {
	        long result = 0;
	        long target = x;
	        while (result * result < target)
	            result++;
	        if (result * result > target)
	            result--;
	        return (int)result;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sqrt s = new Sqrt();
		//System.out.println(s.sqrt(2147483641));
		System.out.println(s.sqrt(2147483647));

	}

}
