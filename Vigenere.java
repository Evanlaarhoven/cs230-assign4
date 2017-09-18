/*
 * Vigenere.java
 * Written by: Emily Van Laarhoven
 * CS 230 Assignment 4
 * Due: Tuesday Oct 4, 2016 @11:59pm
 */



import javax.swing.JOptionPane;

/**
 * Vigenere allows user to encrypt and decrypt messages using a password to vary the shift of each letter
 * 
 * @author Emily Van Laarhove
 */
public class Vigenere implements Encryptable {
  
  //instance vars
  private char[] message;
  private String pw;
  
  //constructor
  public Vigenere(String input, String password) {
    /*Constructor creates Vigenere object and stores the input message in an array of characters
     * 
     * @param input the message entered by the user
     * @param password the password to be used for encryption and decryption
     */
    pw = password.toUpperCase();
    String input_noSpaces = input.replaceAll(" ","");
    message = new char[input_noSpaces.length()];
    for (int i=0; i<input_noSpaces.length(); i++) {
      message[i] = input_noSpaces.toUpperCase().charAt(i); 
    }
  } 
  
  public String toString() {
    /*toString returns the message array as a string - will either be encrypted or decrypted
     */
    String s="";
    for (int i=0; i<message.length; i++) {
      s+=message[i];
    }
    return s;
  }
  
  //because Vigenere implements Encryptable, must define emcrypt() and decrypt() methods
  public void encrypt(){
    /**
     * Encrypt shifts all of the characters in the message array based on the character values of the password
     * Iterates through password as many times as needed to shift the whole length of the message
     */
    for (int i=0; i<pw.length(); i++) {
      for (int j=i%pw.length(); j<message.length; j=j+pw.length()) {
        int shift = (message[j]+pw.charAt(i)-65);
        if (shift<91){
          message[j]=(char)shift;
        } else {
          message[j]=(char)(shift-26);
        }
      }
    }
  }
  
  public String decrypt(){
    /**
     * Decrypt undoes encrypt and returns a string with the decrypted message
     */
    for (int i=0; i<pw.length(); i++) {
      for (int j=i%pw.length(); j<message.length; j=j+pw.length()) {
        int shiftBack = (message[j]-pw.charAt(i)+65);
        if (shiftBack<65){
          message[j]=(char)(shiftBack+26);
        }else{
          message[j]=(char)shiftBack;
        }
      }
    }
    String s="";
    for (int k=0; k<message.length; k++) {
      s+=message[k];
    }
    return s;
  }
  
  //main method - test encryption and decryption and implement dialogue boxes
  public static void main (String [] args) {
    String input = JOptionPane.showInputDialog("What is the message? ");
    String pw = JOptionPane.showInputDialog("What is the password? ");
    Vigenere secret = new Vigenere(input,pw);
    secret.encrypt();
    JOptionPane.showMessageDialog(null,secret.toString());
    int reply =JOptionPane.showConfirmDialog(null,"Would you like it decrypted?");
    if (reply==JOptionPane.YES_OPTION) {
      JOptionPane.showMessageDialog(null,secret.decrypt());
    }    
  }
  
}