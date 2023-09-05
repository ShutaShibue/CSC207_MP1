import java.io.PrintWriter;

public class CaeserCipher {
  public static void main (String[] args) throws Exception {
    java.io.PrintWriter pen;
    pen = new java.io.PrintWriter(System.out, true);

    //Checking argument number
    if(args.length != 2)
    {
      System.err.println("Incorrect number of parameters");
      System.exit(2);
    }

    //Checking if given string is consisted by lowercase only
    if(!args[1].equals(args[1].toLowerCase()))
    {
      System.err.println("Message should only contain lowercase letters");
      System.exit(1);
    }
    
    //Checking command
    if(args[0].equals("encode")) encode(args[1], pen);
    else if(args[0].equals("decode")) decode(args[1], pen);
    else
    {
      System.err.println("Valid options are \"encode\" or \"decode\"");
      System.exit(1);
    }
  } // main(String[])

  public static void encode(String message, PrintWriter pen)
  {
    for (int i = 0; i < 26; i++) {
      pen.println("n = " + i + ": " + shiftString(message, i));
    }
  }

  public static void decode(String message, PrintWriter pen)
  {
    for (int i = 0; i < 26; i++) {
      pen.println("n = " + i + ": " + shiftString(message, -i));
    }
  }

  public static String shiftString(String message, int key)
  {
    char[] msg = message.toCharArray();
    for(int i = 0; i < message.length(); i++)
    {
      msg[i] -= 97; //base
      msg[i] = (char)(Math.floorMod(msg[i] + key, 26));
      msg[i] += 97; //base
    }
    return new String(msg);
  }
} //class