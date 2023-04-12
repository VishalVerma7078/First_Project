
import java.text.BreakIterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Date;
import java.lang.String;
class code
{
    // here we are declaring an array to store the ADD a book to the library
    String[] add_book = new String[1];
    int choice, iss_time, i;  // iss_time stand for, how many days we want to take the book from the library.
    int std,std0, payment = 300, rent = 50; // std stands for class/ grade of the student.
    // payment = 300 until we can find the way for changing them according to the book.
    int roll_no, roll_no1;
    LinkedList<String> ll = new LinkedList<>();
    long contact;
    String name, name1, book_name, choice2, m;  // choice2 stand for the book buying by the user permanently or on rent for some days
    Scanner input = new Scanner(System.in);
    Date today = new Date();



    void stu_details() // this function is used to get the details of the students
    {
        Scanner scanstr = new Scanner(System.in);
        System.out.println("Today's date is : " + today);

        System.out.println("\n <--- WELCOME TO HYBRID LIBRARY --->" +
                "\n[NOTICE] -> PLEASE ENTER ONLY VALID DETAILS.");

        System.out.println("\n       --- STUDENT DETAILS ---");

        System.out.println("\nEnter the name of student : ");
        name = scanstr.nextLine();

        System.out.println("Enter the class/ grade ( 1-12 )th of student : ");
        std = input.nextInt();
        if (std<=12)
        {
            System.out.println("Enter the roll number of student : ");
            roll_no = input.nextInt();

            System.out.println("Enter your contact number : ");
            contact = input.nextLong();

            // HERE WE CALLING THE SHOW BOOK METHOD
            showbooks();
        }
        else {
            System.out.println("Standard mismatch.");
        }

    }
    void show_choices()
    {
        System.out.println("\n<--- choose any one :" +
                "\n1. Issue books." +
                "\n2. Return book." +
                "\n3. Add book." +
                "\n4. Exit from library.");

        System.out.println("\nEnter your choice :");
        choice = input.nextInt();

        if (choice==1)
        {
            issuebooks();
        }
        else if (choice==2)
        {
            returnbooks();
        }
        else if (choice==3)
        {
            addbooks();
        }
        else
        {
            return;
        }
    }

    void showbooks() // this function is used to show the details of the library.
    {

        System.out.println("\n<--- SOME INTERESTING BOOKS AVAILABLE IN LIBRARY IS ---> ");

        ll.add("\n1. Brave New World ( Aldous huxley");
        ll.add("\n2. When Worlds Collide ( Edwin Balmer & Philip Wylie");
        ll.add("\n3. Earth Abides ( George R. Stewart )");
        ll.add("\n4. And Then There Were None ( Agatha Christie )");
        ll.add("\n5. The Big Sleep ( Raymond Chandler )");
        ll.add("\n6. The Postman Always Rings Twice ( James M. Cain )");
        ll.add("\n7. Anatomy of a Murder ( Robert Traver )");

        System.out.println(ll);

        show_choices();

    }

    void issuebooks() // this is used when anyone wants to issue any book.
    {
        Scanner scan2str = new Scanner(System.in);
        // System.out.println("issue Book is working properly");
        System.out.println("Which book do you want to issue :");
        book_name = scan2str.nextLine();

        System.out.println("For how many days you want this book :");
        iss_time = input.nextInt();

        System.out.println("Are you want to buys this book permanently or on rent for some days : ( buy/ rent )");
        choice2 = scan2str.nextLine();

        if(choice2.equals("buy"))
        {
            System.out.println("pay amount = "+payment);
            payment = input.nextInt();
            if(payment == 300)
            {
                System.out.println("payment done." +
                        "\nThank you for visiting library.");
            }
            else
            {
                System.out.println("error.");
            }
        }
        else if(choice2.equals("rent"))
        {
            System.out.println("Please pay the rent fee :"+rent);
            rent = input.nextInt();
            if (rent == 50)
            {
                System.out.println("Ok, you can take this book from the library.");
            }
            else
            {
                System.out.println("error.");
            }
        }
        else
        {
            return;
        }
        show_choices();
    }

    void returnbooks() // this is used for returning any books
    {
        Scanner scanstr = new Scanner(System.in);
        //  System.out.println("return books is working properly");
        System.out.println("What is your name :");
        name1 = scanstr.nextLine();

        System.out.println("Enter your class :");
        std0 = input.nextInt();

        System.out.println("Enter your roll number :");
        roll_no1 = input.nextInt();

        if (name.equals(name1)  && std == std0 && roll_no == roll_no1)
        {
            System.out.println("which book do you wants to return :");
            ll.remove(scanstr.nextLine());

            System.out.println("Ok, thank you for returning this book. ");
        }
        else
        {
            System.out.println("Sorry, Not valid details");
        }
        show_choices();
    }

    void addbooks() // this is the last function used when any student want to give their book for library
    {
        Scanner gets = new Scanner(System.in);

        System.out.println("Enter the name of book you want to add :");
        for (i=0; i<1; i++)
        {
            ll.addLast(gets.nextLine());
        }
        System.out.println("Book is added.\n\n");

        for (i=0; i<ll.toArray().length; i++)
        {
            System.out.println(i+1 +". "+ll.get(i));
        }
        show_choices();
    }
}


class library
{
    public static void main(String[] args) {
        code ob = new code();
        ob.stu_details();

    }
}