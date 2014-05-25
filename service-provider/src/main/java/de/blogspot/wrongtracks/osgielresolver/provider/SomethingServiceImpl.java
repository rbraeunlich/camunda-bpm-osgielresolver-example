package de.blogspot.wrongtracks.osgielresolver.provider;

import java.util.logging.Logger;

import de.blogspot.wrongtracks.osgielresolver.api.SomethingService;

public class SomethingServiceImpl implements SomethingService {

	private static final Logger LOGGER = Logger
			.getLogger(SomethingServiceImpl.class.getName());

	public void doSomething() {
		LOGGER.info("Service called");
//		throw new RuntimeException("Exterminate!");
	}

}
