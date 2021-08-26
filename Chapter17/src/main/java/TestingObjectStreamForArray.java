import java.io.*;
public class TestingObjectStreamForArray {
    public static void main (String args []) throws IOException, ClassNotFoundException{
        int [] numbers = {1,2,3,4,5};
        String [] strings = {"Juan", "Sra", "asdf", "pepe"};

        try(ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("array.dat", true));
        ){
            // writing the array to the object output stream
            output.writeObject(numbers);
            output.writeObject(strings);
        }

        try(
                ObjectInputStream input = new ObjectInputStream(new FileInputStream("array.dat"));
                ){
            int [] newNumbers = (int[])(input.readObject());
            String [] newStrings = (String[])(input.readObject());

            // display the array
            for(int i = 0; i < newNumbers.length; i++){
                System.out.println(newNumbers[i] + " ");
            }
            System.out.println();
            for(int i = 0; i < newStrings.length; i++){
                System.out.println(newStrings[i] + " ");
            }
            System.out.println();

        }
    }
}
