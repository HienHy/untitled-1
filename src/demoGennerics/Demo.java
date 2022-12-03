package demoGennerics;

public class Demo<S> {
    /*
    S,E: Element reference
    N: number
    T:type
    K:key
    V:value
     */
    S element;

    public S getElement() {
        return element;
    }

    public void setElement(S element) {
        this.element = element;
    }
public <E> void print(E msg){
    System.out.println(msg);
}
}
