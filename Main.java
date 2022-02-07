import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        ArrayList<String> part = new ArrayList<>();
        ArrayList<Integer> power = new ArrayList<>();
        ArrayList<Double> sign = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        //String s = sc.next();
        //System.out.println(s);
        String str = sc.next();
        String help = "+";
        for (int i = 0 ; i<str.length() ; i++){
            if(str.charAt(i) == '+' || str.charAt(i) == '-'){
                part.add(help);
                help = Character.toString(str.charAt(i));
            }
            else {
                help += Character.toString(str.charAt(i));
            }
        }
        part.add(help);
        for (int i = 0 ; i<part.size() ; i++){
            if(part.get(i).equals("+") || part.get(i).equals("")) {
                part.remove(i);
                i--;
            }
        }
        String signH , powerH ;
        int j;
        int sabet = 0;
        for (int i= 0 ;i<part.size() ; i++){
            signH = "";
            powerH = "";
            if(part.get(i).contains("x")){
                if(part.get(i).contains("^")){
                    for (j = 0 ; part.get(i).charAt(j) != 'x' ; j++){
                        signH += Character.toString(part.get(i).charAt(j));
                    }
                    powerH = part.get(i).substring(j+2 , part.get(i).length());
                }
                else {
                    for (j = 0 ; part.get(i).charAt(j) != 'x' ; j++){
                        signH += Character.toString(part.get(i).charAt(j));
                    }
                    powerH = "1";
                }
                if(signH.equals("+"))
                    signH = "1";
                else if(signH.equals("-"))
                    signH = "-1";
                power.add(Integer.parseInt(powerH));
                sign.add(Double.parseDouble(signH));
            }
            else {
                sabet += Integer.parseInt(part.get(i));
            }
        }
        for (int i = 0; i<sign.size() ; i++){
            for (int k = i+1 ; k<sign.size() ; k++){
                if(power.get(i).equals(power.get(k))){
                    sign.set(i , sign.get(i)+sign.get(k));
                    sign.remove(k);
                    power.remove(k);
                    k--;
                }
            }
        }
        for (int i = 0 ; i<sign.size() ; i++){
            if(sign.get(i).equals(0.0)){
                sign.remove(i);
                power.remove(i);
                i--;
            }
        }
        int h1;
        double h2;
        for (int i = 0 ; i<sign.size();i++){
            for (int k = i+1 ; k<sign.size() ; k++){
                if(power.get(k) > power.get(i)){
                    h1 = power.get(k);
                    power.set(k , power.get(i));
                    power.set(i , h1);
                    h2 = sign.get(k);
                    sign.set(k , sign.get(i));
                    sign.set(i , h2);
                }
            }
        }
        boolean flag = false;
        for (int i = 0 ; i<sign.size() ; i++){
            power.set(i , power.get(i)+1);
            sign.set(i , sign.get(i)/power.get(i));
            if(sign.get(i)>0){
                if (flag)
                    System.out.print("+");
            }
            else {
                System.out.print("-");
                sign.set(i , -sign.get(i));
            }
            if(sign.get(i) != 1.0){
                if (sign.get(i).equals(Math.floor(sign.get(i))))
                    System.out.printf("%.0f",sign.get(i));
                else if(sign.get(i)*10 == Math.floor(sign.get(i)*10))
                    System.out.printf("%.1f",sign.get(i));
                else
                    System.out.printf("%.2f",Math.floor(sign.get(i)*100)/100);
            }
            System.out.print("x^" + power.get(i));
            flag = true;
        }
        if (sabet != 0){
            if (sabet >0){
                if (flag){
                    System.out.print("+");
                }
            }
            else {
                System.out.print("-");
                sabet = -sabet;
            }
            if (sabet != 1){
                System.out.print(sabet);
            }
            System.out.print("x");
        }
    }
}
