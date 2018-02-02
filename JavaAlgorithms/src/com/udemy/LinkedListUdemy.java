package com.udemy;




import java.util.Objects;

class Node
{
    //node 
    /**
     * Node class to create the linked list
     */
    private Object data;
    private Node next;


    public Node(Object data, Node next)
    {
        this.data = data;
        this.next = next;
    }

    public Object getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}


class LinkedListUdemy
{

    /**
     * Class needed to create new linked list objects
     */
    private Node top;
    private Node firstNode;
    private int size;

    public LinkedListUdemy()
    {
        top = null;
    }

    public void addNode(Object data)
    {
        /**
         * adds nodes to the beginning of the linked list
         */
        top = new Node(data, top);
        size++;
    }

    public int size()
    {
        return size;
    }

    public Object deletePos(int position)
    {
        Node prev = null;
        Node curr = top;
        Object result = null;
        int i;

        if ( position < size )
        {
            for (curr = top,  i = 0; curr != null && i <= size; curr = curr.getNext(),++i)
            {
                if ( position == i )
                {
                    if ( prev != null )
                    {
                        result = curr.getData();
                        prev.setNext(curr.getNext());
                        size--;

                    }else
                    {
                        top = curr.getNext();
                        size--;
                    }
                }

                prev = curr;

            }
        }else
        {
            System.out.println("This linked list is not this size so I cant delete the item");
        }

        return result;

    }

    public Object delete(Object key) // works
    {
        /**
         * deletes a given item from the linked list
         */
        Node prev = null;
        Node curr = top;
        Object result = null;

        //search for the key
        while((curr != null) && (!curr.getData().equals(key)))
        {
            prev = curr;
            curr = curr.getNext();
        }

        if ( curr != null )
        {
            if ( prev != null )
            {
                result = curr.getData();
                prev.setNext(curr.getNext());
                size--;

            }else
            {
                top = curr.getNext();
                size--;
            }
        }



        return result;
    }

    public Object initTraversal()
    {
        /**
         * An initialization traversal method
         */
        Object item = null;

        if ( top != null )
        {
            firstNode = top;
            item = firstNode.getData();
        }

        return item;
    }


    public Object traverse()
    {
        /**
         * traverse method to traverse the linked list
         */
        Object item = null;
        if ( top.getNext() != null )
        {
            firstNode = top.getNext();
            item = firstNode;
        }else
        {
            firstNode = null;
        }

        return item;

    }


    public LinkedListUdemy reverse()
    {
        /**
         * reverses a linked list and returns a new linked list object
         */
        Node curr = top;
        LinkedListUdemy newList = new LinkedListUdemy();

        newList.add(newList, curr);
        System.out.println("\nReverse Linked List: " + newList);
        return newList;
    }

    private void add(LinkedListUdemy newList, Node current)
    {
        /**
         * recursively adds nodes to the new linked list
         */
        if ( current != null )
        {
            newList.addNode(current.getData());
            add(newList,current.getNext());
            size++;
        }
    }

    public String toString()
    {
        /**
         * public driver toString method to print out all elements in the list recursively
         */
        return toString(top);
    }

    private String toString(Node curr)
    {
        /**
         * private helper recursive toString method
         */
        String result = "";

        if(curr != null)
        {
            if ( curr == top )
            {
                result += "{";
            }

            if ( curr.getNext() != null )
            {
                result += curr.getData() + "," + toString(curr.getNext());
            }else
            {
                result += curr.getData().toString();
                result += "}";
            }
        }
        return  result;

        
    }


}
