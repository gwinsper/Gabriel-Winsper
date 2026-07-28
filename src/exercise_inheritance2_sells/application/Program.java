package exercise_inheritance2_sells.application;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.Locale;
import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;

import exercise_inheritance2_sells.entities.UsedProduct;
import exercise_inheritance2_sells.entities.Product;
import exercise_inheritance2_sells.entities.ImportedProduct;

public class Program {
public static void main(String[]args){

    Scanner sc = new Scanner(System.in);
    Locale.setDefault(Locale.US);

    List <Product> list= new ArrayList<>();

    System.out.print("Enter the number of products: ");
    int n = sc.nextInt();

    for(int i=1; i<=n; i++){
        System.out.println("Product #"+i+" data:");
        System.out.print("Common, used or imported (c/u/i)? ");
        char ch = sc.next().charAt(0);
        sc.nextLine();
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Price: ");
        double price = sc.nextDouble();

        if( ch == 'c'){
            list.add(new Product(name,price));
        }
         else if (ch =='u'){
            System.out.print("Data de fabricação (DD/MM/YYYY): ");
            LocalDate date = LocalDate.parse(sc.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            list.add(new UsedProduct(name,price,date));
        }
       else{
           System.out.print("Taxa de importacao: ");
           double customsFee = sc.nextDouble();
           list.add(new ImportedProduct(name,price,customsFee));

        }
    }

    System.out.println();
    System.out.println("ETIQUETAS DE PRECO: ");
    for(Product prod : list){
        System.out.println(prod.priceTag());
    }





}


}
