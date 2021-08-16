package FileSystem;


import java.util.*;


public class FileSystem {
    
    HashMap<String, Deque<File>> files = new HashMap<>();


    public boolean addFile(String path,File file,int snp){
        file.setState(snp);
       if(files.containsKey(path)){
           if(files.get(path).size() == 1){
                files.get(path).addLast(file);
            }
            else{
                files.get(path).removeFirst();
                files.get(path).peekFirst().setState(1);
                files.get(path).addLast(file);
            }
            
        return true;
       }
       else{
            Deque<File> dq = new LinkedList<>();
            file.setState(snp);
            dq.add(file);
            files.put(path,dq);
            return true;
       }
    }

    public void query(){
        ArrayList<File> deletedFiles = new ArrayList<>(); //storing the deleted files for printing
        ArrayList<File> newFiles = new ArrayList<>(); //storing the new files for printing
        ArrayList<File> changedFiles = new ArrayList<>(); //storing the change file for printing

        for(Map.Entry<String, Deque<File>> entry : files.entrySet()){
            Deque<File> fileStates = entry.getValue();

            if(fileStates.size() == 1){
                //if only 1 file is present check to which snapshot it belongs to
                //if it belongs to snap1, its deleted will be
                //if it beongs to snap2 its added 

                int snap = fileStates.peekLast().getState();
                if(snap==1){
                    deletedFiles.add(fileStates.peekLast());
                }
                else if(snap==2){
                    newFiles.add(fileStates.peekLast());
                }
            }
            else{
                changedFiles.add(fileStates.peekFirst());
                changedFiles.add(fileStates.peekLast());
            }
        }

        showDeletes(deletedFiles);
        showChangedFiles(changedFiles);
        showAddedFiles(newFiles);
    }
    //printing the file metadata
    public void showDeletes(ArrayList<File> files){
        System.out.println("DELETED FILES");
        for(File f:files){
            System.out.println(f);
        }
    }

    public void showChangedFiles(ArrayList<File> files){
        System.out.println("CHANGED FILES");
        for(int i=0;i<files.size();i+=2){
            System.out.print("OLD : ");
            System.out.println(files.get(i));
            System.out.print("NEW  : ");
            System.out.println(files.get(i+1));
        }
    }
    
    public void showAddedFiles(ArrayList<File> files){
        System.out.println("ADDED FILES");
        for(File f:files){
            System.out.println(f);
        }
    }


}
