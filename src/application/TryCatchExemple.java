package application;
import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatchExemple {
public static void main(String[]args) {

    Scanner sc = new Scanner(System.in);

    try{
        String[] vect = sc.nextLine().split(" ");
        int position = sc.nextInt();
        System.out.println(vect[position]);
    }
    catch(ArrayIndexOutOfBoundsException e){
        System.out.println("Invalid Position");
    }
    catch(InputMismatchException e){
        System.out.println("Input error");
    }
    finally {
        System.out.println("End of the program");
    }




    sc.close();
}

}
