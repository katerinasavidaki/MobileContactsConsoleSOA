package gr.aueb.cf.mobilecontacts;

import gr.aueb.cf.mobilecontacts.controller.MobileContactController;
import gr.aueb.cf.mobilecontacts.dto.MobileContactInsertDTO;
import gr.aueb.cf.mobilecontacts.dto.MobileContactUpdateDTO;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner in = new Scanner(System.in);
    private static final MobileContactController controller = new MobileContactController();

    public static void main(String[] args) {
        String choice;

        while (true) {
            printMenu();
            choice = getToken();

            if (choice.equals("q") || (choice.equals("Q"))) {
                break;
            }

            handleChoice(choice);
        }

        System.out.println("Thank you for using Mobile contacts App");
    }

    public static void handleChoice(String choice) {
        String firstname;
        String lastname;
        String phoneNumber;
        String response;

        switch (choice) {
            case "1":
                System.out.println("Please insert Firstname, Lastname, Phone Number");
                firstname = getToken();
                lastname = getToken();
                phoneNumber = getToken();
                MobileContactInsertDTO insertDTO = new MobileContactInsertDTO(firstname, lastname, phoneNumber);
                response = controller.insertContact(insertDTO);

                if (response.startsWith("OK")) {
                    System.out.println("Successful insertion");
                    System.out.println(response.substring(3));
                } else {
                    System.out.println("Insert was unsuccessful");
                    System.out.println(response.substring(7));
                }
                break;
            case "2":
                System.out.println("Please insert phone number");
                phoneNumber = getToken();
                response = controller.getContactByPhoneNumber(phoneNumber);
                if (response.startsWith("Error")) {
                    System.out.println("Contact was not found");
                    System.out.println(response.substring(7));
                    return;
                }
                System.out.println("Unsuccessful insertion");
                System.out.println(response.substring(6));
                System.out.println("Please insert the existing id");
                long oldId = Long.parseLong(getToken());
                System.out.println("Please insert new firstname, new lastname, new phone number");
                firstname = getToken();
                lastname = getToken();
                phoneNumber = getToken();
                MobileContactUpdateDTO updateDTO = new MobileContactUpdateDTO(oldId, firstname, lastname, phoneNumber);
                response = controller.updateContact(updateDTO);
                System.out.println(response);
                break;
            case "3":
                System.out.println("Insert Contact id");
                long id = Long.parseLong(getToken());
                response = controller.deleteContactById(id);
                if (response.startsWith("OK")) {
                    System.out.println("Successful deletion");
                    System.out.println(response.substring(3));
                } else {
                    System.out.println("Unsuccessful deletion");
                    System.out.println(response.substring(6));
                }
                break;
            case "4":
                System.out.println("Insert Contact id");
                id = Long.parseLong(getToken());
                response = controller.getContactById(id);
                if (response.startsWith("OK")) {
                    System.out.println("Successful Search");
                    System.out.println(response.substring(3));
                } else {
                    System.out.println("Search was unsuccessful");
                    System.out.println(response.substring(6));
                }
                break;
            case "5":
                List<String> mobileContacts = controller.getAllContacts();
                if (mobileContacts.isEmpty()) {
                    System.out.println("Empty contact list");
                }
                mobileContacts.forEach(System.out::println);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    public static void printMenu() {
        System.out.println("Choose one of the following:");
        System.out.println("1. Insert contact");
        System.out.println("2. Update contact");
        System.out.println("3. Delete contact");
        System.out.println("4. Search contact");
        System.out.println("5. Show contacts");
        System.out.println("Q/q. Exit");
    }

    public static String getToken() {
        return in.nextLine().trim();
    }
}
