/**
 * Main class
 * 
 * @author Medhashree Adhikari
 */

public class BrailleASCII {
  public static void main(String[] args) throws Exception {
    // there has to be 2 arguments
    // 1. target char set, 2. source char
    if (args.length != 2) {
      throw new Exception("Invalid! Number of arguments has to be two!");
    } // args len check

    // call BrailleASCIITable.toBraille
    // call BrailleASCIITable.toASCII
    // call BrailleASCIITable.toUnicode

  } // main
} // class BrailleASCII