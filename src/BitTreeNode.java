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
   * grabs left node
   * 
   * @return left node
   */
  public BitTreeNode getLeft();// getLeft()

  /**
   * grabs rigth node
   * 
   * @return rigth node
   */
  public BitTreeNode getRight();// getRight()

  /**
   * gets the path of the value
   * 
   * @return bit string
   */
  public String getPath(); // getPath()

  /**
   * grabs the parent node
   * 
   * @return the parent node of a leaf or node
   */
  public BitTreeInnerNode getParent(); // getParent()

  // /**
  //  * prints out the contents of the tree in CSV format
  //  * 
  //  * @param pen
  //  */
  // public void dump(PrintWriter pen);

} // interface BitTreeNode