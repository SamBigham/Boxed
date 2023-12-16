package lab.polymorphism;

import java.io.PrintWriter;

/**
 * A series of experiments with the text block layout classes.
 * 
 * @author Samuel A. Rebelsky
 * @author Sam Bigham
 * @version 1.3 of September 2019
 */
public class TBExpt {
  // +------+--------------------------------------------------------------
  // | Main |
  // +------+

  public static void main(String[] args) throws Exception {
    // Prepare for input and output
    PrintWriter pen = new PrintWriter(System.out, true);

    // Create a block to use
    // TextBlock block = new TextLine("Hello");

    TextBlock block = new TextLine("hello");
    TextBlock truncblock = new TextLine("Goodbye!");
    TextBlock test = new TextLine("test");
    BoxedBlock tes = new BoxedBlock(test);

    BoxedBlock bblock = new BoxedBlock(truncblock);
    BoxedBlock bblock2 = new BoxedBlock(block);
    VComposition vcomp = new VComposition(bblock2, truncblock);

    BoxedBlock b = new BoxedBlock(block);

    Truncated trun = new Truncated(bblock, 8);
    Centered cent = new Centered(bblock, 17);
    RightJustified rj = new RightJustified(bblock, 17);
    HorizontallyFlipped hf = new HorizontallyFlipped(bblock);
    NewBlock nb = new NewBlock(bblock, 1);
    NewBlock nbt = new NewBlock(tes, 2);

    VerticallyFlipped vf = new VerticallyFlipped(vcomp);

    HorizontallyFlipped horflip = new HorizontallyFlipped(block);

    TBUtils.print(pen, trun);
    TBUtils.print(pen, cent);
    TBUtils.print(pen, rj);
    TBUtils.print(pen, hf);
    TBUtils.print(pen, vcomp);
    TBUtils.print(pen, vf);
    TBUtils.print(pen, nb);
    TBUtils.print(pen, nbt);
    TBUtils.print(pen, horflip);

    System.out.println("nb width is : " + nb.width());
    System.out.println("nbt width is : " + nbt.width());
    System.out.println("VF width is :" + vf.width());
    System.out.println("hf width is : " + hf.width());
    System.out.println("horflip width is : " + horflip.width());

    // Clean up after ourselves.
    pen.close();
  } // main(String[])

} // class TBExpt
