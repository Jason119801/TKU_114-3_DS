import java.util.Scanner;
public class ProductIdSearchPractice {
    public static void main(String[] args) {
        int[] ids = {205, 101, 330, 450, 118, 500, 210, 80};
        Scanner sc = new Scanner(System.in);
        System.out.print("輸入商品編號: ");
        int target = sc.nextInt();
        int checks = 0;
        int foundIndex = -1;
        for (int i = 0; i < ids.length; i++) {
            checks++;
            if (ids[i] == target) {
                foundIndex = i;
                break;
            }
        }
        if (foundIndex != -1) System.out.println("索引: " + foundIndex);
        else System.out.println("找不到");
        System.out.println("比較次數: " + checks);
    }
}