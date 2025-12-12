import java.util.*;
import java.util.Random;
public class EmployeeWageCal {
    Scanner sc = new Scanner(System.in);

    public void CheckAttendance() {
        Random random = new Random();
        int attendance = random.nextInt(2); // 0 = Absent, 1 = Present
        if (attendance == 1) {
            System.out.println("Employee is Present");
        } else {
            System.out.println("Employee is Absent");
        }
    }
    public void DailyWage() {
        System.out.print("Enter wage per hour: ");
        int wagePerHour = sc.nextInt();
        System.out.print("Enter full day hours: ");
        int fullDayHours = sc.nextInt();
        int dailyWage = wagePerHour * fullDayHours;
        System.out.println("Daily Wage = " + dailyWage);
    }
    public void PartTimeWage() {
        System.out.print(" Enter wage per hour: ");
        int wagePerHour = sc.nextInt();
        System.out.print("Enter part-time hours: ");
        int partTimeHours = sc.nextInt();
        int dailyWage = wagePerHour * partTimeHours;
        System.out.println("Part-time Wage = " + dailyWage);
    }

    public void UsingSwitchCase() {
        System.out.print("Enter wage per hour: ");
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
        System.out.println(" Daily Wage using switch = " + dailyWage);
    }
    public void MonthlyWage() {
        System.out.print(" Enter wage per hour: ");
        int wagePerHour = sc.nextInt();
        System.out.print("Enter full day hours: ");
        int fullDayHours = sc.nextInt();
        System.out.print("Enter working days: ");
        int workingDays = sc.nextInt();
        int totalWage = wagePerHour * fullDayHours * workingDays;
        System.out.println("Monthly Wage = " + totalWage);
    }
    public void TillCondition() {
        System.out.print(" Enter wage per hour: ");
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
        System.out.println("Total Wage = " + totalWage + " Days Worked = " + totalDays + " | Hours Worked = " + totalHours);
    }
    public int ComputeEmpWage(int wagePerHour, int maxDays, int maxHours) {
        int totalHours = 0, totalDays = 0, totalWage = 0;
        Random random = new Random();
        while (totalDays < maxDays && totalHours < maxHours) {
            totalDays++;
            int empCheck = random.nextInt(3);
            int hours = (empCheck == 1) ? 8 : (empCheck == 2 ? 4 : 0);
            if (totalHours + hours > maxHours) hours = maxHours - totalHours;
            totalHours += hours;
            totalWage += hours * wagePerHour;
        }
        System.out.println(" Computed Wage = " + totalWage);
        return totalWage;
    }

    public void MultipleCompanies() {
        System.out.println(" TCS Details:");
        int tcsWage = ComputeEmpWage(20, 20, 100);
        System.out.println(" Infosys Details:");
        int infosysWage = ComputeEmpWage(25, 22, 120);
        System.out.println(" TCS Total = " + tcsWage + " Infosys Total = " + infosysWage);
    }
    class Company {
        String name;
        int totalWage;
        Company(String name) { this.name = name; }
        void setWage(int wage) { totalWage = wage; }
    }
    public void SaveTotalWage() {
        System.out.print("UC9: Enter company name: ");
        String name = sc.next();
        Company c = new Company(name);
        c.setWage(ComputeEmpWage(20,20,100));
        System.out.println("" + name + " Total Wage = " + c.totalWage);
    }
    public void ManageMultipleCompaniesArray() {
        Company[] companies = new Company[3];
        for(int i=0;i<3;i++){
            System.out.print("Enter company name: ");
            String name = sc.next();
            companies[i] = new Company(name);
            companies[i].setWage(ComputeEmpWage(20,20,100));
        }
        System.out.println("Total Wages for multiple companies:");
        for (Company c : companies) System.out.println(c.name + " = " + c.totalWage);
    }
    interface ICompute { void addCompany(String name,int wage,int days,int hours); void computeWages(); }
    class EmpWageImpl implements ICompute {
        ArrayList<Company> list = new ArrayList<>();
        public void addCompany(String name,int wage,int days,int hours) {
            Company c = new Company(name);
            c.setWage(ComputeEmpWage(wage,days,hours));
            list.add(c);
        }
        public void computeWages() {
            System.out.println("UC11: Wages via Interface:");
            for(Company c : list) System.out.println(c.name + " = " + c.totalWage);
        }
    }
    public void uc11_InterfaceApproach() {
        EmpWageImpl emp = new EmpWageImpl();
        emp.addCompany("TCS",20,20,100);
        emp.addCompany("Infosys",25,22,120);
        emp.computeWages();
    }






}
