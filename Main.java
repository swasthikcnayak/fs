
import FileSystem.File;
import FileSystem.FileSystem;




public class Main{
   

    
    public static void main(String[] args) {
        
        FileSystem fs = new FileSystem();
        fs.addFile("F://Drive/File1.txt",new File("File","F://Drive/File1.txt","1234","12345"),1);
        fs.addFile("F://TestDrive",new File("Dir","F://Drive","89","112"),1);
        //fs.addFile("F://Drive/File1.txt",new File("Dir","F://Drive/File1.txt","1234","12345"));
        //fs.addFile("F://Drive/File1.txt",new File("Dir","F://Drive/File1.txt","1234","12345"));
        //fs.addFile("F://Drive/File1.txt",new File("Dir","F://Drive/File1.txt","1234","12345"));
        fs.addFile("F://Drive/File1.txt",new File("File","F://Drive/File1.txt","180905012","67821"),2);
        fs.addFile("F://Drive/File1.txt",new File("File","F://Drive/File1.txt","1234","12345"),2);
        fs.addFile("F://NewDir",new File("Dir","F://newDir","69","112"),2);
        fs.query();

    }

}