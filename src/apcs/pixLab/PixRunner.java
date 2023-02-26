package apcs.pixLab;

import java.awt.Color;

public class PixRunner {

    public static void main(String[] args) {
        Color[][] img = new Color[256][256];
        for (int r=0; r<img.length; r++) {
            for (int c=0; c<img[r].length; c++) {
                img[r][c] = new Color (255, 0, 0);
            }
        }
        Image a = new Image(img);
        a.display("Red Image");
    }
}

