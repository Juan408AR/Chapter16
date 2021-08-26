import java.io.*;
public class TestObjectOutputStream {
    public static void main(String [] args) throws IOException, ClassNotFoundException{
        try(    // we are creating an outputstream for the object.dat file
                ObjectOutputStream output= new ObjectOutputStream(new FileOutputStream("object.dat"));
                ){
            // we are writing a string,double,object into the file
            output.writeUTF("Juan");
            output.writeDouble(12);
            output.writeObject(new java.util.Date());
        }

        try(
                ObjectInputStream input = new ObjectInputStream(new FileInputStream("object.dat"));
                ){
            System.out.println(input.readUTF() + "\n" +
                    input.readDouble() + "\n" + input.readObject());
        }


    }
}
