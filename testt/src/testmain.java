public class PassObject {
 static void f(Number m) {
 m.i = 15;
 }
 public static void main(String[] args) {
Number n = new Number();
n.i =14;
PassObject.f(n);
System.out.println(n.i);
// what is n.i now? 15 or 14
}
}