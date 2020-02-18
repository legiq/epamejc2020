package seaBattle.data;

import seaBattle.data.enums.CellStatus;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Field {

    private List<Cell> field = new ArrayList<>();

    public void generateField() {
        int cellIndex = 0;
        for (int i = 1; i <= Configuration.getFieldSize(); i++) {
            for (int j = 1; j <= Configuration.getFieldSize(); j++) {
                field.add(new Cell(cellIndex, i, j, CellStatus.HIDDEN.getStatus()));
                cellIndex++;
            }
        }
    }

    public List<Cell> getField() {
        return field;
    }

    public Cell getCellByCoords(int xCoord, int yCoord) {
        return field.stream()
                .filter(cell -> cell.getxCoord() == xCoord
                        && cell.getyCoord() == yCoord)
                .findAny()
                .orElse(null);
    }

    public List<Cell> getShipCells(Ship ship) {
        if (ship.getDirection().equals("up")) {
            return getTopDirectionCells(ship);
        } else if (ship.getDirection().equals("right")) {
            return getRightDirectionCells(ship);
        } else if (ship.getDirection().equals("down")) {
            return getBottomDirectionCells(ship);
        } else {
            return getLeftDirectionCells(ship);
        }
    }


    public List<Cell> getTopDirectionRadius(int xCoord, int yCoord, int shipDecks) {
        List<Cell> radiusCellsList = new ArrayList<>();
        for (int y = yCoord - shipDecks; y <= yCoord + 1; y++) {
            for (int x = xCoord - 1; x <= xCoord + 1; x++) {
                Cell cell = getCellByCoords(x, y);
                if (cell == null) {
                    continue;
                } else {
                    radiusCellsList.add(cell);
                }
            }
        }
        return radiusCellsList;
    }

    public List<Cell> getRightDirectionRadius(int xCoord, int yCoord, int shipDecks) {
        List<Cell> radiusCellsList = new ArrayList<>();
        for (int y = yCoord - 1; y <= yCoord + 1; y++) {
            for (int x = xCoord - 1; x <= xCoord + shipDecks; x++) {
                Cell cell = getCellByCoords(x, y);
                if (cell == null) {
                    continue;
                } else {
                    radiusCellsList.add(cell);
                }
            }
        }
        return radiusCellsList;
    }

    public List<Cell> getBottomDirectionRadius(int xCoord, int yCoord, int shipDecks) {
        List<Cell> radiusCellsList = new ArrayList<>();
        for (int y = yCoord - 1; y <= yCoord + shipDecks; y++) {
            for (int x = xCoord - 1; x <= xCoord + 1; x++) {
                Cell cell = getCellByCoords(x, y);
                if (cell == null) {
                    continue;
                } else {
                    radiusCellsList.add(cell);
                }
            }
        }
        return radiusCellsList;
    }

    public List<Cell> getLeftDirectionRadius(int xCoord, int yCoord, int shipDecks) {
        List<Cell> radiusCellsList = new ArrayList<>();
        for (int y = yCoord - 1; y <= yCoord + 1; y++) {
            for (int x = xCoord - shipDecks; x <= xCoord + 1; x++) {
                Cell cell = getCellByCoords(x, y);
                if (cell == null) {
                    continue;
                } else {
                    radiusCellsList.add(cell);
                }
            }
        }
        return radiusCellsList;
    }

    private List<Cell> getTopDirectionCells(Ship ship) {
        return field.stream()
                .filter(cell -> cell.getxCoord() == ship.getShipCoordX() &&
                        cell.getyCoord() <= ship.getShipCoordY() &&
                        cell.getyCoord() >= ship.getShipCoordY() - ship.getShipDecks() + 1)
                .collect(Collectors.toList());
    }

    private List<Cell> getRightDirectionCells(Ship ship) {
        return field.stream()
                .filter(cell -> cell.getyCoord() == ship.getShipCoordY() &&
                        cell.getxCoord() >= ship.getShipCoordX() &&
                        cell.getxCoord() <= ship.getShipCoordX() + ship.getShipDecks() - 1)
                .collect(Collectors.toList());
    }

    private List<Cell> getBottomDirectionCells(Ship ship) {
        return field.stream()
                .filter(cell -> cell.getxCoord() == ship.getShipCoordX() &&
                        cell.getyCoord() >= ship.getShipCoordY() &&
                        cell.getyCoord() <= ship.getShipCoordY() + ship.getShipDecks() - 1)
                .collect(Collectors.toList());
    }

    private List<Cell> getLeftDirectionCells(Ship ship) {
        return field.stream()
                .filter(cell -> cell.getyCoord() == ship.getShipCoordY() &&
                        cell.getxCoord() <= ship.getShipCoordX() &&
                        cell.getxCoord() >= ship.getShipCoordX() - ship.getShipDecks() + 1)
                .collect(Collectors.toList());
    }
}