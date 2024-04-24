import java.io.InputStream;
import java.io.PrintWriter;

/**
 * Store only the value
 * 
 * @author Medhashree Adhikari
 */

public class BitTreeLeaf implements BitTreeNode {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  // the value of the node
  private String value;

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * adds or replaces the value at the end with value
   * 
   * @param bits
   * @param value
   */
  public void set(String bits, String value) {
    this.value = value;
  } // set(String, String)

  /**
   * returns the value at the end
   * 
   * @param bits
   * @return value
   */
  public String get(String bits) {
    return this.value;
  } // get(String)

  /**
   * prints out the contents of the tree in CSV format
   * 
   * @param pen
   */
  public void dump(PrintWriter pen) {
    pen.println(this.value);
  } // dump(PrintWriter)

  /**
   * reads a series of lines of the form bits,value and stores them in the tree.
   * 
   * @param source
   */
  public void load(InputStream source) {
    // STUB
  } // load(InputStream)

} // class BitTreeLeaf