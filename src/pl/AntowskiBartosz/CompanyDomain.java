package pl.AntowskiBartosz;

import java.util.Scanner;

public class CompanyDomain {
    private static String domain = "@nazwa_firmy.com.pl";

    static Scanner scanner = new Scanner(System.in);

    public static void showDomain(){
        System.out.println(domain);
    }

    public static void editDomain(){
        String tempDomain1;
        String tempDomain2;

        System.out.println("aktualna domena: " + CompanyDomain.getDomain());
        System.out.println("podaj nową domenę: ");
        tempDomain1 = scanner.nextLine();
        System.out.println("powtórz nową domenę: ");
        tempDomain2 = scanner.nextLine();

        if (tempDomain1.equals(tempDomain2)){
            CompanyDomain.setDomain(tempDomain1);
            System.out.println("poprawnie zmieniono domenę na: " + CompanyDomain.getDomain());
        }else
            System.out.println("podane domeny nie sa takie same!!!");
    }

    public static String getDomain() {
        return domain;
    }

    public static void setDomain(String domain) {
        CompanyDomain.domain = domain;
    }
}
