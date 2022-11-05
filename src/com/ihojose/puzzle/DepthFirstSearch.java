package com.ihojose.puzzle;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DepthFirstSearch {
    private Integer[][] initialState = new Integer[ 3 ][ 3 ];
    private Node root;
    private Node currentNode;
    private Integer[][] goalState = { { 0, 1, 2 }, { 3, 4, 5 }, { 6, 7, 8 } };
    private Stack< Node > fringe = new Stack<>();
    private List< Node > exploredNodes = new ArrayList<>();

    public DepthFirstSearch( Integer... state ) {
        int index = 0;
        for ( int i = 0; i < 3; i++ ) {
            for ( int j = 0; j < 3; j++ ) {

                if ( state[ index ] == 0 ) {
                    root = new Node( 0, i, j, initialState, "INITIAL", 0 );
                }
                initialState[ i ][ j ] = state[ index++ ];

            }
        }
        assert root != null;
        root.setState( initialState );
    }

    public boolean solve() {
        fringe.add( root );

        while ( !fringe.isEmpty() ) {
            currentNode = fringe.pop();
            exploredNodes.add( currentNode );
            if ( globalReached() ) {
                printCurrentState();
                return true;
            } else {
                printCurrentState();
            }

            for ( Node neighbor : currentNode.getNeighbors() ) {
                if ( !exploredNodes.contains( neighbor ) && !fringe.contains( neighbor ) ) {
                    fringe.add( neighbor );
                }
            }
            currentNode.setNeighbors( null );
        }

        return false;
    }

    private boolean globalReached() {
        boolean success = true;

        for ( int i = 0; i < 3; i++ ) {
            for ( int j = 0; j < 3; j++ ) {
                if ( !currentNode.getState()[ i ][ j ].equals( goalState[ i ][ j ] ) ) {
                    success = false;
                    break;
                }
            }
            if ( success ) {
                break;
            }
        }

        return success;
    }

    private void printCurrentState() {
        System.out.printf( "STATE STEP: %1$s\n", currentNode.getPathToGoal() );

        for ( int i = 0; i < 3; i++ ) {
            System.out.print( "| " );
            for ( int j = 0; j < 3; j++ ) {
                if ( currentNode.getState()[ i ][ j ] == 0 ) {
                    System.out.print( "  " );
                    continue;
                }

                System.out.printf( "%1$s ", currentNode.getState()[ i ][ j ] );
            }

            System.out.print( "|\n" );
        }

        System.out.println( "" );
    }

    public Integer[][] getInitialState() {
        return initialState;
    }

    public void setInitialState( Integer[][] initialState ) {
        this.initialState = initialState;
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot( Node root ) {
        this.root = root;
    }

    public Node getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode( Node currentNode ) {
        this.currentNode = currentNode;
    }

    public Integer[][] getGoalState() {
        return goalState;
    }

    public void setGoalState( Integer[][] goalState ) {
        this.goalState = goalState;
    }

    public Stack< Node > getFringe() {
        return fringe;
    }

    public void setFringe( Stack< Node > fringe ) {
        this.fringe = fringe;
    }

    public List< Node > getExploredNodes() {
        return exploredNodes;
    }

    public void setExploredNodes( List< Node > exploredNodes ) {
        this.exploredNodes = exploredNodes;
    }
}
