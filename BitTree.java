import java.io.InputStream;
import java.io.PrintWriter;

/**
 * Store mappings from bits to values
 * 
 * @author Medhashree Adhikari
 */

public class BitTree {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  public BitTree(int n) {
    // STUB
  }

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * adds or replaces the value at the end with value
   * 
   * @param bits
   * @param value
   * @return
   */
  public void set(String bits, String value) {
    // STUB
    // throw an exception if bits is the inappropriate length or contains values
    // other than 0 or 1
  } // set(String, String)

  /**
   * returns the value at the end
   * 
   * @param bits
   * @return
   */
  public String get(String bits) {
    // STUB
    // If there is no such path, or if bits is the incorrect length, get should
    // throw an exception.
    return null;
  } // get(String)

  /**
   * prints out the contents of the tree in CSV format
   * 
   * @param pen
   */
  public void dump(PrintWriter pen) {
    // STUB
  } // dump(PrintWriter)

  /**
   * reads a series of lines of the form bits,value and stores them in the tree.
   * 
   * @param source
   */
  public void load(InputStream source) {
    // STUB
  }

} // class BitTree