import java.util.EmptyStackException;

interface Stack {
    boolean empty();
    void    push(int i);
    int     pop() throws EmptyStackException;
}
