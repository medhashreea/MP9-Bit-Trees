import java.io.InputStream;
import java.io.PrintWriter;

/**
 * Store links to the subtrees below them
 * 
 * @author Medhashree Adhikari
 */

public class BitTreeInnerNode implements BitTreeNode {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  // the link to the left node
  private BitTreeNode left;

  // the link to the right
  private BitTreeNode right;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  public BitTreeInnerNode() {
    this.left = null;
    this.right = null;
  } // BitTreeInnerNode()

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
  public void set(String bits, String value) {
    // branch is either 0 (left) or 1 (right)
    char branch = bits.charAt(0);

    // if 0, then left
    if (branch == '0') {
      if (left == null) { // if left is null
        left = new BitTreeInnerNode(); // make a new BitTreeInnerNode & init to left
        left.set(bits.substring(1), value); // recursive set
      } // if not null
      this.left = new BitTreeInnerNode(); // make a new BitTreeInnerNode & init to left
    } // else check if 1
    else if (branch == '1') {
      if (right == null) {
        right = new BitTreeInnerNode(); // make a new BitTreeInnerNode & init to right
        right.set(bits.substring(1), value); // recursive set
      } // if not null
      this.right = new BitTreeInnerNode(); // make a new BitTreeInnerNode & init to right
    }
  } // set(String, String)

  /**
   * returns the value at the end
   * 
   * @param bits
   * @return
   */
  public String get(String bits) {
    // branch is either 0 (left) or 1 (right)
    Character branch = bits.charAt(0);

    // if 0, then left
    if (branch.equals('0')) {
      if (left == null) { // if left is null
        return null;
      } // if not null
      left.get(bits.substring(1)); // recursive get
    } // else check if 1
    else if (branch.equals('1')) {
      if (right == null) { // if left is null
        return null;
      } // if not null
      right.get(bits.substring(1)); // recursive get
    }

    return null;
  } // get(String)

  /**
   * prints out the contents of the tree in CSV format
   * 
   * @param pen
   */
  public void dump(PrintWriter pen) {
    // traverse, 
    // if not leaf = empty leaf -> recursive call
    // if leaf pen.print and return

    if(left == null) {
      return null;
    }
    // if 0, then left
    // if (branch.equals('0')) {
    //   if (left == null) { // if left is null
    //     return null;
    //   } // if not null
    //   left.get(bits.substring(1)); // recursive get
    // } // else check if 1
    // else if (branch.equals('1')) {
    //   if (right == null) { // if left is null
    //     return null;
    //   } // if not null
    //   right.get(bits.substring(1)); // recursive get
    // }
  } // dump(PrintWriter)

  /**
   * reads a series of lines of the form bits,value and stores them in the tree.
   * 
   * @param source
   */
  public void load(InputStream source) {
    // STUB

  } // load(InputStream)

}
