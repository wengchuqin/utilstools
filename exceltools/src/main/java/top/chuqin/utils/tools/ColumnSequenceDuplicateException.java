package top.chuqin.utils.tools;

public class ColumnSequenceDuplicateException extends RuntimeException{
    private int seq;

    public ColumnSequenceDuplicateException(int seq) {
        super(String.format("序号重复:%d", seq));
        this.seq = seq;
    }

    public int getSeq() {
        return seq;
    }
}
