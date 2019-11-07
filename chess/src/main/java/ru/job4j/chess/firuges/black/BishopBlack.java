package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

/**
 * @author Petr Arsentev (parsentev@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell position) {
        this.position = position;
    }

    @Override
    public Cell position() {
        return this.position;
    }

    @Override
    public Cell[] way(Cell source, Cell dest) {
        if (!isDiagonal(source, dest)) {
            throw new IllegalStateException(
                    String.format("Could not way by diagonal from %s to %s", source, dest)
            );
        }
        int size = Math.abs(dest.y - source.y);
        Cell[] steps = new Cell[size];
        int deltaX = dest.x > source.x ? 1 : -1;
        int deltaY = dest.y > source.y ? 1 : -1;
        for (int index = 0; index < size; index++) {
            int x = source.x + deltaX;
            int y = source.y + deltaY;
            for (Cell cell: Cell.values()) {
                if (cell.x == x && cell.y == y) {
                    steps[index] = cell;
                    break;
                }
            }
            deltaX = deltaX > 0 ? ++deltaX : --deltaX;
            deltaY = deltaY > 0 ? ++deltaY : --deltaY;
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        boolean result = true;
        if (source.x == dest.x || source.y == dest.y) {
            result = false;
        } else {
            int deltaX = dest.x > source.x ? 1 : -1;
            int deltaY = dest.y > source.y ? 1 : -1;
            int x = source.x;
            int y = source.y;
            while (true) {
                x += deltaX;
                y += deltaY;
                if (x == dest.x && y == dest.y) {
                    break;
                }
                if (x < 0 || x > 7 || y < 0 && y > 7) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
