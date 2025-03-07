public class ErrorLogProcessor extends LogProcessor{
    public ErrorLogProcessor(LogProcessor nextLogProcessor){
        super(nextLogProcessor);
    }
    public void log(LogTypes logType,String message){
        if(logType == LogTypes.ERROR){
            System.out.println("Error : " + message);
        }else{
            super.log(logType,message);
        }
    }
}
