package apcs.pixLab;

public class PixRunner {
    public static void main(String[] args) {
        new Image("/Users/collindrake/IdeaProjects/apcs-cldrake01/src/apcs/pixLab/p2p.jpg").removeRed().display("removeRed()");
        new Image("/Users/collindrake/IdeaProjects/apcs-cldrake01/src/apcs/pixLab/p2p.jpg").blackWhite().display("blackWhite()");
        new Image("/Users/collindrake/IdeaProjects/apcs-cldrake01/src/apcs/pixLab/p2p.jpg").invert().display("invert()");
        new Image("/Users/collindrake/IdeaProjects/apcs-cldrake01/src/apcs/pixLab/p2p.jpg").verticalMirror().display("verticalMirror()");
        new Image("/Users/collindrake/IdeaProjects/apcs-cldrake01/src/apcs/pixLab/p2p.jpg").horizontalMirror().display("horizontalMirror()");
        new Image("/Users/collindrake/IdeaProjects/apcs-cldrake01/src/apcs/pixLab/p2p.jpg").blur().display("blur()");
        new Image("/Users/collindrake/IdeaProjects/apcs-cldrake01/src/apcs/pixLab/p2p.jpg").sharpen().display("sharpen()");
        new Image("/Users/collindrake/IdeaProjects/apcs-cldrake01/src/apcs/pixLab/p2p.jpg").blend("/Users/collindrake/Downloads/desmos-graph.png").display("blend()");
        new Image("/Users/collindrake/IdeaProjects/apcs-cldrake01/src/apcs/pixLab/p2p.jpg").blend("/Users/collindrake/IdeaProjects/apcs-cldrake01/src/apcs/pixLab/repository-open-graph-template.png", "/Users/collindrake/IdeaProjects/apcs-cldrake01/src/apcs/pixLab/benson.jpg").display("blend(), with several images");
        new Image("/Users/collindrake/IdeaProjects/apcs-cldrake01/src/apcs/pixLab/p2p.jpg").contrast(2).display("Increase Contrast");
        new Image("/Users/collindrake/IdeaProjects/apcs-cldrake01/src/apcs/pixLab/p2p.jpg").contrast(0.5).display("Reduce Contrast");
        new Image("/Users/collindrake/IdeaProjects/apcs-cldrake01/src/apcs/pixLab/p2p.jpg").gradientBlend("/Users/collindrake/Downloads/desmos-graph.png").display("gradientBlend()");
        new Image("/Users/collindrake/IdeaProjects/apcs-cldrake01/src/apcs/pixLab/p2p.jpg").display("Reference Image");
    }
}

