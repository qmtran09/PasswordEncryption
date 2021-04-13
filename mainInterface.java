import java.security.*;
import java.util.Base64;
import java.util.Scanner;
public class mainInterface{
  public static void main(String[] args){
    String d1 = null;
    Scanner scan = new Scanner(System.in);
    boolean check1 = true;
    while(check1){
      System.out.println("Do you want to generate key? (y/n)");
      d1 = scan.nextLine();
      if(d1.equals("y") || d1.equals("n")){
        check1 = false;
      }
    }

    if(d1.equals("y")){
    createKeys genKeys = new createKeys();
    //return keys in base64 so its readable
    System.out.println(Base64.getEncoder().encodeToString(genKeys.getPublicKey().getEncoded()));
    System.out.println(Base64.getEncoder().encodeToString(genKeys.getPrivateKey().getEncoded()));
    }
    scan.close();
  }
}