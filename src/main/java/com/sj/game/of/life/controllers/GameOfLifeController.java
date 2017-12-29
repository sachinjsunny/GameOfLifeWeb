/**
 * 
 */
package com.sj.game.of.life.controllers;

import static com.sj.game.of.life.constants.LifeConstants.ALL_FILLED;
import static com.sj.game.of.life.constants.LifeConstants.MATRIX_LENGTH;
import static com.sj.game.of.life.factory.InitialLifePattern.getMatrix;
import static com.sj.game.of.life.constants.WebConstants.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sj.game.of.life.pojo.Cell;

/**
 * @author sachinjsunny
 *
 */
@Controller
@RequestMapping("/*")
public class GameOfLifeController {

	private static final Logger log = LoggerFactory.getLogger(GameOfLifeController.class);

	@RequestMapping(value = "/" + JSP_INDEX, method = RequestMethod.GET)
	public String index() {
		log.info(JSP_INDEX);
		return JSP_INDEX;
	}

	@RequestMapping(value = "/" + JSP_GOL, method = RequestMethod.POST)
	public String getInitialMatrix(ModelMap model,
			@RequestParam(defaultValue = ALL_FILLED, required = true, name = "selectedPattern") String selectedPattern) {
		log.info(JSP_GOL);

		model.put(MODEL_ATTR_MATRIX, getMatrix(selectedPattern));

		return JSP_GOL;
	}

	@RequestMapping(value = "/refreshMatrix", method = RequestMethod.POST)
	public String refreshMatrix(@ModelAttribute() ModelMap model) {
		log.info("refreshMatrix");

		Cell[][] theMatrix = (Cell[][]) model.get(MODEL_ATTR_MATRIX);
		runGameOfLifeRules(theMatrix);
		model.put(MODEL_ATTR_MATRIX, theMatrix);
		return "JSP_GOL";
	}

	private void runGameOfLifeRules(Cell[][] theMatrix) {
		for (int rowIndex = 0; rowIndex < MATRIX_LENGTH; rowIndex++) {
			for (int columnIndex = 0; columnIndex < MATRIX_LENGTH; columnIndex++) {
				theMatrix[rowIndex][columnIndex].willIContinueToLiveInTheMatrix(theMatrix);
			}
		}
	}
}
