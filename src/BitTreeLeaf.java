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

  // the parent node
  private BitTreeInnerNode parent;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  public BitTreeLeaf(BitTreeInnerNode parent) {
    this.parent = parent;
  }

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
   * grabs left node
   * 
   * @return left node
   */
  public BitTreeNode getLeft() {
    return null;
  } // getLeft()

  /**
   * grabs rigth node
   * 
   * @return rigth node
   */
  public BitTreeNode getRight() {
    return null;
  } // getRight()

  /**
   * gets the path of the value
   * 
   * @return bit string
   */
  public String getPath() {
    // base case:
    // if the parent is null, then nothing to check
    if (this.parent == null) {
      return "";
    } else if (this.parent.getLeft() == this) {
      // else, check if left
      return parent.getPath() + "0";
    } else {
      // else, it has to be right
      return parent.getPath() + "1";
    }
  } // getPath()

  /**
   * grabs the parent node
   * 
   * @return the parent node of a leaf or node
   */
  public BitTreeInnerNode getParent() {
    return this.parent;
  } // getParent()

  // /**
  // * prints out the value
  // *
  // * @param pen
  // */
  // public void dump(PrintWriter pen) {
  // pen.println(value);
  // } // dump(PrintWriter)

} // class BitTreeLeaf