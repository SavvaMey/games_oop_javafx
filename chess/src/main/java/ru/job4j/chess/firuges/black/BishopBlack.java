package ru.job4j.chess.firuges.black;

import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.Figure;

public class BishopBlack implements Figure {
    private final Cell position;

    public BishopBlack(final Cell ps) {
        position = ps;
    }

    @Override
    public Cell position() {
        return position;
    }


    @Override
    public Cell[] way(Cell dest) {
        Cell source = this.position;
        int size = Math.abs(source.getX() - dest.getX());
        if (!isDiagonal(position, dest)) {
            throw new IllegalStateException(String.format("Could not move by diagonal from %s to %s", source, dest));
        }
        Cell[] steps = new Cell[size];
        int deltaX = source.getX() - dest.getX() > 0 ? -1 : 1;
        int deltaY = source.getY() - dest.getY() > 0 ? -1 : 1;
        int x = source.getX() + deltaX;
        int y = source.getY() + deltaY;
        for (int index = 0; index < size; index++) {
            steps[index] = Cell.findBy(x, y);
            x += deltaX;
            y += deltaY;
        }
        return steps;
    }

    public boolean isDiagonal(Cell source, Cell dest) {
        return (Math.abs(source.getX() - dest.getX()) == Math.abs(source.getY() - dest.getY()));
    }

    @Override
    public Figure copy(Cell dest) {
        return new BishopBlack(dest);
    }
}
