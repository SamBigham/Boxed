package lab.polymorphism;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.lang.Math;

/**
 * @author Sam Bigham
 *         RightJustifies textblocks
 */
public class RightJustified implements TextBlock {

    int width;

    TextBlock txt;

    // pre: textblock
    // pre: width, where width is bigger than or equal to the string inside plus 2
    // post: textblock, where textblock has a string in the middle
    // this program takes in a textblock and a width, and creates a textblock where
    // the string is in the middle of the textblock
    // and the text block has width equal to the width given
    public RightJustified(TextBlock txt, int widt) {
        this.txt = txt;
        if (widt >= this.txt.width()) {
            this.width = widt;
        } else {
            this.width = this.txt.width();
        }

    }

    public String row(int i) throws Exception {
        // Gather some basic information
        int th = this.txt.height();
        int h = th;

        int k = this.width - this.txt.width();
        if (this.width <= this.txt.width()) {
            k = 0;
        }
        char[] padding = new char[k];
        for (int j = 0; j < k; j++) {
            padding[j] = ' ';
        }

        String padtop = new String(padding);

        if ((i < 0) || (i >= h)) {
            throw new Exception("Invalid row " + i);
        } else if (i < th) {
            return padtop + this.txt.row(i);
        } else {
            return padtop + this.txt.row(i - th);
        } // if the row is in the bottom half
    } // row(int)

    /**
     * Determine how many rows are in the block.
     */
    public int height() {
        // The height is the sum of the heights of the top and bottom
        // blocks.
        return this.txt.height();
    } // height()

    /**
     * Determine how many columns are in the block.
     */
    public int width() {
        // The width is the greater of the widths of the top and bottom
        // blocks.
        return this.width;
    } // width()

    public String textline() {
        return this.txt.textline();
    }

    public String type() {
        return "RightJustified";
    }

}
