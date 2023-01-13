package apcs.playList;

public class PlayListTester {
    public static void main(String[] args) {
        PlayList playList = new PlayList();
        playList.add(new Song("Metadata"), new Song("AES", 800), new Song("The Orwellian Oracle"));
        System.out.println(playList);
        playList.play("AES");
        playList.moveTo("Oracle", 0);
        System.out.println(playList);
    }
}
