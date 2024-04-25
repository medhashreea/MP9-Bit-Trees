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

  // the link to the parent node
  private BitTreeInnerNode parent;

  // the link to the left node
  private BitTreeNode left;

  // the link to the right
  private BitTreeNode right;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  public BitTreeInnerNode(BitTreeInnerNode parent) {
    this.left = null;
    this.right = null;
    this.parent = parent;
  } // BitTreeInnerNode()

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * grabs left node
   * 
   * @return left node
   */
  public BitTreeNode getLeft() {
    return this.left;
  } // getLeft()

  /**
   * grabs rigth node
   * 
   * @return rigth node
   */
  public BitTreeNode getRight() {
    return this.right;
  } // getRight()

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
    BitTreeNode node;

    // set node to be either left or right
    if (branch == '0') {
      node = left;
    } else {
      node = right;
    }

    // base case, if we are one before the leaf
    if (bits.length() == 1) {
      node = new BitTreeLeaf(this); // make a new BitTreeInnerNode & init to left or right
      node.set(bits, value); // value set
    } else if (node == null) { // if node is null
      node = new BitTreeInnerNode(this); // make a new BitTreeInnerNode & init to node
      node.set(bits.substring(1), value); // recursive set
    } else {
      // if not null
      node.set(bits.substring(1), value); // reset 0 to 0, or 1 to 1 (avoids recreating path)
    }

    // // if 0, then left
    // if (branch == '0') {
    // if (bits.length() == 1) { // base case
    // left = new BitTreeLeaf(); // make a new BitTreeInnerNode & init to left
    // left.set(bits, value); // value set
    // } else if (left == null) { // if left is null
    // left = new BitTreeInnerNode(); // make a new BitTreeInnerNode & init to left
    // left.set(bits.substring(1), value); // recursive set
    // } // if not null
    // else {
    // left.set(bits.substring(1), value); // reset 0 to 0, or 1 to 1 (avoids
    // recreating path)
    // }
    // } // else check if 1
    // else if (branch == '1') {
    // if (bits.length() == 1) { // base case
    // right = new BitTreeLeaf(); // make a new BitTreeInnerNode & init to right
    // right.set(bits, value); // value set
    // } else if (right == null) {
    // right = new BitTreeInnerNode(); // make a new BitTreeInnerNode & init to
    // right
    // right.set(bits.substring(1), value); // recursive set
    // } // if not null
    // else {
    // right.set(bits.substring(1), value); // reset 0 to 0, or 1 to 1 (avoids
    // recreating path)
    // }
    // }
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
    BitTreeNode node = parent;

    // leaf case
    if ((node.getRight() == null) && (node.getLeft() == null)) {
      node = (BitTreeLeaf) node;
      return node.get(bits);
    } else {
      if (branch == '0') {
        node = left;
      } else {
        node = right;
      } // set node to be either left or right

      if (node != null) {
        return node.get(bits.substring(1)); // recursive get
      }

      return "";
    }
  } // get(String)

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
  // * prints out the contents of the tree in CSV format
  // *
  // * @param pen
  // */
  // public void dump(PrintWriter pen) {

  // } // dump(PrintWriter)

  // /**
  // * prints out the contents of the tree in CSV format
  // *
  // * @param pen
  // */
  // public void dumpHelper(PrintWriter pen) {
  // if (left != null) {

  // }
  // } // dumpHelper(PrintWriter)

} // class BitTreeInnerNode