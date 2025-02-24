package Model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
//file etc mein updates yehi banda karega

public class TaskHandler {
   Logger logger;
   List<Task> taskList;

   public TaskHandler(Logger logger){
       this.logger = logger;
       getTasks();
   };

   public void addTask(Task task){
     taskList.add(task);
     //call logger
     updateFile();

   };

   public void modifyTask(int index,Task task){


    updateFile();
   }

   public Boolean removeTask(int index){
       taskList.remove(index);
       //call the logger for object removal
       //update the local file
       updateFile();
       return true;
   };

   public boolean taskComplete(int index){
    //update the task 
    taskList.get(index).setComplete();

    taskList.remove(index);
    //call the logger for task completion
    //update the local file
      updateFile();
       return true;
   };

    public void updateFile(){
    ///use the serializaton here
     try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("tasks.dat"))){
        oos.writeObject(taskList);
     }catch(Exception e){
        System.err.println(e);
     }
   };

    public void getTasks(){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("tasks.dat"))){
           taskList = (ArrayList<Task>)ois.readObject();
        }catch(FileNotFoundException f){
          taskList = new ArrayList<>();
        }catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            // return;
        }
    }

}
