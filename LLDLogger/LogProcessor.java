public abstract class LogProcessor {
  private LogProcessor nextLogProcessor;
  public LogProcessor(LogProcessor nextLogProcessor){
      this.nextLogProcessor = nextLogProcessor;
  }
  public void log(LogTypes logType,String message){
      if(nextLogProcessor != null){
          nextLogProcessor.log(logType,message);
      }
  };
}
