public class PlaylistSystem {
    public static void main(String[] args) {
        PlaylistLinkedList playlist = new PlaylistLinkedList();

        playlist.addLast("S01", "Song A");
        playlist.addLast("S02", "Song B");
        playlist.addLast("S01", "Song C"); // 應失敗，代碼重複
        playlist.addLast("S03", "Song D");

        playlist.printOrder();

        System.out.println("刪除第一首 (S01): " + playlist.remove("S01"));
        System.out.println("刪除最後一首 (S03): " + playlist.remove("S03"));
        System.out.println("刪除不存在 (S99): " + playlist.remove("S99"));
        
        playlist.printOrder();
    }
}