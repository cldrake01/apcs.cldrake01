package apcs.playList;

public class PlayListTesterFull {
    public static void main (String args[]) {

        // This runner should fully test the PlayList class, including all
        // valid and exception cases. You can verify whether it tested
        // completely by running this "with code coverage" and seeing if
        // coverage from PlayList is at 100% - you can also see visually
        // whether a line of code was run by looking for the red/green indicators
        // next to the line numbers in PlayList.java

        // most tests will describe the expected output in parentheses next to the task so that you
        // can visually verify that your code is working properly

        /*===============================================*/

        // First, do some setup to allow exceptions to be caught and displayed to the
        // console properly relative to regular console printing:

        System.setErr (System.out);

        // First test VALID cases (exception cases are done later - NONE of these should produce an exception
        // Start by testing default constructor - it should create an empty list

        System.out.println ("Testing Default Constructor and size method");
        PlayList eighties = new PlayList ();
        System.out.print ("size (0): ");
        System.out.println (eighties.size ());

        // test toString for empty list

        System.out.print ("List is (Empty List): ");
        System.out.println (eighties);

        // test add method (add to end)

        System.out.println ("\nTesting add (to the end) and toString: add 4 Songs");

        eighties.add ("Livin' on a Prayer");
        eighties.add ("Don't Stop Believin'");
        eighties.add ("Take on Me");
        eighties.add ("Girls Just Want to Have Fun");
        System.out.println ("size (4): " + eighties.size ());
        System.out.println ("List is (all 4 songs): " + eighties);

        System.out.println ("\nTesting getSong - print songs using loop");

        for (int i = 0; i < eighties.size (); i++) {
            System.out.println ("Song " + i + ": Title: " + eighties.getSong (i));
        }

        System.out.println ("\nTesting play individual songs (display song info and increment playcount)");
        eighties.play (0);
        eighties.play (1);
        eighties.play (2);
        eighties.play (3);

        System.out.println ("\nTesting play entire playlist (all songs should appear with 2 plays each)");
        eighties.play ();

        // test remove

        System.out.print ("\nTesting remove - three cases: last, middle, first\n");
        System.out.println ("\nRemoving the last song (Girls Just Want to Have Fun):");
        eighties.remove (eighties.size () - 1);
        System.out.println ("List is: " + eighties);

        System.out.println ("\nRemoving a middle song (Don't Stop Believin'):");
        eighties.remove (1);
        System.out.println ("List is: " + eighties);

        System.out.println ("\nRemoving the first song (Livin' on a Prayer):");
        eighties.remove (0);
        System.out.println ("List is: " + eighties);

        // test insert

        System.out.print ("\nTesting insert - three cases: last, middle, first\n");
        System.out.println ("\nInserting 'Walk This Way' - verify that it is now the last song:");
        eighties.insert (eighties.size (), "Walk This Way");
        System.out.println ("List is: " + eighties);

        System.out.println ("\nInserting 'Wake Me Up Before You Go-Go' - verify that it is now the second song:");
        eighties.insert (1, "Wake Me Up Before You Go-Go");
        System.out.println ("List is: " + eighties);

        System.out.println ("\nInserting 'What's Love Got to Do With It' - verify that it is now the first song:");
        eighties.insert (0, "What's Love Got to Do With It");
        System.out.println ("List is: " + eighties);

        // test move

        System.out.print ("\nTesting move - move second to third - verify that Wake Me Up Before You Go-Go has moved\n");
        eighties.move (1, 2);
        System.out.println ("List is: " + eighties);
        System.out.print ("\nTesting move - and third back to second (verify that it restores the list)\n");
        eighties.move (1, 2);
        System.out.println ("List is: " + eighties);

        System.out.print ("\nTesting move - move first song to the end - verify that What's Love Got to Do With It is now at the end\n");
        eighties.move (0, 3);
        System.out.println ("List is: " + eighties);
        System.out.print ("\nTesting move - move the end song back to the beginning\n");
        eighties.move (3, 0);
        System.out.println ("List is: " + eighties);

        // test find

        System.out.println ("\nTesting find - locate all songs");
        System.out.println ("What's Love Got to Do With It should be in position (0): "+eighties.find("What's Love Got to Do With It"));
        System.out.println ("Take on Me is in position (1): "+eighties.find("Take on Me"));
        System.out.println ("Wake Me Up Before You Go-Go should be in position (2): "+eighties.find("Wake Me Up Before You Go-Go"));
        System.out.println ("Walk This Way should be in position (3): "+eighties.find("Walk This Way"));
        System.out.println ("\nTesting find - try to locate unknown song");
        System.out.println ("Never Gonna Give You Up is not in the list (-1): "+eighties.find("Never Gonna Give You Up"));

        // test getMostPlayed
        System.out.println ("\nThe most played song is (Take on Me): " + eighties.getMostPlayed ());
        System.out.println ("\nPlaying Walk This Way twice to tie for most played");
        eighties.play(3);
        eighties.play(3);
        System.out.println ("The most played song is a tie (Take on Me, Walk This Way): " + eighties.getMostPlayed ());

        // test rating
        System.out.println ("\nTesting ratings - rate and print");
        eighties.rate (0, 5);
        eighties.rate (1, 4);
        eighties.rate (2, 3);
        eighties.rate (3, 2);
        System.out.println ("List is (should show ratings): " + eighties);
        System.out.println ("The favorite song is (What's Love Got to Do With It): " + eighties.getFavorite());

        System.out.println ("Update rating for Take On Me to form a tie");
        eighties.rate(3, 5);
        System.out.println ("The favorite songs are (What's Love Got to Do With It, Walk This Way): " + eighties.getFavorite());


        /*=========================================*/

        // Now test Exception cases - each one must be wrapped in a try/catch
        System.out.println ("\n\nTesting Exception cases");
        System.out.println ("All tests should result in YOUR Exception message being printed (NOT the default Java message)");


        // test getSong
        try {
            System.out.println ("\nAttempt to get song number -1 (index out bounds exception)");
            eighties.getSong(-1);
        } catch (Exception e) {
            System.out.println ("Error: ");
            e.printStackTrace ();
        }
        try {
            System.out.println ("\nAttempt to get song number 4 (index out bounds exception)");
            eighties.getSong(4);
        } catch (Exception e) {
            System.out.println ("Error: ");
            e.printStackTrace ();
        }
        // test play
        try {
            System.out.println ("\nAttempt to play song number -1 (index out bounds exception)");
            eighties.play(-1);
        } catch (Exception e) {
            System.out.println ("Error: ");
            e.printStackTrace ();
        }
        try {
            System.out.println ("\nAttempt to play number 4 (index out bounds exception)");
            eighties.play(4);
        } catch (Exception e) {
            System.out.println ("Error: ");
            e.printStackTrace ();
        }

        // test remove
        try {
            System.out.println ("\nAttempt to remove song number -1 (index out bounds exception)");
            eighties.remove(-1);
        } catch (Exception e) {
            System.out.println ("Error: ");
            e.printStackTrace ();
        }
        try {
            System.out.println ("\nAttempt to remove song number 4 (index out bounds exception)");
            eighties.remove(4);
        } catch (Exception e) {
            System.out.println ("Error: ");
            e.printStackTrace ();
        }

        // test insert
        try {
            System.out.println ("\nAttempt to insert song number -1 (index out bounds exception)");
            eighties.insert(-1, "Error checking");
        } catch (Exception e) {
            System.out.println ("Error: ");
            e.printStackTrace ();
        }
        try {
            System.out.println ("\nAttempt to play number 5 (index out bounds exception)");
            eighties.insert(5, "Error checking");
        } catch (Exception e) {
            System.out.println ("Error: ");
            e.printStackTrace ();
        }
        // test move
        try {
            System.out.println ("\nAttempt to move song -1 to 2 (index out bounds exception)");
            eighties.move(-1, 2);
        } catch (Exception e) {
            System.out.println ("Error: ");
            e.printStackTrace ();
        }
        try {
            System.out.println ("\nAttempt to move song 2 to -1 (index out bounds exception)");
            eighties.move(2, -1);
        } catch (Exception e) {
            System.out.println ("Error: ");
            e.printStackTrace ();
        }
        try {
            System.out.println ("\nAttempt to move song 2 to 4 (index out bounds exception)");
            eighties.move(2, 4);
        } catch (Exception e) {
            System.out.println ("Error: ");
            e.printStackTrace ();
        }
        try {
            System.out.println ("\nAttempt to move song 4 to 2 (index out bounds exception)");
            eighties.move(4, 2);
        } catch (Exception e) {
            System.out.println ("Error: ");
            e.printStackTrace ();
        }
        // test getMostPlayed

        try {
            System.out.println ("\nAttempt to get most played of empty list");
            PlayList empty = new PlayList();
            empty.getMostPlayed();

        } catch (Exception e) {
            System.out.println ("Error: ");
            e.printStackTrace ();
        }

        // test rate
        try {
            System.out.println ("\nAttempt to rate song number -1 (index out bounds exception)");
            eighties.rate(-1, 5);
        } catch (Exception e) {
            System.out.println ("Error: ");
            e.printStackTrace ();
        }
        try {
            System.out.println ("\nAttempt to rate number 4 (index out bounds exception)");
            eighties.rate(4, 5);
        } catch (Exception e) {
            System.out.println ("Error: ");
            e.printStackTrace ();
        }
        try {
            System.out.println ("\nAttempt to rate song number 2 as 0 (runtime exception)");
            eighties.rate(2, 0);
        } catch (Exception e) {
            System.out.println ("Error: ");
            e.printStackTrace ();
        }
        try {
            System.out.println ("\nAttempt to rate song number 2 as 6 (runtime exception)");
            eighties.rate(2, 6);
        } catch (Exception e) {
            System.out.println ("Error: ");
            e.printStackTrace ();
        }

    }

}



