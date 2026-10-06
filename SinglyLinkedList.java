class SinglyLinkedList{

  //make node
  static class Node{
    int data;
    Node next;
    //constructor is used so that u can direclty write Node n=new Node(10);
    //if u dont create the NODE CONSTRUCTOR THEN U HAVE TO first make the obj e.g Node n=new Node();
    //n.data=10;
    //n.next=null;
    Node(int data){
      this.data=data;
      this.next=null;
    }

  }

   private Node head;
   private Node tail;
   private int size;

   SinglyLinkedList(){
      this.head=null;
      this.tail=null;
      this.size=0;
   }


   //------------------------------------
   //insertion
   //------------------------------------


   //insert at beginning 
   public void insertAtHead(int data){
       Node newNode=new Node(data);
       if(head==null && tail==null){
          head=newNode;
          tail=newNode;
       }else{
         newNode.next=head;
         head=newNode;
       }
       //increase the size of the linked list
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
        tail=newNode;
      }
      size++;
   }
  

   //insertion at position
   public void insertionAtPosition(int position,int data){
    if(position<1 || position>size+1){
      System.out.println("Insertion is not possible");
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
    Node prevNode=head;
    for(int i=1;i<=position-2;i++){
      prevNode=prevNode.next;
    }
    Node newNode=new Node(data);
    newNode.next=prevNode.next;
    prevNode.next=newNode;
    size++;
   }


  //print the linked list
   public void printLL(){
    Node temp=head;
    while(temp!=null){
      System.out.print(temp.data + " -> ");
       temp=temp.next;
    }
    System.out.println();
   }

   //Linked List utility functions
   public int getSize(){
    return size;
   }

   public boolean isEmpty(){
    return head==null;
   }

    public int getHead(){
      if(head==null){
        return -1;
      }else{
        return head.data;
      }
   }

   public int getTail(){
        if(tail==null){
        return -1;
      }else{
        return tail.data;
      }
   }
//searching


   public boolean search(int target){
    Node temp=head;
    while(temp!=null){
      if(temp.data==target){
        return true;
      }
      temp=temp.next;
    }
    return false;
   }

   public int findPosition(int target){
    Node temp=head;
    int count=1;
    while(temp!=null){
      if(temp.data==target){
        return count;
      }
      else{
        temp=temp.next;
        count++;
      }
    }
    return -1;
   }

           //updating


   public void updateAtPosition(int position,int data){
      if(position<1 || position>size+1){
         System.out.println("Invalid position to change the data");
         return;
      }
      Node prevNode=head;
      for(int i=1;i<=position-2;i++){
        prevNode=prevNode.next;
      }
      prevNode.next.data=data;
      
   }

   //update the fisrt occurance of the value
   public boolean updateValue(int oldValue,int newValue){
       Node temp=head;
       while(temp!=null){
         if(temp.data==oldValue){
            temp.data=newValue;
            return true;
         }else{
          temp=temp.next;
         }
       }
       
       return false;
   }

   ///deleting 
   
   public void deleteHead(){
    if(head==null){
      System.out.println("ll is empty cannot able to delete anything");
      return;
    }
     head=head.next;
     size--;
     if(head==null){
      tail=null;
     }
   }
   public void deleteTail(){
    if(head==null){
      System.out.println("ll is empty cannot able to delete anything");
      return;
    }
    if(head==tail){
      head=null;
      tail=null;
      size=0;
    }
    //normal way to delte the tail
    Node temp=head;
    for(int i=1;i<=size-2;i++){
      temp=temp.next;
    }
    temp.next=null;
    tail=temp;
    size--;
   }

   public void deleteAtPosition(int position){
       if(position<1 || position>size+1){
         System.out.println("Invalid position to change the data");
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
      Node prev=head;
      for(int i=1;i<=position-2;i++){
        prev=prev.next;
      }
      prev.next=prev.next.next;
      size--;

   }

   public boolean deleteGivenValue(int value){

       if(head.data==value){
          deleteHead();
          return true;
       }

       if(tail.data==value){
        deleteTail();
        return true;
       }

       Node curr=head.next;
       Node prev=head;
       while(curr!=null){
           if(curr.data==value){
               prev.next=curr.next;
               return true;
           }
           else{
             curr=curr.next;
             prev=prev.next;
           }
       }
       return false;
   }

   public static void main(String[] args){
       SinglyLinkedList list =new SinglyLinkedList();
       if(list.isEmpty()){
        System.out.println("List is empty");
       }
        System.out.println("size of list is : "+list.getSize());

        //inserting at head
        list.insertAtHead(10);
        list.printLL();
        list.insertAtHead(20);
        list.printLL();
        list.insertAtHead(30);
        list.printLL();

       //inserting at tail
        list.inserAtTail(40);
        list.printLL();

        //insert at given position
        list.insertionAtPosition(3,10101110);
        list.printLL();
        System.out.println("head of list is : "+list.getHead());
        System.out.println("tail of list is : "+list.getTail());
        boolean ans=list.search(1010110);
        System.out.println(ans);
        int position=list.findPosition(20);
        System.out.println(position);
        list.updateAtPosition(4,50);
        list.printLL();
        System.out.println(list.updateValue(50,101));
         list.printLL();
        //  list.deleteHead();
        //  list.printLL();
        //  list.deleteTail();
        //  list.printLL();
        //  list.deleteAtPosition(2);
        //  list.printLL();
        list.deleteGivenValue(40);
        list.printLL();


   }

}