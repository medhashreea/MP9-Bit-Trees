import java.io.InputStream;
import java.io.PrintWriter;

/**
 * Interface for the nodes
 * 
 * @author Medhashree Adhikari
 */

public interface BitTreeNode {
  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+
  /**
   * adds or replaces the value at the end with value
   * 
   * @param bits
   * @param value
   * @return void
   */
  public void set(String bits, String value); // set(String, String)

  /**
   * returns the value at the end
   * 
   * @param bits
   * @return String
   */
  public String get(String bits); // get(String)

  /**
   * prints out the contents of the tree in CSV format
   * 
   * @param pen
   */
  public void dump(PrintWriter pen); // dump(PrintWriter)

  /**
   * reads a series of lines of the form bits,value and stores them in the tree.
   * 
   * @param source
   */
  public void load(InputStream source);

} // interface BitTreeNode