package pixLabKotlin

import javax.swing.*
import java.awt.*
import java.awt.image.BufferedImage

class ImageGUI(imgArr: Array<Array<Color>>, title: String) {
    /*
    * Instance variables: image - a Buffered Image
    */
    private val image: BufferedImage

    init {
        // duplicate pixel data to instance variable
        image = BufferedImage(imgArr[0].size, imgArr.size, BufferedImage.TYPE_INT_RGB)
        for (r in imgArr.indices) {
            for (c in imgArr[r].indices) {
                image.setRGB(c, r, imgArr[r][c].rgb)
            }
        }

        // create a JFrame to display the image in
        val theGUI = JFrame()

        val height = image.height + 47
        val width = image.width + 18

        theGUI.title = title
        theGUI.setSize(width, height)
        theGUI.defaultCloseOperation = WindowConstants.DISPOSE_ON_CLOSE

        // create a custom ColorPanel to insert the image into a single-paned JFrame
        val panel = ColorPanel()
        val pane = theGUI.contentPane
        pane.add(panel)

        // view the JFrame
        theGUI.isVisible = true
    }

    /**
     *
     * This is a custom private class to extend JPanel and display a Buffered Image
     * in the panel - it allows redisplay if the window is moved or obscured
     *
     */
    private inner class ColorPanel : JPanel() {

        override fun paintComponent(g: Graphics) {
            super.paintComponent(g)
            val other = ImageIcon(image)
            other.paintIcon(this, g, 0, 0)
        }
    }
}
