package lab.polymorphism;

/**
 * @author Sam Bigham
 *         truncates TextBlocks
 */
public class Truncated implements TextBlock {

    int width;

    TextBlock txt;

    // pre: Textblock
    // pre: width -> int n, where n is greater than 1
    // post: Textblock truncated by width
    // This program truncates by making the string smaller, or by making the string
    // bigger using
    // spaces if the width is greater than the string
    public Truncated(TextBlock txt, int widt) { // truncates the given textblock
        this.txt = txt;
        if (widt >= this.txt.width()) {
            this.width = txt.width();
        } else {
            this.width = widt;
        }
    }
    // +---------+-----------------------------------------------------------
    // | Methods |
    // +---------+

    /**
     * Get one row from the block.
     * 
     * @pre 0 <= i < this.height()
     * @exception Exception if the precondition is not met
     */
    public String row(int i) throws Exception {
        int lh = this.txt.height();

        // Sanity check
        if ((i < 0) || (i >= lh)) {
            throw new Exception("Invalid row " + i);
        } // if the row is invalid

        String result;
        if (i < lh) {
            result = this.txt.row(i).substring(0, width);
        } else {
            result = TBUtils.spaces(this.txt.width());
        }

        return result;
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
        return (width);
    } // width()

    public String textline() {
        return this.txt.textline();
    }

    public String type() {
        return "Truncate";
    }

}
