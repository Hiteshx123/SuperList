import java.lang.ArrayIndexOutOfBoundsException;
 
public class SuperList<E>
{
    private SuperNode<E> root;
    private SuperNode<E> end;
    private int size;
 
    public SuperList()
    {
        root = null;
        end = null;
        size = 0;
    }
 
    public boolean isEmpty(){
        return size <= 0;
    }
 
    public int size(){
        return size;
    }
 
    public void add(E val){
        SuperNode<E> node = new SuperNode<E>(val);
        if(root == null)
            root = node;
        else if (end == null){
            end = node;
            root.setNext(end);
            end.setPrevious(root);
        }
        else {
            end.setNext(node);
            node.setPrevious(end);
            end = node;
        }
        size++;
    }
 
    public boolean add(int index, E val){
        if(index < 0 || index > size())
            return false;
       SuperNode<E> newNode = new SuperNode<E>(val);
       if(index == 0){
            if(root == null)
                root = newNode;
            else {
                newNode.setNext(root);
                root.setPrevious(newNode);
                root = newNode;
            }
       } else if(index == size()){
            if(end == null){
                end = newNode;
                end.setPrevious(root);
            } else {
                newNode.setPrevious(end);
                end.setNext(newNode);
                end = newNode;
            }
       } else {
        SuperNode<E> currNode = recursiveGet(root, index);
        //System.out.println(currNode.value);
        currNode.getPrevious().setNext(newNode);
        newNode.setPrevious(currNode.getPrevious());
        newNode.setNext(currNode);
        currNode.setPrevious(newNode);
       }
           
     
       
        size++;
        return true;
    }
 
    public String toString(){
        return "[" + recusiveStringBuilder(root) + "]";
    }
 
    private String recusiveStringBuilder(SuperNode<E> node){
        if(node.hasNext())
            return node.getValue().toString() + ", " + recusiveStringBuilder(node.getNext());
        else
            return node.getValue().toString();
    }
 
    private SuperNode<E> recursiveGet(SuperNode<E> node, int toNodeDistance){
        if(toNodeDistance == 0 || node == null)
            return node;
        return recursiveGet(node.getNext(), toNodeDistance - 1);
       
    }
 
    public void push(E val){
        add(val);
    }
 
    public E remove(int index){
        if(index < 0 || index >= size())
            throw new ArrayIndexOutOfBoundsException();     
       SuperNode<E> currNode;
       if(index == 0){
        currNode = root;
        root = root.getNext();
        if(root != null)
        root.setPrevious(null);
         else 
             root = null;
       } else if(index == size() - 1){
           currNode = end;
           end = end.getPrevious();
           if(end != null)
                end.setNext(null);
            else 
                root = null;
       } else {
        currNode = recursiveGet(root, index+1);
        currNode.getPrevious().setNext(currNode.getNext());
        currNode.getNext().setPrevious(currNode.getPrevious());
        size--;
       }
           
     
       
 
        return currNode.getValue();


    }
 
    public E pop(){
        SuperNode node = end;
        //System.out.println(node.getValue());
        if(end != null){
        end = end.getPrevious();
        if (end != null)
            end.setNext(null);
        else 
            root =null;
        size--;
        }
        return (E)node.getValue();
    }
 
    public E poll(){
        SuperNode node = root;

        if(root !=null){
        root = root.getNext();
        if (root != null)
            root.setPrevious(null);
        else {
            end = null;
        }
        size--;
        }
        return (E)node.getValue();
    }
 
    public E stackPeek(){
        return end.getValue();
    }
 
    public E queuePeek(){
        return root.getValue();
    }
 
    public E get(int index){
        return recursiveGet(root, index).getValue();
    }
 
    public E set(int index, E val){
        if(index < 0 || index >= size())
            throw new ArrayIndexOutOfBoundsException();     
       SuperNode<E> currNode;
       if(index == 0){
            
            currNode =root;
            root.value = val;
       } else if(index == size() - 1){
           currNode =end;
            end.value = val;
       } else {
        SuperNode node = recursiveGet(root, index);
        currNode = node;
        node.value = val;
       }
           
     
       
 
        return currNode.getValue();
    }
 
    //public boolean contains(E val){
       
   // }
 
    public void clear(){
        root = null;
        end = null;
        size = 0;
    }
 
 
 
    public class SuperNode<E>
    {
        private E value;
        private SuperNode<E> next;
        private SuperNode<E> previous;
 
        public SuperNode(E val)
        {
            value = val;
            next = null;
            previous = null;
        }
 
        void setNext(SuperNode<E> next){
            this.next = next;
        }
 
        void setPrevious(SuperNode<E> prev){
            this.previous = prev;
        }
 
        SuperNode<E> getNext(){
            return next;
        }
 
        SuperNode<E> getPrevious(){
            return previous;
        }
 
        E getValue(){
            return value;
        }
 
        boolean hasNext(){
            return next != null;
        }
 
        boolean hasPrevious(){
            return previous != null;
        }
    }
}

