import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        // 2 Nhập vào 1 số bất kỳ và kiểu tra xem số là số chẵn hay số lẻ (Sử dụng toán
        // tử điều kiện)
        Scanner scanner = new Scanner(System.in);
        int intNum;
        String check;
        System.out.println("Nhập số nguyên bất kỳ để kiểm tra: ");
        intNum = scanner.nextInt();
        check = (intNum%2==0) ? "Số này là số chẵn" : "Số này là số lẻ";
        System.out.println(check);
        scanner.close();
    }
}
