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
        System.out.print("UC3: Enter wage per hour: ");
        int wagePerHour = sc.nextInt();
        System.out.print("Enter part-time hours: ");
        int partTimeHours = sc.nextInt();
        int dailyWage = wagePerHour * partTimeHours;
        System.out.println("UC3: Part-time Wage = " + dailyWage);
    }

    public void UsingSwitchCase() {
        int wagePerHour = 20;
        int fullTimeHours = 8;
        int partTimeHours = 4;
        Random random = new Random();
        int empCheck = random.nextInt(3);
        int dailyHours;
        switch (empCheck) {
            case 1: dailyHours = fullTimeHours; break;
            case 2: dailyHours = partTimeHours; break;
            default: dailyHours = 0;
        }
        int dailyWage = dailyHours * wagePerHour;
        System.out.println("Daily Wage using switch = " + dailyWage);
    }




}
