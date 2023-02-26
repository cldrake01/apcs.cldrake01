package apcs.pixLab;

public class PixRunner {
    public static void main(String[] args) {
        new Image("/Users/collindrake/IdeaProjects/apcs-cldrake01/src/apcs/pixLab/p2p.jpg").removeRed().display("removeRed()");
        new Image("/Users/collindrake/IdeaProjects/apcs-cldrake01/src/apcs/pixLab/p2p.jpg").blackWhite().display("blackWhite()");
        new Image("/Users/collindrake/IdeaProjects/apcs-cldrake01/src/apcs/pixLab/p2p.jpg").invert().display("invert()");
        new Image("/Users/collindrake/IdeaProjects/apcs-cldrake01/src/apcs/pixLab/p2p.jpg").verticalMirror().display("verticalMirror()");
        new Image("/Users/collindrake/IdeaProjects/apcs-cldrake01/src/apcs/pixLab/p2p.jpg").horizontalMirror().display("horizontalMirror()");
        new Image("/Users/collindrake/IdeaProjects/apcs-cldrake01/src/apcs/pixLab/p2p.jpg").blur().display("blur()");
    }
}

