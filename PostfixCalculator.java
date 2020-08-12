import java.util.Stack;


public class PostfixCalculator{
    public static boolean HigherPrecedence(String a, String b){
        if (a=="+"||a=="-"){
            if (b=="*"||b=="/"){
                return true;
            }
        }
        return false;
    }

    public static String ShuntingYard(String infix){
        Stack<String> S= new Stack<>(); // a stack
        SLL<String> Q =new SLL<>(); //single linked list as queue

        while (infix.length()>0)
        {
            String T=Character.toString( infix.charAt(0)); 
            infix=infix.substring(1);
            System.out.println(T);
            //System.out.println(infix);

            //if T is a number, enqueue into Q
            if (T.charAt(0)<=57&&T.charAt(0)>=48){
                
                Q.enqueue(T);
                   // FIFO , addToTail as enqueue
                                // delete from head as dequeue
            }
            //if T is not a number
            else{ 
                if(T=="("){
                    S.push(T);
                }
                else if(T==")"){
                    while (S.peek()!="("){
                        if(S.peek()!="("&&S.peek()!=")"){
                            Q.enqueue(S.peek());
                        }
                        if(!S.empty()){
                            S.pop();
                        }
                        
                    }
                    if(!S.empty()){
                        S.pop();
                    }
                    
                }
                else{
                    while (HigherPrecedence(S.peek(),T)){
                        if(S.peek()!="("&&S.peek()!=")"){
                            Q.enqueue(S.peek());
                        }
                        S.pop();
                    }
                    S.push(T);
                }
            }
        }


        while (!S.empty()){
            if(S.peek()!="("&&S.peek()!=")"){
                Q.enqueue(S.peek());
            }
            S.pop();
        }

        return Q.toString();
        
    }


    public static void main(String [] args){
        System.out.println(ShuntingYard("(2*3+4)/5-6"));
    }
}