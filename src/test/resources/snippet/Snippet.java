package snippet;

public class Snippet {
	<?xml version="1.0" encoding="UTF-8"?>
	<Configuration status="INFO">
	    <Appenders>
	        <Console name="Console" target="SYSTEM_OUT">
	            <PatternLayout pattern="%d{yyyy-MM-dd HH:mm:ss} [%t] %-5level %logger{36} - %msg%n"/>
	        </Console>
	
	        <File name="FileLogger" fileName="logs/application.log">
	            <PatternLayout>
	                <Pattern>%d{yyyy-MM-dd HH:mm:ss} [%t] %-5level %logger{36} - %msg%n</Pattern>
	            </PatternLayout>
	        </File>
	    </Appenders>
	
	    <Loggers>
	        <Root level="info">
	            <AppenderRef ref="Console"/>
	            <AppenderRef ref="FileLogger"/>
	        </Root>
	    </Loggers>
	</Configuration>
	
}

