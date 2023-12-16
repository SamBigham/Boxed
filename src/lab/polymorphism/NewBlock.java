package lab.polymorphism;

/**
 * @author Sam Bigham
 *         my own new textblock
 */
public class NewBlock implements TextBlock {

    int n;

    TextBlock txt;

    // pre: textblock
    // pre: n, where n is an integer greater than or equal to 0
    // post: a new textblock with the edges cut off n times. Similar to truncate but
    // on both sides and starts doing its job when n is greater than 0
    public NewBlock(TextBlock txt, int n) {
        this.txt = txt;
        if (n < 0) {
            this.n = 0;
        } else {
            this.n = n;
        }
    }

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
            result = this.txt.row(i).substring(n, this.txt.width() - n);
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
        return this.txt.width() - (2 * n);
    } // width()

    public String textline() {
        return this.txt.textline();
    }

    public String type() {
        return "NewBlock";
    }
}
