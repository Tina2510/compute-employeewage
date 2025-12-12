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
    public void DailyWage() {
        System.out.print("UC2: Enter wage per hour: ");
        int wagePerHour = sc.nextInt();
        System.out.print("Enter full day hours: ");
        int fullDayHours = sc.nextInt();
        int dailyWage = wagePerHour * fullDayHours;
        System.out.println("UC2: Daily Wage = " + dailyWage);
    }
    public void PartTimeWage() {
        int wagePerHour = 20;
        int partTimeHours = 4;
        int dailyWage = wagePerHour * partTimeHours;
        System.out.println("UC3: Part-time Wage = " + dailyWage);
    }



}
