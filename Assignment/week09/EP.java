package week09;

import java.util.*;
import java.io.*;

public class EP implements ExamPile{
  
  private LinkedList<Integer> exams;
  //private currentNode;
  private Integer head;
  private Integer tail;
  private int counter;
  private int depth = 1;
  
  public void setDepth(int depth){
    this.depth = depth;
  }
  
  public void load(List<Integer> items){
    exams = new LinkedList<Integer>();
    exams.addAll(items);
  }
  
  public int size() throws EmptyPileException{
    if(exams.isEmpty()){
      throw new EmptyPileException("The exam pile is empty");
      //throw new EmptyPileException("There are no exams in the pile.");
    }
    return exams.size();
  }
  
  
  public int peek(){
    try{
      if(exams.isEmpty()){
        throw new EmptyPileException("The exam pile is empty");
      }
    }catch(EmptyPileException e){
    throw new EmptyPileException("The exam pile is empty.");
  }return exams.getFirst();
  }
  
  
  public int mark(int depth, int value){
 
    for(int index = 1; index<=depth; index++){
      int currentNode = exams.get(index-1);
      if(currentNode == value){
        exams.remove(index-1);
        return 1;
      }
      else if(index == depth){
        delay(depth);
      }
    }
    return -1;
  }
  
  public String sortingSteps() throws EmptyPileException{
    StringBuilder marks = new StringBuilder();
    if(exams.isEmpty()){
      throw new EmptyPileException("The exam pile is empty");
    }
    while(!exams.isEmpty()){
      if(mark(depth,counter)==1){
        marks.append("M");
        counter++;
      }else{
        marks.append("D");
      }
    }
    System.out.println(marks.toString());
    return marks.toString();
  }
  public void delay(int count){
     try{
      if(exams.isEmpty()){
        throw new EmptyPileException("The exam pile is empty");
      }
    }catch(EmptyPileException e){}
    
    int i=1;
    while(i<=count){
      int temp = exams.getFirst();
      exams.add(temp);
      exams.remove(exams.getFirst());
      i++;
    }
  }
  
  private class EmptyPileException extends NoSuchElementException {
    public EmptyPileException(String message){
      super(message);
    }
  }
}//end class