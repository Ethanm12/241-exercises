

public class LinkList<T>{
  
  private NextNode firstNode;
  private NextNode lastNode;
  private int count; 
  
  public LinkList(T value){
    firstNode = lastNode;
    count = 0;
  }
  
  public boolean isEmpty(){
    return firstNode == null;
  }
  
  public void add(T node){
    NextNode newNode = new NextNode(node);
    
    if(isEmpty()){
      firstNode = newNode;
      lastNode = newNode;
    }else{
      NextNode tail = lastNode;
      tail.next = newNode;
      newNode.next = firstNode;
      lastNode = newNode;
    }
    
  }
}
