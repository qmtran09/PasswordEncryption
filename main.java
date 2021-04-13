import java.security.*;
import java.util.Base64;
import java.util.Scanner;
public class main{
  public static void main(String[] args){
    String d1 = null;
    Scanner scan = new Scanner(System.in);
    do{
    System.out.println("Do you want to generate key? (y/n)");
    d1 = scan.nextLine();
    }while(!d1.equals("y")||!d1.equals("n"));

    if(d1.equals("y")){
    createKeys genKeys = new createKeys();
    //return keys in base64 so its readable
    System.out.println(Base64.getEncoder().encodeToString(genKeys.getPublicKey().getEncoded()));
    System.out.println(Base64.getEncoder().encodeToString(genKeys.getPrivateKey().getEncoded()));
    }

  }
}