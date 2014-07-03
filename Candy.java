
public class Candy {
public int candy(int[] ratings) {
        
        int[] candies = new int[ratings.length];
        int total = 0;
        
        if (ratings.length == 0)
            return 0;
        //initialize first element as 1, assuming that's the base.
        candies[0] = 1;
        for (int i = 1; i<ratings.length; i++)
        {
            if (ratings[i] > ratings[i-1])
            {
                //increase expected candy number
                candies[i] = candies[i-1] +1;
                
            }
            else
                candies[i] = 1;
        }
        
        for (int i= ratings.length-2; i>=0; i--)
        {
            if(ratings[i]>ratings[i+1] && candies[i] <= candies[i+1])
            //increase expected candy on i
            candies[i] = candies[i+1] +1;
            total += candies[i+1];
        }
        
        return total + candies[0];
    
    }
}
