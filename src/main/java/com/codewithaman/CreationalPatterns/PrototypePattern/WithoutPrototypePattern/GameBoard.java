package com.codewithaman.CreationalPatterns.PrototypePattern.WithoutPrototypePattern;

import java.util.ArrayList;
import java.util.List;

public class GameBoard {
    private List<GamePiece> gameBoard;

    public GameBoard() {
        this.gameBoard = new ArrayList<>();
    }

    public void addGamePiece(GamePiece gamePiece) {
        gameBoard.add(gamePiece);
    }

    public List<GamePiece> getGameBoard() {
        return gameBoard;
    }

    public void showGameBoard() {
        for(GamePiece piece: gameBoard) {
            System.out.println(piece);
        }
    }
}
