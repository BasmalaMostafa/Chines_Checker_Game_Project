package company;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import company.GUI.Seed;

public class Node {

    private int x0, y0;
    private int x, y;
    private Node parent;
    private ArrayList<Node> ArrayofChildren;
    private Seed[][] board;
    private Seed player;
    private Seed piece;
    private int wins;
    private int plays;
    private int level;
    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public List<Node> getChildArray() {
        return ArrayofChildren;
    }

    public void setChildArray(List<Node> childArray) {
        this.ArrayofChildren = (ArrayList<Node>) childArray;
    }

    Seed[][] getBoard() {
        return board;
    }

    void setBoard(Seed[][] board) {
        this.board = board;
    }

    Seed getPlayer() {
        return player;
    }

    void setPlayer(Seed player) {
        this.player = player;
    }

    Seed getPiece() {
        return piece;
    }

    void setPiece(Seed piece) {
        this.piece = piece;
    }

    Seed getOpponent() {
        return ((player == Seed.CROSS) ? Seed.NOUGHT : Seed.CROSS);
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getPlays() {
        return plays;
    }

    public void setPlays(int plays) {
        this.plays = plays;
    }

    public int getX0() {
        return x0;
    }

    public int getY0() {
        return y0;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getLevel() {
        return level;
    }
    void incrementnumPlays() {
        this.plays++;
    }
    public Node(Node parent, Seed[][] board, Seed player, Seed piece, int wins, int plays, int x0, int y0, int x, int y) {
        this.parent = parent;
        Simulation figure = new Simulation(board);
        this.board = figure.copyBoard(board);
        this.player = player;
        this.piece = piece;
        this.wins = wins;
        this.plays = plays;
        this.x0 = x0;
        this.y0 = y0;
        this.x = x;
        this.y = y;
        this.level = parent.level++;
        ArrayofChildren = new ArrayList<>();
    }

    public Node(Seed[][] board, Seed player, int wins, int plays, int x0, int y0, int x, int y, int level) {

        Simulation figure = new Simulation(board);
        this.board = figure.copyBoard(board);
        this.player = player;
        this.wins = wins;
        this.plays = plays;
        this.x0 = x0;
        this.y0 = y0;
        this.x = x;
        this.y = y;
        this.level = level;
        ArrayofChildren = new ArrayList<>();

    }

    public Node(Node node) {
        if (node.getParent() != null) {
            this.parent = node.getParent();
        }
        this.ArrayofChildren = new ArrayList<>();
        ArrayList<Node> childArray = new ArrayList<Node>(node.getChildArray().size());
        for (int i = 0; i < node.getChildArray().size(); i++) {
            childArray.add(node.getChildArray().get(i));
        }

        this.board = node.getBoard();
        Simulation figure = new Simulation(board);
        this.board = figure.copyBoard(node.getBoard());
        this.player = node.getPlayer();
        this.piece = node.getPiece();
        this.wins = node.getWins();
        this.plays = node.getPlays();
        this.x0 = node.getX0();
        this.y0 = node.getY0();
        this.x = node.getX();
        this.y = node.getY();
        this.level = node.getLevel();
    }

    public void addChild(Node parent, Node child) {
        parent.getChildArray().add(child);
    }

    public void createNodes(Node Parent) {
        ArrayList<Node> Childern = new ArrayList<Node>();

        Simulation moveFigure = new Simulation(this.board);
        int[] positions = moveFigure.searchPieces(this.board, getOpponent());
        for (int i = 0; i < positions.length/2; i++) {
            List<Integer> NewPos = new ArrayList<Integer>();
            NewPos.addAll(moveFigure.legalMoves(this.board, getOpponent(), positions[(i*2)], positions[(i*2)+1]));
            for (int j = 0; j < NewPos.size()/2; j++) {
                Seed[][] Bord = moveFigure.copyBoard(this.board);
                Seed Seeds = Bord[positions[i*2]][positions[i*2+1]];
                Bord[positions[i*2]][positions[i*2+1]] = Seed.EMPTY;
                Bord[NewPos.get(j*2)][NewPos.get(j*2+1)] = Seeds;
                Node n=new  Node(Parent, Bord, getOpponent(), Seeds, 0, 0, positions[i*2], positions[i*2+1],
                        NewPos.get(j*2), NewPos.get(j*2+1));
                Childern.add(n);
            }
        }
        //put new children in array
        ArrayofChildren = Childern;
    }


}