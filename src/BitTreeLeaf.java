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
  String value;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  public BitTreeLeaf(String val) {
    this.value = val;
  } // BitTreeLeaf(String)

} // class BitTreeLeaf