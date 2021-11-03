package server;
import java.net.InetAddress;
import java.util.regex.Pattern;

public class toGameCode{

    //the list of all characters
    final static String[] allLetersinOrder = {"N","A","B","C","D","E","F","G","H","I","J","K","L","M","O","P","Q","R","S","T","U","V","W","X","Y","Z"};//the list of all letters in the order that they will be assigned

    public static String conversion(InetAddress add){
        //useless print command
        String endGameCode ="";

        //converts the Address objects into a string so that I can use it later also splits it into its own parts
        String theCurrentIpAddressAsString = add.getHostAddress();
        String IpAddressArray[] = theCurrentIpAddressAsString.split(Pattern.quote("."));

        //iterates through every part of the ip and then uses it
        for (String currentInput: IpAddressArray) {

            //takes all the individual numbers and runs them to the second methode
            endGameCode = endGameCode + convertIndividualAddresToWords(currentInput);
        }
        //just there as feedback can be removed
        System.out.println("the final String is : " + endGameCode);//just prints the final game code as a test


        return endGameCode;
    }
    //converts the individual number into a string
    private static String convertIndividualAddresToWords(String partOfTheAddress){
        String finalString = "";
        //takes the number and converts it into a float and divides that float by 10 so that I can separate the first and second part later
        float ogPartofAdd=Float.parseFloat(partOfTheAddress);
        String endAdd = Float.toString(ogPartofAdd/10);//this splits it I could have also used Big number, but I don't need nay of those functions and this should not take that many cpu cycles to convert this back to an int later

        //splitting it into the respective numbers
        String splitVal[] = endAdd.split(Pattern.quote("."));//the first part is the hundred digit and the second part is only the first number
        //I can hardcode the values of the array because I know that they will always be two

        //converts to an Integer and then uses that Integer to get the corresponding letter in the array
        finalString = allLetersinOrder[Integer.parseInt(splitVal[0])];

        //just addes the last number to the string
        finalString = finalString + splitVal[1];//n means that there is no value
        return finalString;

    }
}