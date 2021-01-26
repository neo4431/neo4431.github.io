import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
         // 3 Tính tiền lãi hàng tháng của khoản vay, biết:
        // Số nợ: 100.000.000
        // Lãi xuất năm: 12%
        // Lãi suất tháng = Lãi suất năm/12 tháng
        // Tiền lãi trả hàng tháng = Số nợ gốc x Lãi suất tháng
        // Tổng số tiền phải trả hàng tháng = tiền gốc/12 tháng + tiền lãi trả hàng tháng
        float amount, interestMonthly;
        int total = 100000000;
        interestMonthly = total * 1 / 100;
        amount = (total / 12) + interestMonthly;
        System.out.println(amount);
    }
}