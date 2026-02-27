package Listeners;

import org.testng.IExecutionListener;
public class Log4jSetupListener implements IExecutionListener{
// This method runs once BEFORE entire test execution starts
@Override
public void onExecutionStart() {
// TODO Auto-generated method stub
IExecutionListener.super.onExecutionStart();
// Setting system property to tell log4j where config file is located user.dir = current project directory
System.setProperty(
"log4j.configurationFile",
System.getProperty("user.dir") + "/resources/log4j2.xml");
// Just for confirmation in console
System.out.println("Log4j initialized from: " + System.getProperty("user.dir") +
"/resources/log4j2.xml");
}
// This method runs once AFTER execution completes
@Override
public void onExecutionFinish() {
// TODO Auto-generated method stub
IExecutionListener.super.onExecutionFinish();
}
}
