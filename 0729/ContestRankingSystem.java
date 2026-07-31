class Contestant {
    String id, name; int score, time;
    public Contestant(String id, String name, int s, int t) {
        this.id=id; this.name=name; this.score=s; this.time=t;
    }
    public String toString() { return name + " " + score + "分 " + time + "秒"; }
}
public class ContestRankingSystem {
    public static void main(String[] args) {
        Contestant[] c = { new Contestant("1", "A", 90, 100), new Contestant("2", "B", 90, 80) };
        for (int i = 1; i < c.length; i++) {
            Contestant key = c[i];
            int p = i - 1;
            while (p >= 0 && (c[p].score < key.score || (c[p].score == key.score && c[p].time > key.time))) {
                c[p + 1] = c[p];
                p--;
            }
            c[p + 1] = key;
        }
        for (Contestant con : c) System.out.println(con);
    }
}