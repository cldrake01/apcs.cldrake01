package apcs.pixLab;

public class PixRunner {
    public static void main(String[] args) {
        new Image("src/apcs/pixLab/p2p.jpg").removeRed().display("removeRed()");
        new Image("src/apcs/pixLab/p2p.jpg").blackWhite().display("blackWhite()");
        new Image("src/apcs/pixLab/p2p.jpg").invert().display("invert()");
        new Image("src/apcs/pixLab/p2p.jpg").verticalMirror().display("verticalMirror()");
        new Image("src/apcs/pixLab/p2p.jpg").horizontalMirror().display("horizontalMirror()");
        new Image("src/apcs/pixLab/p2p.jpg").blur().display("blur()");
        new Image("src/apcs/pixLab/p2p.jpg").sharpen().display("sharpen()");
        new Image("src/apcs/pixLab/p2p.jpg").blend("src/apcs/pixLab/benson.jpg").display("blend()");
        //new Image("src/apcs/pixLab/p2p.jpg").blend("", "benson.jpg").display("blend(), with several images");
        new Image("src/apcs/pixLab/p2p.jpg").contrast(2).display("Increase Contrast");
        new Image("src/apcs/pixLab/p2p.jpg").contrast(0.5).display("Reduce Contrast");
        new Image("src/apcs/pixLab/p2p.jpg").gradientBlend("src/apcs/pixLab/benson.jpg").display("gradientBlend()");
        new Image("src/apcs/pixLab/p2p.jpg").display("Reference Image");
    }
}

