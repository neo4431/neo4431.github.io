import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // 1 Tính chu vi và diện tích của hình tròn với bán kính r nhập vào từ bàn phím
        Scanner scanner = new Scanner(System.in);
        Double radius, acreage, perimeter;
        System.out.println("Nhập bán kính: ");
        radius = scanner.nextDouble();
        perimeter = radius * 2 * Math.PI;
        acreage = radius * radius * Math.PI;
        System.out.printf("Chu vi hình tròn là: %1.2f\n"+"Diện tích hình tròn là: %1.2f\n", perimeter, acreage);
        scanner.close();
    }
}