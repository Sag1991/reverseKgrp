class Main{

    Node head;

    public static void main(String[] args){

        Main m=new Main();
        m.push(5);
        m.push(4);
        m.push(3);
        m.push(2);
        m.push(1);
        m.push(8);
        m.push(9);
        m.push(10);

        System.out.println("Given Linked List:");
        m.printList();

        m.head=m.reverseKGrp(m.head,3);

        System.out.println("Reverse list");

        m.printList();


    }

    class Node{
        int data;
        Node next;

        Node(int d){
            this.data=d;
            next=null;
        }
    }

    public void push(int data){
        Node note=new Node(data);
        if(head==null){
            head=note;
            return;
        }
        note.next=head;
        head=note;
    }

    public void printList(){
        if(head==null){
            System.out.println("List is Empty!");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }

    public Node reverseKGrp(Node head,int k){
      int count=0;
      Node dummy=new Node(-1);
      dummy.next=head;
      Node temp=dummy;

      while(temp.next!=null){
          temp=temp.next;
          count++;
      }
      temp=dummy;

      while(temp.next!=null){
          if(count<k)
              break;
          int nodes=k-1;

          Node tempnext=temp.next;
          Node first=temp.next;
          Node second=first.next;


          while(nodes>0){
              Node next=second.next;
              second.next=first;
              first=second;
              second=next;
              nodes--;
          }

          temp.next=first;
          tempnext.next=second;
          temp=tempnext;
          count-=k;
      }
      return dummy.next;

    }
}

