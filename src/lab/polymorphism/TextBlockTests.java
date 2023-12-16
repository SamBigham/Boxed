package lab.polymorphism;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import java.io.PrintWriter;

/**
 * @author Sam Bigham
 *         tests for textblocks
 */
public class TextBlockTests {

    @Test
    public void fakeTest() {
        assertTrue(true);
    } // fakeTest()

    @Test
    public void test1() {
        TextBlock block = new TextLine("test");
        assertEquals("test1", block.width(), 4);
    }

    @Test
    public void test2() {
        TextBlock truncblock = new TextLine("We're truncating");
        Truncated trun = new Truncated(truncblock, 3);
        assertEquals("truncated", trun.width(), 3);
    }

    @Test
    public void test3() {
        TextBlock rightblock = new TextLine("Right");
        RightJustified rjust = new RightJustified(rightblock, 40);
        assertEquals("right justified", rjust.width(), 40);
    }

    @Test
    public void test4() {
        TextBlock block = new TextLine("test");
        Centered cent = new Centered(block, 10);
        assertEquals("centered", cent.width(), 10);
    }

    @Test
    public void test5() {
        TextBlock block = new TextLine("test");
        BoxedBlock bblock = new BoxedBlock(block);
        NewBlock mult = new NewBlock(bblock, 2);
        assertEquals("NewBlock", mult.width(), 2);
    }

    @Test
    public void test6() {
        TextBlock block = new TextLine("test");
        NewBlock mult = new NewBlock(block, 1);
        assertEquals("NewBlocktests", mult.width(), 2);
    }

    @Test
    public void test7() {
        TextBlock tb = new TextLine("test");
        BoxedBlock bblock = new BoxedBlock(tb);
        HorizontallyFlipped horfli = new HorizontallyFlipped(bblock);
        assertEquals("Horizontal flip", horfli.width(), 6);
    }

    @Test
    public void test8() {
        TextBlock block = new TextLine("test");
        BoxedBlock bblock = new BoxedBlock(block);
        VerticallyFlipped vertflip = new VerticallyFlipped(bblock);
        assertEquals("Vertical Flip", vertflip.width(), 6);
    }

    @Test
    public void test9() {
        TextBlock block1 = new TextLine("test");
        TextBlock block2 = new TextLine("test");
        assertEquals("equal", true, TBUtils.equal(block1, block2));
    }
}
