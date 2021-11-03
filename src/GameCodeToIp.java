
import java.net.InetAddress;
import java.net.UnknownHostException;

public class GameCodeToIp{
    final static String[] allLetersinOrder = {"N","A","B","C","D","E","F","G","H","I","J","K","L","M","O","P","Q","R","S","T","U","V","W","X","Y","Z"};//the list of all letters in the order that they will be assigned
    public GameCodeToIp(){

    }
    public static InetAddress convertoInet(String input) {
        String finalString = "";
        String[] splitchars = input.split("");//splits the string into single characters

        int numberofchars = 0;
        while (numberofchars < (splitchars.length)) {//just checks if there is

            if (!splitchars[numberofchars].matches("^-?\\d+$")) {//this just checks if it not a number but instead a letter

                //stuff for the following loop
                boolean wronganswe = true;
                int n = 0;

                while (wronganswe) {
                    // this is there to prevent infinite loops and other problems
                    if (n >= 26) {
                        System.out.println("there seems to be an Error");
                        break;
                        // just skip to the next number
                        }
                        //it is the correct letter
                    if (allLetersinOrder[n].matches(splitchars[numberofchars])) {
                        finalString = finalString + n + splitchars[numberofchars + 1] + ".";//just adds everything to the final string
                        wronganswe = false;
                    } else {
                        n++;
                    }
                }
            }
            numberofchars++;
        }
        //final everything
        finalString = finalString.substring(0, finalString.length() -1);//just removes the last dot at the end of sentence
        try {
            return InetAddress.getByName(finalString);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        //this should not be triggered, but I still have to be here because I have a try catch statement because there is a possibility for there to be nothing
        return null;
    }


}
