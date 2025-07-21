package com.codewithaman.CreationalPatterns.PrototypePattern.WithoutPrototypePattern;

public class GameClient {
    public static void main(String[] args) {
        GameBoard gameBoard = new GameBoard();
        gameBoard.addGamePiece(new GamePiece("Red", 1));
        gameBoard.addGamePiece(new GamePiece("Blue", 2));
        gameBoard.addGamePiece(new GamePiece("Green", 3));
        System.out.println("Original Game Board:");
        gameBoard.showGameBoard();

        // checkpoint this state
        GameBoard copiedBoard = new GameBoard();
        for(GamePiece gamePiece : gameBoard.getGameBoard()) {
            copiedBoard.addGamePiece(new GamePiece(gamePiece.getColor(), gamePiece.getPosition()));
        }
        System.out.println("\nCopied Game Board:");
        copiedBoard.showGameBoard();

    }
}
