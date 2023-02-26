package apcs.pixLab;

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
    /**
     * Creates a new Image based on an existing 2D array of colors
     * @param image the array of Colors
     */
    public Image (Color[][] image) {
        this.image = image;
    }
    /**
     * Creates a new Image from an image stored in a file
     * @param file the name of the file to create the Image from
     */
    public Image (String file) {
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
     * @param title The title to be displayed in the window's title bar
     */
    public void display (String title) {
        new ImageGUI (image, title);
    }

    /**
     * copy - creates and returns a duplicate copy of an image
     * precondition: the image has at least one row and at least one column
     *
     * @return a copy of the image
     */
    public Image copy () {
        Color[][] theCopy = new Color[image.length][image[0].length];
        for (int r=0; r<image.length; r++) {
            for (int c=0; c<image[0].length; c++) {
                theCopy[r][c] = new Color (image[r][c].getRGB ());
            }
        }
        return new Image (theCopy);
    }

    /**
     * removeBlue - modifies an image by removing the blue component form all pixels
     * Postcondition: the image itself is modified
     */
    public void removeBlue() {
        for (int r = 0; r < image.length; r++) {
            for (int c = 0; c < image[r].length; c++) {
                image[r][c] = new Color(image[r][c].getRed(), image[r][c].getGreen(), 0);
            }
        }
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
        for (int r =  image.length / 2; r < image.length; r++) {
            for (int c = 0; c < image[r].length; c++) {
                image[r][c] = image[ image.length - r][c];
            }
        }
        return this;
    }
}

