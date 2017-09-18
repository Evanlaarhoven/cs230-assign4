/**
 * Webpage.java
 * Written by: Emily Van Laarhoven
 * CS 230 Assignment 4
 * Due: Tuesday Oct 4, 2016 @11:59pm
 */




public class Webpage implements Comparable<Webpage> {
  
  //instance vars
  private String urlName;
  private int lineCounter;
  private String pageContent; 
  
  //constructor
  public Webpage(String urlName, int lineCounter, String pageContent) { 
    this.urlName=urlName;
    this.lineCounter=lineCounter;
    this.pageContent=pageContent;
  }
  
  //Getters
  public String getURLName() {
    return urlName;
  }
  
  public int getLineCounter() {
    return lineCounter;
  }
  
  public String getPageContent() {
    return pageContent;
  }
  
  //Setters
  public void setURLName(String name) {
    urlName=name;
  }
  
  public void setLineCounter(int value) {
    lineCounter = value;
  }
  
  public void setPageContent(String content) {
    pageContent = content;
  }
 
  //CompareTo
  public int compareTo(Webpage p){
    if (lineCounter > p.getLineCounter()) {
      return 1;
    }else if (lineCounter < p.getLineCounter()) {
      return -1;
    } else {
      return 0;
    }
  }
  
  //toString
  public String toString() {
    String s = this.urlName+" : "+this.lineCounter+" : "+this.pageContent.substring(0,20);
    return s;
  }
  
  //main
  public static void main (String[] args) {
    Webpage google = new Webpage("http://www.google.com",10,"This is the google website so fancy!");
    System.out.println(google);
    google.setLineCounter(100);
    google.setPageContent("Goooooooooooooooooooogle");
    System.out.println(google);
    Webpage wellesley = new Webpage("http://wellesley.edu",50,"what a swell college");
    System.out.println(wellesley.compareTo(google));
    System.out.println(google.compareTo(wellesley));
    wellesley.setLineCounter(100);
    System.out.println(wellesley.compareTo(google));
  }
  
}