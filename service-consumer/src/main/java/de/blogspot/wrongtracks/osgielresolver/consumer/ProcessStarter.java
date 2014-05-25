package de.blogspot.wrongtracks.osgielresolver.consumer;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.RuntimeService;

public class ProcessStarter {
	
	private static final Logger LOGGER = Logger.getLogger(ProcessStarter.class
			.getName());
	private ProcessEngine engine;

	public void startProcess() throws InterruptedException {
		LOGGER.info("Starting to sleep");
		//give the deployment listener 5seconds to parse process definition
		Thread.sleep(TimeUnit.MILLISECONDS.convert(5L, TimeUnit.SECONDS));
		LOGGER.info("Waking up");
		RuntimeService runtimeService = engine.getRuntimeService();
		runtimeService.startProcessInstanceByKey("Process_1");
		LOGGER.info("Started process");
	}

	public ProcessEngine getEngine() {
		return engine;
	}

	public void setEngine(ProcessEngine engine) {
		this.engine = engine;
	}

}
