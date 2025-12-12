import java.util.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.HashMap;

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
        int wagePerHour = 20;
        int fullDayHours = 8;
        int dailyWage = wagePerHour * fullDayHours;
        System.out.println("Daily Wage = " + dailyWage);
    }

    public void PartTimeWage() {
        int wagePerHour = 20;
        int partTimeHours = 4;
        int dailyWage = wagePerHour * partTimeHours;
        System.out.println("Part-time Wage = " + dailyWage);
    }

    public void UsingSwitchCase() {
        int wagePerHour = 20;
        int fullTimeHours = 8;
        int partTimeHours = 4;
        Random random = new Random();
        int empCheck = random.nextInt(3);
        int dailyHours;
        switch (empCheck) {
            case 1:
                dailyHours = fullTimeHours;
                break;
            case 2:
                dailyHours = partTimeHours;
                break;
            default:
                dailyHours = 0;
        }
        int dailyWage = dailyHours * wagePerHour;
        System.out.println(" Daily Wage using switch = " + dailyWage);
    }
    public void MonthlyWage() {
        int wagePerHour = 20;
        int fullDayHours = 8;
        int workingDays = 20;
        int totalWage = wagePerHour * fullDayHours * workingDays;
        System.out.println("Monthly Wage = " + totalWage);

    }



    public void TillCondition() {

        int wagePerHour = 20;
        int fullDayHours = 8;
        int maxHours = 100;
        int maxDays = 20;

        int totalHours = 0;
        int totalDays = 0;
        int totalWage = 0;

        Random random = new Random();
        while (totalDays < maxDays && totalHours < maxHours) {
            totalDays++;
            int empCheck = random.nextInt(3);
            int hours = 0;
            switch (empCheck) {
                case 1:
                    hours = 8;
                    break;
                case 2:
                    hours = 4;
                    break;
                default:
                    hours = 0;
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
        int tcsWage = ComputeEmpWage(20, 20, 100);
        int infosysWage = ComputeEmpWage(25, 22, 120);
        System.out.println("UC8: TCS Total = " + tcsWage + " | Infosys Total = " + infosysWage);
    }

    class Company {
        String name;
        int totalWage;

        Company(String name) {
            this.name = name;
        }

        void setWage(int wage) {
            totalWage = wage;
        }
    }

    public void SaveTotalWage() {
        Company tcs = new Company("TCS");
        tcs.setWage(ComputeEmpWage(20,20,100));
        System.out.println("TCS Total Wage = " + tcs.totalWage);

    }

    public void ManageMultipleCompaniesArray() {
        Company[] companies = new Company[3];

        companies[0] = new Company("TCS"); companies[0].setWage(ComputeEmpWage(20,20,100));
        companies[1] = new Company("Infosys"); companies[1].setWage(ComputeEmpWage(25,22,120));
        companies[2] = new Company("Wipro"); companies[2].setWage(ComputeEmpWage(30,18,90));
        System.out.println("Total Wages for multiple companies:");
        for (Company c : companies) System.out.println(c.name + " = " + c.totalWage);
    }
    interface ICompute {
        void addCompany(String name, int wage, int days, int hours);
        void computeWages();
    }

    class EmpWageImpl implements ICompute {
        ArrayList<Company> list = new ArrayList<>();

        public void addCompany(String name, int wage, int days, int hours) {
            Company c = new Company(name);
            c.setWage(ComputeEmpWage(wage, days, hours));
            list.add(c);
        }

        public void computeWages() {
            System.out.println("UC11: Wages via Interface:");
            for (Company c : list)
                System.out.println(c.name + " = " + c.totalWage);
        }
    }
    public void InterfaceApproach() {
        EmpWageImpl emp = new EmpWageImpl();
        emp.addCompany("TCS", 20, 20, 100);
        emp.addCompany("Infosys", 25, 22, 120);
        emp.computeWages();
    }

    public void ArrayListApproach() {
        ArrayList<Company> companies = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            System.out.print("Enter company name: ");
            String name = sc.next();
            Company c = new Company(name);
            c.setWage(ComputeEmpWage(20, 20, 100));
            companies.add(c);
        }
        System.out.println("Wages with ArrayList:");
        for (Company c : companies) System.out.println(c.name + " = " + c.totalWage);
    }

    class CompanyWithDaily extends Company {
        ArrayList<Integer> dailyWages = new ArrayList<>();

        CompanyWithDaily(String name) {
            super(name);
        }

        void setDailyWages(ArrayList<Integer> wages) {
            dailyWages = wages;
        }
    }

    public void StoreDailyWage() {
        System.out.print(" Enter company name: ");
        String name = sc.next();
        CompanyWithDaily c = new CompanyWithDaily(name);
        ArrayList<Integer> daily = new ArrayList<>();
        Random random = new Random();
        int totalWage = 0;
        System.out.print("Enter number of working days: ");
        int days = sc.nextInt();
        System.out.print("Enter wage per hour: ");
        int wagePerHour = sc.nextInt();
        for (int i = 0; i < days; i++) {
            int empCheck = random.nextInt(3);
            int hours = (empCheck == 1) ? 8 : (empCheck == 2 ? 4 : 0);
            int wage = hours * wagePerHour;
            totalWage += wage;
            daily.add(wage);
        }
        c.setDailyWages(daily);
        c.setWage(totalWage);
        System.out.println(" Daily Wages: " + c.dailyWages + "Total: " + c.totalWage);


        System.out.println("Total Wage = " + totalWage + " | Days Worked = " +   " Hours Worked = " );

    }





    public static void main(String[] args) {
        EmployeeWageCal emp = new EmployeeWageCal();
        emp.CheckAttendance();
        emp.DailyWage();
        emp.PartTimeWage();
        emp.UsingSwitchCase();
        emp.MonthlyWage();
        emp.TillCondition();
        emp.ComputeEmpWage(20, 20, 100);
        emp.MultipleCompanies();
        emp.SaveTotalWage();
        emp.ManageMultipleCompaniesArray();
        emp.InterfaceApproach();
        emp.ArrayListApproach();
        emp.StoreDailyWage();
        //emp.QueryTotalWage();
    }

}
