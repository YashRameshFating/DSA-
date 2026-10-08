class CircularDoubleLinkedList{

   static class Node {
     int data;
     Node next;
     Node previous;

     Node(int data){
      this.data=data;
      this.next=null;
      this.previous=null;
     }

   }
   
  private Node head;
  private Node tail;
  private int size;

  public CircularDoubleLinkedList(){
    head=null;
    tail=null;
    size=0;
  }

  public void insertAtHead(int data){
     Node newNode=new Node(data);
     if(head==null){
      head=newNode;
      tail=newNode;
      head.previous=tail;
      tail.next=head;
    }else{
      newNode.next=head;
      head.previous=newNode;
      head=newNode;
      head.previous=tail;
      tail.next=head;
    }
    size++;
  }

  public void insertAtTail(int data){
     Node newNode=new Node(data);
     if(head==null){
      head=newNode;
      tail=newNode;
      head.previous=tail;
      tail.next=head;
    }else{
        newNode.previous=tail;
        tail.next=newNode;
        tail=newNode;
        tail.next=head;
        head.previous=tail;
    }
    size++;
  }

  public void insertAtPosition(int position,int data){
    if(position<0 || position>size){
      System.out.println("Position is not suitable to insert the linked list");
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
    Node prevNode=head;
    for(int i=1;i<=position-2;i++){
      prevNode=prevNode.next;
    }
     Node nextNode=prevNode.next;

     prevNode.next=newNode;
     newNode.previous=prevNode;

     newNode.next=nextNode;
     nextNode.previous=newNode;

     size++;

  }

  public void printForward(){
    if(head==null){
        System.out.println("linked list is empty");
        return;
    }
    Node temp=head;
    do{

       System.out.print(temp.data);
       temp=temp.next;
       if(temp!=head){
         System.out.print("<->");
       }

    }while(temp!=head);

     System.out.println("<-> (Back to head)");

  }
  

    public static void main(String [] args){

         CircularDoubleLinkedList myList=new CircularDoubleLinkedList();
         
         myList.insertAtHead(10);
         myList.printForward();
         myList.insertAtHead(20);
         myList.printForward();
         myList.insertAtTail(30);
         myList.printForward();
         myList.insertAtPosition(2,15);
         myList.printForward();

    }
}