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
    String TestPK = null;
    if(d1.equals("y")){

    createKeys genKeys = new createKeys();
    //return keys in base64 so its readable
    TestPK = Base64.getEncoder().encodeToString(genKeys.getPrivateKey().getEncoded());
    System.out.println("Public Key: "+Base64.getEncoder().encodeToString(genKeys.getPublicKey().getEncoded()));
    System.out.println("Private Key: "+Base64.getEncoder().encodeToString(genKeys.getPrivateKey().getEncoded()));
    }


    System.out.println("Enter Password: ");
    String password = scan.nextLine();
    System.out.println("Enter public key");
    String publicKey = scan.nextLine();

    encryptPassword encryptor =  new encryptPassword();
    decryptPassword decryptor = new decryptPassword();
    String ePass = null;
    try{
    ePass = Base64.getEncoder().encodeToString(encryptor.encrypt(password, publicKey));
    }catch(Exception e){
      e.printStackTrace();
    }
    System.out.println("Encrypted pass: "+ePass);
    // System.out.println("Enter Private Key: ");
    // String privatekey = scan.nextLine();
    String dPass = null;
    try{
      dPass = decryptor.decrypt(ePass, TestPK);
    }catch(Exception e){
      e.printStackTrace();
    }
    System.out.println("Decrypted pass: "+dPass);



    scan.close();
  }

}