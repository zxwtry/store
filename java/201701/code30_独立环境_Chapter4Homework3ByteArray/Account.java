package step30Chapter4Homework3ByteArray;

public class Account {
    private byte[] ownerPhoto;
    private int id;
    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }
    public void setOwnerPhoto(byte[] ownerPhoto) {
        this.ownerPhoto = ownerPhoto;
    }
    public byte[] getOwnerPhoto() {
        return ownerPhoto;
    }
}
