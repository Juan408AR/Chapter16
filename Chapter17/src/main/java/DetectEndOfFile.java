import java.io.*;

public class DetectEndOfFile {
    public static void main(String [] args) throws IOException{
        try{
            try(DataOutputStream output = new DataOutputStream(new FileOutputStream("test.dat"))){
                output.writeDouble(4.5);
                output.writeDouble(54.25);
                output.writeDouble(2.3);

            }

            try(DataInputStream input =
                    new DataInputStream(new FileInputStream("test.dat"))){
                while(true)
                    System.out.println(input.readDouble());
            }
        }catch(EOFException ex){
            System.out.println("All data were read");
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
