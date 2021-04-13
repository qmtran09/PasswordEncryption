import java.io.IOException;
import java.security.*;

public class createKeys(){
  private PrivateKey privatekey;
  private publicKey publickey;
  //constructor
  public createKeys(){
    //using RSA algorithm to generate keys
    KeyPairGenerator key = KeyPairGenerator.getInstance("RSA");
    //using key size pf 2048-bit (recomended in NIST)
    key.initialize(2048);

    KeyPair kPair = key.genKeyPair();
    this.privatekey = kPair.getPrivate();
    this.publicKey = kPair.getPublic();

  }

//get public key
public PrivateKey getPrivateKey() {
  return privateKey;
}
//get private key
public PublicKey getPublicKey() {
  return publicKey;
}


}