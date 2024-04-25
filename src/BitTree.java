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
    this.root = new BitTreeInnerNode(null);
  }

  // +---------+-----------------------------------------------------------
  // | Methods |
  // +---------+

  /**
   * throw an exception if bits is the inappropriate length or contains values
   * other than 0 or 1
   * 
   * @param bits
   * @param value
   */
  public void illArgCheck(String bits) {
    if (bits.length() != this.n) {
      throw new IllegalArgumentException("Invalid bits length: " + bits.length() + "!");
    } // if exception

    if (!(bits.contains("0")) && !(bits.contains("1"))) {
      throw new IllegalArgumentException("Bits can only contain 0 and 1.");
    }
    // for (char c : bits.toCharArray()) {
    //   if ((c != '0') || (c != '1')) {
    //     throw new IllegalArgumentException("Bits can only contain 0 and 1. " + c + " is not valid" + "!");
    //   }
    // } // if exception
  } // illArgCheck(String, String)

  /**
   * adds or replaces the value at the end with value
   * 
   * @param bits
   * @param value
   * @return
   */
  public void set(String bits, String value) {
    // calls exception check method
    illArgCheck(bits);

    // recursively call set on bit and value
    root.set(bits, value);
  } // set(String, String)

  /**
   * returns the value at the end
   * 
   * @param bits
   * @return
   */
  public String get(String bits) {
    // calls exception check method
    illArgCheck(bits);

    return root.get(bits);
  } // get(String)

  /**
   * prints out the contents of the tree in CSV format
   * 
   * @param pen
   */
  public void dumpHelper(PrintWriter pen, String bits, BitTreeNode node) {
    if ((node.getRight() == null) && (node.getLeft() == null)) {
      pen.println(node.getPath() + "," + node.get(bits));
    } else if (node.getLeft() != null) {
      pen.println(node.getPath() + "," + node.get(bits));
      dumpHelper(pen, node.getLeft().getPath(), node.getLeft());
    } else if (node.getRight() != null) {
      pen.println(node.getPath() + "," + node.get(bits));
      dumpHelper(pen, node.getRight().getPath(), node.getRight());
    }
  } // dumpHelper(PrintWriter)

  /**
   * prints out the contents of the tree in CSV format
   * 
   * @param pen
   */
  public void dump(PrintWriter pen) {
    // traverse,
    // if not leaf = empty leaf -> recursive call
    // if leaf pen.printand return
    dumpHelper(pen, root.getPath(), root);
    // if (root.getLeft() != null) {
    //   pen.println(pen + "," + root.getPath());
    // } else {
    //   pen.println(pen + "," + root.getPath());
    // }

    // root.dump(pen);
  } // dump(PrintWriter)

  // /**
  // * prints out the contents of the tree in CSV format
  // *
  // * @param pen
  // */
  // public void dump(PrintWriter pen) {
  // // traverse,
  // // if not leaf = empty leaf -> recursive call
  // // if leaf pen.print and return

  // // if 0, then left
  // // if (branch.equals('0')) {
  // // if (left == null) { // if left is null
  // // return null;
  // // } // if not null
  // // left.get(bits.substring(1)); // recursive get
  // // } // else check if 1
  // // else if (branch.equals('1')) {
  // // if (right == null) { // if left is null
  // // return null;
  // // } // if not null
  // // right.get(bits.substring(1)); // recursive get
  // // }
  // } // dump(PrintWriter)
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

} // class BitTree

// /**
// * prints out the contents of the tree in CSV format
// *
// * @param pen
// */
// public void dump(PrintWriter pen) {
// // traverse,
// // if not leaf = empty leaf -> recursive call
// // if leaf pen.print and return

// // if 0, then left
// // if (branch.equals('0')) {
// // if (left == null) { // if left is null
// // return null;
// // } // if not null
// // left.get(bits.substring(1)); // recursive get
// // } // else check if 1
// // else if (branch.equals('1')) {
// // if (right == null) { // if left is null
// // return null;
// // } // if not null
// // right.get(bits.substring(1)); // recursive get
// // }
// } // dump(PrintWriter)