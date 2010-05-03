/**
 * 
 */
package gov.nasa.ltl.graphio;

import java.io.PrintStream;

import gov.nasa.ltl.graph.AbstractGuard;
import gov.nasa.ltl.graph.Edge;
import gov.nasa.ltl.graph.Graph;
import gov.nasa.ltl.graph.Node;
import gov.nasa.ltl.trans.State;
import gov.nasa.ltl.trans.Transition;

/**
 * @author estar
 * @param <PropT>
 *
 */
public abstract class Writer<PropT> {
  public static enum Format {
    FSP, XML, SPIN
  }
  
  /**
   * Print a graph in some data format.
   * @param g graph
   */
  public abstract void write (Graph<PropT> g);
  /**
   * Print a vertex in some data format.
   * @param n vertex
   */
  public abstract void write (Node<PropT> n);
  /**
   * Print an edge in some data format.
   * @param e edge
   */
  public abstract void write (Edge<PropT> e);
  /**
   * Print a graph in some data format.
   * @param states set of vertices making up the graph
   */
  public abstract void write (State<PropT>[] states);
  /**
   * Print a vertex in some data format.
   * @param s vertex
   */
  public abstract void write (State<PropT> s);
  /**
   * Print an edge in some data format.
   * @param t edge
   */
  public abstract void write (Transition<PropT> t);
  /**
   * Print an edge label in some data format.
   * @param g label
   */
  public abstract void write (AbstractGuard<PropT> g);
  
  /**
   * Obtain an instance of an Writer subclass for a given
   * output format.
   * @param <PropT>
   * @param f format to be used
   * @return
   */
  public static final <PropT> Writer<PropT> getWriter(Format f, PrintStream out) {
    switch(f) {
    case FSP:
      return new FSPWriter<PropT> (out);
    case XML:
    case SPIN:
      return null;
    }
    return null;
  }
}
