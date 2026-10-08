class CircularLinkedList{
   static class Node{
     int data;
     Node next;
     Node(int data){
      this.data=data;
      this.next=null;
     }
   }

  private  Node head;
  private Node tail;
  private int size;
  
  CircularLinkedList(){
    head=null;
    tail=null;
    size=0;
  }
   
  public void insertAtHead(int data){
    Node newNode=new Node(data);
    if(head==null){
      head=newNode;
      tail=newNode;
      tail.next=head;
    }else{
       newNode.next=head;
       head=newNode;
       tail.next=head;
    }
    size++;
  }

  public void insertAtTail(int data){
    Node newNode=new Node(data);
    if(head==null){
      head=newNode;
      tail=newNode;
      tail.next=head;
    }
    else{
      tail.next=newNode;
      tail=newNode;
      tail.next=head;
    }
    size++;
  }
  public void insertionAtPosition(int position,int data){
    if( position<0 || position>size+1 ){
      System.out.println("cant able to connect the newNode to the given position");
      return;
    }
    Node newNode=new Node(data);
    if(position==1){
      insertAtHead(data);
      return;
    }
    if(position==size+1){
      insertAtTail(data);
      return;
    }
      Node temp=head;
      for(int i=1;i<=position-2;i++){
         temp=temp.next;
      }
      Node next=temp.next;
      temp.next=newNode;
      newNode.next=next;
      size++;
  }
  public void printList(){
    if(head==null){
       System.out.println("LL is empty");
      return;
    }
    Node temp=head;
    do{
        System.out.print(temp.data+" -> ");
        temp=temp.next;
    }while(temp!=head);
    System.out.println("Back  to head");
  }
  public boolean search(int target){

    if(head==null){
      return false;
    }

    Node curr=head;

    do{

       if(curr.data==target){

         return true;

       }

        curr=curr.next;

    }while(curr!=head);

    return false;

  }
  public void deleteHead(){

     if(head==null){
      System.out.println("ll is empty");
      return;
     }

     if(head==tail){
      head=null;
      tail=null;
      size=0;
      return;
     }
      Node temp=head;
      head=temp.next;
      temp.next=null;
      tail.next=head;
      size--;
  }
  public void deleteTail(){

     if(head==null){
      System.out.println("ll is empty");
      return;
     }

     if(head==tail){
      head=null;
      tail=null;
      size=0;
      return;
     }
     
     Node prev=head;
     for(int i=1;i<=size-2;i++){
      prev=prev.next;
     }
     prev.next=head;
     tail.next=null;
     tail=prev;
     size--;

  }

  public void deleteAtPosition(int position){
     if(head==null){
      System.out.println("ll is empty");
      return;
     }
     if(position < 1 || position > size){
        System.out.println("Invalid position");
        return;
    }
     if(position==1){
      deleteHead();
      return;
    }
    if(position==size){
      deleteTail();
      return;
    }

    Node prevNode=head;
    for(int i=1;i<=position-2;i++){
      prevNode=prevNode.next;
    }
    
   Node currNode= prevNode.next;
   Node nextNode=currNode.next;
   
   prevNode.next=nextNode;
   currNode.next=null;
   size--;

  }

  public int getSize(){
    return size;
  }
  public boolean isEmpty(){
    return head==null;
  }
  public int getHead(){
    if(head==null){
      throw new IllegalStateException("circular linked list is empty");
    }
    return head.data;
  }
  public int getTail(){
    if(head==null){
      throw new IllegalStateException("circular linked list is empty");
    }
    return tail.data;
  }
  public static void main(String [] args){
      CircularLinkedList myList=new CircularLinkedList();
      myList.insertAtHead(10);
      myList.insertAtTail(20);
      myList.insertAtTail(30);
      myList.printList();

      myList.insertionAtPosition(2,15);
      myList.printList();

      myList.insertionAtPosition(3,16);
      myList.printList();

      // myList.deleteHead();
      // myList.printList();
     
      // myList.deleteTail();
      // myList.printList();
      
      myList.deleteAtPosition(2);
      myList.printList();

      myList.deleteAtPosition(3);
      myList.printList();
       


  }


}