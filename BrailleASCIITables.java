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

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  public BrailleASCIITables() {
    // STUB
  } // BrailleASCIITables()

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * converts an ASCII character to a string of bits representing the
   * corresponding braille character
   * 
   * @param letter
   * @return
   */
  public String toBraille(char letter) {
    // STUB
    return null;
  } // toBraille(char)

  /**
   * converts a string of bits representing a braille character to the
   * corresponding ASCII character
   * 
   * @param bits
   * @return
   */
  public String toASCII(String bits) {
    // STUB
    return null;
  } // toASCII(String)

  /**
   * converts a string of bits representing a braille character to the
   * corresponding Unicode braille character for those bits. You need only support
   * six-bit braille characters
   * 
   * @param bits
   * @return
   */
  public String toUnicode(String bits) {
    // STUB
    return null;
  } // toUnicode(String)

}
// class BrailleASCIITables