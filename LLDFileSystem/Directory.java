import java.util.List;
import java.util.ArrayList;

public class Directory implements FileComponent{
    private String directoryName;
    private List<FileComponent> subdir;
    public Directory(String directoryName){
        this.directoryName = directoryName;
        subdir = new ArrayList<>();
    }
    public void add(FileComponent fileComponent){
        subdir.add(fileComponent);
    }
    @Override
    public void ls(){
        System.out.println("Directory Name : " + directoryName);

        for(FileComponent fileComponent : subdir){
            fileComponent.ls();
        }
    }
}
