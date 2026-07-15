import java.util.Scanner;

public class TextAnalyzer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String text = readValidInput(sc);
        
        // 顯示原始與有效字元數
        System.out.println("原始字元數（含空白）：" + text.length());
        
        String trimmedText = text.trim();
        System.out.println("有效字元數（去前後空白）：" + trimmedText.length());
        
        // 使用 \\s+ 來處理連續空白
        String[] words = trimmedText.split("\\s+");
        System.out.println("單字數量：" + words.length);
        
        int vowelCount = countVowels(trimmedText);
        System.out.println("母音 (a,e,i,o,u) 總數：" + vowelCount);
        
        String longestWord = findLongestWord(words);
        System.out.println("最長單字：" + longestWord);

        System.out.print("\n請輸入要搜尋的關鍵字：");
        String keyword = sc.nextLine().trim();
        int keywordCount = countKeyword(trimmedText, keyword);
        System.out.println("關鍵字「" + keyword + "」出現次數 (忽略大小寫)：" + keywordCount);
        
        sc.close();
    }

    // 避免空字串或全空白
    public static String readValidInput(Scanner sc) {
        String input = "";
        while (input.trim().isEmpty()) {
            System.out.print("請輸入一行非空白文字：");
            input = sc.nextLine();
            if (input.trim().isEmpty()) {
                System.out.println("錯誤：輸入不能為空或全空白！");
            }
        }
        return input;
    }

    public static int countVowels(String text) {
        int count = 0;
        String lowerText = text.toLowerCase();
        for (int i = 0; i < lowerText.length(); i++) {
            char c = lowerText.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                count++;
            }
        }
        return count;
    }

    public static String findLongestWord(String[] words) {
        String longest = words[0];
        for (int i = 1; i < words.length; i++) {
            if (words[i].length() > longest.length()) {
                longest = words[i];
            }
        }
        return longest;
    }

    // 計算關鍵字出現次數 (忽略大小寫)
    public static int countKeyword(String text, String keyword) {
        if (keyword.isEmpty()) return 0;
        
        String lowerText = text.toLowerCase();
        String lowerKeyword = keyword.toLowerCase();
        int count = 0;
        int index = 0;
        
        // indexOf 會回傳找到的索引位置，如果找不到會回傳 -1
        while ((index = lowerText.indexOf(lowerKeyword, index)) != -1) {
            count++;
            index += lowerKeyword.length(); // 往下一個位置繼續找
        }
        return count;
    }
}