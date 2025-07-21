package com.codewithaman.CreationalPatterns.PrototypePattern.WithPrototypePattern;

public class GameClient {
    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard();

        gameBoard.addGamePiece(new GamePiece("Red", 1));
        gameBoard.addGamePiece(new GamePiece("Blue", 2));
        gameBoard.showGameBoard();

        // Checkpoint this state
        GameBoard copiedBoard = gameBoard.clone();
        copiedBoard.showGameBoard();
    }
}
