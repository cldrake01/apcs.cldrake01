package pixLabKotlin

fun main() {
    Image("/Users/collindrake/IdeaProjects/apcs-cldrake01/src/apcs/pixLab/p2p.jpg").removeRed().display("removeRed()")
    Image("/Users/collindrake/IdeaProjects/apcs-cldrake01/src/apcs/pixLab/p2p.jpg").blackWhite().display("blackWhite()")
    Image("/Users/collindrake/IdeaProjects/apcs-cldrake01/src/apcs/pixLab/p2p.jpg").invert().display("invert()")
    Image("/Users/collindrake/IdeaProjects/apcs-cldrake01/src/apcs/pixLab/p2p.jpg").verticalMirror().display("verticalMirror()")
    Image("/Users/collindrake/IdeaProjects/apcs-cldrake01/src/apcs/pixLab/p2p.jpg").horizontalMirror().display("horizontalMirror()")
    Image("/Users/collindrake/IdeaProjects/apcs-cldrake01/src/apcs/pixLab/p2p.jpg").blur().display("blur()")
    Image("/Users/collindrake/IdeaProjects/apcs-cldrake01/src/apcs/pixLab/p2p.jpg").sharpen().display("sharpen()")
    Image("/Users/collindrake/IdeaProjects/apcs-cldrake01/src/apcs/pixLab/p2p.jpg").blend("/Users/collindrake/Downloads/desmos-graph.png").display("blend()")
    Image("/Users/collindrake/IdeaProjects/apcs-cldrake01/src/apcs/pixLab/p2p.jpg").blend("/Users/collindrake/IdeaProjects/apcs-cldrake01/src/apcs/pixLab/repository-open-graph-template.png", "/Users/collindrake/IdeaProjects/apcs-cldrake01/src/apcs/pixLab/benson.jpg").display("blend(), with several images")
    Image("/Users/collindrake/IdeaProjects/apcs-cldrake01/src/apcs/pixLab/p2p.jpg").contrast(2.0).display("Increase Contrast")
    Image("/Users/collindrake/IdeaProjects/apcs-cldrake01/src/apcs/pixLab/p2p.jpg").contrast(0.5).display("Reduce Contrast")
    Image("/Users/collindrake/IdeaProjects/apcs-cldrake01/src/apcs/pixLab/p2p.jpg").gradientBlend("/Users/collindrake/Downloads/desmos-graph.png").display("gradientBlend()")
    Image("/Users/collindrake/IdeaProjects/apcs-cldrake01/src/apcs/pixLab/p2p.jpg").display("Reference Image")
}