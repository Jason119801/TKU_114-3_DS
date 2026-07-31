public class RecursiveNameSearchPractice {
    public static void main(String[] args) {
        String[] names = {"Amy", "Ben", "Cara"};
        System.out.println(search(names, "Ben", 0));
    }
    public static int search(String[] names, String target, int index) {
        if (index >= names.length) return -1;
        if (names[index].equals(target) && target != null) return index;
        return search(names, target, index + 1);
    }
}