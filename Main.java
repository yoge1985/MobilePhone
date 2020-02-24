import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static MobilePhone mobilePhone = new MobilePhone("34566");

    public static void main(String[] args) {

        //prompt user to chose from one of the following options
        boolean quit = false;
        while (!quit){

            printOptions();
            int choice = scanner.nextInt();
            switch (choice){
                case 0:
                    printOptions();
                    break;
                case 1:
                    addContacts();
                    break;
                case 2:
                    modifyContact();
                    break;
                case 3:
                    removeContact();
                    break;
                case 4:
                    mobilePhone.printContacts();
                    break;
                case 5:
                    quit = true;
                    break;
            }
        }

        mobilePhone.printContacts();

    }

    private static Scanner scanner1 = new Scanner(System.in);

    private static void printOptions(){
        System.out.println("select from the following options:\n0 - print options\n1 - add contact" +
                "\n2 - modify contact\n3 - remove contact\n4 - print contacts\n5 - quit");
    }
    private static void addContacts(){
        System.out.println("enter new contact name:");
        String name = scanner1.nextLine();
        System.out.println("enter contact phone number:");
        String number = scanner1.nextLine();
        if (mobilePhone.addContacts(name,number)){
            System.out.println("contact has been successfully added");
        }else {
            System.out.println("contact already exists");
        }
    }

    private static void modifyContact(){
        System.out.print("enter name you wish to modify:");
        String oldName = scanner1.nextLine();
        System.out.print("enter new name:");
        String newName = scanner1.nextLine();
        System.out.print("enter phone number:");
        String phoneNumber = scanner1.nextLine();
        if (mobilePhone.modifyContact(oldName,newName,phoneNumber)){
            System.out.println("contact successfully modified");
        }else{
            System.out.println("could not change!");
        }
    }

    private static void removeContact(){
        System.out.println("enter name to be removed:");
        String name = scanner1.nextLine();
        if (mobilePhone.removeContact(name)){
            System.out.println(name + " has been removed");
        }else{
            System.out.println(name + "does not exist");
        }
    }

}
