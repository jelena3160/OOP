import java.util.List;

public class Bingo extends Listic{
    private int[][] bingoListic = new int[3][5];
    public static List<Integer> izvuceniBrojevi;

    public Bingo(int premija,int[][] bingoListic) {
        super(premija);
        this.bingoListic = bingoListic;
    }

    public int[][] getBingoListic() {
        return bingoListic;
    }

    public void setBingoListic(int[][] bingoListic) {
        this.bingoListic = bingoListic;
    }

    public static List<Integer> getIzvuceniBrojevi() {
        return izvuceniBrojevi;
    }

    @Override
    public int odrediDobitak() {
        return 0;
    }

    @Override
    public String proveriDobitak() {
        return null;
    }
}
