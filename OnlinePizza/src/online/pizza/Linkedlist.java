
package online.pizza;

import javax.swing.JOptionPane;
//O(n)
public class Linkedlist {

//    static void addNode(String name, int phone, double totalcost) {
//        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
//    }
Node node = new Node();
    static Node head;

    public Linkedlist ()
    {
        head=null;
    }
    //O(1)
public Node delete(int k)
{
    Node current=head;
    Node previous=head;
    while(current.phone!=k)
    {
        if(current.next==null)
            return null;
        previous=current;
        current=current.next;
    }
    if(current==head)
        head=head.next;
    else
        previous.next=current.next;
    return current;
}
//    void search(int key)
//    {
//        Node current=head;
//        while(current !=null)
//        {
//            
//            if(current.phone==key){
//                
//            }
//            current=current.next;
//        }
//    }
//O(1)
    public Node getHead()
    {
        return head;
    }

    public static void addNode(String name,  int phone,double totalprice,int Distance)
    {
       Node newNode = new Node(name, phone,totalprice,Distance);
        if (head == null)
       {
            head = newNode;
            JOptionPane.showMessageDialog(null,"data is inserted");
            return;
       }

            newNode.next = head;
            head = newNode;
            JOptionPane.showMessageDialog(null,"data is inserted");
            return;
    }
//O(1)
    public Node deleteNode()
    {
         if(head==null){
         JOptionPane.showMessageDialog(null,"The list was empty.");
    }
    else{
        head=head.getNext();
        JOptionPane.showMessageDialog(null,"The data has been deleted.");
    } 
         return null;
}

//public String displayNode()
//{
//    
//    Node current;
//    String output = "";
//
//    for (current=head; current!=null; current=current.next)
//    {
//        output+="Name: "+current.getName()+" phone: "+current.getphone()+"\n";
//    }
//
//    return(output+"null");
//}    


    

static public class Node 
{
    String name;
    int Distance;
    double totalprice;
    int order_num;
    int phone;
    Node next;

    public Node()
    {
        name = null;
        Distance = 0;
        totalprice=0;
        phone = 0;
        next = null;
    }

    public Node(String name, int phone,double totalprice,int Distance)
    {
        this.Distance=Distance;
        this.totalprice=totalprice;
        this.name = name;
        //this.address = address;
        this.phone = phone;
    }

        public int getDistance() {
            return Distance;
        }

        public double getTotalprice() {
            return totalprice;
        }

    public String getName()
    {
        return name;
    }

//    public String getaddress()
//    {
//        return address;
//    }

    public int getphone()
    {
        return phone;
    }

    public Node getNext()
    {
        return next;   
    }

    public void setNext(Node next)
    {
        this.next=next;
    }
    }
}
