package lab.polymorphism;

import static org.junit.Assert.assertEquals;

import java.io.PrintWriter;

import org.junit.Test;

public class TextBlockTests {

    @Test
    public void test1() {
        TextBlock block = new TextLine("test");
        TBUtils.print(pen, block);
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
        NewBlock mult = new NewBlock(block, 4);
        assertEquals("Multiblock", mult.width(), 12);
    }
            @Test
        public void test6() {
        TextBlock block = new TextLine("test");
        NewBlock mult = new NewBlock(block, 4);
        assertEquals("centered", mult.width(), 12);
    }

            @Test
        public void test7() {
        TextBlock tb = new TextLine("test");
        HorizontallyFlipped horfli = new HorizontallyFlipped(tb);
        assertEquals("Horizontal flip", horfli.width(), 6);
    }
            @Test
        public void test8() {
        TextBlock block = new TextLine("test");
        VerticallyFlipped vertflip = new VerticallyFlipped(block);
        assertEquals("Vertical Flip", vertflip.width(), 6);
    }
             @Test
        public void test9(){
        TextBlock block1 = new TextLine("test");
        TextBlock block2 = new TextLine("test");
        assertEquals("equal", true, TBUtils.equal(block1, block2));
    }
}
