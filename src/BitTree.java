import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Store mappings from bits to values
 * 
 * @author Medhashree Adhikari
 */

public class BitTree {
  // +--------+------------------------------------------------------------
  // | Fields |
  // +--------+

  // number of bits
  private int n;

  // the root of the tree
  private BitTreeInnerNode root;

  // +--------------+------------------------------------------------------
  // | Constructors |
  // +--------------+

  public BitTree(int n) {
    this.n = n;
    this.root = new BitTreeInnerNode();
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
    // calls exception check method
    illArgCheck(bits);

    setHelp(root, bits, value);
  } // set(String, String)

  /**
   * returns the value at the end
   * 
   * @param bits
   * @return
   * @throws Exception
   */
  public String get(String bits) throws Exception {
    // calls exception check method
    illArgCheck(bits);

    return getHelp(root, bits);
  } // get(String)

  /**
   * prints out the contents of the tree in CSV format
   * 
   * @param pen
   */
  public void dump(PrintWriter pen) {
    pen.println(dumpHelper(root, ""));
  } // dump(PrintWriter)

  /**
   * reads a series of lines of the form bits,value and stores them in the tree.
   * 
   * @param source
   */
  public void load(InputStream source) {
    try (Scanner input = new Scanner(source)) {
      // read each line one at a time
      while (input.hasNextLine()) {
        String _line = input.nextLine();

        // split at comma
        // ex: 100000,A --> [100000] [A]
        String[] _split = _line.split(",");

        // now there is two parts, confirm 2 parts then
        if (_split.length == 2) {
          String bits = _split[0]; // get bits from index 0
          String value = _split[1]; // get bits from index 1

          // make binary tree for the source
          set(bits, value);
        } else {
          // if not length 2, throw exception
          throw new IllegalArgumentException();
        }
      } // while loop
      input.close();
    } // try
  } // load(InputStream)

  // +---------+-----------------------------------------------------------
  // | Helpers |
  // +---------+

  /**
   * throw an exception if bits is the inappropriate length or contains values
   * other than 0 or 1
   * 
   * @param bits
   */
  public void illArgCheck(String bits) {
    // length check
    if (bits.length() != this.n) {
      throw new IllegalArgumentException("Invalid bits length: " + bits.length() + "!");
    } // if exception

    for (int i = 0; i < bits.length(); i++) {
      if (bits.charAt(i) != '0' && bits.charAt(i) != '1') {
        throw new IllegalArgumentException("Invalid bits!");
      }
    } // bits check

    return;
  } // illArgCheck(String, String)

  /**
   * helps adds or replaces the value at the end with value
   * 
   * @param node
   * @param bits
   * @param value
   */
  public void setHelp(BitTreeNode node, String bits, String value) {
    char branch = bits.charAt(0);

    // base case, if we are one before the leaf, check branch
    if (bits.length() == 1) {
      // set node to be either left or right
      if (branch == '0') {
        ((BitTreeInnerNode) node).left = new BitTreeLeaf(value);
      } else {
        ((BitTreeInnerNode) node).right = new BitTreeLeaf(value);
      }
    } // if not one before leaf, check value
    else if (branch == '0') { // if it is an innernode with a left branch
      if ((node instanceof BitTreeInnerNode) && (((BitTreeInnerNode) node).hasLeft())) {
        setHelp((((BitTreeInnerNode) node).left), bits.substring(1), value); // recursive set
      } else {
        // create and set
        ((BitTreeInnerNode) node).left = new BitTreeInnerNode(); // make a new BitTreeInnerNode & init to node
        setHelp(((BitTreeInnerNode) node).left, bits.substring(1), value); // recursive set
      }
    } // if branch is 1
    else if (branch == '1') {
      if ((node instanceof BitTreeInnerNode) && (((BitTreeInnerNode) node).hasRight())) {
        setHelp((((BitTreeInnerNode) node).right), bits.substring(1), value); // recursive set
      } else {
        // create and set
        ((BitTreeInnerNode) node).right = new BitTreeInnerNode(); // make a new BitTreeInnerNode & init to node
        setHelp(((BitTreeInnerNode) node).right, bits.substring(1), value); // recursive set
      }
    } // cond check
  } // set(String, String)

  /**
   * returns the value at the end
   * 
   * @param bits
   * @return value as string
   * @throws Exception
   */
  public String getHelp(BitTreeNode node, String bits) throws Exception {
    // branch is either 0 (left) or 1 (right)
    Character branch = bits.charAt(0);

    // leaf case
    if (node instanceof BitTreeLeaf) {
      if (bits.length() == 0) {
        return ((BitTreeLeaf) node).value;
      } else {
        throw new Exception("Invalid length!");
      }
    } // if not leaf, inner node
    else {
      if (bits.length() == 0) {
        throw new Exception("Element not found!");
      }

      // if goes left
      if (branch == '0') {
        // recurse on left
        return getHelp(((BitTreeInnerNode) node).left, bits.substring(1));
      } else if (branch == '1') {
        // recurse on right
        return getHelp(((BitTreeInnerNode) node).right, bits.substring(1));
      } else {
        // if neither, then invalid
        throw new Exception("Element not found!");
      } // branch check
    } // leaf/non-leaf check
  } // getHelp(String, BitTreeNode)

  /**
   * prints out the contents of the tree in CSV format
   * 
   * @param pen
   */
  public String dumpHelper(BitTreeNode node, String bits) {
    String bitStr = "";

    // leaf case
    if (node instanceof BitTreeLeaf) {
      return bitStr + bits + "," + ((BitTreeLeaf) node).value + "\n";
    } // innernode case
    else if (node instanceof BitTreeInnerNode) {
      if (((BitTreeInnerNode) node).hasLeft()) {
        bitStr += dumpHelper(((BitTreeInnerNode) node).left, bits + "0");
      } // left check

      if (((BitTreeInnerNode) node).hasRight()) {
        bitStr += dumpHelper(((BitTreeInnerNode) node).right, bits + "1");
      } // right check

      return bitStr;
    }

    return "";
  } // dumpHelper(BitTreeNode, String)

} // class BitTree