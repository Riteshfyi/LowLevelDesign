public class InfoLogProcessor extends LogProcessor{
    public InfoLogProcessor(LogProcessor nextLogProcessor){
        super(nextLogProcessor);
    }
    public void log(LogTypes logType,String message){
        if(logType == LogTypes.INFO){
            System.out.println("Info : " + message);
        }else{
            super.log(logType,message);
        }
    }
}
