

public class Duration implements Comparable<Duration> {

    private int hours, minutes, seconds;    // remember, these are CLASS ATTRIBUTES (also known as MEMBER VARIABLES)

    private Duration()
    {
        hours = 1;
        minutes = 1;
        seconds = 1;
    }
    // ^^^ This is a "default constructor" or "no-argument constructor" It creates
    // a Duration object with preset default values

    public Duration(int hours, int minutes, int seconds)
    {   //             ^ these are ARGUMENTS inside the brackets. They are the same names as the CLASS ATTRIBUTES so we use THIS to diffrentiate between them
        // Now the constructor can set initial values for the attribute
        this.hours = hours;
        this.minutes = minutes;
        this.seconds = seconds;
    }
    // ^^^This is a "parameterized constructor" It lets you create
    // a Duration object with specific values that you choose, like: Duration Track1 = new Duration(02,24,50);
    // This is the one essential one for us

    public Duration(String DurationAsString)
    {
        String[] parts = DurationAsString.split(":");
        this.hours = Integer.parseInt(parts[0]);
        this.minutes = Integer.parseInt(parts[1]);
        this.seconds = Integer.parseInt(parts[2]);
    };

    public int getHours()
    {
        return hours;
    }
    public int getMinutes()
    {
        return minutes;
    }
    public int getSeconds()
    {
        return seconds;
    }
    // I dont think these are necessary now as were using the compareTo interface to return


    @Override
    public String toString()
    {
         return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

    @Override
    public int compareTo(Duration o)
    {
        int thisTotalseconds = ((this.hours * 3600) + (this.minutes * 60) + this.seconds);
        int oTotalseconds = ((o.hours * 3600) + (o.minutes * 60) + o.seconds);

        return thisTotalseconds - oTotalseconds;

       // couldn't get it to work this way :( , but i guess its not necessary anyway.
       // if( thisTotalseconds - oTotalseconds < 0)
       // {
       //    return oTotalseconds;
       // }
       // else
       // {
       //     return thisTotalseconds;
       // }

    }
}
