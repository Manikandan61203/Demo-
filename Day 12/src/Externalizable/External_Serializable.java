package Externalizable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class External_Serializable {
    public static void main(String[] args) {
        External_Serializable sd = new External_Serializable();
        sd.Serial();
        sd.DeSerial();
    }
    public void Serial() {
        ObjectOutputStream oos = null;
        try {
            ExampleObject eo = new ExampleObject("Manikandan", 56);
            oos = new ObjectOutputStream(new FileOutputStream("C:\\Java  Backend\\Day 12\\src\\Externalizable\\Example.txt"));
            oos.writeObject(eo);
            System.out.println("Objects are Successfully Serialized");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (oos != null)
                    oos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public void DeSerial() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("C:\\Java  Backend\\Day 12\\src\\Externalizable\\Example.txt"));
            ExampleObject eo = (ExampleObject) ois.readObject();
            System.out.println("Objects are Successfully DeSerialized");
            System.out.println(eo.getName());
            System.out.println(eo.getId());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (ois != null)
                    ois.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
