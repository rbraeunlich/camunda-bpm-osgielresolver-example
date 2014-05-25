package de.blogspot.wrongtracks.osgielresolver.consumer;

import java.util.logging.Logger;

import de.blogspot.wrongtracks.osgielresolver.api.SomethingService;

public class Activator {

	private static final Logger LOGGER = Logger.getLogger(Activator.class
			.getName());

	private SomethingService service;

	public void init() {
		LOGGER.severe("Found service: " + service.toString());
	}

	public SomethingService getService() {
		return service;
	}

	public void setService(SomethingService service) {
		this.service = service;
	}

}
