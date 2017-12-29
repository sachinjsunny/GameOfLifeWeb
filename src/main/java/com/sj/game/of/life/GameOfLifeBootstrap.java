/**
 * 
 */
package com.sj.game.of.life;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author sachinjsunny
 *
 */
@SpringBootApplication(scanBasePackages="com.sj.game.of.life")
public class GameOfLifeBootstrap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(GameOfLifeBootstrap.class, args);
	}

}