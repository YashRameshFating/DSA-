class DoublyLinkedList{

 static class Node{
    
    int data;
    Node previous;
    Node next;

    Node(int data){
      this.data=data;
      this.previous=previous;
      this.next=next;
    }

 }

   private Node head;
   private Node tail;
   private int size;

   DoublyLinkedList(){
    this.head=null;
    this.tail=null;
    this.size=0;
   }
   
   //insert at head
   public void insertAtHead(int data){
      Node newNode=new Node(data);
      if(head==null && tail==null){
         head=newNode;
         tail=newNode;
      }else{
         newNode.next=head;
         head.previous=newNode;
         head=newNode;
      }
      size++;
   }
   //insert at tail
   public void inserAtTail(int data){
       Node newNode=new Node(data);
       if(head==null && tail==null){
        head=newNode;
        tail=newNode;
      }else{
        tail.next=newNode;
        newNode.previous=tail;
        tail=newNode;
      }
      size++;
   }

   public void insertionAtPosition(int position,int data){

        if(position<1 || position>size+1){
           System.out.println("cant able to insert the node at given position");
           return;
        }
         
        if(position==1){
          insertAtHead(data);
          return;
        }

        if(position==size+1){
          inserAtTail(data);
          return;
        }
        
        Node newNode=new Node(data);
        Node temp=head;
        Node curr=head.next;
        for(int i=1;i<=position-2;i++){
          temp=temp.next;
          curr=curr.next;
        }
        temp.next=newNode;
        newNode.previous=temp;
        newNode.next=curr;
        curr.previous=newNode;
        size++;
   }

   public void printLL(){
     Node temp=head;
     while(temp!=null){
      System.out.print(temp.data + " -> ");
       temp=temp.next;
     }
     System.out.println();
   }

   public void printLLBackward(){
    Node temp=tail;
    while(temp!=null){
        System.out.print(" <- "+temp.data);
        temp=temp.previous;
    }
       System.out.println();
   }

   public boolean searchTarget(int target){

     if(head.data==target){
        return true;
     }

     if(tail.data==target){
      return true;
     }

     //normal check for the target
     Node temp=head;
     while(temp!=null){
      if(temp.data==target){
        return true;
      }
      temp=temp.next;
     }

     return false;

   }

   public boolean updateValue(int oldValue,int newValue){
      
    Node temp=head;
    while(temp!=null){
        if(temp.data==oldValue){
          temp.data=newValue;
          return true;
        }
        else{
          temp=temp.next;
        }
    }
   return false;

  }
  public void deleteAtHead(){
    if(head==null){
      System.out.println("no head is available");
      return;
    }
    //single node
    if(head==tail){
      head=null;
      tail=null;
      size=0;
      return;
    }
    head=head.next;
    head.previous=null;
    size--;

  }

  public void deleteAtTail(){
     if(head==null){
      System.out.println("no head is available");
      return;
    }
    //single node
    if(head==tail){
      head=null;
      tail=null;
      size=0;
      return;
    }
    Node currNode=tail;
    Node prevNode=tail.previous;
    
    //discards the links to remove it from the chain of ll
    prevNode.next=null;
    currNode.previous=null;
    tail=prevNode;
    size--;
  }
 public void deleteAtPosition(int position){
        if(position<1 || position>size+1){
           System.out.println("cant able to insert the node at given position");
           return;
        }
         if(head==null){
          System.out.println("cant able to delte ll is empty");
          return;
         }
        if(position==1){
          deleteAtHead();
          return;
        }

        if(position==size){
          deleteAtTail();
          return;
        }

        Node prevNode=head;
        for(int i=1;i<=position-2;i++){
          prevNode=prevNode.next;
        }
        Node currNode=prevNode.next;
        Node nextNode=currNode.next;

        prevNode.next=nextNode;
        nextNode.previous=prevNode;
        currNode.previous=null;
        currNode.next=null;
        size--;
 }
   public static void main(String[] args){
      DoublyLinkedList myList=new DoublyLinkedList();
      myList.insertAtHead(10);
      myList.printLL();
      myList.inserAtTail(20);
      myList.printLL();
      myList.insertionAtPosition(2,15);
      myList.printLL();
      // myList.printLLBackward();
      // System.out.println(myList.searchTarget(15));
      myList.insertionAtPosition(2,12);
      myList.printLL();
      myList.insertionAtPosition(3,13);
      myList.printLL();

      System.out.println("updated true/false : "+myList.updateValue(13,14));
       myList.printLL();
      //  myList.deleteAtHead();
      //  myList.printLL();
      //  myList.deleteAtTail();
      //     myList.printLL();
      // myList.deleteAtTail();
      //     myList.printLL();
         myList.deleteAtPosition(3);
         myList.printLL();
           myList.deleteAtPosition(2);
         myList.printLL();
   }
}