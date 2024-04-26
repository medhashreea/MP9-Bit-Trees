import java.io.PrintWriter;

/**
 * Main class
 * 
 * @author Medhashree Adhikari
 */

public class BrailleASCII {
  public static void main(String[] args) throws Exception {
    PrintWriter pen = new PrintWriter(System.out, true);
    String translateTo = args[0];
    String input = args[1];

    // there has to be 2 arguments
    // 1. target char set, 2. source char
    if (args.length != 2) {
      throw new Exception("Invalid! Number of arguments has to be two!");
    } // args len check
    else if (translateTo.equals("braille")) {
      pen.println(toBraille(input));
    } // braille check
    else if (translateTo.equals("ascii")) {
      // grab each value
      for (int i = 0; i < input.length(); i += 6) {
        pen.println((BrailleASCIITables.toASCII(input.substring(i, i + 6))).toLowerCase() + "");
      }
    } // ascii check
    else if (translateTo.equals("unicode")) {
      String braille = toBraille(input);

      for (int i = 0; i < braille.length(); i += 6) {
        String unicodeStr = "";
        unicodeStr += (BrailleASCIITables.toUnicode(braille.substring(i, i + 6)));
        int j = Integer.decode("0x" + unicodeStr);
        pen.print(Character.toChars(j));
      }
      pen.println("");
    } // unicode check
  } // main

  /**
   * converts input to braille char
   * 
   * @param input
   * @return
   * @throws Exception
   */
  public static String toBraille(String input) throws Exception {
    String brailleStr = "";

    // grab each value
    for (int i = 0; i < input.length(); i++) {
      brailleStr += BrailleASCIITables.toBraille(input.charAt(i));
    }

    return brailleStr;
  } // toBraille(String)
} // class BrailleASCII