package com.ilyagubarev.projects.miscellaneous.domain.model.elements;

/**
 *
 *
 * @author gubarev
 * @param <T>
 */
public class DoubleLinkedNode<T> {

    private T _data;
    private DoubleLinkedNode<T> _next;
    private DoubleLinkedNode<T> _previous;

    /**
     * 
     */
    public DoubleLinkedNode() {

    }

    /**
     *
     *
     * @param data
     */
    public DoubleLinkedNode(T data) {
        _data = data;
    }

    /**
     *
     *
     * @return
     */
    public T getData() {
        return _data;
    }

    /**
     *
     *
     * @return
     */
    public DoubleLinkedNode<T> getNext() {
        return _next;
    }

    /**
     *
     *
     * @return
     */
    public DoubleLinkedNode<T> getPrevious() {
        return _previous;
    }

    /**
     *
     *
     * @param data
     */
    public void setData(T data) {
        _data = data;
    }

    /**
     *
     * 
     * @param next
     */
    public void setNext(DoubleLinkedNode<T> next) {
        _next = next;
    }

    /**
     *
     *
     * @param previous
     */
    public void setPrevious(DoubleLinkedNode<T> previous) {
        _previous = previous;
    }
}