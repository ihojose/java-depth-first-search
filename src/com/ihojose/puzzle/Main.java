package com.ihojose.puzzle;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Main {
    static final long MEGABYTE_FACTOR = 1024L * 1024L;

    public static void main( String... args ) {
        System.out.println( "===> PUZZLE 8" );

        // Start time record -------------------------------------------------------------------------------------------
        LocalDateTime startTime = LocalDateTime.now();

        // Start Search Algorithm --------------------------------------------------------------------------------------
        DepthFirstSearch bfs = new DepthFirstSearch( 1, 2, 5, 3, 4, 0, 6, 7, 8 );
        boolean success = bfs.solve();
        LocalDateTime endTime = LocalDateTime.now();

        if ( success ) {
            System.out.println( "===> Statistics:" );
            System.out.printf( "> %1$-30s: %2$s \n", "Path to goal", bfs.getCurrentNode().getPathToGoal() );
            System.out.printf( "> %1$-30s: %2$s \n", "Cost to goal", bfs.getCurrentNode().getCostOfPath() );
            System.out.printf( "> %1$-30s: %2$s \n", "Nodes expanded", bfs.getExploredNodes().size() );
            System.out.printf( "> %1$-30s: %2$s \n", "Search depth", bfs.getCurrentNode().getSearchDepth() );
            System.out.printf( "> %1$-30s: %2$s \n", "Max Search depth", bfs.getCurrentNode().getMaxSearchDepth() );

            long seconds = startTime.until( endTime, ChronoUnit.SECONDS );
            if ( seconds == 0 ) {
                long milliSeconds = startTime.until( endTime, ChronoUnit.MILLIS );
                System.out.printf( "> %1$-30s: %2$s MILLISECONDS \n", "Running time", milliSeconds );
            } else {
                System.out.printf( "> %1$-30s: %2$s SECONDS \n", "Running time", seconds );
            }
            final DecimalFormat ROUNDED_DOUBLE_DECIMAL_FORMAT;
            DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols( Locale.ENGLISH );
            otherSymbols.setDecimalSeparator( '.' );
            otherSymbols.setGroupingSeparator( ',' );
            ROUNDED_DOUBLE_DECIMAL_FORMAT = new DecimalFormat( "####0.00", otherSymbols );
            ROUNDED_DOUBLE_DECIMAL_FORMAT.setGroupingUsed( false );
            double totalMiB = bytesToMiB( getUsedMemory() );
            System.out.printf( "> %1$-30s: %2$s Megabytes%n", "Max memory usage", totalMiB );
        } else {
            System.err.println( "No solution found!" );
        }
    }

    public static long getTotalMemory() {
        return Runtime.getRuntime().totalMemory();
    }

    private static double bytesToMiB( long bytes ) {
        return ( ( double ) bytes / MEGABYTE_FACTOR );
    }

    public static long getMaxMemory() {
        return Runtime.getRuntime().maxMemory();
    }

    public static long getUsedMemory() {
        return getTotalMemory() - getFreeMemory();
    }

    public static long getFreeMemory() {
        return Runtime.getRuntime().freeMemory();
    }
}