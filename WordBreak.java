
import java.util.*;

public class WordBreak {
	HashSet<String> badcombo = new HashSet<String>();
    public boolean wordBreak(String s, Set<String> dict) {
        String presubstring = "";
        String postsubstring = "";
        
        
        for (int i = 0; i<s.length(); i++)
        {
            presubstring +=s.charAt(i);
            if(dict.contains(presubstring))
            {
                if (i==s.length()-1)
                    return true;
                else
                {
                    postsubstring = s.substring(i+1);
                    if (!badcombo.contains(postsubstring) && wordBreak(postsubstring, dict))
                        return true;
                    else if (!badcombo.contains(postsubstring))
                    	badcombo.add(postsubstring);
                }
            }
        }
        return false;
    }
}
