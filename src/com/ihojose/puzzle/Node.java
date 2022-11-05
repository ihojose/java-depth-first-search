package com.ihojose.puzzle;

import java.util.ArrayList;
import java.util.List;

public class Node {
    int i, j;
    Integer nodeVal;
    Integer[][] state = new Integer[ 3 ][ 3 ];
    List< Node > neighbors = new ArrayList<>();
    String pathToGoal = "INITIAL";
    Integer costOfPath = 0;
    int searchDepth = 0;
    static int maxSearchDepth = 0;

    public Node( Integer nodeVal, int i, int j, Integer[][] state, String pathToGoal, Integer costOfPath ) {
        this.nodeVal = nodeVal;
        this.i = i;
        this.j = j;
        this.state = state;
        this.pathToGoal = pathToGoal;
        this.costOfPath = costOfPath;
        this.searchDepth = costOfPath;
        if ( searchDepth > maxSearchDepth ) {
            maxSearchDepth = searchDepth;
        }
    }

    private void getRightNeighbor() {
        Integer[][] stateTemp = new Integer[ 3 ][ 3 ];
        for ( int k = 0; k < 3; k++ ) {
            System.arraycopy( state[ k ], 0, stateTemp[ k ], 0, 3 );
        }

        int i1 = i, j1 = j + 1;
        Integer nodeValTemp;
        if ( j + 1 < 3 ) {
            nodeValTemp = stateTemp[ i1 ][ j1 ];
            Integer temp = stateTemp[ i1 ][ j1 ];
            stateTemp[ i1 ][ j1 ] = stateTemp[ i ][ j ];
            stateTemp[ i ][ j ] = temp;
            Node tempNode = new Node( nodeValTemp, i1, j1, stateTemp, String.format( "%1$s, RIGHT", pathToGoal ), costOfPath + 1 );
            neighbors.add( tempNode );
        }

    }

    private void getLeftNeighbor() {
        Integer[][] stateTemp = new Integer[ 3 ][ 3 ];
        for ( int k = 0; k < 3; k++ ) {
            System.arraycopy( state[ k ], 0, stateTemp[ k ], 0, 3 );
        }

        int i1 = i, j1 = j - 1;
        Integer nodeValTemp;
        if ( j - 1 >= 0 ) {
            nodeValTemp = stateTemp[ i1 ][ j1 ];
            Integer temp = stateTemp[ i1 ][ j1 ];
            stateTemp[ i1 ][ j1 ] = stateTemp[ i ][ j ];
            stateTemp[ i ][ j ] = temp;
            Node tempNode = new Node( nodeValTemp, i1, j1, stateTemp, String.format( "%1$s, LEFT", pathToGoal ), costOfPath + 1 );
            neighbors.add( tempNode );
        }

    }

    private void getBottomNeighbor() {
        Integer[][] stateTemp = new Integer[ 3 ][ 3 ];
        for ( int k = 0; k < 3; k++ ) {
            System.arraycopy( state[ k ], 0, stateTemp[ k ], 0, 3 );
        }

        int i1 = i + 1, j1 = j;
        Integer nodeValTemp;
        if ( i + 1 < 3 ) {
            nodeValTemp = stateTemp[ i1 ][ j1 ];
            Integer temp = stateTemp[ i1 ][ j1 ];
            stateTemp[ i1 ][ j1 ] = stateTemp[ i ][ j ];
            stateTemp[ i ][ j ] = temp;
            Node tempNode = new Node( nodeValTemp, i1, j1, stateTemp, String.format( "%1$s, BOTTOM", pathToGoal ), costOfPath + 1 );
            neighbors.add( tempNode );
        }

    }

    private void getTopNeighbor() {
        Integer[][] stateTemp = new Integer[ 3 ][ 3 ];
        for ( int k = 0; k < 3; k++ ) {
            System.arraycopy( state[ k ], 0, stateTemp[ k ], 0, 3 );
        }

        int i1 = i - 1, j1 = j;
        Integer nodeValTemp;
        if ( i - 1 >= 0 ) {
            nodeValTemp = stateTemp[ i1 ][ j1 ];
            Integer temp = stateTemp[ i1 ][ j1 ];
            stateTemp[ i1 ][ j1 ] = stateTemp[ i ][ j ];
            stateTemp[ i ][ j ] = temp;
            Node tempNode = new Node( nodeValTemp, i1, j1, stateTemp, String.format( "%1$s, TOP", pathToGoal ), costOfPath + 1 );
            neighbors.add( tempNode );
        }
    }

    public Node() {
        super();
    }

    public int getI() {
        return i;
    }

    public void setI( int i ) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ( int j ) {
        this.j = j;
    }

    public Integer getNodeVal() {
        return nodeVal;
    }

    public void setNodeVal( Integer nodeVal ) {
        this.nodeVal = nodeVal;
    }

    public Integer[][] getState() {
        return state;
    }

    public void setState( Integer[][] state ) {
        this.state = state;
    }


    public List< Node > getNeighbors() {
        getRightNeighbor();
        getLeftNeighbor();
        getBottomNeighbor();
        getTopNeighbor();


        return neighbors;
    }


    public String getPathToGoal() {
        return pathToGoal;
    }


    public void setPathToGoal( String pathToGoal ) {
        this.pathToGoal = pathToGoal;
    }


    public void setNeighbors( List< Node > neighbors ) {
        this.neighbors = neighbors;
    }


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ( ( nodeVal == null ) ? 0 : nodeVal.hashCode() );
        return result;
    }

    @Override
    public boolean equals( Object obj ) {
        if ( this == obj )
            return true;
        if ( obj == null )
            return false;
        if ( getClass() != obj.getClass() )
            return false;
        Node other = ( Node ) obj;
        if ( nodeVal == null ) {
            return other.nodeVal == null;
        } else return nodeVal.equals( other.nodeVal );
    }

    public Integer getCostOfPath() {
        return costOfPath;
    }

    public void setCostOfPath( Integer costOfPath ) {
        this.costOfPath = costOfPath;
    }

    public int getSearchDepth() {
        return searchDepth;
    }

    public void setSearchDepth( int searchDepth ) {
        this.searchDepth = searchDepth;
    }

    public int getMaxSearchDepth() {
        return maxSearchDepth;
    }

    public void setMaxSearchDepth( int maxSearchDepth ) {
        Node.maxSearchDepth = maxSearchDepth;
    }
}
