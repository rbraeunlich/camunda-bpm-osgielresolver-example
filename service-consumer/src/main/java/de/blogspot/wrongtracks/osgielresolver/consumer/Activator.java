package de.blogspot.wrongtracks.osgielresolver.consumer;

import java.util.logging.Logger;

import javax.sql.DataSource;

import org.camunda.bpm.engine.ProcessEngine;
import org.camunda.bpm.engine.ProcessEngineConfiguration;
import org.camunda.bpm.engine.impl.cfg.StandaloneProcessEngineConfiguration;
import org.camunda.bpm.extension.osgi.el.OSGiExpressionManager;
import org.camunda.bpm.extension.osgi.engine.ProcessEngineFactoryWithELResolver;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

public class Activator {

	private static final Logger LOGGER = Logger.getLogger(Activator.class
			.getName());

	private Bundle bundle = FrameworkUtil.getBundle(getClass());

	private ProcessEngineFactoryWithELResolver factory;

	private DataSource dataSource;

	public ProcessEngine createProcessEngine() {
		LOGGER.info("creating process engine");
		ProcessEngineConfiguration conf = new StandaloneProcessEngineConfiguration();
		conf.setDataSource(dataSource);
		conf.setDatabaseSchemaUpdate(ProcessEngineConfiguration.DB_SCHEMA_UPDATE_CREATE_DROP);
		factory = new ProcessEngineFactoryWithELResolver();
		factory.setBundle(bundle);
		factory.setExpressionManager(new OSGiExpressionManager());
		factory.setProcessEngineConfiguration(conf);
		factory.init();
		ProcessEngine object = factory.getObject();
		LOGGER.info("creation done process engine");
		return object;
	}

	public void close() {
		factory.destroy();
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
