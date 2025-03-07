import java.util.ArrayList;
import java.util.Map;
import java.util.List;

public class File implements FileComponent{
    private String fileName;
    private String fileContent;

    public File(String fileName){
        this.fileName = fileName;
        this.fileContent = "";
    }
    public String getName(){
        return fileName;
    }

    public void appendFileContent(String fileContent){
        this.fileContent+=fileContent;
    }
    public void setFileContent(String fileContent){
        this.fileContent = fileContent;
    }
    public String getFileContent(){
        return fileContent;
    }
}
