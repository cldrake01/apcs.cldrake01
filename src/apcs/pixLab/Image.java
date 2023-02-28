package apcs.pixLab;

import org.jetbrains.annotations.NotNull;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Image {
    /*
     * Instance variables: image - a 2D Array of Colors
     */
    private Color[][] image;

    public Color getPixel(int r, int c) {
        try {
            return this.image[r][c];
        } catch (ArrayIndexOutOfBoundsException AI) {
            return new Color(0, 0, 0);
        }
    }

    /**
     * Creates a new Image based on an existing 2D array of colors
     *
     * @param image the array of Colors
     */
    public Image(Color[][] image) {
        this.image = image;
    }

    /**
     * Creates a new Image from an image stored in a file
     *
     * @param file the name of the file to create the Image from
     */
    public Image(String file) {
        // read image and load into array of Colors
        try {
            BufferedImage img = ImageIO.read(new File(file));
            image = new Color[img.getHeight()][img.getWidth()];
            for (int r = 0; r < image.length; r++) {
                for (int c = 0; c < image[r].length; c++) {
                    image[r][c] = new Color(img.getRGB(c, r));
                }
            }
        } catch (IOException e) {  // couldn't open file
            e.printStackTrace();
            System.exit(-1);
        }
    }

    /**
     * Displays a COPY of the image into a Java GUI Window
     *
     * @param title The title to be displayed in the window's title bar
     */
    public void display(String title) {
        new ImageGUI(image, title);
    }

    /**
     * copy - creates and returns a duplicate copy of an image
     * precondition: the image has at least one row and at least one column
     *
     * @return a copy of the image
     */
    public Image copy() {
        Color[][] theCopy = new Color[image.length][image[0].length];
        for (int r = 0; r < image.length; r++) {
            for (int c = 0; c < image[0].length; c++) {
                theCopy[r][c] = new Color(image[r][c].getRGB());
            }
        }
        return new Image(theCopy);
    }

    /**
     * removeBlue - modifies an image by removing the blue component form all pixels
     * Postcondition: the image itself is modified
     */
    public Image removeRed() {
        for (int r = 0; r < image.length; r++) {
            for (int c = 0; c < image[r].length; c++) {
                image[r][c] = new Color(0, image[r][c].getGreen(), image[r][c].getBlue());
            }
        }
        return this;
    }

    public Image blackWhite() {
        for (int r = 0; r < image.length; r++) {
            for (int c = 0; c < image[r].length; c++) {
                int avg = (image[r][c].getRed() + image[r][c].getGreen() + image[r][c].getBlue()) / 3;
                image[r][c] = new Color(avg, avg, avg);
            }
        }
        return this;
    }

    public Image invert() {
        for (int r = 0; r < image.length; r++) {
            for (int c = 0; c < image[r].length; c++) {
                image[r][c] = new Color(255 - image[r][c].getRed(), 255 - image[r][c].getGreen(), 255 - image[r][c].getBlue());
            }
        }
        return this;
    }

    public Image verticalMirror() {
        for (int r = 0; r < image.length; r++) {
            for (int c = image[r].length / 2; c < image[r].length; c++) {
                image[r][c] = image[r][image[r].length - c];
            }
        }
        return this;
    }

    public Image horizontalMirror() {
        for (int r = image.length / 2; r < image.length; r++) {
            System.arraycopy(image[image.length - r], 0, image[r], 0, image[r].length);
        }
        return this;
    }

    public Image blur() {
        int height = image.length;
        int width = image[0].length;
        Color[][] blurredImage = new Color[height][width];

        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                int redSum = 0;
                int greenSum = 0;
                int blueSum = 0;
                int numNeighbors = 0;

                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        int x = r + i;
                        int y = c + j;

                        if (x >= 0 && x < height && y >= 0 && y < width) {
                            redSum += image[x][y].getRed();
                            greenSum += image[x][y].getGreen();
                            blueSum += image[x][y].getBlue();
                            numNeighbors++;
                        }
                    }
                }

                int avgRed = redSum / numNeighbors;
                int avgGreen = greenSum / numNeighbors;
                int avgBlue = blueSum / numNeighbors;

                // set the pixel color in the blurred image
                blurredImage[r][c] = new Color(avgRed, avgGreen, avgBlue);
            }
        }

        this.image = new Image(blurredImage).image;

        return this;
    }

    public Image blend(String path) {
        Image param = new Image(path);
        int height = Math.max(image.length, param.image.length);
        int width = Math.max(image[0].length, param.image[0].length);
        Image normalized = new Image(new Color[height][width]);

        for (int r = 0; r < height; r++) {
            for (int c = 0; c < width; c++) {
                normalized.image[r][c] = new Color((this.getPixel(r, c).getRed() + param.getPixel(r, c).getRed()) / 2, (this.getPixel(r, c).getGreen() + param.getPixel(r, c).getGreen()) / 2, (this.getPixel(r, c).getBlue() + param.getPixel(r, c).getBlue()) / 2);
            }
        }

        this.image = normalized.image;

        return this;
    }

    public Image blend(String @NotNull ... paths) {
        Image result = new Image(this.image);

        for (String path : paths) {
            result = result.blend(path);
            this.image = result.image;
        }

        return this;
    }

    public Image contrast(double amount) {
        for (int r = 0; r < this.image.length; r++) {
            for (int c = 0; c < this.image[0].length; c++) {
                this.image[r][c] = new Color((int) Math.min(this.image[r][c].getRed() * amount, 255), (int) Math.min(this.image[r][c].getGreen() * amount, 255), (int) Math.min(this.image[r][c].getBlue() * amount, 255));
            }
        }

        return this;
    }
}

