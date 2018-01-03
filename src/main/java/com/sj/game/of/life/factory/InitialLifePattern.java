package com.sj.game.of.life.factory;

import static com.sj.game.of.life.constants.LifeConstants.ALL_FILLED;
import static com.sj.game.of.life.constants.LifeConstants.BOX;
import static com.sj.game.of.life.constants.LifeConstants.CROSS;
import static com.sj.game.of.life.constants.LifeConstants.CROSS_IN_A_BOX;

import com.sj.game.of.life.pojo.Cell;

/**
 * @author sachinjsunny
 *
 */
public final class InitialLifePattern {

	private InitialLifePattern() {

	}

	private static Cell[][] createAllFilledPattern(int matrixLength) {
		Cell[][] allFilled = new Cell[matrixLength][matrixLength];

		for (int rowIndex = 0; rowIndex < matrixLength; rowIndex++) {
			for (int columnIndex = 0; columnIndex < matrixLength; columnIndex++) {
				allFilled[rowIndex][columnIndex] = new Cell(true, rowIndex, columnIndex);
			}
		}
		return allFilled;
	}

	private static Cell[][] createBoxPattern(int matrixLength) {
		Cell[][] box = new Cell[matrixLength][matrixLength];

		for (int rowIndex = 0; rowIndex < matrixLength; rowIndex++) {
			for (int columnIndex = 0; columnIndex < matrixLength; columnIndex++) {
				if (rowIndex - 1 < 0 || columnIndex - 1 < 0 || rowIndex + 1 > (matrixLength - 1) || columnIndex + 1 > (matrixLength - 1)) {
					box[rowIndex][columnIndex] = new Cell(true, rowIndex, columnIndex);
				} else {
					box[rowIndex][columnIndex] = new Cell(false, rowIndex, columnIndex);
				}
			}
		}
		return box;
	}

	private static Cell[][] createCrossPattern(int matrixLength) {
		Cell[][] cross = new Cell[matrixLength][matrixLength];

		for (int rowIndex = 0; rowIndex < matrixLength; rowIndex++) {
			for (int columnIndex = 0; columnIndex < matrixLength; columnIndex++) {
				if (rowIndex == columnIndex || (rowIndex + columnIndex) == (matrixLength - 1)) {
					cross[rowIndex][columnIndex] = new Cell(true, rowIndex, columnIndex);
				} else {
					cross[rowIndex][columnIndex] = new Cell(false, rowIndex, columnIndex);
				}
			}
		}
		return cross;
	}

	private static Cell[][] createCrossInABoxPattern(int matrixLength) {
		Cell[][] crossInABoxPattern = new Cell[matrixLength][matrixLength];

		for (int rowIndex = 0; rowIndex < matrixLength; rowIndex++) {
			for (int columnIndex = 0; columnIndex < matrixLength; columnIndex++) {
				if (rowIndex == columnIndex || (rowIndex + columnIndex) == (matrixLength - 1)
						|| (rowIndex - 1 < 0 || columnIndex - 1 < 0 || rowIndex + 1 > (matrixLength - 1)
								|| columnIndex + 1 > (matrixLength - 1))) {
					crossInABoxPattern[rowIndex][columnIndex] = new Cell(true, rowIndex, columnIndex);
				} else {
					crossInABoxPattern[rowIndex][columnIndex] = new Cell(false, rowIndex, columnIndex);
				}
			}
		}
		return crossInABoxPattern;
	}

	public static Cell[][] getMatrix(String lifePatternName, int matrixLength) {
		switch (lifePatternName) {
		case CROSS_IN_A_BOX:
			return createCrossInABoxPattern(matrixLength);
		case BOX:
			return createBoxPattern(matrixLength);
		case CROSS:
			return createCrossPattern(matrixLength);
		case ALL_FILLED:
		default:
			return createAllFilledPattern(matrixLength);
		}

	}
}
