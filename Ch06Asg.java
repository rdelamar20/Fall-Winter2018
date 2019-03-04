/*Ryan Delamar
CIS117 Section 2227
02/01/2019

Drag Race Simulator

   In this program we were asked to simulate a drag race by using a class in java a long with multiple methods within
   the class itself in order to collect and output data in a table style format. The program includes in-line validation
   and uses public getters and setters within the class to create a fully encapsulated and easy to edit code layout.

   */


import java.lang.reflect.Array;
import java.util.Scanner;

public class Ch06Asg {

    public static void main (String[] args){

        Scanner input = new Scanner(System.in);

            Dragster car1 = new Dragster ();
            Dragster car2 = new Dragster ();
            Dragster car3 = new Dragster ();

        System.out.println("Please enter car color for dragster #1");
        String answer = input.next();
        car1.setcolor(answer);

        System.out.println("Please enter car name for dragster #1");
        answer = input.next();
        car1.setname(answer);

        System.out.println("Please enter horsepower for dragster #1");
        double answerdouble = input.nextDouble();
        car1.sethp(answerdouble);

        System.out.println("Please enter rpm for dragster #1");
        int answerint = input.nextInt();
        car1.setrpm(answerint);

        System.out.println("Please enter weight for dragster #1");
        answerdouble = input.nextDouble();
        car1.setweight(answerdouble);

        System.out.println("Please enter Wheel Diameter for dragster #1");
        answerdouble = input.nextDouble();
        car1.setWheel_diameter(answerdouble);

        System.out.println("Please enter car color for dragster #2");
        answer = input.next();
        car2.setcolor(answer);

        System.out.println("Please enter car name for dragster #2");
        answer = input.next();
        car2.setname(answer);

        System.out.println("Please enter horsepower for dragster #2");
        answerdouble = input.nextDouble();
        car2.sethp(answerdouble);

        System.out.println("Please enter rpm for dragster #2");
        answerint = input.nextInt();
        car2.setrpm(answerint);

        System.out.println("Please enter weight for dragster #2");
        answerdouble = input.nextDouble();
        car2.setweight(answerdouble);

        System.out.println("Please enter Wheel Diameter for dragster #2");
        answerdouble = input.nextDouble();
        car2.setWheel_diameter(answerdouble);

        System.out.println("Please enter car color for dragster #3");
        answer = input.next();
        car3.setcolor(answer);

        System.out.println("Please enter car name for dragster #3");
        answer = input.next();
        car3.setname(answer);

        System.out.println("Please enter horsepower for dragster #3");
        answerdouble = input.nextDouble();
        car3.sethp(answerdouble);

        System.out.println("Please enter rpm for dragster #3");
        answerint = input.nextInt();
        car3.setrpm(answerint);

        System.out.println("Please enter weight for dragster #3");
        answerdouble = input.nextDouble();
        car3.setweight(answerdouble);

        System.out.println("Please enter Wheel Diameter for dragster #3");
        answerdouble = input.nextDouble();
        car3.setWheel_diameter(answerdouble);

        double time = 0;

        while(car1.getDistance() <= 1320) {

            time += 0.5;
            car1.CalculateDistance(time);

        }

        time = 0;
        while(car2.getDistance() <= 1320) {

            time += 0.5;
            car2.CalculateDistance(time);

        }

        time = 0;
        while(car3.getDistance() <= 1320) {

            time += 0.5;
            car3.CalculateDistance(time);

        }

        int highestTime = 0;
        if (car1.getLength() > highestTime) {
            highestTime = car1.getLength();
        }

        if (car2.getLength() > highestTime) {
            highestTime = car2.getLength();
        }

        if (car3.getLength() > highestTime) {
            highestTime = car3.getLength();
        }


        String[] rows = new String[highestTime];

        for(int i = 0; i < highestTime; i++){
            if (i == 0) {
                rows[i] = "Dragster";
            }
            else {
                double g = i;
                rows[i] = Double.toString((.5 * g));
            }

        }


        final Object[][] table = new String[4][highestTime];

        table[0] = rows;

        car1.print(table,1);
        car2.print(table,2);
        car3.print(table,3);

        String formatString = "";
        for(int i= 0; i < highestTime; i++) {
            formatString += "%29s";
        }

        formatString += "\n";


        for (final Object[] row : table) {
            int length = Array.getLength(row);
            if (length < highestTime) {
                Object[] newRow = new String[highestTime];

                System.arraycopy(row, 0, newRow, 0, row.length);

                for(int i = 0; i < newRow.length; i++) {
                    if (i < length - 1) {
                        newRow[i] = row[i];
                    }
                    else {
                        newRow[i] = "";
                    }
                }

                System.out.format(formatString, newRow);
            }
            else {

                System.out.format(formatString, row);
            }
        }



        //Checks for winners
        if (car1.getLength() < car2.getLength() &&  car1.getLength() < car3.getLength()){
            System.out.println(car1.getname()+ " is the winner!");
        }else if (car2.getLength() < car1.getLength() && car2.getLength() < car3.getLength()){
            System.out.println(car2.getname()+ " is the winner!");
        }else if(car3.getLength() < car1.getLength() && car3.getLength() < car2.getLength()){
            System.out.println(car3.getname()+ " is the winner!");
        }else if(car1.getLength() == car2.getLength()){
            System.out.println(car1.getname() + " and " + car2.getname() + " are the winners!");
        }else if (car2.getLength() == car3.getLength()){
            System.out.println(car2.getname() + " and " + car3.getname() + " are the winners!");
        }else if (car1.getLength() == car3.getLength()){
            System.out.println(car1.getname() + " and " + car3.getname() + " are the winners!");
        }else if(car1.getLength() == car2.getLength() && car2.getLength() == car3.getLength()){
            System.out.println("Everyone ties for the win.");
        }

    }

    static class Dragster{

        private String color;
        private String name;
        private double horsepower;
        private int rpm;
        private double weight;
        private double Wheel_diameter;
        int[] array = {0};

        double CalculateDistance(double time){
            double acceleration = 0;
            acceleration = ((horsepower * 169017) / (rpm * weight * (Wheel_diameter/2)));
            double distance = 0.5 * acceleration * time * time;

            int d = (int) distance;

            int[] tmp = new int[array.length + 1];

            System.arraycopy(array, 0, tmp, 0, array.length);

            for(int i = 0; i < tmp.length; i++) {
                if (i < tmp.length - 1) {
                    tmp[i] = array[i];
                }
                else {
                    tmp[i] = d;
                }
            }

            //System.out.println(Arrays.toString(array));
            array = tmp;
            return distance;
        }

        public int getDistance() {
            return array[array.length - 1];
        }

        public int getLength () {

            return array.length;
        }

        public void print (Object[][] table, int row_number) {
//            System.out.println(Arrays.toString(array));

            String[] stringarray = new String[array.length];

           for(int i = 0; i < array.length; i++){
                if (i == 0) {
                    stringarray[i] = this.getcolor() + "(" + this.getname() + ")";
                }
                else {
                    stringarray[i] = Integer.toString(array[i]);
                }

            }

             table[row_number] = stringarray;
        }

        public double gethp(){

            return horsepower;

        }

        public void sethp(double newhp){

            Scanner input = new Scanner(System.in);
            int length = Double.toString(newhp).length();
            if (length > 29) {
                System.out.println("Dragster hp has to be less than 29 Characters! Please re-enter a name");
                newhp = input.nextDouble();
            }else if (newhp <= 0){
                System.out.println("Horsepower cannot be <= 0. Please re-enter.");
                newhp = input.nextDouble();
            }

            else{
                this.horsepower = newhp;
            }

        }

        public int getrpm(){

            return rpm;

        }

        public void setrpm(int newrpm){
            Scanner input = new Scanner(System.in);
            int length = String.valueOf(newrpm).length();

            if (length > 29) {
                System.out.println("Dragster rpm has to be less than 29 Characters! Please re-enter a name");
                newrpm = input.nextInt();
            }else if (newrpm <= 0){
                System.out.println("RPM cannot be <= 0. Please re-enter.");
                newrpm = input.nextInt();
            }

            else{
                this.rpm = newrpm;
            }
        }

        public String getcolor(){

            return color;

        }

        public void setcolor(String newcolor){

            Scanner input = new Scanner(System.in);


            if (newcolor.length() > 29) {
                System.out.println("Dragster color has to be less than 29 Characters! Please re-enter a name");
                newcolor = input.next();
            }else{
                this.color = newcolor;
            }


        }

        public String getname(){

            return name;

        }

        public void setname(String newname){

            Scanner input = new Scanner(System.in);

            if (newname.length() > 29){
                System.out.println("Dragster name has to be less than 29 Characters! Please re-enter a name");
                newname = input.next();
            }else {
                this.name = newname;
            }
        }

        public double getweight(){

            return weight;

        }

        public void setweight(double newweight){

            Scanner input = new Scanner(System.in);
            int length = Double.toString(newweight).length();
            if (length > 29) {
                System.out.println("Dragster weight has to be less than 29 Characters! Please re-enter a name");
                newweight = input.nextDouble();
            } else if (newweight <= 0){
                System.out.println("Vehicle weight cannot <= 0. Please re-enter.");
                newweight = input.nextDouble();
            }

            else{
                this.weight = newweight;
            }


        }

        public double getWheel_diameter(){

            return Wheel_diameter;

        }

        public void setWheel_diameter(double newWheel_diameter){

            Scanner input = new Scanner(System.in);
            int length = Double.toString(newWheel_diameter).length();
            if (length > 29) {
                System.out.println("Dragster wheel diameter has to be less than 29 Characters! Please re-enter a name");
                newWheel_diameter = input.nextDouble();

            } else if (newWheel_diameter <= 0){
                System.out.println("Wheel diameter cannot <= 0. Please re-enter.");
                newWheel_diameter = input.nextDouble();
            }

            else{
                this.Wheel_diameter = newWheel_diameter;
            }

        }
    }

}
