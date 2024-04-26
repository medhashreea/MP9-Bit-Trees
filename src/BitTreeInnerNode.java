/**
 * Store links to the subtrees below them
 * 
 * @author Medhashree Adhikari
 */

public class BitTreeInnerNode implements BitTreeNode {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  // // the link to the parent node
  // BitTreeInnerNode parent;

  // the link to the left node
  BitTreeNode left;

  // the link to the right
  BitTreeNode right;

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
   * checks for left node
   * 
   * @return bool
   */
  public boolean hasLeft() {
    return this.left != null;
  } // getLeft()

  /**
   * checks for  right node
   * 
   * @return bool
   */
  public boolean hasRight() {
    return this.right != null;
  } // getRight()

} // class BitTreeInnerNode