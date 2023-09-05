import java.io.PrintWriter;

public class VigenereCipher {
  public static void main (String[] args) throws Exception {
    java.io.PrintWriter pen;
    pen = new java.io.PrintWriter(System.out, true);

    //Checking argument number
    if(args.length != 3)
    {
      System.err.println("Incorrect number of parameters");
      System.exit(2);
    }

    //Checking if given message is consisted by lowercase only
    if(!args[1].equals(args[1].toLowerCase()))
    {
      System.err.println("Message should only contain lowercase letters");
      System.exit(1);
    }
    
    //Checking if given keyword is consisted by lowercase only
    if(!args[2].equals(args[2].toLowerCase()))
    {
      System.err.println("Keyword should only contain lowercase letters");
      System.exit(1);
    }

    //Checking command
    if(args[0].equals("encode")) encode(args[1], args[2], pen);
    else if(args[0].equals("decode")) decode(args[1], args[2], pen);
    else
    {
      System.err.println("Valid options are \"encode\" or \"decode\"");
      System.exit(1);
    }
  } // main(String[])

  public static void encode(String message, String keyword, PrintWriter pen)
  {
    pen.println(shiftString(message, keyword, true));
  }

  public static void decode(String message,String keyword, PrintWriter pen)
  {
    pen.println(shiftString(message, keyword, false));
  }

  //Message to process, keyword, encryption or decription
  public static String shiftString(String m, String k, boolean encrypt)
  {
    char[] msg = m.toCharArray();
    char[] keyword = k.toCharArray();

    for(int i = 0; i < msg.length; i++)
    {
      int key = 0;
      if(keyword.length > 0) key = keyword[i % keyword.length] - 97; //considering the case of keyword being ""
      if(!encrypt) key = -key; //subtruction when decrypt
      msg[i] -= 97; //base
      msg[i] = (char)(Math.floorMod(msg[i] + key, 26));
      msg[i] += 97; //base
    }
    return new String(msg);
  }
} //class