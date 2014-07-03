
public class GasStation {
	//O(N) solution
	//Here is the reason: Now we know A + B + C < 0, A+B > 0, and A > 0 And we want to know if B+C < 0? Since A > 0 and A+B+C <0, we can know B+C<-A, so B+C < 0
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        for (int i=0; i<len;i++)
        {
            int car = 0;
            boolean finishloop = true;
            
            int j=i;
            do{
                car+=gas[j];
                if (car >= cost[j])
                    car -= cost[j];
                else
                {
                    finishloop = false;
                    break;
                }
                j=(j+1)%len;
            }while (j!= i);
            
            if (finishloop)
                return i;
                
            //if j is already < i, there's no solution for this sequence. otherwise, make i<-j, skip starting points between i and j
            if (j<i)
                return -1;
            else
                i = j;
            
        }
        return -1;
    }
    // the brute force solution. will get time limit exceed error in OJ
    public int canCompleteCircuitBruteForce(int[] gas, int[] cost) {
        int len = gas.length;
        for (int i=0; i<len;i++)
        {
            int car = 0;
            boolean finishloop = true;
            int loopend = ((i==0)?len-1:i-1);
            for (int j=i; j!=loopend; j=(j+1)%len )
            {
                car += gas[j];
                if (car >= cost[j])
                    car -= cost[j];
                else
                {
                    finishloop = false;
                    break;
                }
                
            }
            if (finishloop)
                return i;
            
        }
        return -1;
    }
}
