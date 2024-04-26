import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Store the translation information (from ASCII to braille, from braille to
 * ASCII, and from braille to Unicode) as bit trees
 * 
 * @author Medhashree Adhikari
 */

public class BrailleASCIITables {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  // BitTree Unicode to Braille
  static BitTree toBraille;

  // BitTree Braille to ASCII
  static BitTree toASCII;

  // BitTree Braille to Unicode
  static BitTree toUnicode;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  public BrailleASCIITables() throws FileNotFoundException {
    // ASCII to Braille
    toBraille = new BitTree(8);
    toBraille.load(new FileInputStream(new File("../lib/toBraille.txt")));

    // Braille to ASCII
    toASCII = new BitTree(6);
    toASCII.load(new FileInputStream(new File("../lib/toASCII.txt")));

    // Braille to Unicode
    toUnicode = new BitTree(6);
    toUnicode.load(new FileInputStream(new File("../lib/toUnicode.txt")));
  } // BrailleASCIITables()

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * converts an ASCII character to a string of bits representing the
   * corresponding braille character
   * 
   * @param letter
   * @return Braille
   * @throws Exception
   */
  public static String toBraille(char letter) throws Exception {
    BitTree brailleTree = new BitTree(1);

    try {
      InputStream input = new FileInputStream("toBraille.txt");
      brailleTree.load(input);
    } catch (FileNotFoundException e) {
    }

    int asciiLetter = (int) letter;
    StringBuilder binary = new StringBuilder(Integer.toBinaryString(asciiLetter));

    if (binary.length() < 8) {
      for (int i = binary.length(); i < 8; i++) {
        binary.insert(0, "0");
      }
    }

    String bits = binary.toString();

    try {
      return brailleTree.get(bits);
    } catch (Exception e) {
      throw new IllegalArgumentException();
    }
  } // toBraille(char)

  /**
   * converts a string of bits representing a braille character to the
   * corresponding ASCII character
   * 
   * @param bits
   * @return ASCII
   * @throws Exception
   */
  public static String toASCII(String bits) throws Exception {
    BitTree asciiTree = new BitTree(1);

    try {
      InputStream input = new FileInputStream("toASCII.txt");
      asciiTree.load(input);
    } catch (FileNotFoundException e) {
    }

    try {
      return asciiTree.get(bits);
    } catch (Exception e) {
      return ("invalid!");
    }
  } // toASCII(String)

  /**
   * converts a string of bits representing a braille character to the
   * corresponding Unicode braille character for those bits. You need only support
   * six-bit braille characters
   * 
   * @param bits
   * @return Unicode
   * @throws Exception
   */
  public static String toUnicode(String bits) throws Exception {
    BitTree unicodeTree = new BitTree(1);

    try {
      InputStream input = new FileInputStream("toUnicode.txt");
      unicodeTree.load(input);
    } catch (FileNotFoundException e) {
    }

    try {
      return unicodeTree.get(bits);
    } catch (Exception e) {
      return ("invalid!");
    }
  } // toUnicode(String)
} // class BrailleASCIITables