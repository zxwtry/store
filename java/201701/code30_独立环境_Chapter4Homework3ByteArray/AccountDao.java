package step30Chapter4Homework3ByteArray;

public interface AccountDao {
    public Account find(int id);
    public int insert(byte[] owner_photo);
}
