import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
public class TestingFileStream {
    public static void main(String [] args) throws IOException{
        try(    // this style is used to automatically close the output ...this is known as try with resources
                FileOutputStream output = new FileOutputStream("temp.dat");
                ){
            // output values to the file we created/overwrite above
            for(int i = 0; i <= 10; i++)
                output.write(i);
        }

        // now we do a try with resources for the input file
        try(
                FileInputStream input = new FileInputStream("temp.dat");
                ){
            // read the values from the file
            int value;
            while((value = input.read()) != -1)
                System.out.print(value + " ");
        }

    }
}
