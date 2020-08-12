public class SLL<T> {

    private int size = 0;
    
    // public visibility for head and tail for compatibility with packaging and grading
    public ListNode<T> head, tail;  
    
    
    public SLL() {
      head = tail = null;
    }
  
    public boolean isEmpty() {
      return head == null;
    }
  
    public void addToHead(T el) {
      head = new ListNode<T>(el,head);
      if (tail == null)
        tail = head;
      size++;
    }
    
    public void addToTail(T el) {
      if (!isEmpty()) {
        tail.next = new ListNode<T>(el);
        tail = tail.next;
      }
      else head = tail = new ListNode<T>(el);
  
      size++;
    }
  
    public T deleteFromHead() { // delete the head and return its info; 
      if (isEmpty()) 
        return null;
      T el = head.info;
      if (head == tail)       // if only one node on the list;
        head = tail = null;
      else head = head.next;
  
      size--;
      return el;
    }
    
    public T deleteFromTail() { // delete the tail and return its info;
      if (isEmpty()) 
        return null;
      T el = tail.info;
      if (head == tail)       // if only one node in the list;
        head = tail = null;
      else {                  // if more than one node in the list,
        ListNode<T> tmp;    // find the predecessor of tail;
        for (tmp = head; tmp.next != tail; tmp = tmp.next);
        tail = tmp;        // the predecessor of tail becomes tail;
        tail.next = null;
      }
      size--;
      return el;
    }
    
    public void delete(T el) {  // delete the node with an element el;
      if (!isEmpty()) {
        if (head == tail && el.equals(head.info)) // if only one
          head = tail = null;       // node on the list;
        else if (el.equals(head.info)) // if more than one node on the list;
          head = head.next;    // and el is in the head node;
        else {                    // if more than one node in the list
            ListNode<T> pred, tmp;// and el is in a nonhead node;
          for (pred = head, tmp = head.next;  
               tmp != null && !tmp.info.equals(el); 
               pred = pred.next, tmp = tmp.next);
          if (tmp != null) {   // if el was found;
            pred.next = tmp.next;
            if (tmp == tail) // if el is in the last node;
              tail = pred;
          }
        }
        size--;
      }
    }
    
    public void printAll() {
      for (ListNode<T> tmp = head; tmp != null; tmp = tmp.next)
        System.out.print(tmp.info + " ");                
    }
    
    
    // Added this for pretty printing
    public String toString() {
      String str = "[";
      for (ListNode<T> tmp = head; tmp != null; tmp = tmp.next) {
        str = str + tmp.info.toString();
        if( tmp.next != null) {
          str = str + "";
        }
      }
      str = str + "]";
      return str;
    }
    
    
    public boolean isInList(T el) {
        ListNode<T> tmp;
      for (tmp = head; tmp != null && !tmp.info.equals(el); tmp = tmp.next);
      return tmp != null;
    }
  
    public int getLength() {
      return size;
    }
    
    
  
  
    public void enqueue(T el){
        addToTail(el);
    }

    public T dequeue(){
        return deleteFromHead();
    }
}