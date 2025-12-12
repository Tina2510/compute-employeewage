import java.util.*;
import java.util.Random;
public class EmployeeWageCal {
    Scanner sc = new Scanner(System.in);

    public void CheckAttendance() {
        Random random = new Random();
        int attendance = random.nextInt(2); // 0 = Absent, 1 = Present
        if (attendance == 1) {
            System.out.println("UC1: Employee is Present");
        } else {
            System.out.println("UC1: Employee is Absent");
        }
    }

}
