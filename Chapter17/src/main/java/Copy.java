import java.io.*;

public class Copy {
    /*
        Main method
        @param args[0] source file
               args[1] target file
     */

    public static void main(String [] args) throws IOException{
       // check command line parameter usage
       if(args.length != 2){
           System.out.println( "Usage: java Copy sourceFile targetFile");
           System.exit(1);
       }

       // check if source file exists
        File sourceFile = new File(args[0]);
       if(!sourceFile.exists()){
           System.out.println("Source file " + args[0] + " " +
                   "does not exist");
           System.exit(2);
       }

        // Check if target file exists
        File targetFile = new File(args[1]);
        if(targetFile.exists()){
            System.out.println("Target file " + args[1] + " already exists");
            System.exit(3);
        }

        try(
                BufferedInputStream input = new BufferedInputStream(new FileInputStream(sourceFile));

                BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(targetFile));
                ){
            // continuously read a byte from input and write it to output
            int r, numberOfBytesCopied = 0;
            while((r = input.read()) != -1){
                output.write((byte)r);
                numberOfBytesCopied++;
            }
            System.out.println(numberOfBytesCopied + " bytes copied");
        }

    }
}
