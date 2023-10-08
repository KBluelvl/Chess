package g58137.chess.model;

import g58137.chess.model.pieces.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Florian
 */
public class Game implements Model {

    private Board board; // le plateau de jeu
    private Player white; // le joueur blanc
    private Player black; // le joueur noir
    private Player currentPlayer; // le joueur courant
    private King whiteKing; // le roi blanc
    private King blackKing; // le roi noir
    private GameState state; // l'état du jeu.

    /**
     * Constructeur Game : Qui crée un nouveau joueur blanc, un nouveau joueur
     * noir et un nouveau plateau de jeu vide.
     */
    public Game() {
        white = new Player(Color.WHITE);
        black = new Player(Color.BLACK);
        board = new Board();
        whiteKing = new King(Color.WHITE);
        blackKing = new King(Color.BLACK);
    }

    /**
     * Start the game: create the pieces and put them on the board, initialize
     * the current player to 'WHITE'.
     */
    @Override
    public void start() {
        for (int i = 0; i < board.getSquares().length; i++) {
            board.setPiece(new Pawn(Color.WHITE), new Position(1, i));
            board.setPiece(new Pawn(Color.BLACK), new Position(6, i));
            switch (i) {
                case 0 -> {
                    board.setPiece(new Rook(Color.WHITE), new Position(0, i));
                    board.setPiece(new Rook(Color.BLACK), new Position(7, i));
                }
                case 1 -> {
                    board.setPiece(new Knight(Color.WHITE), new Position(0, i));
                    board.setPiece(new Knight(Color.BLACK), new Position(7, i));
                }
                case 2 -> {
                    board.setPiece(new Bishop(Color.WHITE), new Position(0, i));
                    board.setPiece(new Bishop(Color.BLACK), new Position(7, i));
                }
                case 3 -> {
                    board.setPiece(new Queen(Color.WHITE), new Position(0, i));
                    board.setPiece(new Queen(Color.BLACK), new Position(7, i));
                }
                case 4 -> {
                    board.setPiece(whiteKing, new Position(0, i));
                    board.setPiece(blackKing, new Position(7, i));
                }
                case 5 -> {
                    board.setPiece(new Bishop(Color.WHITE), new Position(0, i));
                    board.setPiece(new Bishop(Color.BLACK), new Position(7, i));
                }
                case 6 -> {
                    board.setPiece(new Knight(Color.WHITE), new Position(0, i));
                    board.setPiece(new Knight(Color.BLACK), new Position(7, i));
                }
                case 7 -> {
                    board.setPiece(new Rook(Color.WHITE), new Position(0, i));
                    board.setPiece(new Rook(Color.BLACK), new Position(7, i));
                }
            }
        }
        currentPlayer = white;
        state = GameState.PLAY;
    }

    /**
     * Getter for the current player.
     *
     * @return the current player.
     */
    @Override
    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Getter for the second player.
     *
     * @return the player that is waiting
     */
    @Override
    public Player getOppositePlayer() {
        return currentPlayer.getColor() == Color.BLACK ? white : black;
    }

    /**
     * Get the possible moves for the piece located at the specified position.
     *
     * @param position the position of the piece
     * @return the liste of admissible positions.
     */
    @Override
    public List<Position> getPossibleMoves(Position position) {
        return board.getPiece(position).getPossibleMoves(position, board);
    }

    /**
     * Get the piece of the board located on a given position
     *
     * @param pos the position
     * @return the piece located at P
     * @throws IllegalArgumentException pos is not located on the board.
     */
    @Override
    public Piece getPiece(Position pos) {
        if (!board.contains(pos)) {
            throw new IllegalArgumentException("La position donnée n'est pas dans le tableau.");
        }
        return board.getPiece(pos);
    }

    /**
     * Recupère la valeur de l'attribut state.
     *
     * @return la valeur de l'attribut state.
     */
    @Override
    public GameState getState() {
        return state;
    }

    /**
     * Check if the square at the given position is occupied by a piece of the
     * current player.
     *
     * @param pos the postion
     * @return true if the position is occupied by a piece of the current
     * player, false otherwise.
     * @throws IllegalArgumentException if the position is not located on the
     * board.
     * @throws IllegalArgumentException if there is no piece at the given
     * position
     */
    @Override
    public boolean isCurrentPlayerPosition(Position pos) {
        if (!board.contains(pos)) {
            throw new IllegalArgumentException("La position donnée n'est pas dans le tableau.");
        }
        if (getPiece(pos) == null) {
            throw new IllegalArgumentException("Il n'y a pas de piece à cette position.");
        }
        return getPiece(pos).getColor() == currentPlayer.getColor();
    }

    /**
     * Moves a piece from one position of the chess board to another one. If the
     * game is not over, change the current player.
     *
     * @param oldPos the current position
     * @param newPos the new position of the board where to put the piece
     * @throws IllegalArgumentException if 1) oldPos or newPos are not located
     * on the board, or 2) oldPos does not contain a piece, or 3) the piece does
     * not belong to the current player, or 4) the move is not valid for the
     * piece located at position oldPos
     */
    @Override
    public void movePiecePosition(Position oldPos, Position newPos) {
        if (!board.contains(oldPos)) {
            throw new IllegalArgumentException("La première position donnée ne rentre pas dans le tableau.");
        } else if (!board.contains(newPos)) {
            throw new IllegalArgumentException("La deuxième position donnée ne rentre pas dans le tableau.");
        } else if (board.isFree(oldPos)) {
            throw new IllegalArgumentException("Il n'y a pas de piece à cette position.");
        } else if (!this.isCurrentPlayerPosition(oldPos)) {
            throw new IllegalArgumentException("Cette piece ne vous appartient pas.");
        } else if (!board.getPiece(oldPos).getPossibleMoves(oldPos, board).contains(newPos)) {
            throw new IllegalArgumentException("Vous ne pouvez pas faire ce déplacement.");
        } else if (!isValidMove(oldPos, newPos)) {
            throw new IllegalArgumentException("ce déplacement n'est pas valide.");
        }
        Piece piece = getPiece(oldPos);
        board.setPiece(piece, newPos);
        board.dropPiece(oldPos);


        enPassant(piece,oldPos,newPos);
        promotion(newPos);

        state = GameState.PLAY;
        
        if (échec()) {
            state = GameState.CHECK;
            if (échecEtMat()) {
                state = GameState.CHECK_MATE;
            }
        } else if (égalité()) {
            state = GameState.STALE_MATE;
        }
        currentPlayer = getOppositePlayer();
    }

    private void promotion(Position newPos) {
        Piece piece = getPiece(newPos);
        if ("♟".equals(piece.toString())) {
            if (newPos.getRow() == 0) {
                board.setPiece(new Queen(Color.BLACK), newPos);
            }
        } else if ("♙".equals(piece.toString())) {
                if (newPos.getRow() == 7) {
                board.setPiece(new Queen(Color.WHITE), newPos);
            }
        }
    }
    
    private void enPassant(Piece piece,Position oldPos, Position newPos){
        try{
            Pawn pawn = (Pawn) piece;
            if (pawn.getColor() == Color.WHITE && oldPos.next(Direction.N).next(Direction.N).equals(newPos)
                    || pawn.getColor() == Color.BLACK && oldPos.next(Direction.S).next(Direction.S).equals(newPos)){
                pawn.setEnPassant(true);
            } else{
                pawn.setEnPassant(false);
            }
            if (pawn.getColor() == Color.WHITE && oldPos.next(Direction.N).next(Direction.E).equals(newPos)
                    || oldPos.next(Direction.N).next(Direction.W).equals(newPos)){
                board.dropPiece(newPos.next(Direction.S));
            } else if (pawn.getColor() == Color.BLACK && oldPos.next(Direction.S).next(Direction.E).equals(newPos)
                    || oldPos.next(Direction.S).next(Direction.W).equals(newPos)) {
                board.dropPiece(newPos.next(Direction.N));
            }
        } catch (Exception e) {}
    }

    protected Board getBoard() {
        return board;
    }

    protected void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    /**
     * vérifie que le déplacement d’une pièce de la position oldPos vers la
     * position newPos est bien valide
     *
     * @param oldPos = un position donnée.
     * @param newPos = un position donnée.
     * @return true si le déplacement d’une pièce de la position oldPos vers la
     * position newPos est bien valide sinon false.
     */
    @Override
    public boolean isValidMove(Position oldPos, Position newPos) {
        if (board.isFree(oldPos)) {
            throw new IllegalArgumentException("La position donnée ne contient pas de piece.");
        } else if (!board.getPiece(oldPos).getPossibleMoves(oldPos, board).contains(newPos)) {
            throw new IllegalArgumentException("le déplacement n'est pas possible.");
        }
        Piece piece = board.getPiece(oldPos);
        Color myColor = piece.getColor();
        Piece piece2 = board.getPiece(newPos);
        Color color = piece.getColor().opposite();

        board.setPiece(piece, newPos);
        board.dropPiece(oldPos);

        Position positionDuRoi = board.getPiecePosition(getKing(new Player(myColor)));

        // si le joueur qui attaque est mis en echec après son coup.
        boolean valide = !getCapturePositions(new Player(color)).contains(positionDuRoi);

        board.setPiece(piece, oldPos);
        board.dropPiece(newPos);
        board.setPiece(piece2, newPos);

        return valide;
    }

    /**
     * revoie une liste de toutes les positions où le joueur passée en paramètre
     * peut potentiellement capturer une piece adverses.
     *
     * @param player = joueur donnée.
     * @return une liste de toutes les positions où le joueur passée en
     * paramètre peut potentiellement capturer une piece adverses.
     */
    private List<Position> getCapturePositions(Player player) {
        List<Position> capturesPossible = new ArrayList();

        List<Position> pieces = board.getPositionOccupiedBy(player);

        for (int i = 0; i < pieces.size(); i++) {
            Position position = pieces.get(i);
            List<Position> capturesPiece = board.getPiece(position).getCapturePositions(position, board);
            capturesPossible.addAll(capturesPiece);
        }
        return capturesPossible;
    }

    /**
     * revoie le roi oppossée au joueur courant.
     *
     * @return le roi oppossée au joueur.
     */
    private King getKing(Player player) {
        return player.getColor() == Color.WHITE ? whiteKing : blackKing;
    }

    /**
     * vérife si le joueur courant met en échec le joueur adverse.
     *
     * @return true si un joueur est en échec sinon false.
     */
    private boolean échec() {
        return getCapturePositions(currentPlayer).contains(board.getPiecePosition(getKing(getOppositePlayer())));
    }

    /**
     * Vérifie si un joueur est en échec et mat.
     *
     * @return true si un joueur est en echec et mat sinon false.
     */
    private boolean échecEtMat() {
        List<Position> pieces = board.getPositionOccupiedBy(getOppositePlayer());
        boolean mat = false;
        for (int i = 0; i < pieces.size(); i++) {
            List<Position> deplacements = getPossibleMoves(pieces.get(i));
            for (int j = 0; j < deplacements.size(); j++) {
                Position oldPos = pieces.get(i);
                Position newPos = deplacements.get(j);

                if (isValidMove(oldPos, newPos)) {
                    Piece piece2 = getPiece(newPos);
                    board.setPiece(getPiece(oldPos), newPos);
                    board.dropPiece(oldPos);
                    if (!échec()) {
                        board.setPiece(getPiece(newPos), oldPos);
                        board.dropPiece(newPos);
                        board.setPiece(piece2, newPos);
                        return mat;
                    }
                    board.setPiece(getPiece(newPos), oldPos);
                    board.dropPiece(newPos);
                    board.setPiece(piece2, newPos);
                }
            }
        }
        mat = true;
        return mat;
    }

    /**
     * vérifie si il y'a une égalité.
     *
     * @return true si il y'a une égalité.
     */
    private boolean égalité() {
        List<Position> pieces = board.getPositionOccupiedBy(getOppositePlayer());
        boolean égalité = false;
        for (int i = 0; i < pieces.size(); i++) {
            List<Position> deplacements = getPossibleMoves(pieces.get(i));
            Position oldPos = pieces.get(i);

            for (int j = 0; j < deplacements.size(); j++) {
                Position newPos = deplacements.get(j);
                if (isValidMove(oldPos, newPos)) {
                    return égalité;
                }
            }
        }
        égalité = true;
        return égalité;
    }
}
