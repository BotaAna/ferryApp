package pl.exercise.ferry.screen;

import pl.exercise.ferry.Basket;
import pl.exercise.ferry.ferryboat.Prom;
import pl.exercise.ferry.fileWriterAndPrinter.Printer;
import pl.exercise.ferry.fileWriterAndPrinter.Writer;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class MainScreen {

  private final Scanner scanner = new Scanner(System.in);

  public void interact() throws IOException {

    System.out.println("Witamy w systemie zakupu biletów. Wybierz akcję: \n"
            + "1 <Kup bilet> \n"
            + "2 <Wyświetl dane> \n"
            + "2a <Wyświetl dane dla konkretnego użytkownika> \n"
            + "3 <Zapisz dane> \n"
            + "4 <Wczytaj zapisane dane> \n"
            + "5 <Pokaż listę promów oraz dostępnego miejsca> \n"
            + "6 <Zakończ sesję> \n"
            + "7 <Wyjdź z programu>");
    String firstResponse = scanner.next();
    if ("1".equalsIgnoreCase(firstResponse)) {
      TicketScreen ticketScreen = new TicketScreen();
      ticketScreen.interact();
    }
    if ("2".equalsIgnoreCase(firstResponse)) {
      DisplayScreen displayScreen = new DisplayScreen();
      displayScreen.display();
      System.out.println();
    }
    if ("2a".equalsIgnoreCase(firstResponse)) {
      DisplayScreen displayScreen = new DisplayScreen();
      displayScreen.displayForSpecificUser();
    }
    if ("3".equalsIgnoreCase(firstResponse)) {
      Writer writer = new Writer();
      System.out.println("Podaj nazwę pliku z rozszerzeniem .txt: ");
      String nameOfFile = scanner.next();
      writer.writeToFile(Basket.INSTANCE.listOfTickets(), nameOfFile);
    }

    if ("4".equalsIgnoreCase(firstResponse)) {
      Printer printer = new Printer();
      printer.readExternalData();
    }

    if ("5".equalsIgnoreCase(firstResponse)) {

      List<Prom> listOfProms = Basket.INSTANCE.getListOfProms();
      for(Prom prom : listOfProms) {
        System.out.println("Prom o nazwie:" + prom.getPromName() + "posiada" + prom.getLeftQuantity());
      }
    }

    if("6".equalsIgnoreCase(firstResponse)) {

      DisplayScreen displayScreen = new DisplayScreen();
      displayScreen.displayFinalData();

//      Writer writer = new Writer();
//      System.out.println("Podaj nazwę pliku z rozszerzeniem .txt: ");
//      String nameOfFile = scanner.next();
//      writer.writeToFile(Basket.INSTANCE.listOfTickets(), nameOfFile);
//      System.out.println("Dziękujemy za wybór naszej firmy. Zapraszamy do zakupu kolejnych biletów. Co chcesz dalej zrobić?");
//      Basket.INSTANCE.listOfTickets().clear();
//      Basket.INSTANCE.setBalance(BigDecimal.ZERO);
//      interact();
//      return;
    }

    if("7".equalsIgnoreCase(firstResponse)) {
      Writer writer = new Writer();
      System.out.println("Podaj nazwę pliku z rozszerzeniem .txt: ");
      String nameOfFile = scanner.next();
      writer.writeToFile(Basket.INSTANCE.listOfTickets(), nameOfFile);
      System.out.println("Dziękujemy za wybór naszej firmy. Zapraszamy ponownie!");
      return;
    }

    else {
      MainScreen mainScreen = new MainScreen();
      mainScreen.interact();
    }
  }
}
