package review;
public class Leaf {
    int i = 0;
    public Leaf() {} // default constructor
    // int x; // Dòng này có thể bỏ đi nếu không dùng, hoặc giữ lại nếu có mục đích khác và khởi tạo nó.
               // Nhưng nó không phải nguyên nhân chính của lỗi "Unresolved compilation problem" ở main.

    int increment() {
        return ++i;
    }

    public static void main(String[] args) {
        Leaf x = new Leaf();
        x.increment(); // Lần 1: i = 1
        x.increment(); // Lần 2: i = 2
        x.increment(); // Lần 3: i = 3
        x.increment();
        x.increment();
        x.increment();
        x.increment();

        System.out.println(x.i); // Truy cập biến 'i' thông qua đối tượng 'x'
    }
}