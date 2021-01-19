package com.sj.game.of.life.factory;

import static com.sj.game.of.life.constants.LifeConstants.ALL_FILLED;
import static com.sj.game.of.life.constants.LifeConstants.BOX;
import static com.sj.game.of.life.constants.LifeConstants.CROSS;
import static com.sj.game.of.life.constants.LifeConstants.CROSS_IN_A_BOX;
import static com.sj.game.of.life.constants.LifeConstants.DIAMOND;
import static com.sj.game.of.life.constants.LifeConstants.PLUS;
import static com.sj.game.of.life.constants.LifeConstants.PYRAMID;
import static com.sj.game.of.life.constants.LifeConstants.SMALL_EXPLORER;
import static com.sj.game.of.life.constants.LifeConstants.SOLID_DIAMOND;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.sj.game.of.life.pojo.Cell;

/**
 * @author sachinjsunny
 *
 */
public final class InitialLifePattern {

	private static final Logger log = LoggerFactory.getLogger(InitialLifePattern.class);

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
				if (rowIndex - 1 < 0 || columnIndex - 1 < 0 || rowIndex + 1 > (matrixLength - 1)
						|| columnIndex + 1 > (matrixLength - 1)) {
					box[rowIndex][columnIndex] = new Cell(true, rowIndex, columnIndex);
				} else {
					box[rowIndex][columnIndex] = new Cell(false, rowIndex, columnIndex);
				}
			}
		}
		return box;
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

	private static Cell[][] createDiamondPattern(int matrixLength) {
		Cell[][] diamond = new Cell[matrixLength][matrixLength];
		int halfLength = matrixLength / 2;
		for (int rowIndex = 0; rowIndex < matrixLength; rowIndex++) {
			for (int columnIndex = 0; columnIndex < matrixLength; columnIndex++) {
				if ((rowIndex + columnIndex == halfLength) || (rowIndex - columnIndex == halfLength)
						|| (columnIndex - rowIndex == halfLength)
						|| (rowIndex + columnIndex == matrixLength + halfLength)) {
					diamond[rowIndex][columnIndex] = new Cell(true, rowIndex, columnIndex);
				} else {
					diamond[rowIndex][columnIndex] = new Cell(false, rowIndex, columnIndex);
				}
			}
		}

		return diamond;
	}

	private static Cell[][] createPlusPattern(int matrixLength) {
		Cell[][] plus = new Cell[matrixLength][matrixLength];
		int halfLength = matrixLength / 2;
		for (int rowIndex = 0; rowIndex < matrixLength; rowIndex++) {
			for (int columnIndex = 0; columnIndex < matrixLength; columnIndex++) {
				if (rowIndex == halfLength - 1 || rowIndex == halfLength || rowIndex == halfLength + 1
						|| columnIndex == halfLength || columnIndex == halfLength - 1
						|| columnIndex == halfLength + 1) {
					plus[rowIndex][columnIndex] = new Cell(true, rowIndex, columnIndex);
				} else {
					plus[rowIndex][columnIndex] = new Cell(false, rowIndex, columnIndex);
				}
			}
		}

		return plus;
	}

	private static Cell[][] createPyramidPattern(int matrixLength) {
		Cell[][] pyramid = new Cell[matrixLength][matrixLength];

		int halfLength = matrixLength / 2;

		for (int rowIndex = 0; rowIndex < matrixLength; rowIndex++) {
			for (int columnIndex = 0; columnIndex < matrixLength; columnIndex++) {
				if (columnIndex >= (halfLength - rowIndex) && columnIndex <= (halfLength + rowIndex)
						&& rowIndex <= halfLength) {
					pyramid[rowIndex][columnIndex] = new Cell(true, rowIndex, columnIndex);
				} else {
					pyramid[rowIndex][columnIndex] = new Cell(false, rowIndex, columnIndex);
				}
			}
		}
		return pyramid;
	}

	private static Cell[][] createSmallExplorerPattern(int matrixLength) {
		Cell[][] smallExplorer = new Cell[matrixLength][matrixLength];

		int halfLength = matrixLength / 2;

		for (int rowIndex = 0; rowIndex < matrixLength; rowIndex++) {
			for (int columnIndex = 0; columnIndex < matrixLength; columnIndex++) {
				if ((rowIndex == halfLength && columnIndex == halfLength)
						|| (rowIndex - 1 == halfLength && (columnIndex - 1 == halfLength || columnIndex == halfLength
								|| columnIndex + 1 == halfLength))
						|| (rowIndex - 2 == halfLength
								&& (columnIndex - 1 == halfLength || columnIndex + 1 == halfLength))
						|| (rowIndex - 3 == halfLength && columnIndex == halfLength)) {
					smallExplorer[rowIndex][columnIndex] = new Cell(true, rowIndex, columnIndex);
				} else {
					smallExplorer[rowIndex][columnIndex] = new Cell(false, rowIndex, columnIndex);
				}
			}
		}
		return smallExplorer;
	}

	private static Cell[][] createSolidDiamondPattern(int matrixLength) {
		Cell[][] solidDiamond = new Cell[matrixLength][matrixLength];

		int halfLength = matrixLength / 2;

		for (int rowIndex = 0; rowIndex < matrixLength; rowIndex++) {

			for (int columnIndex = 0; columnIndex < matrixLength; columnIndex++) {
				if (columnIndex >= (halfLength - rowIndex) && columnIndex <= (halfLength + rowIndex)
						&& rowIndex < halfLength) {
					solidDiamond[rowIndex][columnIndex] = new Cell(true, rowIndex, columnIndex);
				} else if (rowIndex >= halfLength && columnIndex >= (rowIndex - halfLength)
						&& columnIndex + rowIndex <= (matrixLength + halfLength)) {
					solidDiamond[rowIndex][columnIndex] = new Cell(true, rowIndex, columnIndex);
				} else {
					solidDiamond[rowIndex][columnIndex] = new Cell(false, rowIndex, columnIndex);
				}
			}

		}
		return solidDiamond;
	}

	public static Cell[][] getMatrix(String lifePatternName, int matrixLength) {
		switch (lifePatternName) {
		case CROSS_IN_A_BOX:
			return createCrossInABoxPattern(matrixLength);
		case BOX:
			return createBoxPattern(matrixLength);
		case CROSS:
			return createCrossPattern(matrixLength);
		case SMALL_EXPLORER:
			return createSmallExplorerPattern(matrixLength);
		case DIAMOND:
			return createDiamondPattern(matrixLength);
		case PLUS:
			return createPlusPattern(matrixLength);
		case PYRAMID:
			return createPyramidPattern(matrixLength);

		case SOLID_DIAMOND:
			return createSolidDiamondPattern(matrixLength);
		case ALL_FILLED:
		default:
			return createAllFilledPattern(matrixLength);
		}

	}

	private InitialLifePattern() {

	}
}
