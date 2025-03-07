import java.util.*;

public class Directory implements FileComponent{
    private String directoryName;
    public Map<String,FileComponent> subdir;
    public Directory(String directoryName){
        this.directoryName = directoryName;
        subdir = new HashMap<>();
    }
    public void add(FileComponent fileComponent){
        subdir.put(fileComponent.getName(),fileComponent);
    }

    public FileComponent getFile(String fileName){
        if(subdir.containsKey(fileName))return subdir.get(fileName);
        return null;
    }
    public String getName(){
        return directoryName;
    }
    @Override
    public FileComponent getChild(String fileName){
        if(subdir.containsKey(fileName))return subdir.get(fileName);
        return null;
    }
}
