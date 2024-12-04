import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.io.FileReader;
import java.io.BufferedReader;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        ArrayList<Duration> durationStrings = new ArrayList<>();
        
        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("albums.txt"));
            String line;
            while((line = reader.readLine()) != null)
            {
                if (line.contains("-"))
                {
                    String[] trackSection = line.trim().split(" - ", 2);
                    Duration durationstrings = new Duration(trackSection[0]);
                    String trackName = trackSection[1];
                    durationStrings.add(durationstrings);
                }
            }
            reader.close();
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }




        Collections.sort(durationStrings); // this method automatically sorts the arraylist

        //for (Duration orderedlist : durationStrings)     This prints the whole list in order longest to shortest
        //{
        //    System.out.println(orderedlist);
        //}

        Duration longest = durationStrings.get(durationStrings.size()-1);
        // the sorted list is numbered 0 to 3 not 1 to 4 so I guess you need to -1??? I don't get this bit really. Took me ages to get it to work

        System.out.println("\nThe below song is the longest out of the whole album collection (need to get it to save song name)\n\n"
                         +"     Longest (HH:MM:SS) >>> "+ longest);
    }
}

  // It works so far!   but now im struggling to understand how I use FileReader to make an ArrayList of the album.txt data

