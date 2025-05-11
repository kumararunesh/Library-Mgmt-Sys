package com.example.springdatajdbcDemo1.mainapplication;

import com.example.springdatajdbcDemo1.dao.BookDao;
import com.example.springdatajdbcDemo1.dao.IssueBookDao;
import com.example.springdatajdbcDemo1.dao.UserDao;
import com.example.springdatajdbcDemo1.entity.Book;
import com.example.springdatajdbcDemo1.entity.IssueBook;
import com.example.springdatajdbcDemo1.entity.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Scanner;

@Component
public class CliApp implements CommandLineRunner {

    private BookDao bookDao;
    private IssueBookDao issueBookDao;
    private UserDao userDao;

    public CliApp(BookDao bookDao, IssueBookDao issueBookDao, UserDao userDao) {
        this.bookDao = bookDao;
        this.issueBookDao = issueBookDao;
        this.userDao = userDao;
    }

    @Override
    public void run(String... args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        int choice;
       do{
           System.out.println("================================");
           System.out.println("Library Management Application");
           System.out.println("Select a choice");
           System.out.println("1 .Issue a book");
           System.out.println("2.Return a book");
           System.out.println("3.See all the users ");
           System.out.println("4.See all books");
           System.out.println("20-  Exit");
            choice = scanner.nextInt();
           switch (choice){
               case 1:
                   issueBook();

                   break;
               case 2:
                   returnBook();
                   break;
               case 3:
                   List<User> allUsers = userDao.getAllUsers();
                   allUsers.forEach(System.out::println);
                   break;
               case 4:
                   List<Book> allBooks = bookDao.getAllBooks();
                   allBooks.forEach(System.out::println);
                   break;

           }

       }while(choice!=20);


    }

    public void issueBook()
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter book id to be issued");
        long bookId = scanner.nextLong();
        System.out.println("Enter User Id to be issued ");
        long userId = scanner.nextLong();
        Book book = bookDao.getBookById(bookId);
        if(!book.isAvailable())
        {
            System.out.println("Book is not available to be issued");
            return;
        }
        System.out.println("Enter no. of days to issue");
        int issueDays = scanner.nextInt();

        LocalDate issuedDate = LocalDate.now();
        LocalDate expectedSubmitDate = issuedDate.plusDays(issueDays);
        double totalFee = book.getPricePerDay()*issueDays;
        //        public IssueBook(long bookId, long userId, LocalDate issuedDate,
//            java.time.LocalDate expectedSubmitDate, java.time.LocalDate actualSubmitDate,
//        int issueDays, double totalFee, double totalPenalty, boolean returned)
        long issueId = issueBookDao.saveIssueBook(new IssueBook(bookId,userId,issuedDate,expectedSubmitDate,
                expectedSubmitDate,issueDays,totalFee,0,false));

        System.out.println("your issue id is "+ issueId);

        book.setAvailable(false);
        bookDao.updateBook(bookId,book);

    }

    public void returnBook()
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter issueId");
        int issueId = scanner .nextInt();
        scanner.nextLine();
        System.out.println("Enter date (yyyy-MM-dd): ");
        String input = scanner.nextLine();

        LocalDate submitDate = LocalDate.parse(input); // Assumes correct format
        System.out.println("You entered: " + submitDate);

        IssueBook issueBook = issueBookDao.getIssueBook(issueId);
        LocalDate issuedDate = issueBook.getIssuedDate();
        long actualIssuedDays = ChronoUnit.DAYS.between(issuedDate,submitDate);
        long issuedDays =issueBook.getIssueDays();
        long bookId = issueBook.getBookId();
        double pricePerDay = bookDao.getBookById(bookId).getPricePerDay();
        double penaltyPeDay = bookDao.getBookById(bookId).getPenaltyPerDay();
        double totalFee;
        if(actualIssuedDays<=issuedDays)
        {
             totalFee = actualIssuedDays*pricePerDay;
            System.out.println("you are returning before or on submit date "+issueBook.getExpectedSubmitDate());
            System.out.println("Days book issued for :" + actualIssuedDays);
            System.out.println("Please Pay :" + totalFee);

            issueBook.setTotalFee(totalFee);
        }
        else
        {
            long penaltyDays = actualIssuedDays-issuedDays;
            totalFee = issuedDays*pricePerDay + penaltyDays*penaltyPeDay;
            System.out.println("You were supposed to return the book on :" +issueBook.getExpectedSubmitDate());
            System.out.println("Days book is issued for "+ actualIssuedDays);
            System.out.println("Please pay "+ totalFee +"which has penalty of "+penaltyDays*penaltyPeDay) ;
            issueBook.setTotalPenalty(penaltyDays*penaltyPeDay);

    }

        issueBook.setReturned(true);
        issueBook.setIssueDays((int)actualIssuedDays);
        issueBook.setActualSubmitDate(submitDate);

        issueBookDao.returnedBook(issueId,issueBook);
        System.out.println("Db updasSFVSDCDSted");
    }

}
