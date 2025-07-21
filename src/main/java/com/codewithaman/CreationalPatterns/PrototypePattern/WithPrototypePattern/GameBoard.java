package com.codewithaman.CreationalPatterns.PrototypePattern.WithPrototypePattern;

import java.util.ArrayList;
import java.util.List;

public class GameBoard implements Prototype<GameBoard>{


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

    @Override
    public GameBoard clone() {
        GameBoard clonedGameBoard = new GameBoard();
        for(GamePiece piece: gameBoard) {
            clonedGameBoard.addGamePiece(piece.clone());
        }
        return clonedGameBoard;
    }
}
