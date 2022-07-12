package List;

public interface ListInterface<E> {
    
    /**
     * Appends a new item to the end of this list. The entry becomes the greatest index item in this list,
     * at index(size -1) after the size is updated.
     * Size will be increased by 1 after the add.
     * Items in indexes 0 to (size - 1) before the add are not modified, and exist in indexes 9 to (size-2) afterward.
     * List have no inherent capacity limit and resize if needed. Null entries are allowed, as are duplicate entries.
     * @param entry The item to be added to the end of the List.
     */
    public void add(E entry);

    /**
     * Inserts entry at index newPos in this list. Before the insert, consider items in indexes 0 to (newPos - 1) and newPos to (size - 1); after the add these exist at indexes 
     * 0 to (newPos - 1)
     * AND (newPos +1) to (size - 1) after an increment to size.
     * More simply, items from newPos to the end of the array are shifted to the high-index side by 1 position each.
     * Then, entry is inserted at index newPos and size is incremented.
     */
    public void add(int newPos, E entry);
}
