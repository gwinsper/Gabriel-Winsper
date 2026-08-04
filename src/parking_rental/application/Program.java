package parking_rental.application;
import parking_rental.entities.CarRental;
import parking_rental.entities.Vehicle;
import parking_rental.services.BrazilTaxService;
import parking_rental.services.RentalService;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.Locale;

public class Program {

    public static void main(String[]args){

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

      System.out.println("Entre com os dados de aluguel");
      System.out.print("Modalo do carro: ");
      String carModel = sc.nextLine();
      System.out.print("Retirada (dd/MM/yyyy hh:mm): ");
      LocalDateTime start = LocalDateTime.parse(sc.nextLine(),fmt);
      System.out.print("Retorno (dd/MM/yyyy hh:mm): ");
      LocalDateTime finish = LocalDateTime.parse(sc.nextLine(),fmt);

      CarRental cr = new CarRental(start,finish,new Vehicle(carModel));

      System.out.print("Entre com o preço por hora: ");
      double pricePerHour = sc.nextDouble();
      System.out.print("Entre com o preço por dia: ");
      double pricePerDay = sc.nextDouble();

        RentalService rentalService = new RentalService(pricePerHour,pricePerDay,new BrazilTaxService());

        rentalService.processInvoice(cr);

        System.out.println("FATURA:");
        System.out.println("Pagamento Basico:"+String.format("%.2f",cr.getInvoice().getBasicPayment()));
        System.out.println("Imposto: "+ String.format("%.2f",cr.getInvoice().getTax()));
        System.out.println("Pagamento total: "+ String.format("%.2f",cr.getInvoice().getTotalPayment()));




        sc.close();
    }

}
