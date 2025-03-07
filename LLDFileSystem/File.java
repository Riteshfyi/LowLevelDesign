public class File implements FileComponent{
    private String fileName;
    public File(String fileName){
        this.fileName = fileName;
    }
    @Override
    public void ls(){
        System.out.println("File : " + fileName);
    }
}
