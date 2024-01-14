package ratings;

import ratings.datastructures.BinaryTreeNode;
import ratings.datastructures.Comparator;
import ratings.datastructures.LinkedListNode;

public class Playlist {
    private BinaryTreeNode<Song> root;
    private Comparator<Song> comparator;
    private LinkedListNode<Song> songList;
    public Playlist(Comparator<Song> a){
        this.comparator = a;
    }
    public void addSong(Song song){
        if (this.root == null) {
            this.root = new BinaryTreeNode<>(song, null, null);
        } else {
            this.insertHelper(this.root, song);
        }
    }
    private void insertHelper(BinaryTreeNode<Song> node, Song toInsert) {
        if (this.comparator.compare(toInsert, node.getValue())) {
            if (node.getLeft() == null) {
                node.setLeft(new BinaryTreeNode<>(toInsert, null, null));
            } else {
                insertHelper(node.getLeft(), toInsert);
            }
        } else {
            if (node.getRight() == null) {
                node.setRight(new BinaryTreeNode<>(toInsert, null, null));
            } else {
                insertHelper(node.getRight(), toInsert);
            }
        }
    }
    public BinaryTreeNode<Song> getSongTree(){
        return this.root;
    }
    public LinkedListNode<Song> getSongList(BinaryTreeNode<Song> node){
        if (node != null){
            getSongListHelper(node);
        }
        return this.songList;
    }
    private void getSongListHelper(BinaryTreeNode<Song> node) {
        if (node != null) {
            getSongListHelper(node.getLeft());
            if (songList == null) {
                this.songList = new LinkedListNode<>(node.getValue(), null);
                getSongListHelper(node.getRight());
            }
            else {
                this.songList.append(node.getValue());
                getSongListHelper(node.getRight());
            }
        }
    }
    public LinkedListNode<Song> getSongList(){
        return getSongList(this.root);
    }
}