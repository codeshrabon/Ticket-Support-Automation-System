package com.ticket_support_automation_system.ticket_support_automation_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TicketSupportAutomationSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketSupportAutomationSystemApplication.class, args);
	}

}
