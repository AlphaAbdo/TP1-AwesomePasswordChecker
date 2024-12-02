package AwesomePasswordChecker;

import fr.isima.codereview.tp1.*;
import java.io.File;


public class App 
{
    public static void main( String[] args )
    {
        AwesomePasswordChecker tmp_instance = null;
        try {
            tmp_instance = AwesomePasswordChecker.getInstance( new File("src/main/resources/cluster_centers_HAC_aff.csv"));
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        String passwoString = "Hello! World°02lk!;:487";
        String MD5_hash = AwesomePasswordChecker.ComputeMD5("Hello World");
        double distance_TEST = tmp_instance.getDistance(passwoString);
        System.out.printf("MD5 hash: %s\nDistance: "+ "<%f> \n", MD5_hash, distance_TEST);
        //AwesomePasswordChecker.getInstance( new File("/mnt/d/DualShared/ZZ2/code-Review/CodeReview/TP/TP1-BeautifyThatCode/ai-checkpassword/cluster_centers_HAC_aff.csv") );
        System.out.println( "Hello Worldss!" );
    }
}
