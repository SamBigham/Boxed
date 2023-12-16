package lab.polymorphism;

/**
 * @author Sam Bigham
 *         veritcallyFlips textblocks
 */
public class VerticallyFlipped implements TextBlock {

    TextBlock txt;

    public VerticallyFlipped(TextBlock txt) {
        this.txt = txt;
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
            result = this.txt.row(this.txt.height() - i - 1);
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
        return this.txt.width();
    } // width()

    public String textline() {
        return this.txt.textline();
    }

    public String type() {
        return "VerticallyFlipped";
    }

}
