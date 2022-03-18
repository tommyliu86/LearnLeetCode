package nowcoder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 *
 * @author: liuwenfei14
 * @date: 2022-02-12 10:50
 */
public class Main {


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();

        while (scan.hasNext()) {
            String s = scan.nextLine();
            inputs.add(s);
        }

    }
    public static void main1(String args[]) {
        StringBuffer s = new StringBuffer("Hello");
        if ((s.length() > 5) && (s.append("there").equals("False"))) ;

        System.out.println("value is " + s);
    }

}
