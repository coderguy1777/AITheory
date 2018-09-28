public class Stack <T> {
    private Node top;
    public long length = 0;

    public Stack(){
    }

    public void push(T newVal) {
        Node newNode = new Node<T>(newVal);
        newNode.setNext(top);
        top = newNode;
        length++;
    }

    public T pop() {
        Node holder = top;
        top = top.getNext();
        length--;
        return (T) holder.get();
    }

    public void setValue(T i) {
        top.set(i);
    }
}