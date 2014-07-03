
public class ReverseWordsinaString {
	public String reverseWords(String s) {
        String [] words = s.split(" ");
        String temp = "";
        
        for (int i = words.length - 1;i >=0; i--){
            
            if (!words[i].isEmpty()) {
                temp = temp + words[i].trim() + " ";
            }
        }
        return temp.trim();
    }
}
