package FileSystem;


public class File {
    private String fileType;
    private String path;
    private String mdate;
    private String size;
    private int state;

    public File(String fileType, String path, String mdate, String size){
        this.fileType = fileType;
        this.path = path;
        this.mdate = mdate;
        this.size = size;
        this.state = 1;
    }

    public String toString(){
        return "File type : "+this.fileType +"\tPath : "+this.path +"\tmdate : "+this.mdate+"\tsize : "+this.size;
    }

    public int getState(){
        return this.state;
    }

    public void setState(int i){
        this.state = i;
    }

}
