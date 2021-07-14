package pl.AntowskiBartosz;

import pl.AntowskiBartosz.employee.Employee;
import pl.AntowskiBartosz.employee.manualWorker.Cleaner;
import pl.AntowskiBartosz.employee.manualWorker.Driver;
import pl.AntowskiBartosz.employee.manualWorker.Warehouseman;
import pl.AntowskiBartosz.employee.officeWorker.OfficeWorker;

import java.util.*;

public class EmployeeRegister {

    private int officeWorkerTempID = 1101;
    private int warehousemanTempID = 2201;
    private int driverTempID = 3301;
    private int cleanerTempID = 4401;

    List <Employee> employeeList = new ArrayList<>();
    Map<Integer, Employee> employeeID = new HashMap<>();

    Scanner scan = new Scanner(System.in);

    public void showEmails(){
        System.out.println("\nLISTA EMAIL:");
        for (Employee employee : employeeList)
            System.out.println(employee.generateEmail(employee.getFirstName(), employee.getLastName()));
    }

    public void showAll(){
        for(Employee employee : employeeList)
            System.out.println(employee);
    }

    public void showOfficeWorkers(){
        for(Employee employee : employeeList) {
            if (employee instanceof OfficeWorker)
                System.out.println(employee);
        }
    }

    public void salary(){
        for(Employee employee : employeeList)
            employee.giveRise();
        System.out.println("PRZYZNANO PREMIĘ DLA WSZYSTKICH PRACOWNIKÓW");
    }

    public void showDrivers(){
        for(Employee employee : employeeList) {
            if (employee instanceof Driver)
                System.out.println(employee);
        }
    }

    public void showWarehousemen(){
        for(Employee employee : employeeList) {
            if (employee instanceof Warehouseman)
                System.out.println(employee);
        }
    }

    public void showCleaners(){
        for(Employee employee : employeeList) {
            if (employee instanceof Cleaner)
                System.out.println(employee);
        }
    }

    public void searchByName(){
        System.out.println("\nWYSZUKIWANIE PO NAZWISKU\n---------------------------");
        System.out.println("wpisz szukaną frazę: ");
        String temp = scan.nextLine();

        int count = 0;
        for (Employee employee : employeeList){
            if(employee.getLastName().toLowerCase().contains(temp.toLowerCase())) {
                System.out.println(employee);
                count++;
            }
        }
        if (count == 0)
            System.out.println("BRAK PASUJĄCEJ FRAZY!!!");
    }

    public void removeEmployee(){
        System.out.println("USUWANIE PRACOWNIKA\n-----------------");
        System.out.println("podaj ID pracownika: ");
        Integer ID = Integer.valueOf(scan.nextLine());

        if (employeeID.containsKey(ID)){
            employeeList.remove(employeeID.get(ID));
            System.out.println("PRACOWNIK O ID: " + ID + "ZOSTAŁ POPRAWNIE USNIĘTY Z BAZY!!!");
        }
        else {
            System.out.println("NIEPRAWIDŁOWE ID!!! : " + ID);
        }
    }

    private void peselValidation(){
        boolean isNumber = false;
        do {
            try {
                System.out.println("Pesel (6 pierwszych cyfr): ");
                pesel = Integer.valueOf(scan.nextLine());
                if (pesel < 100000){
                    System.out.println("pesel jest za krótki!");
                }
                else if (pesel > 1000000){
                    System.out.println("pesel jest za długi!");
                }
                else
                    isNumber = true;
            }catch (NumberFormatException e){
                System.out.println("DANE NIEPOPRAWNE!");
            }
        } while (!(isNumber));
    }

    String firstName;
    String lastName;
    int pesel;
    int salary = 0;

    private void generalInfo(){
        System.out.println("Imię: ");
        firstName = scan.nextLine();

        System.out.println("Nazwisko: ");
        lastName = scan.nextLine();

        boolean isNumber = false;
        do {
            try {
                System.out.println("Pensja: ");
                salary = Integer.valueOf(scan.nextLine());
                isNumber = true;
            }catch (NumberFormatException e){
                System.out.println("BŁĘDNA WARTOŚĆ!!!\n");
            }
        } while (!(isNumber));

        peselValidation();
    }

    public void addOfficeWorker(){

        generalInfo();

        System.out.println("Kod przydzielonego komputera: ");
        String computerCodeNumber  = scan.nextLine();

        OfficeWorker officeWorker = new OfficeWorker(officeWorkerTempID, firstName, lastName, salary, pesel, computerCodeNumber);

        employeeList.add(officeWorker);
        employeeID.put(officeWorkerTempID, officeWorker);
        officeWorkerTempID++;
        System.out.println("\nPRAWIDŁOWO DODANO PRACOWNIKA\n-------------------------"+officeWorker);
    }


    int cupboardNumber;
    private void cupboardNumber(){
        boolean cupboardNumberValidation = true;
        System.out.println("Nr szafki (1-100): ");
        do {
            try {
                cupboardNumber = Integer.valueOf(scan.nextLine());
                if (0<cupboardNumber && cupboardNumber<101){
                    cupboardNumberValidation = true;
                }
                else {
                    System.out.println("Nie ma takiej szafki!\nPodaj nr 1-100: ");
                    cupboardNumberValidation = false;
                }
            }catch (NumberFormatException e){
                System.out.println("BLAD!!!\nPodaj nr 1-100: ");
                cupboardNumberValidation = false;
            }
        }while (!(cupboardNumberValidation));
    }

    public void addWarehouseman() {

        generalInfo();
        cupboardNumber();
        isUTD();

        Warehouseman warehouseman = new Warehouseman(warehousemanTempID, firstName, lastName, salary, pesel, cupboardNumber, isUTD);
        warehousemanTempID++;
        employeeList.add(warehouseman);
        System.out.println("\nPRAWIDŁOWO DODANO PRACOWNIKA\n-------------------------"+warehouseman);

    }

    boolean isUTD = true;
    private void isUTD(){
        String tmpLicenceUTD;
        boolean UTDValidation;

        do {
            System.out.println("Licencja na wózki widłowe? (T/N)");
            tmpLicenceUTD = scan.nextLine().toLowerCase();
            if (tmpLicenceUTD.equals("t")) {
                isUTD = true;
                UTDValidation = true;
            }
            else if (tmpLicenceUTD.equals("n")) {
                isUTD = false;
                UTDValidation = true;
            }
            else {
                System.out.println("BŁĄD! WYBIERZ T/N");
                UTDValidation = false;
            }
        } while (!(UTDValidation));
    }

    public void addCleaner(){

        generalInfo();
        cupboardNumber();

        System.out.println("Przydział do brygady: ");
        String team  = scan.nextLine();

        Cleaner cleaner = new Cleaner(cleanerTempID, firstName, lastName, salary, pesel, cupboardNumber, team);
        cleanerTempID++;

        employeeList.add(cleaner);

        System.out.println("\nPRAWIDŁOWO DODANO PRACOWNIKA\n-------------------------"+cleaner);


    }

    public void addDriver(){
        generalInfo();
        cupboardNumber();
        drivingLicenceCategory();

        System.out.println("Numer rejestracyjny przydzielonego pojazdu: ");
        String vehicleRegistrationNumber  = scan.nextLine();

        Driver driver = new Driver(driverTempID, firstName, lastName, salary, pesel, cupboardNumber, drivingLicenceCategory, vehicleRegistrationNumber);
        driverTempID++;

        employeeList.add(driver);
        System.out.println("\nPRAWIDŁOWO DODANO PRACOWNIKA\n-------------------------"+driver);

    }

    private String drivingLicenceCategory;

    private void drivingLicenceCategory(){
        boolean drivingLicenceValidation;
        System.out.println("Prawo jazdy [B/BE/C/CE]: ");
        do {
            drivingLicenceCategory  = scan.nextLine().toUpperCase();
            if (drivingLicenceCategory.matches("B|BE|C|CE")){
                drivingLicenceValidation = true;
            }
            else {
                System.out.println("NIEPOPRAWNY FORMAT DANYCH!\nWprowadź (B/BE/C/CE): ");
                drivingLicenceValidation = false;
            }
        }while (!(drivingLicenceValidation));
    }
}
