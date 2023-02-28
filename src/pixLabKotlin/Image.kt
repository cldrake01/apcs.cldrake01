package pixLabKotlin

import apcs.pixLab.ImageGUI
import java.awt.Color
import java.awt.color.ColorSpace
import java.io.File
import javax.imageio.ImageIO
import kotlin.system.exitProcess

class Image(private var image: Array<Array<Color>>) {
    fun getPixel(r: Int, c: Int): Color {
        return try {
            image[r][c]
        } catch (ao: ArrayIndexOutOfBoundsException) {
            Color(0, 0, 0)
        }
    }

    constructor(file: String) : this(try {
        val img = ImageIO.read(File(file))
        Array(img.height) { r ->
            Array(img.width) { c ->
                Color(img.getRGB(c, r))
            }
        }
    } catch (e: NoSuchFieldException) {  // couldn't open file
        e.printStackTrace()
        exitProcess(-1)
    })

    fun display(title: String) {
        ImageGUI(image, title)
    }

    fun copy(): Image {
        val theCopy = Array(image.size) { r ->
            Array(image[r].size) { c ->
                Color(image[r][c].rgb)
            }
        }
        return Image(theCopy)
    }

    fun removeRed(): Image {
        for (r in image.indices) {
            for (c in image[r].indices) {
                image[r][c] = Color(0, image[r][c].green, image[r][c].blue)
            }
        }
        return this
    }

    fun blackWhite(): Image {
        for (r in image.indices) {
            for (c in image[r].indices) {
                val avg = (image[r][c].red + image[r][c].green + image[r][c].blue) / 3
                image[r][c] = Color(avg, avg, avg)
            }
        }
        return this
    }

    fun invert(): Image {
        for (r in image.indices) {
            for (c in image[r].indices) {
                image[r][c] = Color(255 - image[r][c].red, 255 - image[r][c].green, 255 - image[r][c].blue)
            }
        }
        return this
    }

    fun verticalMirror(): Image {
        for (r in image.indices) {
            for (c in image[r].size / 2 until image[r].size) {
                image[r][c] = image[r][image[r].size - c - 1]
            }
        }
        return this
    }

    fun horizontalMirror(): Image {
        for (r in image.size / 2 until image.size) {
            image[r].copyInto(image[image.size - r - 1], 0, 0, image[r].size)
        }
        return this
    }

    fun blur(): Image {
        val height: Int = image.size
        val width: Int = image[0].size
        val blurredImage = Array(height) { Array(width) { Color(0, 0, 0) } }

        for (r in 0 until height) {
            for (c in 0 until width) {
                var redSum = 0
                var greenSum = 0
                var blueSum = 0
                var numNeighbors = 0

                for (i in -1..1) {
                    for (j in -1..1) {
                        val x = r + i
                        val y = c + j

                        if (x in 0 until height && y >= 0 && y < width) {
                            redSum += image[x][y].red
                            greenSum += image[x][y].green
                            blueSum += image[x][y].blue
                            numNeighbors++
                        }
                    }
                }

                val avgRed = redSum / numNeighbors
                val avgGreen = greenSum / numNeighbors
                val avgBlue = blueSum / numNeighbors

                blurredImage[r][c] = Color(avgRed, avgGreen, avgBlue)
            }
        }

        this.image = blurredImage

        return this
    }

    fun sharpen(): Image {
        val height: Int = image.size
        val width: Int = image[0].size
        val blurredImage = Array(height) { Array(width) { Color(0, 0, 0) } }

        for (r in 0 until height) {
            for (c in 0 until width) {
                var redSum = 0
                var greenSum = 0
                var blueSum = 0
                var numNeighbors = 0

                for (i in -1..1) {
                    for (j in -1..1) {
                        val x = r + i
                        val y = c + j

                        if (x in 0 until height && y >= 0 && y < width) {
                            redSum += image[x][y].red
                            greenSum += image[x][y].green
                            blueSum += image[x][y].blue
                            numNeighbors++
                        }
                    }
                }

                val avgRed = (image[r][c].red * numNeighbors - (redSum - image[r][c].red)).coerceAtMost(255).coerceAtLeast(0)
                val avgGreen = (image[r][c].green * numNeighbors - (greenSum - image[r][c].green)).coerceAtMost(255).coerceAtLeast(0)
                val avgBlue = (image[r][c].blue * numNeighbors - (blueSum - image[r][c].blue)).coerceAtMost(255).coerceAtLeast(0)

                blurredImage[r][c] = Color(avgRed, avgGreen, avgBlue)
            }
        }

        this.image = blurredImage

        return this
    }

    fun blend(path: String): Image {
        val param = Image(path)
        val height = maxOf(image.size, param.image.size)
        val width = maxOf(image[0].size, param.image[0].size)
        val normalized = Image(Array(height) { Array(width) { Color(0, 0, 0) } })

        for (r in 0 until height) {
            for (c in 0 until width) {
                val red = (getPixel(r, c).red + param.getPixel(r, c).red) / 2
                val green = (getPixel(r, c).green + param.getPixel(r, c).green) / 2
                val blue = (getPixel(r, c).blue + param.getPixel(r, c).blue) / 2
                normalized.image[r][c] = Color(red, green, blue)
            }
        }

        image = normalized.image

        return this
    }

    fun blend(vararg paths: String): Image {
        var result = Image(this.image)

        for (path: String in paths) {
            result = result.blend(path)
            this.image = result.image
        }

        return this
    }

    fun contrast(amount: Double): Image {
        for (r: Int in this.image.indices) {
            for (c: Int in this.image[0].indices) {
                this.image[r][c] = Color(Math.min((this.image[r][c].red * amount).toInt(), 255), Math.min((this.image[r][c].green * amount).toInt(), 255), Math.min((this.image[r][c].blue * amount).toInt(), 255))
            }
        }

        return this
    }

    fun gradientBlend(path: String): Image {
        val param = Image(path)
        val height = maxOf(this.image.size, param.image.size)
        val width = maxOf(this.image[0].size, param.image[0].size)
        val normalized = Image(Array(height) { Array(width) { Color(0) } })
        var decC: Int

        for (r: Int in 0 until height) {
            decC = width
            for (c: Int in 0 until width) {
                normalized.image[r][c] = Color(((getPixel(r, c).red.toDouble() * (decC.toDouble() / width.toDouble()) + param.getPixel(r, c).red.toDouble() * (c.toDouble() / width.toDouble())) / 2).toInt(), ((getPixel(r, c).green.toDouble() * (decC.toDouble() / width.toDouble()) + param.getPixel(r, c).green.toDouble() * (c.toDouble() / width.toDouble())) / 2).toInt(), ((getPixel(r, c).blue.toDouble() * (decC.toDouble() / width.toDouble()) + param.getPixel(r, c).blue.toDouble() * (c.toDouble() / width.toDouble())) / 2).toInt())
                decC--
            }
        }

        this.image = normalized.image

        return this
    }

    fun gradientBlend(vararg paths: String): Image {
        var result = Image(this.image)

        for (path: String in paths) {
            result = result.gradientBlend(path)
            this.image = result.image
        }

        return this
    }
}