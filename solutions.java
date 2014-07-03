import java.util.*;
import java.io.*;


public class solutions {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//LRUTest();
		//Listreordertest();
		//wordBreak();
		//twosum();
		//wordBreakII();
		//int i = 10;
		//System.out.println((i=i+1)%10);
		//FindAmicableNumber fan = new FindAmicableNumber();
		//fan.PrintAmicableNumber(3000000);
		//Sudoku();
		//isPalindrome();
		//System.out.println(gcd(8, 1234568));
		testPartition("bb");
		
		
	}
	
	public static void testPartition(String s)
	{
		Palindrome p = new Palindrome();
		
		List<List<String>> lls = p.partition(s);
		for (List<String> ls : lls)
		{
			for (String ss : ls)
				System.out.print(ss + ",");
			System.out.println("");
			System.out.println("----------------------------------------");
		}
	}
	
	
	
	public static int gcd(int p, int q)
	{
		System.out.println("p = " + p + ", q = " + q);
		if (q == 0) return p;
		int r = p % q;
		return gcd(q, r);
	}
	public static String exR1(int n)
	{
		if (n <= 0) return "";
		return exR1(n-3) + n + exR1(n-2) + n;
	}
	public static int mystery(int a, int b)
	{
		if (b == 0) return 1;
		if (b % 2 == 0) return mystery(a*a, b/2);
		return mystery(a*a, b/2) + a;
	}
	public static void isPalindrome()
	{
		Palindrome pe = new Palindrome();
		System.out.println(pe.isPalindromeInPlace(1410110141));
		
	}
	
	public static void Sudoku()
	{
		int n= 9;
		int[][] grid = new int[n][n];
		for (int i = 0; i<n; i++ )
		{
			for (int j=0;j<n;j++)
			{
				grid[i][j] = -1;
			}
		}
		
		
		
		Sudoku su = new Sudoku();
		if (su.solveSudoku(grid, n))
		{
			for (int i = 0; i<n; i++)
			{
				for (int j = 0; j<n; j++)
				{
					System.out.print(grid[j][i]+" ");
				}
				System.out.println("");
			}
		}
		else
		{
			System.out.println("false");
		}

	}
	
	public static void wordBreakII()
	{
		//String word = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaa";
		String word = "a";
		wordBreakII words = new wordBreakII();
		//build dict set
		String[] strings = {"a"};
		HashSet<String> dict = new HashSet<String>();
		
		for (int i = 0; i <strings.length; i++)
		{
			dict.add(strings[i]);
		}
		List<String> validcombo = words.wordBreak(word, dict);
		while (!validcombo.isEmpty())
		{
			System.out.println(validcombo.remove(0));
		}
		
		
	}
	
	public static void twosum()
	{
		int[] numbers = {0,2,4,6,8,10,12};
		int target = 16;
		TwoSum ts = new TwoSum();
		int[] results = ts.twoSum(numbers, target);
		for (int i = 0; i<results.length; i++)
		{
			System.out.println(results[i]);
		}
	}
	public static void wordBreak()
	{
		String word = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaa";
		//String word = "aaaaaaaaaaaaaaaaaaaaaaaaab";
		//build dict set
		WordBreak words = new WordBreak();
		String[] strings = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
		HashSet<String> dict = new HashSet<String>();
		for (int i = 0; i <strings.length; i++)
		{
			dict.add(strings[i]);
		}
		System.out.println(words.wordBreak(word, dict));
		
	}
	
	public static void Listreordertest()
	{
		ListReOrder.ListNode head = null;
		ListReOrder.ListNode temp = null;
		ListReOrder.ListNode cur = null;
		int[] ar = {1,2,3, 4,5,6};
		for (int i = 0; i<ar.length; i++)
		{
			temp = new ListReOrder.ListNode(ar[i]);
			if (head == null)
				head = temp;
			else
				cur.next = temp;
			cur = temp;
			
		}
		
		ListReOrder lro = new ListReOrder();
		//lro.reorderList(head);
		lro.reorderList2(head);
		
		while (head!= null)
		{
			System.out.println(head.val);
			head = head.next;
		}
		
		
	}
	
	public static void LRUTest()
	{
		try {
			LRUCache lru = new LRUCache(3);
			File file = new File("F:\\Documents\\Interview\\javasuck\\actions.txt");
			FileReader fileReader;
			fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String line;
			
			while ((line = bufferedReader.readLine()) != null)
			{
				String curAct = line;
				System.out.println(line);
				String verb = curAct.substring(0, 3);
				if (verb.equals("set"))
				{
					curAct = curAct.substring(3);
					int a1= curAct.indexOf("(");
					int a2 = curAct.indexOf(",");
					int a3 = curAct.indexOf(")");
					String skey = curAct.substring(a1+1, a2);
					String sValue = curAct.substring(a2+1, a3 );
					lru.set(Integer.parseInt(skey), Integer.parseInt(sValue));
				}
				else
				{
					curAct = curAct.substring(3);
					String sKey = curAct.substring(1, curAct.length() -1 );
					System.out.println(lru.get(Integer.parseInt(sKey)));
				}
			}
			
		}catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
