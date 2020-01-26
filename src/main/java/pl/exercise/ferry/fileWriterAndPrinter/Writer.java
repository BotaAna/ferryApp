package pl.exercise.ferry.fileWriterAndPrinter;

import pl.exercise.ferry.Basket;
import pl.exercise.ferry.ticket.Ticket;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Writer { //serializer

    List<Ticket> tickets = Basket.INSTANCE.listOfTickets();
    List<String> namesOfFiles = new ArrayList<>();

    public void writeToFile(List<String> lines, String nameOfFile) throws IOException {
        File file = new File("D:/Java-programowanie 2/projekty/Baza/" + nameOfFile);
        if(!file.exists()){
            file.createNewFile();
        }
        FileWriter zapis = new FileWriter("D:/Java-programowanie 2/projekty/Baza/" + nameOfFile);
        for (Ticket ticket : tickets) {
            String ticketInfo = ticket.ownerData() + "," + ticket.getType() + "," + ticket.getSubType() + ","
                    + ticket.getPrice() + "," + Basket.INSTANCE.getBalance()+";";
            zapis.write(ticketInfo);
        }
        zapis.close();
        namesOfFiles.add(nameOfFile);
    }
}

