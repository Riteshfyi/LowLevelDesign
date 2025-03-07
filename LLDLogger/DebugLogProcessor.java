public class DebugLogProcessor extends LogProcessor{
    public DebugLogProcessor(LogProcessor nextLogProcessor){
        super(nextLogProcessor);
    }
    public void log(LogTypes logType,String message){
        if(logType == LogTypes.DEBUG){
            System.out.println("Debug : " + message);
        }else{
            super.log(logType,message);
        }
    }
}
