
import java.util.*;

public class wordBreakII {
	HashSet<String> badsubstrings = new HashSet<String>();
	public List<String> wordBreak(String s, Set<String> dict){
		String cur = "";
		LinkedList<String> result = new LinkedList<String>();
		for (int i= 0; i<s.length(); i++){
			cur += s.charAt(i);
			if (dict.contains(cur)){
				//we find a match for the first word
				String substring = s.substring(i+1);
				if (!substring.isEmpty() && !badsubstrings.contains(substring))
				{
					//we should call the core function to continue the substring search for words
					//the core function wil return a string with valid words has speace seperated
					List<String> validcombos = wordBreak(substring,dict);
					if (validcombos.isEmpty())
					{
						badsubstrings.add(substring);
						continue;
					}
					else
					{
						String oneValidCombo = "";
						while (!validcombos.isEmpty())
						{
							//add cur to the head, and space, the move this combo to result list
							oneValidCombo = validcombos.remove(0);
							oneValidCombo = cur + " " + oneValidCombo;
							result.add(oneValidCombo);
						}
					}					
				}
				else if (substring.isEmpty())
				{
					// cur is the smallest set that has an entry in dict, add it to result list
					result.add(cur);
				}
			}
		}
		return result;
	}
}
