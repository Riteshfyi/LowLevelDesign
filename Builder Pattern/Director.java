public class Director {
    private ComputerBuilder computerBuilder;

    public Director(ComputerBuilder computerBuilder){
        this.computerBuilder = computerBuilder;
    }

    public Computer setup(){
        return computerBuilder
        .buildProcessor("i7-7707K")
        .buildMemory(16)
        .buildStorage(512)
        .buildGraphicsCard("GTX-1080Ti")
        .build();
    }
}
