import java.io.File;
import java.io.FileWriter; 
import java.io.IOException;
import java.io.FileNotFoundException; 
import java.util.Scanner;

public class TextEditor {

    public void createFile(String fileName) {
        try {  
            File f = new File(fileName);   
            if (f.createNewFile()) {  
                System.out.println("File " + f.getName() + " is created successfully.");  
            } else {  
                System.out.println("File already exists in the directory.");  
            }  
          } catch (IOException exception) {  
                System.out.println("An unexpected error has occurred.");  
                exception.printStackTrace();  
       }
    }

    public void openFile(String fileName) {
        try {    
            File f = new File(fileName);    
            Scanner dataReader = new Scanner(f);  
            while (dataReader.hasNextLine()) {  
                String fileData = dataReader.nextLine();  
                System.out.println(fileData);  
            }  
            dataReader.close();  
        } catch (FileNotFoundException exception) {  
            System.out.println("Unexcpected error occurred!");  
            exception.printStackTrace();  
        } 
    }

    public void saveFile(String fileName, String fileContent) {
        try {  
            FileWriter fwrite = new FileWriter(fileName);   
            fwrite.write(fileContent);    
            fwrite.close();   
            System.out.println("Content is successfully wrote to the file.");  
        } catch (IOException e) {  
            System.out.println("Unexpected error occurred");  
            e.printStackTrace();  
        }
    }
    public void copyFile(String sourceFileName,String destinationFileName) {
        try { 
            File f = new File(sourceFileName);    
            Scanner dataReader = new Scanner(f);  
            while (dataReader.hasNextLine()) {  
                String fileData = dataReader.nextLine();
                FileWriter fwrite = new FileWriter(destinationFileName);   
                fwrite.write(fileData);    
                fwrite.close();       
            } 
            System.out.println("Content is successfully copied.");
            dataReader.close();
        } catch  (Exception exception) {
            System.out.println("Unexcpected error occurred!");  
            exception.printStackTrace(); 
        }
    }

    public static void main (String[]args) {
         TextEditor obj = new TextEditor();
         Scanner sc = new Scanner(System.in);
         boolean trigger=true;
         while(trigger) {
            System.out.println("Press 1 to create new file\nPress 2 to open file\nPress 3 to save file\nPress 4 to copy file");
            int option = Integer.parseInt(sc.nextLine());
            if (option==1){
                System.out.println("Name of file?");
                String fileName = sc.nextLine();
                obj.createFile(fileName);
            } else if (option==2){
                System.out.println("Name of file?");
                String fileName = sc.nextLine();
                obj.openFile(fileName);
            } else if (option==3){
                System.out.println("Name of file?");
                String fileName = sc.nextLine();
                System.out.println("Content of file?");
                String fileContent = sc.nextLine();
                obj.saveFile(fileName,fileContent);
            } else if (option==4){
                System.out.println("Name of file to be copied from?");
                String sourceFileName = sc.nextLine();
                System.out.println("Name of file to be pasted to?");
                String destinationFileName = sc.nextLine();
                obj.copyFile(sourceFileName,destinationFileName);
            }
            System.out.println("Press 1 to continue program\nPress 2 to exit program");
            option = Integer.parseInt(sc.nextLine());
            if (option==2){
                trigger = false;
            }
        }
        sc.close();
    }
}