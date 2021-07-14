package pl.AntowskiBartosz;

import pl.AntowskiBartosz.employee.manualWorker.Cleaner;
import pl.AntowskiBartosz.employee.manualWorker.Driver;
import pl.AntowskiBartosz.employee.manualWorker.Warehouseman;
import pl.AntowskiBartosz.employee.officeWorker.OfficeWorker;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        boolean shouldContinue = true;

        EmployeeRegister employeeRegister = new EmployeeRegister();

//        Driver driver = new Driver(3300, "Bob", "Matt", 3500, 74920, 1,"C", "PO736N4");
//        employeeRegister.employeeList.add(driver);
//        employeeRegister.employeeID.put(driver.getID(), driver);
//
//        OfficeWorker officeWorker = new OfficeWorker(1100, "Hanna", "Kowalska", 4500, 75392, "xsds434bj334");
//        employeeRegister.employeeList.add(officeWorker);
//        employeeRegister.employeeID.put(officeWorker.getID(), officeWorker);
//
//        Warehouseman warehouseman = new Warehouseman(2200, "Mateusz", "Nowak", 3000, 93263, 13, true);
//        employeeRegister.employeeList.add(warehouseman);
//        employeeRegister.employeeID.put(warehouseman.getID(), warehouseman);
//
//        Cleaner cleaner = new Cleaner(4400, "Marta", "Perz", 2700, 94816, 2, "A");
//        employeeRegister.employeeList.add(cleaner);
//        employeeRegister.employeeID.put(cleaner.getID(), cleaner);

        while (shouldContinue) {
            System.out.println("\nREJESTR PRACOWNIKÓW\n####################\nMENU:");
            System.out.println("1 - dodaj pracownika");
            System.out.println("2 - usuń po ID");
            System.out.println("3 - wyświetl");
            System.out.println("4 - wyszukaj po nazwisku / fragmencie");
            System.out.println("5 - przyznaj premię roczną");
            System.out.println("6 - wyjście");
            System.out.println("7 - domena firmowa");
            System.out.println("8 - lista mailingowa");

            int userChoose = scanner.nextInt();
            scanner.nextLine();

            switch (userChoose) {
                case 1:
                    boolean shouldContinue2 = true;
                    while (shouldContinue2) {
                        System.out.println("\nDODAWANIE PRACOWNIKA\n**************\n" +
                                "1 - fizyczny -> MAGAZYNIER\n" +
                                "2 - fizyczny -> SPRZATACZ\n" +
                                "3 - fizyczny -> KIEROWCA\n" +
                                "4 - BIUROWY\n" +
                                "5 - WSTECZ");

                        int chooseWorker = scanner.nextInt();
                        scanner.nextLine();

                        switch (chooseWorker) {
                            case 1:
                                employeeRegister.addWarehouseman();
                                System.in.read();
                                break;

                            case 2:
                                employeeRegister.addCleaner();
                                System.in.read();
                                break;

                            case 3:
                                employeeRegister.addDriver();
                                System.in.read();
                                break;

                            case 4:
                                employeeRegister.addOfficeWorker();
                                System.in.read();
                                break;

                            case 5:
                                shouldContinue2 = false;

                            default:
                                System.out.println("BŁĄD!");
                        }
                    }
                    break;

                case 2:
                    employeeRegister.removeEmployee();
                    System.in.read();
                    break;

                case 3:
                    boolean shouldContinue3 = true;
                    while (shouldContinue3){
                        System.out.println("\nPOKAŻ PRACOWNIKÓW\n***********\n" +
                                "1 - WSZYSTKICH\n" +
                                "2 - BIURO\n" +
                                "3 - MAGAZYN\n" +
                                "4 - KIEROWCY\n" +
                                "5 - SERWIS SPRZĄTAJĄCY\n" +
                                "6 - WSTECZ");

                        int chooseShow = scanner.nextInt();
                        scanner.nextLine();

                        switch (chooseShow) {
                            case 1:
                                employeeRegister.showAll();
                                System.in.read();
                                break;

                            case 2:
                                employeeRegister.showOfficeWorkers();
                                System.in.read();
                                break;

                            case 3:
                                employeeRegister.showWarehousemen();
                                System.in.read();
                                break;

                            case 4:
                                employeeRegister.showDrivers();
                                System.in.read();
                                break;

                            case 5:
                                employeeRegister.showCleaners();
                                System.in.read();
                                break;

                            case 6:
                                shouldContinue3 = false;
                                break;

                            default:
                                System.out.println("BŁĄD!");
                        }
                    }
                    break;

                case 4:
                    employeeRegister.searchByName();
                    System.in.read();
                    break;

                case 5:
                    employeeRegister.salary();
                    System.in.read();
                    break;

                case 6:
                    shouldContinue = false;
                    break;

                case 7:
                    boolean shouldContinue4 = true;

                    while (shouldContinue4) {
                        System.out.println("\n1 - pokaż domenę\n2 - edytuj domene\n3 - wstecz");
                        int chooseDomain = scanner.nextInt();
                        scanner.nextLine();

                        switch (chooseDomain) {
                            case 1:
                                CompanyDomain.showDomain();
                                System.in.read();
                                break;

                            case 2:
                                CompanyDomain.editDomain();
                                System.in.read();
                                break;

                            case 3:
                                shouldContinue4 = false;
                                break;

                            default:
                                System.out.println("BŁĄD!");
                        }
                    }
                    break;

                case 8:
                    employeeRegister.showEmails();
                    System.in.read();
                    break;

                default:
                    System.out.println("BŁĄD!");
            }
        }

    }
}
