package Model;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;



public class Logger {
    //ek file use krenge for logger
    //logs.dat
    List<String> logs;

    public Logger(){
        getLogs();
    }
    
    public addLogic
    
    void getLogs(){
      try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("logs.dat"))){
          logs = (ArrayList<String>)ois.readObject();
      }catch(FileNotFoundException e){
          logs = new ArrayList<>();
      }catch(Exception e){
        e.printStackTrace();
        // System.err.println(e);
      }
    }


                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
}
