package by.itacademy.karpuk.chess.service.test.spring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ServiceSpringContextExample {
	private static final Logger LOGGER = LoggerFactory.getLogger(ServiceSpringContextExample.class);

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("service-context.xml");
		// LOGGER.info("IPieceService: {}", context.getBean(IPieceService.class));
		LOGGER.info("all beans: {}", context.getBeanDefinitionNames());

	}
}