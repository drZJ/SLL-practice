public class ListNode<T>{
    
    public T info;
    public ListNode<T> next;

    public ListNode(){
        this(null,null);
    }

    public ListNode(T el){
        this(el,null);
    }

    public ListNode(T el, ListNode<T> next){
        this.info=el;
        this.next=next;
    }

}