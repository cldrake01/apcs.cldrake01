package apcs.pixLab;

import java.awt.Color;

public class PixRunner {
    public static int rand() {
        return (int) Math.round(Math.random() * 255);
    }

    public static void main(String[] args) {
        Color[][] img = new Color[256][256];
        for (int r=0; r<img.length; r++) {
            for (int c=0; c<img[r].length; c++) {
                img[r][c] = new Color (rand(), rand(), rand());
            }
        }
        new Image("/Users/collindrake/IdeaProjects/apcs-cldrake01/src/apcs/pixLab/p2p.jpg").blackWhite().display("blackWhite()");
        new Image("/Users/collindrake/IdeaProjects/apcs-cldrake01/src/apcs/pixLab/p2p.jpg").invert().display("invert()");
        new Image("/Users/collindrake/IdeaProjects/apcs-cldrake01/src/apcs/pixLab/p2p.jpg").verticalMirror().display("verticalMirror()");
        new Image("/Users/collindrake/IdeaProjects/apcs-cldrake01/src/apcs/pixLab/p2p.jpg").horizontalMirror().display("horizontalMirror()");
    }
}

