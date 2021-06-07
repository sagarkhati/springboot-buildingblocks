package com.sagarkhati.restservices.config;

import org.springframework.context.annotation.Configuration;

import io.micrometer.appoptics.AppOpticsConfig;
import io.micrometer.appoptics.AppOpticsMeterRegistry;
import io.micrometer.core.instrument.Clock;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.lang.Nullable;

@Configuration
public class MonitoringConfig {

	AppOpticsConfig appopticsConfig = new AppOpticsConfig() {
		@Override
		public String apiToken() {
			return "XzzyEfCQFCrpiTnx44SjRV99mE9B24wJ465JAV3_HAv2AGRAK8bV6k3qWdmpYfLnZ7jVrNM";
		}

		@Override
		@Nullable
		public String get(String k) {
			return null;
		}
	};
	MeterRegistry registry = new AppOpticsMeterRegistry(appopticsConfig, Clock.SYSTEM);

}
