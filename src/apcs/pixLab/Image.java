package apcs.pixLab;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Image {
    /*
     * Instance variables: image - a 2D Array of Colors
     */
    private Color[][] image;

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
            for (int c = 0; c < image[r].length; c++) {
                image[r][c] = image[image.length - r][c];
            }
        }
        return this;
    }

    public Image blur() {
        Image copy = new Image(new Color[image.length + 2][image[0].length + 2]);

        for (int r = 0; r < copy.image.length; r++) {
            for (int c = 0; c < copy.image[r].length; c++) {
                copy.image[r][c] = new Color(0, 0, 0);
            }
        }

        for (int r = 1; r < image.length - 1; r++) {
            System.out.print(r + ", ");
            for (int c = 1; c < image[r].length - 1; c++) {
                System.out.println(c);

                Color[] filter = {
                        image[r - 1][c -1], image[r - 1][c], image[r - 1][c + 1],
                        image[r][c - 1],image[r][c],image[r][c + 1],
                        image[r + 1][c - 1],image[r + 1][c],image[r + 1][c + 1]
                };

                int redSum = 0;
                int greenSum = 0;
                int blueSum = 0;

                for (Color pixel : filter) {
                    redSum += pixel.getRed();
                    greenSum += pixel.getGreen();
                    blueSum += pixel.getGreen();
                }

                System.out.println(Arrays.toString(filter));
                copy.image[r][c] = new Color(redSum / 9, greenSum / 9, blueSum / 9);
            }
        }

        for (int r = 0; r < image.length; r++) {
            for (int c = 0; c < image[r].length; c++) {
                image[r][c] = copy.image[r + 1][c + 1];
            }
        }

        return this;
    }
}

