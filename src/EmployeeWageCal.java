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
        System.out.print("UC4: Enter wage per hour: ");
        int wagePerHour = sc.nextInt();
        System.out.print("Full-time hours: ");
        int fullTimeHours = sc.nextInt();
        System.out.print("Part-time hours: ");
        int partTimeHours = sc.nextInt();

        Random random = new Random();
        int empCheck = random.nextInt(3);
        int dailyHours;
        switch (empCheck) {
            case 1: dailyHours = fullTimeHours; break;
            case 2: dailyHours = partTimeHours; break;
            default: dailyHours = 0;
        }
        int dailyWage = dailyHours * wagePerHour;
        System.out.println("UC4: Daily Wage using switch = " + dailyWage);
    }
    public void MonthlyWage() {
        System.out.print("UC5: Enter wage per hour: ");
        int wagePerHour = sc.nextInt();
        System.out.print("Enter full day hours: ");
        int fullDayHours = sc.nextInt();
        System.out.print("Enter working days: ");
        int workingDays = sc.nextInt();
        int totalWage = wagePerHour * fullDayHours * workingDays;
        System.out.println("UC5: Monthly Wage = " + totalWage);
    }
    public void TillCondition() {
        System.out.print("UC6: Enter wage per hour: ");
        int wagePerHour = sc.nextInt();
        System.out.print("Full-time hours: ");
        int fullDayHours = sc.nextInt();
        System.out.print("Max hours: ");
        int maxHours = sc.nextInt();
        System.out.print("Max days: ");
        int maxDays = sc.nextInt();

        int totalHours = 0;
        int totalDays = 0;
        int totalWage = 0;

        Random random = new Random();
        while (totalDays < maxDays && totalHours < maxHours) {
            totalDays++;
            int empCheck = random.nextInt(3);
            int hours = 0;
            switch (empCheck) {
                case 1: hours = 8; break;
                case 2: hours = 4; break;
                default: hours = 0;
            }
            if (totalHours + hours > maxHours) hours = maxHours - totalHours;
            totalHours += hours;
            totalWage += hours * wagePerHour;
        }
        System.out.println("UC6: Total Wage = " + totalWage + " | Days Worked = " + totalDays + " | Hours Worked = " + totalHours);
    }






}
